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
import in.co.ragasoft.transcare.adapter.StatusAllAdapter;

public class StatusFull extends Fragment {
List<String>list;
List<String>simlist;
List<int[]> mlist;

private StatusAllAdapter statusAllAdapter;
private RecyclerView rv;

Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status_all, container, false);
        context = getActivity();
        statusCollector();
        rv = view.findViewById(R.id.recyclerView_status);
      //  statusAllAdapter = new StatusAllAdapter(context, list, mlist);
       statusAllAdapter = new StatusAllAdapter(context, list, simlist);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(statusAllAdapter);


        return view;
    }

    public  void statusCollector()
    {
        list = new ArrayList<>();
        list.add("Order Confirm");
        list.add("Collector appointed");
        list.add("Collector On Way");
        list.add("Sample In Lab");
        list.add("Sample Being Proccesed");
        list.add("Your Report is Ready");

        mlist = new ArrayList<>();

    /* int[] images = {R.drawable.on_way_scooter, R.drawable.collector_appointment,R.drawable.report_ready,
             R.drawable.sample_in_lab, R.drawable.sample_proccess, R.drawable.collector_appointment};

        for(int i=0;i<images.length;i++)
        {
            mlist.add(images);
        }*/

       /* images = new int[]{R.drawable.on_way_scooter, R.drawable.collector_appointment,R.drawable.report_ready,
                R.drawable.sample_in_lab, R.drawable.sample_proccess, R.drawable.collector_appointment};*/

      simlist = new ArrayList<>();


       simlist.add(R.drawable.on_way_scooter+"");
       simlist.add(R.drawable.collector_appointment+"");
       simlist.add(R.drawable.report_ready+"");
       simlist.add(R.drawable.sample_in_lab+"");
       simlist.add(R.drawable.sample_proccess+"");
       simlist.add(R.drawable.sample_proccess+"");



    }

}
