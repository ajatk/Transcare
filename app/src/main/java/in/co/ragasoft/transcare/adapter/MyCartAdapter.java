package in.co.ragasoft.transcare.adapter;

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
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

/**
 * Created by sam on 4/5/2018.
 */

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
    List<TestPanelModel> list;
    Context context;

    public MyCartAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myreports_by_test_name_list_design, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TestPanelModel tmodel = list.get(position);
        holder.listItem1.setText(tmodel.getName());
        holder.itemGroup1.setMaxHeight(30);
        holder.itemGroup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listItem1, listItem2, listItem3, monthTv;
        RecyclerView rv;
        ConstraintLayout itemGroup1;

        public ViewHolder(View itemView) {
            super(itemView);

            listItem1 = itemView.findViewById(R.id.itemOnList1);
            itemGroup1 = itemView.findViewById(R.id.itemGroup);
        }
    }
}
