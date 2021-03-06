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

public class MainActivity extends AppCompatActivity {

    private String[] opciones = new String[]{"Habitaciones", "Restaurantes", "Salas","Spa", "Cancha", "Consulta", "Promociones", "Ubicacion"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        Intent intentp = new Intent(MainActivity.this, HabitacionesActivity.class);
                        startActivity(intentp);
                        finish();
                        break;
                    case (1):
                        Intent intent = new Intent(MainActivity.this, RestaurantesActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case (2):
                        Intent intent2 = new Intent(MainActivity.this, SalasActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case (3):
                        Intent intent3 = new Intent(MainActivity.this, SpaActivity.class);
                        startActivity(intent3);
                        finish();
                        break;
                    case (4):
                        Intent intent4 = new Intent(MainActivity.this, CanchasActivity.class);
                        startActivity(intent4);
                        finish();
                        break;
                    case (5):
                        Intent intent5 = new Intent(MainActivity.this, ReservasActivity.class);
                        startActivity(intent5);
                        finish();
                        break;
                    case (6):
                        Intent intent6 = new Intent(MainActivity.this, PromocionActivity.class);
                        startActivity(intent6);
                        finish();
                        break;
                    case (7):
                        Intent intent7 = new Intent(MainActivity.this, UbicacionActivity.class);
                        startActivity(intent7);
                        finish();
                        break;
                }
                if (i == 8) {
                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                listView.setItemChecked(i, true);
                drawerLayout.closeDrawer(listView);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
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

