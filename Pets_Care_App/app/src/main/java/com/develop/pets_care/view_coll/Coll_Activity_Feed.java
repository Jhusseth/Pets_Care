package com.develop.pets_care.view_coll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Coll;
import com.google.firebase.database.*;

public class Coll_Activity_Feed extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Cancelled";
    private ImageButton btnFeed;
    private ImageButton btnStories;
    private ImageButton btnExtra;

    private View fragment;

    private String email_coll;

    private FirebaseDatabase mDatabase;

    private Coll coll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_main);

        Bundle parameters = this.getIntent().getExtras();
        assert parameters != null;
        email_coll= parameters.getString("coll");
        mDatabase = FirebaseDatabase.getInstance();

        coll = new Coll();
        data();

        btnFeed = findViewById(R.id.btn_push_feed);
        btnStories = findViewById(R.id.btn_coll_stories);
        btnExtra = findViewById(R.id.btn_coll_perfil);

        btnFeed.setOnClickListener(this);
        btnStories.setOnClickListener(this);
        btnExtra.setOnClickListener(this);

        fragment = findViewById(R.id.coll_fragment);


    }

    public void data(){
        DatabaseReference mDataReference = mDatabase.getReference().child("users").child("collaborator");
        mDataReference.child(email_coll).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                coll = dataSnapshot.getValue(Coll.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(btnFeed==view){

            Coll_Fragment_Main fragmentFeed = new Coll_Fragment_Main(coll);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(fragment.getId(),fragmentFeed);
            transaction.addToBackStack(null);
            transaction.commit();

        }
        else if(btnStories==view){
            Coll_Fragment_Stories fragmentStories =  new Coll_Fragment_Stories(coll);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(fragment.getId(),fragmentStories);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        else if(btnExtra==view){

        }

    }
}
