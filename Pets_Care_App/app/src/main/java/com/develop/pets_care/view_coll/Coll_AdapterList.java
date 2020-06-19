package com.develop.pets_care.view_coll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.develop.pets_care.R;
import com.develop.pets_care.model.Services;

import java.util.List;

public class Coll_AdapterList  extends RecyclerView.Adapter<Coll_AdapterList.MyViewHolder> {

    private final List<Services> mData;

    public Coll_AdapterList(List<Services> mData) {
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView name;
        final TextView description;
        final ImageView img;
        final ImageView avatar;
        final Button btn_edit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.coll_publi_name_service);
            this.description = itemView.findViewById(R.id.description_public_service);
            this.img = itemView.findViewById(R.id.image_coll_service_publi);
            this.btn_edit = itemView.findViewById(R.id.btn_editar_publi_coll);
            this.avatar = itemView.findViewById(R.id.avatar_coll_service);
        }

        public void setData(Services se){
            name.setText(se.getTitle());
            description.setText(se.getDescription());
//            img.setImageBitmap(se.getImage());
//            avatar.setImageBitmap(coll.getPerfil());

        }

        @Override
        public void onClick(View view) {
            if(btn_edit==view){

            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coll_service_item,null,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
