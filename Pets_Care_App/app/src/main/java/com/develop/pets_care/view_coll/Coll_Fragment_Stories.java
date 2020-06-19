package com.develop.pets_care.view_coll;

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
import com.develop.pets_care.model.Coll;
import com.develop.pets_care.model.Services;
import java.util.List;

public class Coll_Fragment_Stories extends Fragment {

    private Coll coll;

    private List<Services> list;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coll_stories_service, container, false);
        getActivity().setTitle("Historial");

        recyclerView = view.findViewById(R.id.coll_list_services);
        swipeRefreshLayout = view.findViewById(R.id.coll_swipe);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.swipeAccent);

        swipeRefreshLayout.setOnRefreshListener(this::updateList);

        setUp();

        return view;
    }

    public Coll_Fragment_Stories(Coll coll){
        this.coll=coll;
        list = coll.getServices();
    }

    private class updateTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(500);
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

    public void setUp(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        Coll_AdapterList adapter = new Coll_AdapterList(list);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

}