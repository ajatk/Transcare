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
import in.co.ragasoft.transcare.adapter.YourReportsDetailAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class FamilyHealthTrends3 extends Fragment {

    YourReportsDetailAdapter adapter;
    List<TestPanelModel> list;
    RecyclerView rv;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_family_health_trends3, container, false);
        context = getActivity();
        list = new ArrayList<TestPanelModel>();
        rv = view.findViewById(R.id.recyclerView_yourReportsDetail);
        adapter = new YourReportsDetailAdapter(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        getReports();
        return view;
    }

    public void getReports() {

        TestPanelModel tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "Gulocose");
        list.add(tmodle);
    }

}
