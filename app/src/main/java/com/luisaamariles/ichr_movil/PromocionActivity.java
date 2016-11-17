package com.luisaamariles.ichr_movil;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Luisa Maria Amariles on 22/10/2016.
 */
public class PromocionActivity extends MainActivity {
    private List[] datos;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.promocion, contentFrameLayout);
        getSupportActionBar().show();

        datos= new List[]{
                new List("Suite presidencial", "Ahorre 10% haciendo la reserva de la suite durante este mes"),
                new List("Descuento", "Incluya una comida dentro de su paquete realizando la reserva 1 mes antes"),
                new List("1000 puntos", "Obtenga 1000 puntos adicionales por realizar el registro desde la aplicación"),
                new List("Dia de Spa", "Por la reserva del piso ejecutivo obtenga un dia de Spa gratis "),
                new List("La cava", "10% de descuento todos los jueves desde las 6 pm por este mes"),
        };

        Adapter adaptador = new Adapter(this);
        listView = (ListView) findViewById(R.id.menu);

        listView.setAdapter(adaptador);

    }


    class Adapter extends ArrayAdapter<List> {
        Activity context;

        public Adapter(Activity context){
            super(context, R.layout.list , datos);
            this.context = context;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list,null);

            TextView nombre = (TextView)item.findViewById(R.id.nom1);
            nombre.setText(datos[position].getNombre());

            TextView promo = (TextView)item.findViewById(R.id.prom1);
            promo.setText(datos[position].getPromo());

            return (item);
        }
    }

}
