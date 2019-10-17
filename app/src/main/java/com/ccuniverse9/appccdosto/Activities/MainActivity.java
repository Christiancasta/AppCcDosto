package com.ccuniverse9.appccdosto.Activities;

import android.os.Bundle;

import com.ccuniverse9.appccdosto.Fragments.AboutFragment;
import com.ccuniverse9.appccdosto.Fragments.ChatFragment;
import com.ccuniverse9.appccdosto.Fragments.GalleryFragment;
import com.ccuniverse9.appccdosto.Fragments.HomeFragment;
import com.ccuniverse9.appccdosto.Fragments.LocationFragment;
import com.ccuniverse9.appccdosto.Fragments.RateFragment;
import com.ccuniverse9.appccdosto.Fragments.SendFragment;
import com.ccuniverse9.appccdosto.Fragments.SettingsFragment;
import com.ccuniverse9.appccdosto.Fragments.ShareFragment;
import com.ccuniverse9.appccdosto.Helpers.Functions;
import com.ccuniverse9.appccdosto.R;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendFragment sendFragment = new SendFragment();
                Functions.changeMainFragment(MainActivity.this, sendFragment);
            }

            public void hiddeFloatingButton() {
                fab.hide();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = new HomeFragment();
        Functions.changeMainFragment(MainActivity.this, homeFragment);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // No inspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingsFragment settingsFragment = new SettingsFragment();
            Functions.changeMainFragment(MainActivity.this, settingsFragment);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            HomeFragment homeFragment = new HomeFragment();
            Functions.changeMainFragment(MainActivity.this, homeFragment);

        } else if (id == R.id.nav_gallery) {
            GalleryFragment galleryFragment = new GalleryFragment();
            Functions.changeMainFragment(MainActivity.this, galleryFragment);

        } else if (id == R.id.nav_location) {
            LocationFragment locationFragment = new LocationFragment();
            Functions.changeMainFragment(MainActivity.this, locationFragment);

        } else if (id == R.id.nav_about) {
            AboutFragment aboutFragment = new AboutFragment();
            Functions.changeMainFragment(MainActivity.this, aboutFragment);

        } else if (id == R.id.nav_share) {
            ShareFragment shareFragment = new ShareFragment();
            Functions.changeMainFragment(MainActivity.this, shareFragment);

        } else if (id == R.id.nav_send) {
            SendFragment sendFragment = new SendFragment();
            Functions.changeMainFragment(MainActivity.this, sendFragment);

        } else if (id == R.id.nav_chat) {
            ChatFragment chatFragment = new ChatFragment();
            Functions.changeMainFragment(MainActivity.this, chatFragment);

        } else if (id == R.id.nav_rate) {
            RateFragment rateFragment = new RateFragment();
            Functions.changeMainFragment(MainActivity.this, rateFragment);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}