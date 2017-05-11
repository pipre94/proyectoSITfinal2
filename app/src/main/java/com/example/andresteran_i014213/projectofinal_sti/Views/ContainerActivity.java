package com.example.andresteran_i014213.projectofinal_sti.Views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.andresteran_i014213.projectofinal_sti.Adapters.UserAdapter;
import com.example.andresteran_i014213.projectofinal_sti.HttpManager;
import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.Parser.Json;
import com.example.andresteran_i014213.projectofinal_sti.R;
import com.example.andresteran_i014213.projectofinal_sti.Views.Fragments.HomeFragment;
import com.example.andresteran_i014213.projectofinal_sti.Views.Fragments.ProfileFragment;
import com.example.andresteran_i014213.projectofinal_sti.Views.Fragments.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.io.IOException;
import java.util.List;

public class ContainerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.id_bottombar);
        // para establcer la pnatalla d home
        bottomBar.setDefaultTab(R.id.tab_home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_search:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.id_container_fragment, searchFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.tab_home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.id_container_fragment, homeFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.tab_profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.id_container_fragment, profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();
                        break;

                }

            }
        });


    }
}
