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
 * Created by sam on 3/30/2018.
 */

public class MyReportsByTestNameAdapter extends RecyclerView.Adapter<MyReportsByTestNameAdapter.ViewHolder> {

    List<TestPanelModel> list;
    Context context;
    RecyclerView rv;

    MyReports myReports;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public MyReportsByTestNameAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
//        myReports =
//        fragmentManager = context.ge ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myreports_by_test_name_list_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TestPanelModel tmodel = list.get(position);
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
            testName = itemView.findViewById(R.id.testName_text);
            listItem1 = itemView.findViewById(R.id.itemOnList1);
        }
    }
}
