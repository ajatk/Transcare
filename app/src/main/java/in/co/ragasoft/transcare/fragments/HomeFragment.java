package in.co.ragasoft.transcare.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.co.ragasoft.transcare.R;
import in.co.ragasoft.transcare.adapter.DashboardSliderAdapter;

public class HomeFragment extends Fragment implements View.OnClickListener {
    LinearLayout layoutDot;
    DashboardSliderAdapter pagerAdapter;
    ImageView bookATest, healthTrends;
    View view;
    ConstraintLayout bookTestLayout, reports, testPanelLayout, myFamily, healthTrend;
    Fragment fragment = null;
    SelectYourTestPanel testPanel;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BookForFrag bookFor;
    MyFamily mfamily;
    MyHealthTrends myHealth;

    Context context;
    private int[] layouts;
    private Drawable[] drawable;
    private TextView[] dotstv;
    private ViewPager viewPager;
//    Resources res;
//    Drawable drawable;
//    ProgressBar progress_bar;
    private OnFragmentInteractionListener mListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        // bookATest =view.findViewById(R.id.booktest_image); bookATest.setImageResource(R.drawable.book_test);
        // healthTrends = view.findViewById(R.id.healthtracker_image);healthTrends.setImageResource(R.drawable.health_trends);
        bookTestLayout = view.findViewById(R.id.layout_bookTest);   bookTestLayout.setOnClickListener(this);
        testPanelLayout = view.findViewById(R.id.layout_testPanel); testPanelLayout.setOnClickListener(this);
        myFamily = view.findViewById(R.id.layout_myFamily);  myFamily.setOnClickListener(this);
        healthTrend = view.findViewById(R.id.layout_healthTrends);  healthTrend.setOnClickListener(this);


        viewPager = view.findViewById(R.id.viewPager_Dashboard);
        layoutDot = view.findViewById(R.id.dot_layout);
        layouts = new int[]{R.layout.dashboard_slide1, R.layout.dashboard_slide2, R.layout.dashboard_slide3, R.layout.dashboard_slide4, R.layout.dashboard_slide5};
        pagerAdapter = new DashboardSliderAdapter(layouts, getContext());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == layouts.length - 1) {
                    //last page
//                    btnNext.setText("START");
//                    btnNext.setTextColor(getResources().getColor(R.color.white));
//                    btnSkip.setVisibility(View.GONE);
                } else {
//                    btnNext.setText("NEXT");
//                    btnSkip.setVisibility(View.VISIBLE);
//                    btnSkip.setTextColor(getResources().getColor(R.color.white));
                }
                setDotStatus(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setDotStatus(0);
//        res = getResources();
//        drawable = res.getDrawable(R.drawable.progress_dialog);
//        progress_bar = view.findViewById(R.id.progressBar);
//        progress_bar.setProgress(25);
//        progress_bar.setSecondaryProgress(50);
//        progress_bar.setMax(100);
//        progress_bar.setProgressDrawable(drawable);

        return view;
    }

    private void setDotStatus(int page) {
        layoutDot.removeAllViews();
        dotstv = new TextView[layouts.length];
        for (int i = 0; i < layouts.length; i++) {
            dotstv[i] = new TextView(getContext());
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(40);
            dotstv[i].setTextColor(Color.parseColor("#f5f7f9"));
            layoutDot.addView(dotstv[i]);
        }
        //set current dot active
        if (dotstv.length > 0) {
            dotstv[page].setTextColor(Color.parseColor("#cc484a"));
        }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_bookTest:
                if (bookFor == null) {
                    bookFor = new BookForFrag();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, bookFor);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, bookFor);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
            case R.id.layout_testPanel:
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

            case R.id.layout_myFamily:
                if (mfamily == null) {
                    mfamily = new MyFamily();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, mfamily);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, mfamily);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;

            case R.id.layout_healthTrends:
                if (myHealth == null) {
                    myHealth = new MyHealthTrends();
                    //fragmentManager = getFragmentManager();
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, myHealth);
                    fragmentTransaction.commit();
                } else {
                    fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, myHealth);
                    fragmentTransaction.commit();
                }
                fragmentTransaction.addToBackStack(null);
                break;
        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
