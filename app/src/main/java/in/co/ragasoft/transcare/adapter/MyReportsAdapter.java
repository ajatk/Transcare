package in.co.ragasoft.transcare.adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.fragments.MyReports;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

/**
 * Created by sam on 3/28/2018.
 */

public class MyReportsAdapter extends RecyclerView.Adapter<MyReportsAdapter.MyViewHolder> {

    List<TestPanelModel> list;
    Context context;
    RecyclerView rv;

    MyReports myReports;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public MyReportsAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
//        myReports =
//        fragmentManager = context.ge ;
    }

    @NonNull
    @Override
    public MyReportsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_reports_list_design, parent, false);
        //context =  view.getContext().getApplicationContext();
        return new MyReportsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyReportsAdapter.MyViewHolder holder, final int position) {
        final TestPanelModel tmodel = list.get(position);
        //holder.monthTv.setText(tmodel.getName());
        holder.itemGroup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* MyReportsView myReportsView = new MyReportsView();

              //  fragmentManager = ((Activity)(context)).getFragmentManager();
               // fragmentManager = ((Activity)context).getFragmentManager();
                fragmentManager =((Activity)context.getApplicationContext()).getFragmentManager();
              //  FragmentManager fragmentManager = (HomeActivity)context;
               fragmentTransaction = fragmentManager.beginTransaction();
             // fragmentTransaction.replace(R.id.frame, myReportsView);
              fragmentTransaction.replace(R.id.frame, myReportsView);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

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
