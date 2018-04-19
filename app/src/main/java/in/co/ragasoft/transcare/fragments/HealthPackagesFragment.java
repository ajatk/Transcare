package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.PopularListDesignAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class HealthPackagesFragment extends Fragment {
    List<TestPanelModel> list;
    PopularListDesignAdapter tadapter;
    RecyclerView rv;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health_packages, container, false);
        context = getActivity();
        list = new ArrayList<>();
        getmoney();

        rv = view.findViewById(R.id.recyclerview_healthPackages);

        tadapter = new PopularListDesignAdapter(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(tadapter);

        return view;
    }

    public void getmoney() {

        TestPanelModel tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
    }


}
