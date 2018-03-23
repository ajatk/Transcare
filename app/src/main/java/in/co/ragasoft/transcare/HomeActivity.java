package in.co.ragasoft.transcare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import in.co.ragasoft.transcare.fragments.EditProfile;
import in.co.ragasoft.transcare.fragments.HealthPanelsFrag;
import in.co.ragasoft.transcare.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HealthPanelsFrag.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener {

    private static int navItemIndex = 0;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;
    Context context;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    ConstraintLayout srchToolbarLayout;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        srchToolbarLayout = findViewById(R.id.srch_toolbar_layout);
        toolbar.inflateMenu(R.menu.toolbar_menu_item);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(context, "notification", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        setSupportActionBar(toolbar);

        mHandler = new Handler();
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        context = getApplicationContext();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView = findViewById(R.id.bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home: {
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.frame, homeFragment);
                            fragmentTransaction.commit();
                        } else {
                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.frame, homeFragment);
                            fragmentTransaction.commit();
                        }
                    }
                }

                return false;
            }
        });


        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, homeFragment);
            fragmentTransaction.commit();
        } else {
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, homeFragment);
            fragmentTransaction.commit();
        }


//        displaySelectedScreen(R.id.my_family);
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//
//        return super.onOptionsItemSelected(item);
//    }

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
        displaySelectedScreen(item.getItemId());
        return true;
    }

    private Fragment getFragment() {
        switch (navItemIndex) {
            case 0:
                HealthPanelsFrag healthPanelsFrag = new HealthPanelsFrag();
                return healthPanelsFrag;
            case 1:
                EditProfile editProfile = new EditProfile();
                return editProfile;

        }
        return fragment;
    }

    private void displaySelectedScreen(int itemId) {
        switch (itemId) {
            case R.id.my_family: {

                Toast.makeText(this, "My Family", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.my_order: {
                Intent intent = new Intent(HomeActivity.this, ChooseTestPanel.class);
                startActivity(intent);
                Toast.makeText(this, "My Order", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.health_trend: {
                HealthPanelsFrag healthPanelsFrag = new HealthPanelsFrag();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, healthPanelsFrag);
                fragmentTransaction.commit();

                Toast.makeText(this, "Health Trends", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.wallet: {
                Intent intent1 = new Intent(HomeActivity.this, PopularTestActivity.class);
                startActivity(intent1);
                Toast.makeText(this, "Wallet", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.call_us: {
                //toolbar.setVisibility(View.GONE);
                // toolbar.setTitle("EDIT PROFILE");

                //srchToolbarLayout.setVisibility(View.GONE);
                EditProfile editProfile = new EditProfile();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, editProfile);
                fragmentTransaction.commit();


                Toast.makeText(this, "Call Us", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.feed_back: {
                Intent intent = new Intent(HomeActivity.this, CreateAccount.class);
                startActivity(intent);
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

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
