package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.modelClasses.TestPanelModel;

/**
 * Created by sam on 4/4/2018.
 */

public class MyReportsByTestName_Adapter extends BaseExpandableListAdapter {

    Context context;
    RecyclerView rv;
    List<String> _listDataHeader;
    private List<TestPanelModel> list;
    private HashMap<String, List<String>> _listDataChild;

    public MyReportsByTestName_Adapter(Context context, List<TestPanelModel> list) {
        this.list = list;
        this.context = context;
//        myReports =
//        fragmentManager = context.ge ;
    }

    public MyReportsByTestName_Adapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this.context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        if (_listDataHeader == null)
            return 0;
        else
            return this._listDataHeader.size();

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = String.valueOf(getGroup(groupPosition));
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.myreports_by_test_name_list_design, null);
        }
        TextView lblListHeader = convertView
                .findViewById(R.id.itemOnList1);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // convertView = infalInflater.inflate(R.layout.second_level_expandable_list, null);
            convertView = infalInflater.inflate(R.layout.by_test_name_child_list, null);
        }

        TextView listHeader = convertView.findViewById(R.id.listItem);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(childText);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
