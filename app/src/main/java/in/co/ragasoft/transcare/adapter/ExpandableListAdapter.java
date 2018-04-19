package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.co.ragasoft.transcare.R;

/**
 * Created by sam on 4/3/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    HashMap<String, List<String>> listDataChild;
    private Context _context;
    private List<String> _listDataHeader;
    private List<String>listDataHeaders;
    private HashMap<String, List<String>> _listDataChild;
    private HashMap<String, List<String>> secList_listDataChild;
    private List<String> child_list;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }


    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
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
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_list_book_appointment, null);
        }
        TextView lblListHeader = convertView
                .findViewById(R.id.spinner_whatsapp);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        listDataHeaders = new ArrayList<String>();
        listDataHeaders.add("Report ");
        secList_listDataChild = new HashMap<String, List<String>>();

        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        secList_listDataChild.put(listDataHeaders.get(0),top250);

        CustExpListview SecondLevelexplv = new CustExpListview(_context);

        SecondLevelexplv.setAdapter(new SecondLevelAdapter(_context,listDataHeaders,secList_listDataChild));

        SecondLevelexplv.setGroupIndicator(null);
        return SecondLevelexplv;
       // return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class CustExpListview extends ExpandableListView {

        int intGroupPosition, intChildPosition, intGroupid;

        public CustExpListview(Context context) {
            super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

            widthMeasureSpec = MeasureSpec.makeMeasureSpec(960,

                    MeasureSpec.AT_MOST);

            heightMeasureSpec = MeasureSpec.makeMeasureSpec(600,

                    MeasureSpec.AT_MOST);

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        }
    }

    public class SecondLevelAdapter extends BaseExpandableListAdapter {
        private List<String> listDataHeader;

        private Context _context;
        // private List<String> _list_DataHeader;
        private List<String> child_list;
        //   private HashMap<String, List<String>> _listDataChild;
        private HashMap<String, List<String>> listDataChild;


       /* public SecondLevelAdapter(Context context, List<String> listDataHeader,
                                  HashMap<String, List<String>> listChildData) {
            this._context = context;
            this._list_DataHeader = listDataHeader;
            this._listDataChild = listChildData;
        }*/

        public SecondLevelAdapter(Context context, List<String> child_list) {
            this._context = context;
            this.child_list = child_list;
        }

        public SecondLevelAdapter(Context context) {
            this._context = context;
        }

        public SecondLevelAdapter() {

        }

        public SecondLevelAdapter(Context context, HashMap<String, List<String>> listDataChild) {
            this._context = context;
            this.listDataChild = listDataChild;
        }

        public SecondLevelAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
            this._context = context;
            this.listDataChild = listDataChild;
            this.listDataHeader = listDataHeader;

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
            return 2;
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
                LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.expandable_list_book_appointment, null);
            }
            TextView lbblListHeader = convertView
                    .findViewById(R.id.spinner_whatsapp);
            final RadioGroup rg = convertView.findViewById(R.id.radioGroup_book);
            lbblListHeader.setTypeface(null, Typeface.BOLD);
            lbblListHeader.setText("WhatsApp");

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
            txtListChild.setTag(childText);
            txtListChild.clearCheck();
        /*ExpandableListView txtListChild = convertView
                .findViewById(R.id.listView_whatsapp);
*/
            return txtListChild;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }


    }
    private void prepareListData() {
        listDataHeaders = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        // listDataChild2 = new HashMap<String, List<String>>();
        listDataHeaders.add("Report ");


        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Shawshank Redemption");

        listDataChild.put(listDataHeaders.get(0), top250);
        // listDataChild.put(listDataHeader.get(1), top250);


    }
}
