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

public class PopularListDesignAdapter extends RecyclerView.Adapter<PopularListDesignAdapter.MyViewHolder> {

    List<TestPanelModel> alist;
    Context context;

    public PopularListDesignAdapter(Context context, List<TestPanelModel> list) {
        this.alist = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_design_popular_test, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TestPanelModel tmodel = alist.get(position);
        holder.itemPrice.setText(tmodel.getRupee());



    }

    @Override
    public int getItemCount() {
        return alist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemOnIndex, itemPrice, addToCart;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemOnIndex = itemView.findViewById(R.id.itemOnIndex);
            itemPrice = itemView.findViewById(R.id.itemList_Price);
            addToCart = itemView.findViewById(R.id.addToCart);
        }
    }
}
