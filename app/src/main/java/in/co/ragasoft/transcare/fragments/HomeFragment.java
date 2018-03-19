package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.ragasoft.transcare.R;

public class HomeFragment extends Fragment {

    View view;
//    Resources res;
//    Drawable drawable;
//    ProgressBar progress_bar;

    private OnFragmentInteractionListener mListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
//        res = getResources();
//        drawable = res.getDrawable(R.drawable.progress_dialog);
//        progress_bar = view.findViewById(R.id.progressBar);
//        progress_bar.setProgress(25);
//        progress_bar.setSecondaryProgress(50);
//        progress_bar.setMax(100);
//        progress_bar.setProgressDrawable(drawable);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
