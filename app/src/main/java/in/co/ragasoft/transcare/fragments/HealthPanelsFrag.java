package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.HealthPanelsAdapter;
import in.co.ragasoft.transcare.modelClasses.ModelClass;

public class HealthPanelsFrag extends Fragment {
    HealthPanelsAdapter adapter;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    SearchView searchView;
    View view;
    ArrayList<ModelClass> list = new ArrayList<ModelClass>();
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_health_panels, container, false);

        rv = view.findViewById(R.id.recyclerview_healthPanels);
        searchView = view.findViewById(R.id.searchView);
        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter = new HealthPanelsAdapter(list);
        rv.setAdapter(adapter);
        listInIt();
        setSearchTextListener(searchView);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void listInIt() {
        ModelClass modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);

    }

    public void setSearchTextListener(SearchView searchView1) {
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
