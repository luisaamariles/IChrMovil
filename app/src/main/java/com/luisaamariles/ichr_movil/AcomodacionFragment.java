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
public class AcomodacionFragment extends Fragment {

    View v;
    public AcomodacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_acomodacion, container, false);

        ListView lv = (ListView)v.findViewById(R.id.menuaco);

        ArrayList<ListAco> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(getActivity(), itemsCompra);

        lv.setAdapter(adapter);

        return v;
    }
    private ArrayList<ListAco> obtenerItems() {
        ArrayList<ListAco> items = new ArrayList<ListAco>();

        items.add(new ListAco("U",R.drawable.u));
        items.add(new ListAco("Auditorio",R.drawable.auditorio));
        items.add(new ListAco("Espina",R.drawable.espina));
        items.add(new ListAco("Aula",R.drawable.aula));
        items.add(new ListAco("Coctel",R.drawable.coctel));
        items.add(new ListAco("Imperial",R.drawable.imperial));
        items.add(new ListAco("Banquete",R.drawable.banquete));

        return items;
    }
    public class ItemCompraAdapter extends BaseAdapter {
        protected Activity activity;
        protected ArrayList<ListAco> items;

        public ItemCompraAdapter(Activity activity, ArrayList<ListAco> items) {
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
                vi = inflater.inflate(R.layout.listaco, null);
            }

            ListAco item = items.get(position);

            ImageView imagen = (ImageView) vi.findViewById(R.id.noms);
            imagen.setImageResource(item.getDrawableImageID());


            TextView nombre = (TextView) vi.findViewById(R.id.acom);
            nombre.setText(item.getNombre());


            return vi;
        }
    }


}
