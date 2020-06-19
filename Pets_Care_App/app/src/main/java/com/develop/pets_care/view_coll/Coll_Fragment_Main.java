package com.develop.pets_care.view_coll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Coll;
import com.develop.pets_care.model.Services;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import java.util.Objects;
import static android.app.Activity.RESULT_OK;

public class Coll_Fragment_Main extends Fragment {

    private FirebaseStorage mStorage;
    private FirebaseDatabase mDatabase;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri;

    private ImageView img;

    private Coll coll;
    private Services service;

    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coll_services, container, false);

        service = new Services();
        mStorage = FirebaseStorage.getInstance();
        mDatabase = FirebaseDatabase.getInstance();

        EditText title = view.findViewById(R.id.name_upload_service);
        EditText description = view.findViewById(R.id.description_upload_service);
        img = view.findViewById(R.id.coll_image_publi);

        ImageButton btnImage = view.findViewById(R.id.btn_service_upload_image);
        btnImage.setOnClickListener(view1 -> uploadImage());

        getActivity().setTitle("Publicar Servicio");

        String ti = title.getText().toString();
        String desc = description.getText().toString();
        String code = coll.getId();
        String state = "Activo";

        String image = "gs://petscare-aa561.appspot.com/services/"+code + "/" + service.getId() + "/images/jpeg";

        Button btnUploadData = view.findViewById(R.id.btn_public_service);
        btnUploadData.setOnClickListener(view12 -> {
            writeData(ti,desc,image,code,state);
            coll.getServices().add(service);
            publicService();

            Coll_Fragment_Stories fr = new Coll_Fragment_Stories(coll);
            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.coll_fragment,fr)
                    .addToBackStack(null)
                    .commit();

        });

        return view;
    }

    public Coll_Fragment_Main(Coll coll){
        this.coll = coll;
    }

    public void saveImage(Uri uri){
        if(uri!=null){
            mStorage.getReference().child("services").child(coll.getId()).child(service.getId()).child("IMG.jpg").putFile(uri).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(getContext(), "Succcessfull upload image",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    public void publicService() {
        String[] push = coll.getEmail().split("@");
        String[] push1 = push[1].split("\\.");
        String pushId = push[0]+push1[0]+push1[1];
        DatabaseReference  mDatabaseReference= mDatabase.getReference().child("users")
                .child("collaborator").child(pushId).child("services");
        mDatabaseReference.setValue(service);
        saveImage(imageUri);
    }

    public void writeData(String title,String description,String image,String idColl,String state){
        service.setTitle(title);
        service.setDescription(description);
        service.setIdColl(idColl);
        service.setImage(image);
        service.setState(state);
    }

    public void uploadImage(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            saveImage(imageUri);
            img.setImageURI(imageUri);
        }
    }
}
