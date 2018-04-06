package in.co.ragasoft.transcare.unkonown_frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.MyCartAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MyCart extends Fragment {
    MyCartAdapter adapter;
    RecyclerView rv;
    Context context;
    List<TestPanelModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        context = getActivity();
        list = new ArrayList<>();
        rv = view.findViewById(R.id.recyclerView_myCart);
        adapter = new MyCartAdapter(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        getOrder();
        return view;
    }

    public void getOrder() {

        TestPanelModel tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "mar");
        list.add(tmodle);


    }


}
