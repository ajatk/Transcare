package in.co.ragasoft.transcare;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.co.ragasoft.transcare.Adapters.Intro_Slider_Adapter;

public class Intro_SliderActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutDot;
    TextView skip, getStarted;
    Intro_Slider_Adapter pagerAdapter;
    private ViewPager viewPager;
    private TextView[] dotstv;
    private int[] layouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro__slider);
        viewPager = findViewById(R.id.view_Pager);
        layoutDot = findViewById(R.id.dot_layout);
        skip = findViewById(R.id.skip);
        skip.setOnClickListener(this);
        getStarted = findViewById(R.id.getstarted);
        getStarted.setOnClickListener(this);
        setStatusBarTransparent();

        layouts = new int[]{R.layout.slider1, R.layout.slider2, R.layout.slider3, R.layout.slider4, R.layout.slider5};
        pagerAdapter = new Intro_Slider_Adapter(layouts, getApplicationContext());
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


    }

    private void setDotStatus(int page) {
        layoutDot.removeAllViews();
        layoutDot.setBackgroundColor(Color.WHITE);
        //layoutDot.

        dotstv = new TextView[layouts.length];
        for (int i = 0; i < layouts.length; i++) {
            dotstv[i] = new TextView(this);
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


    private void setStatusBarTransparent() {
//        if (Build.VERSION.SDK_INT >=21){
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
//            Window window=getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//

//        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skip:
                Intent intent = new Intent(Intro_SliderActivity.this, SignInActivity.class);
                startActivity(intent);
                break;

            case R.id.getstarted: {
                Intent i = new Intent(Intro_SliderActivity.this, SignInActivity.class);
                startActivity(i);
            }
        }
    }
}
