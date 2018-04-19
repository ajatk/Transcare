package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.BookAppointmentViewpagerAdapter;


public class BookYourAppointment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    BookAppointmentViewpagerAdapter adapter;
    Context context;
    RadioButton rB1, rB2, rB3, rB4;
    RadioGroup rg1, rg2;
    PinYourLocationOnMap pinYourLocationOnMap;
    SelectLocation_bookAppointment selectLocation;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_your_appointment, container, false);
        context = getActivity();
        tabLayout = view.findViewById(R.id.sliding_tabs);
        viewPager = view.findViewById(R.id.viewPager_bookAppointment);
        adapter = new BookAppointmentViewpagerAdapter(context, getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        rB1 = view.findViewById(R.id.sheduleAppt);
        rB2 = view.findViewById(R.id.bookNow);
        rB3 = view.findViewById(R.id.visitLab);
        rB4 = view.findViewById(R.id.onSite);
        rg1 = view.findViewById(R.id.selectTime_radioGroup1);
        rg1.setOnCheckedChangeListener(this);
        rg1.clearCheck();
        rg2 = view.findViewById(R.id.selectAddress_radioGroup2);
        rg2.setOnCheckedChangeListener(this);
        rg2.clearCheck();

        return view;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton rb = group.findViewById(checkedId);
        RadioButton lastCheckedRB = null;

        if (null != rb && checkedId > -1) {

            if (rB1.isChecked() && rB4.isChecked()) {
                fragment = new PinYourLocationOnMap();

                methodFrag(fragment);
                Toast.makeText(context, "<rb1 +rb4", Toast.LENGTH_SHORT).show();


            } else if (rB2.isChecked() == rB4.isChecked()) {
                fragment = new PinYourLocationOnMap();

                methodFrag(fragment);
                Toast.makeText(context, "<<<rb2 +rb4", Toast.LENGTH_SHORT).show();

            } else if (rB3.isChecked() == rB2.isChecked()) {
                fragment = new SelectLocation_bookAppointment();
                methodFrag(fragment);
                Toast.makeText(context, "<<<rb3 +rb2", Toast.LENGTH_SHORT).show();

            } else if (rB1.isChecked() == rB3.isChecked()) {
                fragment = new SelectLocation_bookAppointment();
                methodFrag(fragment);
                Toast.makeText(context, "<rb3 +rb1>>>>>", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void methodFrag(Fragment fragment) {
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame1, fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);


    }
}
