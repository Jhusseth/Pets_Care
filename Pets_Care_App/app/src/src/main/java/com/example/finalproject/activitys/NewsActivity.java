package com.example.finalproject.activitys;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

public class NewsActivity extends AppCompatActivity {

        private ListView lisNews;
        String titulos[]={"1","2","3"};
        String description[]={"1","2","3"};
        int img[]={R.drawable.gmail,R.drawable.twitter,R.drawable.facebook};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listado_noticias);
        lisNews=findViewById(R.id.listNews);


        MyAdapter adapter=new MyAdapter(this,titulos,description,img);
        lisNews.setAdapter(adapter);
        lisNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(NewsActivity.this,"FacebookDes1",Toast.LENGTH_SHORT).show();
                }
                if(position==1){
                    Toast.makeText(NewsActivity.this,"FacebookDes2",Toast.LENGTH_SHORT).show();
                }
                if(position==2){
                    Toast.makeText(NewsActivity.this,"FacebookDes3",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String r[];
        String m[];
        int s[];
        MyAdapter(Context context,String r[],String m[],int s[] ){
            super(context,R.layout.item_news, R.id.tittleSer,r);
            this.context=context;
            this.r=r;
            this.m=m;
            this.s=s;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.item_news,parent,false);
            ImageView imag=view.findViewById(R.id.imgSer);
            TextView tittle=findViewById(R.id.tittleSer);
            TextView des=findViewById(R.id.descripcionSer);


            imag.setImageResource(s[position]);
            tittle.setText(r[position]);
            des.setText(m[position]);


            return view;
        }
    }
}
