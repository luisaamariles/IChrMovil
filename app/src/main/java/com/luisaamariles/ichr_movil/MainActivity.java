package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private String[] opciones = new String[]{"Información general", "Consulta reservas", "Promociones", "Ubicacion","Mi perfil", "Cerrar sesión"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment = null;
                switch (i) {

                    case (0):
                        Intent intent4 = new Intent(MainActivity.this, InfoActivity.class);
                        startActivity(intent4);
                        finish();
                        break;
                    case (1):
                        Intent intent5 = new Intent(MainActivity.this, ReservasActivity.class);
                        startActivity(intent5);
                        finish();
                        break;
                    case (2):
                        Intent intent6 = new Intent(MainActivity.this, PromocionActivity.class);
                        startActivity(intent6);
                        finish();
                        break;
                    case (3):
                        Intent intent7 = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent7);
                        finish();
                        break;
                    case (4):
                        Intent intent9 = new Intent(MainActivity.this, MiperfilActivity.class);
                        startActivity(intent9);
                        finish();

                        break;
                    case (5):
                        LoginManager.getInstance().logOut();
                        FirebaseAuth.getInstance().signOut();
                        goLoginActivity();
                        Intent intent8 = new Intent(MainActivity.this, LogginActivity.class);
                        startActivity(intent8);
                        finish();
                        break;
                }
                if (i == 6) {
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                listView.setItemChecked(i, true);
                drawerLayout.closeDrawer(listView);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user==null){
            goLoginActivity();
        }
    }
    public void logout(View view){
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        goLoginActivity();
    }

    private void goLoginActivity() {
        Intent intent = new Intent (getApplicationContext(), LogginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

