package com.itchihuahuaii.plataformamovil;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);

        if(navigationView!=null){
            prepararDrawer(navigationView);
            seleccionarItem(navigationView.getMenu().getItem(0));
        }

    }
    public void setToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab= getSupportActionBar();
        if(ab!=null){
            ab.setHomeAsUpIndicator(R.drawable.homework_icon);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
    public void prepararDrawer(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                seleccionarItem(menuItem);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public void seleccionarItem(MenuItem item){
        Fragment fragment=null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()){
            case R.id.item_miscursos:
                fragment=new FragmentMisCursos();
                break;

        }
        if(fragment!=null){
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal,fragment)
                    .commit();
        }

        setTitle(item.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
