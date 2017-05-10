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

    ProgressBar loader;
    RecyclerView myRecycler;
    List<User> myUser;
    UserAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        loader = (ProgressBar) findViewById(R.id.loader);
        myRecycler = (RecyclerView) findViewById(R.id.myRecycler);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       // myRecycler.setLayoutManager(linearLayoutManager);

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





    // Metodo para validar la conexion a internet
    public Boolean isOnLine(){
        ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connec.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }
    }

    // Medodo para manejar el evento del item del menu
    public void onClickButton(){
        if (isOnLine()){
            //MyTask task = new MyTask();
            //task.execute("https://jsonplaceholder.typicode.com/users");
            Toast.makeText(this, "Funciona", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Sin conexión", Toast.LENGTH_SHORT).show();
        }
    }

    // Tarea asincrona para obtener los datos desde internet

    private class MyTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            loader.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {

            String content = null;
            try {
                content = HttpManager.getData(params[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                myUser = Json.parserJsonUser(s);

            } catch (Exception e) {
                e.printStackTrace();
            }
            cargarDatos();
            loader.setVisibility(View.GONE);
        }
        public void cargarDatos() {

            // Crear un objeto de tipo "PostAdapter" y retorna el item de mi layout (item.xml)
            myAdapter = new UserAdapter(getApplicationContext(), myUser);
            // inyectar el item en mi RecyclerView
            myRecycler.setAdapter(myAdapter);

        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cargar_datos:
                onClickButton();
                return (true);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void showTolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }*/


}
