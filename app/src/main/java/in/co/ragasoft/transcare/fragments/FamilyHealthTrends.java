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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.MyReportsByDateAdapter;
import in.co.ragasoft.transcare.adapter.MyReportsByTestNameAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class FamilyHealthTrends extends Fragment implements View.OnClickListener {
    MyReportsByDateAdapter adapter;
    MyReportsByTestNameAdapter madapter;
    List<TestPanelModel> list;
    RecyclerView rvBydate, rvByTestName;
    Context context;
    Toolbar toolbar;
    TextView reports;
    FamilyHealthTrend2 reportsDetail;
    FragmentTransaction fragmentTransaction;
    RadioButton rB1, rB2;
    RadioGroup rg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_family_health_trends, container, false);
        reports = view.findViewById(R.id.edit_Name);
        reports.setOnClickListener(this);
        context = getActivity();
        list = new ArrayList<>();
        rvBydate = view.findViewById(R.id.recyclerView_myReports); //rvBydate.setVisibility(View.VISIBLE);
        rvByTestName = view.findViewById(R.id.recyclerView_byTestName);
        rB1 = view.findViewById(R.id.radioButton1);
        rB2 = view.findViewById(R.id.radioButton2);

        rg = view.findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                RadioButton lastCheckedRB = null;
                if (null != rb && checkedId > -1)

                    if (checkedId == R.id.radioButton1) {
                        rvBydate.setVisibility(View.VISIBLE);
                        rvByTestName.setVisibility(View.GONE);
                        //adapter = new MyReportsByDateAdapter(context, list);
                        adapter = new MyReportsByDateAdapter(context, list);
                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
                        rvBydate.setLayoutManager(manager);
                        rvBydate.setAdapter(adapter);

                    } else if (checkedId == R.id.radioButton2) {

                        rvByTestName.setVisibility(View.VISIBLE);
                        rvBydate.setVisibility(View.GONE);
                        madapter = new MyReportsByTestNameAdapter(context, list);
                        RecyclerView.LayoutManager rmanager = new LinearLayoutManager(getActivity());
                        rvByTestName.setLayoutManager(rmanager);
                        rvByTestName.setAdapter(madapter);
                    } else {
                        rvBydate.setVisibility(View.VISIBLE);
                        rvByTestName.setVisibility(View.GONE);
                        //adapter = new MyReportsByDateAdapter(context, list);
                        adapter = new MyReportsByDateAdapter(context, list);
                        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
                        rvBydate.setLayoutManager(manager);
                        rvBydate.setAdapter(adapter);
                    }


            }
        });


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
                    reportsDetail = new FamilyHealthTrend2();
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
