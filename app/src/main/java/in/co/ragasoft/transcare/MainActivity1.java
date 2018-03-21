package in.co.ragasoft.transcare;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import in.co.ragasoft.transcare.adapter.TestPanelAdapter;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

public class MainActivity1 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TestPanelAdapter madapter;
    List<TestPanelModel> list = new ArrayList<TestPanelModel>();
    String spinnerG;

    RecyclerView rv;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);

        context = getApplicationContext();
        rv = findViewById(R.id.recyclerview_testPanels);
        madapter = new TestPanelAdapter(context, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        rv.setAdapter(madapter);
        rv.setItemAnimator(new DefaultItemAnimator());
        getmoney();
    }

    public void getmoney() {

        TestPanelModel tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);
        tmodle = new TestPanelModel("4,569", "");
        list.add(tmodle);

    }
}
