package in.co.ragasoft.transcare.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hdodenhof.circleimageview.CircleImageView;
import in.co.ragasoft.transcare.R;


public class FamilyHealthTrend2 extends Fragment implements View.OnClickListener {
    FamilyHealthTrends3 reportsDetail;
    FragmentTransaction fragmentTransaction;
    CircleImageView yellowCircle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_family_health_trend2, container, false);
        yellowCircle = view.findViewById(R.id.yellowCircleView);
        yellowCircle.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.yellowCircleView:

                if (reportsDetail == null) {
                    reportsDetail = new FamilyHealthTrends3();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, reportsDetail);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, reportsDetail);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
        }
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
