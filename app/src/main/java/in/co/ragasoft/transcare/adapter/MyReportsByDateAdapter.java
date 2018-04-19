package in.co.ragasoft.transcare.adapter;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.co.ragasoft.transcare.HomeActivity;
import in.co.ragasoft.transcare.LoadPageListner;
import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.fragments.MyReports;
import in.co.ragasoft.transcare.fragments.MyReportsView;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MyReportsByDateAdapter extends RecyclerView.Adapter<MyReportsByDateAdapter.MyViewHolder> {

    List<TestPanelModel> list;
    Context context;
    RecyclerView rv;

    MyReports myReports;

    MyReportsView myReportsView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    public MyReportsByDateAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
//        myReports =
//        fragmentManager = context.ge ;
    }

    @NonNull
    @Override
    public MyReportsByDateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_reports_list_design, parent, false);
        //context =  view.getContext().getApplicationContext();
        return new MyReportsByDateAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyReportsByDateAdapter.MyViewHolder holder, final int position) {
        final TestPanelModel tmodel = list.get(position);
        //holder.monthTv.setText(tmodel.getName());
        holder.itemGroup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new MyReportsView();
                Toast.makeText(context, "<<<<<>>>>>>>>>>>>set", Toast.LENGTH_SHORT).show();
                ((HomeActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, fragment)
                        .addToBackStack("report view")
                        .commit();

            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

   /* @Override
    public void loaddFragment(Fragment fragment) {

            *//*myReportsView = new MyReportsView();
            fragmentTransaction = ((Activity)context).getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, myReportsView);
            fragmentTransaction.commit();

        fragmentTransaction.addToBackStack(null);*//*
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView listItem1, listItem2, listItem3, monthTv;
        RecyclerView rv;
        ConstraintLayout itemGroup1;

        public MyViewHolder(View itemView) {
            super(itemView);
            monthTv = itemView.findViewById(R.id.month_text);
            itemGroup1 = itemView.findViewById(R.id.itemGroup);
            // rv = itemView.findViewById(R.id.recyclerView_myReports);
        }
    }
}
