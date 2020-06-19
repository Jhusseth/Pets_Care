package com.example.finalproject.activitys;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;
import com.example.finalproject.fragments.ListadoNews;
import com.example.finalproject.fragments.Perfil;
import com.example.finalproject.fragments.Servicio;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuColActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_colaborador);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNav);
       // getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListadoNews()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNav=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.servicios:
                           fragment=new Servicio();
                            break;
                        case  R.id.perfil:
                            fragment=new Perfil();
                            break;
                        case  R.id.listado_noticias:
                           fragment=new ListadoNews();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.containerss,fragment).commit();
                    return true;
                }
            };

}
