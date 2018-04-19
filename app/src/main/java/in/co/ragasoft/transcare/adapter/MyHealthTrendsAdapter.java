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

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.fragments.MyReports;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

/**
 * Created by sam on 4/2/2018.
 */

public class MyHealthTrendsAdapter extends RecyclerView.Adapter<MyHealthTrendsAdapter.ViewHolder> {

   // List<TestPanelModel> list;
   ArrayList<String> list;
    Context context;
    RecyclerView rv;

    MyReports myReports;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public MyHealthTrendsAdapter(Context context, ArrayList<String> list) {
        this.list =list;
        this.context =context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_trend_list, parent, false);
        //context =  view.getContext().getApplicationContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String tmodel = list.get(position);
        holder.testName.setText(tmodel);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listItem1, listItem2, listItem3, testName;
        ConstraintLayout itemGroup1;

        public ViewHolder(View itemView) {
            super(itemView);
            testName = itemView.findViewById(R.id.itemOnList1);
           // testName = itemView.findViewById(R.id.testName_text);

        }
    }
}
