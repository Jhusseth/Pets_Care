package com.develop.pets_care.view_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.develop.pets_care.R;

public class User_Activity_Feed extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnFeed;
    private ImageButton btnShop;
    private ImageButton btnSearch;
    private ImageButton btnStories;
    private ImageButton btnExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);

        btnFeed = findViewById(R.id.btn_feed);
        btnShop = findViewById(R.id.btn_shop);
        btnSearch = findViewById(R.id.btn_search);
        btnStories = findViewById(R.id.btn_stories);
        btnExtras = findViewById(R.id.btn_extra);

        btnFeed.setOnClickListener(this);
        btnShop.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnStories.setOnClickListener(this);
        btnExtras.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(btnFeed==v){

            User_Fragment_Main fragment = new User_Fragment_Main();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.user_fragment, fragment);
            transaction.addToBackStack(null);
            transaction.commit();


        }
        else if(btnShop==v){

        }
        else if(btnSearch==v){

        }
        else if(btnStories==v){

        }
        else if(btnExtras==v){

        }
    }
}
