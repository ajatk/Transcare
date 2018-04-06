package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import in.co.ragasoft.transcare.R;

/**
 * Created by sam on 4/3/2018.
 */

public class SecondLevelAdapter extends BaseExpandableListAdapter {


    private Context _context;
    private List<String> _listDataHeader;
    private List<String> child_list;
    private HashMap<String, List<String>> _listDataChild;

    public SecondLevelAdapter(Context context, List<String> listDataHeader,
                              HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    public SecondLevelAdapter(Context context, List<String> child_list) {
        this._context = context;
        this.child_list = child_list;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
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
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_book_appointment, null);
        }
        TextView lbblListHeader = convertView
                .findViewById(R.id.spinner_whatsapp);
        lbblListHeader.setTypeface(null, Typeface.BOLD);
        lbblListHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.spin_adapt, null);
        }
        RadioGroup txtListChild = convertView
                .findViewById(R.id.radioGroup_book);
        txtListChild.clearCheck();
        /*ExpandableListView txtListChild = convertView
                .findViewById(R.id.listView_whatsapp);
*/
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
