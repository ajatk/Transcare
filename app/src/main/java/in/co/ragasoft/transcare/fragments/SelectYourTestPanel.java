package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.TestViewPageAdapter;

public class SelectYourTestPanel extends Fragment {
    ViewPager viewPager;
    TestViewPageAdapter pageAdapter;
    TabLayout tabLayout;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_your_test_panel, container, false);
        context = getActivity();
        viewPager = view.findViewById(R.id.viewPagerTest);
        pageAdapter = new TestViewPageAdapter(context, getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


}
