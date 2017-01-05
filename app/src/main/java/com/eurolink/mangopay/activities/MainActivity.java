package com.eurolink.mangopay.activities;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.eurolink.mangopay.R;
import com.eurolink.mangopay.fragments.ArticleFragment;
import com.eurolink.mangopay.fragments.FaqFragment;
import com.eurolink.mangopay.fragments.FavoriteFragment;
import com.eurolink.mangopay.fragments.PlaceFragment;
import com.eurolink.mangopay.fragments.PurseFragment;
import com.eurolink.mangopay.fragments.SettingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Sherwin on 12/19/2016.
 */

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AppCompatSpinner cardSpinner;
    private Map<String,String> item;


    @Override
    public void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      //  navHeader = LayoutInflater.from(this).inflate(R.layout.nav_header_main,navigationView);
//        navigationView.addHeaderView(navHeader);

        cardSpinner  = (AppCompatSpinner)  navigationView.getHeaderView(0).findViewById(R.id.spinnerCard);

        final List<Map<String,String>> items = new ArrayList<>();

        item = new HashMap<>(2);
        item.put("balance","400.00 PHP");
        item.put("card","1234567890123456789");
        items.add(item);

        item = new HashMap<>(2);
        item.put("balance","800.00 PHP");
        item.put("card","1234567895678901234");
        items.add(item);

        item = new HashMap<>(2);
        item.put("balance","1000.00 PHP");
        item.put("card","6789567890123412345");
        items.add(item);

        Log.d("ITEM_SIZE",items.size()+"");
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext()
                ,items
                ,android.R.layout.simple_spinner_dropdown_item
                ,new String[]{"balance","card"}
                ,new int[]{android.R.id.text2,android.R.id.text1});
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_2);
       // adapter.setViewImage(new ImageView(this),R.drawable.ic_account_balance);
        cardSpinner.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_article) {
            Fragment af = new ArticleFragment();
            ShowFragment(af);
        } else if (id == R.id.nav_favorite) {
            Fragment af = new FavoriteFragment();
            ShowFragment(af);
        } else if (id == R.id.nav_purse) {
            Fragment af = new PurseFragment();
            ShowFragment(af);
        } else if (id == R.id.nav_place) {
            Fragment af = new PlaceFragment();
            ShowFragment(af);
        } else if (id == R.id.nav_setting) {
            Fragment af = new SettingFragment();
            ShowFragment(af);
        } else if (id == R.id.nav_faq) {
            Fragment af = new FaqFragment();
            ShowFragment(af);
        }else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this,LoginActivity.class);
            application.getAuth().getUser().setIsLoggedIn(false);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ShowFragment(Fragment fr){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.article_fragment,fr);
        ft.commit();
    }
}
