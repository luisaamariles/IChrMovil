package com.luisaamariles.ichr_movil;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservaFragment extends Fragment {

    View v;
    public ReservaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_reserva, container, false);
        ListView lv = (ListView)v.findViewById(R.id.menures);

        ArrayList<ListRes> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(getActivity(), itemsCompra);

        lv.setAdapter(adapter);

        registrarEventos();
        return v;
    }

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) v.findViewById(R.id.menures);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Intent intent = new Intent(getActivity(), HabitacionesActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), SalasActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getActivity(), CanchasActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(getActivity(), SpaActivity.class);
                        startActivity(intent4);
                        break;

                }
            }
        });

    }
    private ArrayList<ListRes> obtenerItems() {
        ArrayList<ListRes> items = new ArrayList<ListRes>();

        items.add(new ListRes(" Habitaciones"," "));
        items.add(new ListRes(" Salas de eventos"," "));
        items.add(new ListRes(" Canchas"," "));
        items.add(new ListRes(" Spa"," "));


        return items;
    }
    public class ItemCompraAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<ListRes> items;

        public ItemCompraAdapter(Activity activity, ArrayList<ListRes> items) {
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
                vi = inflater.inflate(R.layout.listres, null);
            }

            ListRes item = items.get(position);

            TextView nombre = (TextView) vi.findViewById(R.id.nomb1);
            nombre.setText(item.getNombre());

            TextView espacio = (TextView) vi.findViewById(R.id.esp1);
            espacio.setText(item.getEspacio());


            return vi;
        }
    }
}
