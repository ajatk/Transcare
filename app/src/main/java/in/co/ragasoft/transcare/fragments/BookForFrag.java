package in.co.ragasoft.transcare.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.ragasoft.transcare.R;


public class BookForFrag extends Fragment implements View.OnClickListener {

    ConstraintLayout layoutBookTest;
    SelectYourTestPanel testPanel;
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_for, container, false);
        layoutBookTest = view.findViewById(R.id.layout_bookeeName);
        layoutBookTest.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_bookeeName:
                if (testPanel == null) {
                    testPanel = new SelectYourTestPanel();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, testPanel);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, testPanel);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;

        }
    }
}
