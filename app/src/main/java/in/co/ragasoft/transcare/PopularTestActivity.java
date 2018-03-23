package in.co.ragasoft.transcare;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import in.co.ragasoft.transcare.adapter.TestViewPageAdapter;

public class PopularTestActivity extends AppCompatActivity {

    ViewPager viewPager;
    TestViewPageAdapter pageAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_test);
        viewPager = findViewById(R.id.viewPagerTest);
        pageAdapter = new TestViewPageAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
