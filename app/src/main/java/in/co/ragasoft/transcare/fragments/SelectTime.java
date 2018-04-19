package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.ExpandableListAdapter;
import in.co.ragasoft.transcare.adapter.SecondLevelAdapter;
import in.co.ragasoft.transcare.adapter.SpinAdapter;


public class SelectTime extends Fragment implements OnGroupClickListener {

    Spinner reportSpin, whatsappSpin;
    SpinAdapter spinAdapter;
    List<String> list;
    Context context;
    TextView spinText;
    SecondLevelAdapter secondLevelAdapter;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String, List<String>> listDataChild2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_your_appointment_expandable_list, container, false);
        context = getActivity();
        expListView = view.findViewById(R.id.spinnerReport);

        prepareListData();
        listAdapter = new ExpandableListAdapter(context, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(this);

        return view;

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        // listDataChild2 = new HashMap<String, List<String>>();
        listDataHeader.add("Report Delivery Prefrences");


        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Shawshank Redemption");

        listDataChild.put(listDataHeader.get(0), top250);
        // listDataChild.put(listDataHeader.get(1), top250);


    }


    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
           expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getActivity(),
                        "Group Clicked " + listDataHeader.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        return true;
    }
}
/*public class SelectTime extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner reportSpin, whatsappSpin;
    SpinAdapter spinAdapter;
    List<String> list;
    Context context;
    TextView spinText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_select_time, container, false);
       context =getActivity();
      // whatsappSpin =view.findViewById(R.id.spinner_whatsapp);
      // spinText = view.findViewById(R.id.spinner1);
       list =new ArrayList<>();
       list.add("one");
       list.add("two");
       spinAdapter = new SpinAdapter(context,list);
       whatsappSpin.setAdapter(spinAdapter);
        /*ArrayAdapter adapter = new ArrayAdapter(context,R.layout.spin_adapt, list);
        adapter.setDropDownViewResource(R.layout.spin_adapt);
        whatsappSpin.setAdapter(adapter);
        whatsappSpin.setOnItemSelectedListener(this);

                return view;
                }


@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }

@Override
public void onNothingSelected(AdapterView<?> parent) {

        }
        }
        */