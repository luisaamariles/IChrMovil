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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuiteFragment extends Fragment {
    View v;
    String Name, Desc, ima;
    public SuiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_suite, container, false);
        ListView lv = (ListView)v.findViewById(R.id.menuf1);

        ArrayList<List2> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(getActivity(), itemsCompra);

        lv.setAdapter(adapter);

        registrarEventos();
        return v;
    }
    private ArrayList<List2> obtenerItems() {
        ArrayList<List2> items = new ArrayList<List2>();
        items.add(new List2("ApartaSuite", R.drawable.apartasuites));
        items.add(new List2("Suite Antioquia", R.drawable.suiteantioquia));
        items.add(new List2("Suite Presidencial", R.drawable.suitepresidencial));
        items.add(new List2("Suite Ejecutiva", R.drawable.suitepisoejecutivo));
        items.add(new List2("Suite", R.drawable.suites2));
        return items;
    }
    public class ItemCompraAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<List2> items;

        public ItemCompraAdapter(Activity activity, ArrayList<List2> items) {
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
            return items.get(position).getDrawableImageID();
        }

        @Override
        public View getView(int position, View contentView, ViewGroup parent) {
            View vi = contentView;

            if (contentView == null) {
                LayoutInflater inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi = inflater.inflate(R.layout.list2, null);
            }

            List2 item = items.get(position);

            ImageView imagen = (ImageView) vi.findViewById(R.id.nom3);
            imagen.setImageResource(item.getDrawableImageID());


            TextView nombre = (TextView) vi.findViewById(R.id.prom1);
            nombre.setText(item.getNombre());


            return vi;
        }
    }
    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) v.findViewById(R.id.menuf1);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Name = getResources().getString(R.string.habapar);
                        Desc = getResources().getString(R.string.desaparta);
                        ima = "0";
                        Intent intent = new Intent(getActivity(), HabDesActivity.class);
                        intent.putExtra("Name",Name);
                        intent.putExtra("Desc",Desc);
                        intent.putExtra("ima",ima);
                        startActivity(intent);
                        break;
                    case 1:
                        Name = getResources().getString(R.string.habsuan);
                        Desc = getResources().getString(R.string.dessuan);
                        ima = "1";
                        Intent intent2 = new Intent(getActivity(), HabDesActivity.class);
                        intent2.putExtra("Name",Name);
                        intent2.putExtra("Desc",Desc);
                        intent2.putExtra("ima",ima);
                        startActivity(intent2);
                        break;
                    case 2:
                        Name = getResources().getString(R.string.habsupre);
                        Desc = getResources().getString(R.string.dessupre);
                        ima = "2";
                        Intent intent3 = new Intent(getActivity(), HabDesActivity.class);
                        intent3.putExtra("Name",Name);
                        intent3.putExtra("Desc",Desc);
                        intent3.putExtra("ima",ima);
                        startActivity(intent3);
                        break;
                    case 3:
                        Name = getResources().getString(R.string.habsueje);
                        Desc = getResources().getString(R.string.dessupeje);
                        ima = "3";
                        Intent intent4 = new Intent(getActivity(), HabDesActivity.class);
                        intent4.putExtra("Name",Name);
                        intent4.putExtra("Desc",Desc);
                        intent4.putExtra("ima",ima);
                        startActivity(intent4);
                        break;
                    case 4:
                        Name = getResources().getString(R.string.habsu);
                        Desc = getResources().getString(R.string.dessu);
                        ima = "4";
                        Intent intent5 = new Intent(getActivity(), HabDesActivity.class);
                        intent5.putExtra("Name",Name);
                        intent5.putExtra("Desc",Desc);
                        intent5.putExtra("ima",ima);
                        startActivity(intent5);
                        break;
                }
            }
        });

    }
}
