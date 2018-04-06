package in.co.ragasoft.transcare.fragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.ragasoft.transcare.R;

public class MyFamily extends Fragment implements View.OnClickListener {
    ConstraintLayout layoutBookTest, layoutAddMember;
    FamilyHealthTrends familyHealthTrends;
    FragmentTransaction fragmentTransaction;
    AddFamilyMember familyMember;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_family, container, false);
        layoutBookTest = view.findViewById(R.id.layout_bookeeName);
        layoutBookTest.setOnClickListener(this);
        layoutAddMember = view.findViewById(R.id.layout_addMember);
        layoutAddMember.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_bookeeName:
                if (familyHealthTrends == null) {
                    familyHealthTrends = new FamilyHealthTrends();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, familyHealthTrends);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, familyHealthTrends);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
            case R.id.layout_addMember:
                if (familyMember == null) {
                    familyMember = new AddFamilyMember();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, familyMember);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, familyMember);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
        }
    }
}
