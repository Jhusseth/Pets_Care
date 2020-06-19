package com.develop.pets_care.view_user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class User_Activity_Registration_2 extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "EmailPassword";
    private Button btn_add_user;
    private ImageView avatar;
    private ImageButton btnSetImage;
    private EditText description;

    private Users user;

    private FirebaseDatabase mDatabase ;
    private FirebaseStorage mStorage;
    private StorageReference mStorageReference;
    private DatabaseReference mDatabaseReference ;
    private FirebaseAuth mAuth;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_resgistration_2);

        btn_add_user = findViewById(R.id.btn_r2_finish);
        btn_add_user.setOnClickListener(this);

        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        user = (Users) parameters.getSerializable("user");

        TextView name = findViewById(R.id.user_r2_name);
        name.setText(user.getName());

        avatar = findViewById(R.id.user_r2_photo);
        btnSetImage = findViewById(R.id.btnSetImage);
        btnSetImage.setOnClickListener(this);
        description = findViewById(R.id.txt_description);

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();
        mStorage = FirebaseStorage.getInstance();
        mStorageReference = mStorage.getReference();

        mAuth = FirebaseAuth.getInstance();
    }

    public void saveImage(Uri uri){
        if(uri!=null){
            mStorageReference.child("avatars/users/").child(user.getId()+"/IMG.jpg").putFile(uri).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    user.setAvatar("gs://petscare-aa561.appspot.com/avatars/users/"+user.getId()+"IMG.jpg");
                }
            });
        }
    }

    public void uploadImage(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            saveImage(imageUri);
            avatar.setImageURI(imageUri);
        }
    }

    public void writeData(){
        user.setDescription(description.getText().toString());
        mDatabaseReference = mDatabase.getReference().child("users").child("user");
        String[] push = user.getEmail().split("@");
        String[] push1 = push[1].split("\\.");
        String pushId = push[0]+push1[0]+push1[1];

        mDatabaseReference.child(pushId).setValue(user);

        mAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(this, User_Activity_Feed.class);
                        startActivity(i);
                        Toast.makeText(this,"Save user successfully",Toast.LENGTH_LONG).show();
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(User_Activity_Registration_2.this, "Save user failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onClick(View v) {

        if(btnSetImage==v){
            uploadImage();
        }
        else if(btn_add_user==v){
            writeData();
        }
    }
}
