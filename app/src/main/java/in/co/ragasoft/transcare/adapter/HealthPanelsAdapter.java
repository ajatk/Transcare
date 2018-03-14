package in.co.ragasoft.transcare.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.modelClasses.ModelClass;


public class HealthPanelsAdapter extends RecyclerView.Adapter<HealthPanelsAdapter.MyViewHolder> implements Filterable {

    ArrayList<ModelClass> list;
    ArrayList<ModelClass> filterList;


    public HealthPanelsAdapter(ArrayList<ModelClass> list) {
        this.list = list;
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

        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                    ArrayList<ModelClass> filterList = new ArrayList<>();

                    for (ModelClass state : list) {

                        if (state.getDiscriptions().toLowerCase().contains(charString)) {

                            filterList.add(state);
                        }
                    }

                    filterList = filterList;
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

        public MyViewHolder(View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.textView3);
            tvAdd = itemView.findViewById(R.id.textView6);
        }
    }
}
