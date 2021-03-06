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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EspecialFragment extends Fragment {
    View v;
    String Name, Desc, ima;
    public EspecialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_especial, container, false);

        ListView lv = (ListView)v.findViewById(R.id.menu4);

        ArrayList<List2> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(getActivity(), itemsCompra);

        lv.setAdapter(adapter);
        registrarEventos();
        return v;
    }
    private ArrayList<List2> obtenerItems() {
        ArrayList<List2> items = new ArrayList<List2>();

        items.add(new List2("Discapacitados",R.drawable.discapacitados));

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
        ListView lista1 = (ListView) v.findViewById(R.id.menu4);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Name = getResources().getString(R.string.habdis);
                Desc = getResources().getString(R.string.desdis);
                ima = "10";
                Intent intent = new Intent(getActivity(), HabDesActivity.class);
                intent.putExtra("Name",Name);
                intent.putExtra("Desc",Desc);
                intent.putExtra("ima",ima);
                startActivity(intent);


            }
        });

    }

}
