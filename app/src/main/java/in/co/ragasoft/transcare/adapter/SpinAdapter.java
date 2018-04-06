package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import java.util.List;

import in.co.ragasoft.transcare.R;

/**
 * Created by sam on 4/3/2018.
 */

public class SpinAdapter extends BaseAdapter {
    LayoutInflater inflator;
    List<String> mCounting;

    public SpinAdapter(Context context, List<String> list) {
        inflator = LayoutInflater.from(context);
        mCounting = list;
    }


    @Override
    public int getCount() {
        return mCounting.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflator.inflate(R.layout.spin_adapt, null);
        RadioButton rButton1 = convertView.findViewById(R.id.radioButton1);
        RadioButton rButton2 = convertView.findViewById(R.id.radioButton2);
        return convertView;
    }
}
