package in.co.ragasoft.transcare;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import in.co.ragasoft.transcare.adapter.HealthPanelsAdapter;
import in.co.ragasoft.transcare.modelClasses.ModelClass;

public class HealthPanels extends AppCompatActivity {

    HealthPanelsAdapter adapter;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    Context context;

    ArrayList<ModelClass> list = new ArrayList<ModelClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_panels);
        context = getApplicationContext();
        rv = findViewById(R.id.recyclerview_healthPanels);
        adapter = new HealthPanelsAdapter(list);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);


    }

    public void listInIt() {
        ModelClass modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);
        modelClass = new ModelClass("", "");
        list.add(modelClass);

    }
}
