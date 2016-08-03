package com.example.lucas.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//        implements NavigationView.OnNavigationItemSelectedListener {

//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawer;
//    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) {
                    menuItem.setChecked(true);
                } else {
                    menuItem.setChecked(false);
                }

                drawer.closeDrawers();

                switch (menuItem.getItemId()) {

                    case R.id.nav_book:
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_video:
                        Toast.makeText(getApplicationContext(),"Animes Selected",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(), FragmentAnime.class);
//            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
//            startActivity(intent);
//            startActivity(new Intent(this, FragmentAnime.class));
                        FragmentAnime fragmentAnime = new FragmentAnime();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, fragmentAnime);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return true;
                    case R.id.nav_slideshow:
                        Toast.makeText(getApplicationContext(),"Slideshow Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_manage:
                        Toast.makeText(getApplicationContext(),"Manage Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_share:
                        Toast.makeText(getApplicationContext(),"Share Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_send:
                        Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Deu ruim",Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

        };

//        drawerToggle = setupDrawerToggle();

        drawer.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

        //
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);

    }

    public void setFragmentAnime() {
        BlankFragment blankFragment = new BlankFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, blankFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//    private ActionBarDrawerToggle setupDrawerToggle() {
//        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//
//        drawerToggle.syncState();
//    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        drawerToggle.onConfigurationChanged(newConfig);
//    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

//    private void toggle() {
//        int drawerLockMode = drawer.getDrawerLockMode(GravityCompat.START);
//        if (drawer.isDrawerVisible(GravityCompat.START) && drawerLockMode != drawer.LOCK_MODE_LOCKED_OPEN) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else if (drawerLockMode != drawer.LOCK_MODE_LOCKED_CLOSED) {
//            drawer.openDrawer(GravityCompat.START);
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            toggle();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//
//        if (item.isChecked()) item.setChecked(false);
//        else item.setChecked(true);
//
//        drawer.closeDrawers();
//
//        int id = item.getItemId();
//
//        if (id == R.id.nav_book) {
//            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//            startActivity(intent);
//            return true;
//        } else if (id == R.id.nav_video) {
////            item.setChecked(true);
////            drawer.closeDrawers();
////            Intent intent = new Intent(getApplicationContext(), FragmentAnime.class);
////            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
////            startActivity(intent);
////            startActivity(new Intent(this, FragmentAnime.class));
//            FragmentAnime fragmentAnime = new FragmentAnime();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frame_content, fragmentAnime);
//            fragmentTransaction.commit();
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        drawer.closeDrawer(GravityCompat.START);
//        drawer.closeDrawers();
//        return true;
//    }
}
