package com.develop.pets_care.view_coll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Coll;
import com.develop.pets_care.view_user.User_Activity_Feed;
import com.develop.pets_care.view_user.User_Activity_Login;
import com.develop.pets_care.view_user.User_Activity_Registration_2;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Coll_Activity_Registration_2 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";

    private Button btn_add_coll;
    private Button btn_setImage;
    private ImageView avatar;
    private EditText description;

    private Coll collaborator;

    private FirebaseDatabase mDatabase ;
    private DatabaseReference mDatabaseReference ;
    private FirebaseStorage mStorage;
    private StorageReference mStorageReference;
    private  FirebaseAuth mAuth;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Registro final");
        setContentView(R.layout.coll_registration_2);
        btn_add_coll=findViewById(R.id.btn_coll_r2_finish);
        btn_add_coll.setOnClickListener(this);

        btn_setImage = findViewById(R.id.btn_coll_uploadImage);
        btn_setImage.setOnClickListener(this);
        avatar = findViewById(R.id.avatar_coll);
        description = findViewById(R.id.description_coll);


        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        collaborator = (Coll) parameters.getSerializable("coll");

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference();

        mStorage = FirebaseStorage.getInstance();
        mStorageReference = mStorage.getReference();
        
        mAuth = FirebaseAuth.getInstance();

    }

    public void writeData(){
        collaborator.setDescription(description.getText().toString());
        mDatabaseReference = mDatabase.getReference().child("users").child("collaborator");
        String[] push = collaborator.getEmail().split("@");
        String[] push1 = push[1].split("\\.");
        String pushId = push[0]+push1[0]+push1[1];

        mDatabaseReference.child(pushId).setValue(collaborator);

        mAuth.createUserWithEmailAndPassword(collaborator.getEmail(),collaborator.getPassword())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Intent i = new Intent(this, Coll_Activity_Feed.class);
                        i.putExtra("coll",pushId);
                        startActivity(i);
                        Toast.makeText(this,"Save collaborator successfully",Toast.LENGTH_LONG).show();
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(Coll_Activity_Registration_2.this, "Save collaborator failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void uploadImage(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    public void saveImage(Uri uri){
        if(uri!=null){
            mStorageReference.child("avatars").child("colls").child(collaborator.getId()).child("IMG.jpg").putFile(uri).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    collaborator.setAvatar("gs://petscare-aa561.appspot.com/avatars/colls/"+collaborator.getId()+"IMG.jpg");
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            saveImage(imageUri);
            avatar.setImageURI(imageUri);
        }
    }


    @Override
    public void onClick(View view) {

        if(btn_add_coll==view){
            writeData();
        }
        else if(btn_setImage==view){
            uploadImage();
            Toast.makeText(this,"Carga correcta",Toast.LENGTH_LONG).show();
        }
    }
}
