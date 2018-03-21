package in.co.ragasoft.transcare.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.modelClasses.ModelClass;


public class HealthPanelsAdapter extends RecyclerView.Adapter<HealthPanelsAdapter.MyViewHolder> implements Filterable {

    ArrayList<ModelClass> list;
    ArrayList<ModelClass> filterList;
    Context context;

    public HealthPanelsAdapter(ArrayList<ModelClass> list) {
        this.list = list;
    }

    public HealthPanelsAdapter(Context context, ArrayList<ModelClass> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_panels_list_design, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass modelClass = list.get(position);
        holder.tvPrice.setText(modelClass.getDiscriptions());
        // holder.tvAdd.setText(modelClass.getName());

        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*ProgressDialog pg = new ProgressDialog(context);
                pg.setMessage("Please wait.....");
                pg.show();*/

                Dialog dg = new Dialog(context);
                dg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                //requestWindowFeature(Window.FEATURE_NO_TITLE);
                dg.setContentView(R.layout.dailog_health_frag);
                dg.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    filterList = list;
                } else {

                    ArrayList<ModelClass> filteredList = new ArrayList<>();

                    for (ModelClass state : list) {

                        if (state.getDiscriptions().toLowerCase().contains(charString)) {

                            filteredList.add(state);
                        }
                    }

                    filterList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (ArrayList<ModelClass>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrice, tvAdd, tv3, tv4, tv5, tv6;
        FrameLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.textView3);
            tvAdd = itemView.findViewById(R.id.textView6);
            layout = itemView.findViewById(R.id.dailogbox_product);
        }
    }
}
