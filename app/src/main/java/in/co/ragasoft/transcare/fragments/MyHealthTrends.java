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
import in.co.ragasoft.transcare.adapter.MyHealthTrendsAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MyHealthTrends extends Fragment {
    MyHealthTrendsAdapter adapter;
    List<TestPanelModel> list;
    RecyclerView myHealthTrends;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_my_health_trends, container, false);

        myHealthTrends = view.findViewById(R.id.recyclerView_myHealthTrends);
        adapter = new MyHealthTrendsAdapter();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        myHealthTrends.setLayoutManager(manager);
        myHealthTrends.setAdapter(adapter);
        context = getActivity();
        list = new ArrayList<>();
        getmoney();
        return view;
    }

    public void getmoney() {

        TestPanelModel tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
    }

}
