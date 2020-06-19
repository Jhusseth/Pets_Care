package com.develop.pets_care.view_user;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.develop.pets_care.R;
import com.develop.pets_care.model.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User_Fragment_Main extends Fragment {


    private List<Services> list;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.user_services, container, false);


        recyclerView = view.findViewById(R.id.listServices);

        swipeRefreshLayout = view.findViewById(R.id.swipe);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.swipeAccent);

        swipeRefreshLayout.setOnRefreshListener(this::updateList);

        addlist();
        setUp();

        return view;
    }

    public User_Fragment_Main() {
        list = new ArrayList<>();
    }

    private class updateTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void updateList() {
        new updateTask().execute();
    }

    public void addlist(){
        for(int i =0;i<15;i++) {
            Services ser = new Services();
            ser.setTitle("Venta mascota "+i);
            ser.setDescription("se venden mascotas muy bonitas " + i);
            list.add(ser);
        }
    }


    public void setUp(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        User_AdapterList adapter = new User_AdapterList(list);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}
