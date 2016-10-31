package com.luisaamariles.ichr_movil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class ConsActivity extends AppCompatActivity{
    private ListCons[] datos;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cons);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datos= new ListCons[]{
                new ListCons("promo1", "desc1"),
                new ListCons("promo1", "desc1"),
                new ListCons("promo1", "desc1"),
                new ListCons("promo1", "desc1"),
                new ListCons("promo1", "desc1"),
        };
        Adapter adaptador = new Adapter(this);
        listView = (ListView) findViewById(R.id.menucons);

        listView.setAdapter(adaptador);
        registrarEventos();
    }
    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.menucons);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Intent intent = new Intent(ConsActivity.this, InfoConsActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Intent intent2 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case 2:
                        Intent intent3 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        startActivity(intent3);
                        finish();
                        break;
                    case 3:
                        Intent intent4 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        startActivity(intent4);
                        finish();
                        break;
                    case 4:
                        Intent intent5 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        startActivity(intent5);
                        finish();
                        break;
                }
            }
        });

    }
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
    class Adapter extends ArrayAdapter<ListCons> {
        Activity context;

        public Adapter(Activity context){
            super(context, R.layout.listconst , datos);
            this.context = context;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listconst,null);

            TextView nombre = (TextView)item.findViewById(R.id.nom2);
            nombre.setText(datos[position].getNombre());

            TextView promo = (TextView)item.findViewById(R.id.prom2);
            promo.setText(datos[position].getPromo());

            return (item);
        }
    }

}
