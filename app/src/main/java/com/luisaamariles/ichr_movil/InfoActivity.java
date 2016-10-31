package com.luisaamariles.ichr_movil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class InfoActivity extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.info, contentFrameLayout);
        getSupportActionBar().show();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView lv = (ListView)findViewById(R.id.menuinf);

        ArrayList<ListInfo> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(this, itemsCompra);

        lv.setAdapter(adapter);

        registrarEventos();
    }
  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.menuinf);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Intent intent = new Intent(InfoActivity.this, HabitacionesActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(InfoActivity.this, RestaurantesActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(InfoActivity.this, SalasActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(InfoActivity.this, SpaActivity.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(InfoActivity.this, CanchasActivity.class);
                        startActivity(intent5);
                        break;
                }
            }
        });

    }
    private ArrayList<ListInfo> obtenerItems() {
        ArrayList<ListInfo> items = new ArrayList<ListInfo>();

        items.add(new ListInfo(" Habitaciones"," "));
        items.add(new ListInfo(" Restaurantes"," "));
        items.add(new ListInfo(" Salas de eventos"," "));
        items.add(new ListInfo(" Spa & zona humeda"," "));
        items.add(new ListInfo(" Canchas & GYM"," "));



        return items;
    }
    public class ItemCompraAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<ListInfo> items;

        public ItemCompraAdapter(Activity activity, ArrayList<ListInfo> items) {
            this.activity = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 1;
        }

        @Override
        public View getView(int position, View contentView, ViewGroup parent) {
            View vi = contentView;

            if (contentView == null) {
                LayoutInflater inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi = inflater.inflate(R.layout.listinfo, null);
            }

            ListInfo item = items.get(position);

            TextView nombre = (TextView) vi.findViewById(R.id.nomb1);
            nombre.setText(item.getNombre());

            TextView espacio = (TextView) vi.findViewById(R.id.esp1);
            espacio.setText(item.getEspacio());


            return vi;
        }
    }
}
