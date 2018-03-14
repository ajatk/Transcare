package in.co.ragasoft.transcare;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        switch (item.getItemId()) {
            case R.id.my_family: {
                Toast.makeText(this, "My Family", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.my_order: {
                Toast.makeText(this, "My Order", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.health_trend: {
                Toast.makeText(this, "Health Trends", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.wallet: {
                Toast.makeText(this, "Wallet", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.call_us: {
                Toast.makeText(this, "Call Us", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.feed_back: {
                Toast.makeText(this, "Feed Back", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.notification: {
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.share: {
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
            }
        }

        FullDrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class FullDrawerLayout extends DrawerLayout {

        private static final int MIN_DRAWER_MARGIN = 0; // dp

        public FullDrawerLayout(Context context) {
            super(context);
        }

        public FullDrawerLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public FullDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

            if (widthMode != MeasureSpec.EXACTLY || heightMode != MeasureSpec.EXACTLY) {
                throw new IllegalArgumentException(
                        "DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }

            setMeasuredDimension(widthSize, heightSize);

            // Gravity value for each drawer we've seen. Only one of each permitted.
            int foundDrawers = 0;
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);

                if (child.getVisibility() == GONE) {
                    continue;
                }

                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                if (isContentView(child)) {
                    // Content views get measured at exactly the layout's size.
                    final int contentWidthSpec = MeasureSpec.makeMeasureSpec(
                            widthSize - lp.leftMargin - lp.rightMargin, MeasureSpec.EXACTLY);
                    final int contentHeightSpec = MeasureSpec.makeMeasureSpec(
                            heightSize - lp.topMargin - lp.bottomMargin, MeasureSpec.EXACTLY);
                    child.measure(contentWidthSpec, contentHeightSpec);
                } else if (isDrawerView(child)) {
                    final int childGravity =
                            getDrawerViewGravity(child) & Gravity.HORIZONTAL_GRAVITY_MASK;
                    if ((foundDrawers & childGravity) != 0) {
                        throw new IllegalStateException("Child drawer has absolute gravity " +
                                gravityToString(childGravity) + " but this already has a " +
                                "drawer view along that edge");
                    }
                    final int drawerWidthSpec = getChildMeasureSpec(widthMeasureSpec,
                            MIN_DRAWER_MARGIN + lp.leftMargin + lp.rightMargin,
                            lp.width);
                    final int drawerHeightSpec = getChildMeasureSpec(heightMeasureSpec,
                            lp.topMargin + lp.bottomMargin,
                            lp.height);
                    child.measure(drawerWidthSpec, drawerHeightSpec);
                } else {
                    throw new IllegalStateException("Child " + child + " at index " + i +
                            " does not have a valid layout_gravity - must be Gravity.LEFT, " +
                            "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }

        boolean isContentView(View child) {
            return ((LayoutParams) child.getLayoutParams()).gravity == Gravity.NO_GRAVITY;
        }

        boolean isDrawerView(View child) {
            final int gravity = ((LayoutParams) child.getLayoutParams()).gravity;
            int absGravity = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                absGravity = Gravity.getAbsoluteGravity(gravity,
                        child.getLayoutDirection());
            }
            return (absGravity & (Gravity.LEFT | Gravity.RIGHT)) != 0;
        }

        int getDrawerViewGravity(View drawerView) {
            final int gravity = ((LayoutParams) drawerView.getLayoutParams()).gravity;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                return Gravity.getAbsoluteGravity(gravity, drawerView.getLayoutDirection());
            }
            return gravity;
        }

        String gravityToString(int gravity) {
            if ((gravity & Gravity.LEFT) == Gravity.LEFT) {
                return "LEFT";
            }
            if ((gravity & Gravity.RIGHT) == Gravity.RIGHT) {
                return "RIGHT";
            }
            return Integer.toHexString(gravity);
        }

    }
}
