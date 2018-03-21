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
 * Created by Rajat on 3/21/2018.
 */

public class TestPanelAdapter extends RecyclerView.Adapter<TestPanelAdapter.MyViewHolder> {

    List<TestPanelModel> list;
    Context context;


    public TestPanelAdapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_test_panel_list_design, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TestPanelModel tmodel = list.get(position);
        holder.itemprice.setText(tmodel.getRupee());
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        else
            return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemprice;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemprice = itemView.findViewById(R.id.item_Price);
        }
    }
}
