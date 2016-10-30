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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class InfoActivity extends AppCompatActivity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.info);
        //getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView lv = (ListView)findViewById(R.id.menu2);

        ArrayList<ListSalon> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(this, itemsCompra);

        lv.setAdapter(adapter);

        registrarEventos();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) v.findViewById(R.id.menu2);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Intent intent = new Intent(InfoActivity.class, SalDesActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        Intent intent2 = new Intent(this, SalDesActivity.class);

                        startActivity(intent2);
                        break;
                    case 2:

                        Intent intent3 = new Intent(getActivity(), SalDesActivity.class);

                        startActivity(intent3);
                        break;
                    case 3:

                        Intent intent4 = new Intent(getActivity(), SalDesActivity.class);

                        startActivity(intent4);
                        break;
                }
            }
        });

    }
    private ArrayList<ListSalon> obtenerItems() {
        ArrayList<ListSalon> items = new ArrayList<ListSalon>();

        items.add(new ListSalon(" Gran salón"," "));
        items.add(new ListSalon(" Antioquia"," "));
        items.add(new ListSalon(" Medellín"," "));
        items.add(new ListSalon(" Citará"," "));


        return items;
    }
    public class ItemCompraAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<ListSalon> items;

        public ItemCompraAdapter(Activity activity, ArrayList<ListSalon> items) {
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
                vi = inflater.inflate(R.layout.listsalon, null);
            }

            ListSalon item = items.get(position);

            TextView nombre = (TextView) vi.findViewById(R.id.nomb);
            nombre.setText(item.getNombre());

            TextView espacio = (TextView) vi.findViewById(R.id.esp);
            espacio.setText(item.getEspacio());


            return vi;
        }
    }
}
