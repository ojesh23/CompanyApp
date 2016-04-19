package com.kullabs.kullabsapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        //mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        switch (position) {
            default: {
                return;
            }

          /*  case 0: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Class8");
                if (fragment == null) {
                    fragment = new Class8();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Class 8").commit();
                return;
            }*/
            case 1: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Class9");
                if (fragment == null) {
                    fragment = new Home();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Class 9").commit();
                return;
            }

            case 2: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Class10");
                if (fragment == null) {
                    fragment = new Home();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Class 10").commit();
                return;
            }
            case 3: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Home");
                if (fragment == null) {
                    fragment = new Dashboard();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Home").commit();
                return;
            }
            case 4: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Dashboard");
                if (fragment == null) {
                    fragment = new Home();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Dashboard").commit();
                return;
            }
            case 5: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Notification");
                if (fragment == null) {
                    fragment = new Notification();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Notification").commit();
                return;
            }
            case 6: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("Sponsored quiz");
                if (fragment == null) {
                    fragment = new Quiz();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, "Quiz").commit();
                return;
            }

            case 7: {
                finish();
                System.exit(0);
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
        }

        return super.onOptionsItemSelected(item);
    }


}
