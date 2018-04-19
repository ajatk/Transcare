package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import in.co.ragasoft.transcare.fragments.SelectLocation;
import in.co.ragasoft.transcare.fragments.SelectTime;

/**
 * Created by sam on 4/2/2018.
 */

public class BookAppointmentViewpagerAdapter extends FragmentStatePagerAdapter {
    String a[] = {"Select Time", "Select Address"};
    private Context mContext;
    SelectLocation selectLocation;
    SelectTime selectTime;
    public BookAppointmentViewpagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new SelectTime();
        } else {

            return new SelectLocation();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if (position == 0) {
            title = a[0];

        } else {
            title = a[1];
        }

        return title;

    }
}
