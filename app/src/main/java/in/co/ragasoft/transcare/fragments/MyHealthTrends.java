package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.SugarFastingGraph;
import in.co.ragasoft.transcare.adapter.MyHealthTrendsAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MyHealthTrends extends Fragment implements View.OnClickListener {
    MyHealthTrendsAdapter adapter;
   // List<TestPanelModel> list;
    ArrayList<String>list;
    RecyclerView rvHealthTrends;
    Context context;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    TextView selectParameter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_my_health_trends, container, false);
        context =getActivity();
        rvHealthTrends = view.findViewById(R.id.recyclerView_myHealthTrends);
        getmoney();
        adapter = new MyHealthTrendsAdapter(context, list);
        rvHealthTrends.setVisibility(View.VISIBLE);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rvHealthTrends.setLayoutManager(manager);
        rvHealthTrends.setItemAnimator(new DefaultItemAnimator());
        rvHealthTrends.setAdapter(adapter);
        selectParameter = view.findViewById(R.id.selectParameters); selectParameter.setOnClickListener(this);


        return view;
    }

    public void getmoney() {
        list = new ArrayList<>();
        list.add("Sugar Fasting");
        list.add("Sugar Fasting");
        list.add("Sugar Fasting");
        list.add("Sugar Fasting");
        list.add("Sugar Fasting");
        list.add("Sugar Fasting");

       /* TestPanelModel tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.selectParameters:
                if(fragment ==null)
                {
                    fragment =new SugarFastingGraph();
                    fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame,fragment);
                    fragmentTransaction.commit();

                }
                fragmentTransaction.addToBackStack(null);
                break;
        }
    }
}
