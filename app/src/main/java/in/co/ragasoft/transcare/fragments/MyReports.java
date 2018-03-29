package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.MyReportsAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MyReports extends Fragment implements View.OnClickListener {
    MyReportsAdapter adapter;
    List<TestPanelModel> list;
    RecyclerView rv;
    Context context;
    Toolbar toolbar;
    TextView reports;
    MyReportsView reportsDetail;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_reports, container, false);
        reports = view.findViewById(R.id.edit_Name);
        reports.setOnClickListener(this);
        context = getActivity();
        list = new ArrayList<>();
        rv = view.findViewById(R.id.recyclerView_myReports);
        adapter = new MyReportsAdapter(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        // rv.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_Name:

                if (reportsDetail == null) {
                    reportsDetail = new MyReportsView();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, reportsDetail);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, reportsDetail);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
        }
    }
}
