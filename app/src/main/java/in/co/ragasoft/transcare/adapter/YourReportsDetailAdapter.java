package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

/**
 * Created by sam on 3/28/2018.
 */

public class YourReportsDetailAdapter extends RecyclerView.Adapter<YourReportsDetailAdapter.ViewHolder> {

    List<TestPanelModel> list;
    Context context;
    RecyclerView rv;

    public YourReportsDetailAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_reports_detail_list_design, parent, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TestPanelModel tmodel = list.get(position);
        holder.listItemName.setText(tmodel.getName());
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listItemName;

        public ViewHolder(View itemView) {
            super(itemView);

            listItemName = itemView.findViewById(R.id.listItem_name);
        }
    }
}
