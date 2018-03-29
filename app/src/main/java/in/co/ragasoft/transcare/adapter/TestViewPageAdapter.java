package in.co.ragasoft.transcare.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import in.co.ragasoft.transcare.fragments.HealthPackagesFragment;
import in.co.ragasoft.transcare.fragments.PopularTestFrag;
import in.co.ragasoft.transcare.fragments.TestPanelsFragment;

/**
 * Created by Rajat on 3/22/2018.
 */

public class TestViewPageAdapter extends FragmentStatePagerAdapter {

    String a[] = {"Poular Test", "Test Panels", "Health Packages"};
    private Context mContext;


    public TestViewPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {

            return new PopularTestFrag();
        } else if (position == 2) {
            return new HealthPackagesFragment();

        } else {

            return new TestPanelsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if (position == 0) {
            title = a[0];

        } else if (position == 1) {
            title = a[1];
        } else {
            title = a[2];
        }

        return title;

    }
}
