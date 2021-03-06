package com.develop.pets_care.view_user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.develop.pets_care.R;
import com.develop.pets_care.model.Services;

import java.util.List;
import java.util.Objects;

public class User_AdapterList extends RecyclerView.Adapter<User_AdapterList.MyViewHolder> {

    private final List<Services> mData;


    public User_AdapterList(List<Services> myData) {
        mData = myData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView title;
        final TextView description;
        final ImageView img;
        final ImageView perf;
        final Button btnSee;
        final Button btnContact;

        public MyViewHolder(View v) {
            super(v);

            this.title=v.findViewById(R.id.title_service);
            this.description=v.findViewById(R.id.description_service);
            this.img=v.findViewById(R.id.img_service);
            this.perf=v.findViewById(R.id.perfil_user);
            this.btnSee =v.findViewById(R.id.btn_see);
            this.btnContact =v.findViewById(R.id.btn_contac);
            this.btnSee.setOnClickListener(this);
            this.btnContact.setOnClickListener(this);
        }

        public void setData(Services se){
            title.setText(se.getTitle());
            description.setText(se.getDescription());
//            img.setImageBitmap(se.getImage());
//            perf.setImageBitmap(se.getPerfil());
        }

        @Override
        public void onClick(View v) {
            if(btnSee==v){

            }
            if(btnContact==v){

            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_service_item,null,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        int a;
        if(mData!=null||mData.isEmpty()){
            a = mData.size();
        }
        else{
            a=0;
        }
        return a;
    }
}
