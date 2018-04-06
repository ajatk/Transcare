package in.co.ragasoft.transcare.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import in.co.ragasoft.transcare.R;

public class SelectLocation_bookAppointment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    RadioButton rB1, rB2, rB3, rB4;
    RadioGroup rg1, rg2;
    PinYourLocationOnMap pinYourLocationOnMap;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_location_book_appointment, container, false);

        return view;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


    }
}
