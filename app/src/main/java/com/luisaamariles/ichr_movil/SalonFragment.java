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
public class SalonFragment extends Fragment {
    View v;
    String Name, area, altura, u, audi, aula, espi, banq, coc, imp,ima;
    public SalonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_salon, container, false);

        ListView lv = (ListView)v.findViewById(R.id.menu2);

        ArrayList<ListSalon> itemsCompra = obtenerItems();

        ItemCompraAdapter adapter = new ItemCompraAdapter(getActivity(), itemsCompra);

        lv.setAdapter(adapter);

        registrarEventos();

        return v;
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
                        Name = getResources().getString(R.string.salgs);
                        area = getResources().getString(R.string.gsar);
                        altura = getResources().getString(R.string.gsal);
                        u = getResources().getString(R.string.gsu);
                        audi = getResources().getString(R.string.gsau);
                        aula = getResources().getString(R.string.gsaul);
                        espi = getResources().getString(R.string.gses);
                        banq = getResources().getString(R.string.gsba);
                        coc = getResources().getString(R.string.gsco);
                        imp = getResources().getString(R.string.gsim);
                        ima = "0";
                        Intent intent = new Intent(getActivity(), SalDesActivity.class);
                        intent.putExtra("Name",Name);
                        intent.putExtra("area",area);
                        intent.putExtra("altura",altura);
                        intent.putExtra("u",u);
                        intent.putExtra("audi",audi);
                        intent.putExtra("aula",aula);
                        intent.putExtra("espi",espi);
                        intent.putExtra("banq",banq);
                        intent.putExtra("coc",coc);
                        intent.putExtra("imp",imp);
                        intent.putExtra("ima",ima);
                        startActivity(intent);
                        break;
                    case 1:
                        Name = getResources().getString(R.string.salan);
                        area = getResources().getString(R.string.anar);
                        altura = getResources().getString(R.string.anal);
                        u = getResources().getString(R.string.anu);
                        audi = getResources().getString(R.string.anau);
                        aula = getResources().getString(R.string.anaul);
                        espi = getResources().getString(R.string.anes);
                        banq = getResources().getString(R.string.anba);
                        coc = getResources().getString(R.string.anco);
                        imp = getResources().getString(R.string.anim);
                        ima = "1";
                        Intent intent2 = new Intent(getActivity(), SalDesActivity.class);
                        intent2.putExtra("Name",Name);
                        intent2.putExtra("area",area);
                        intent2.putExtra("altura",altura);
                        intent2.putExtra("u",u);
                        intent2.putExtra("audi",audi);
                        intent2.putExtra("aula",aula);
                        intent2.putExtra("espi",espi);
                        intent2.putExtra("banq",banq);
                        intent2.putExtra("coc",coc);
                        intent2.putExtra("imp",imp);
                        intent2.putExtra("ima",ima);
                        startActivity(intent2);
                        break;
                    case 2:
                        Name = getResources().getString(R.string.salmed);
                        area = getResources().getString(R.string.medar);
                        altura = getResources().getString(R.string.medal);
                        u = getResources().getString(R.string.medu);
                        audi = getResources().getString(R.string.medau);
                        aula = getResources().getString(R.string.medaul);
                        espi = getResources().getString(R.string.medes);
                        banq = getResources().getString(R.string.medba);
                        coc = getResources().getString(R.string.medco);
                        imp = getResources().getString(R.string.medim);
                        ima = "2";
                        Intent intent3 = new Intent(getActivity(), SalDesActivity.class);
                        intent3.putExtra("Name",Name);
                        intent3.putExtra("area",area);
                        intent3.putExtra("altura",altura);
                        intent3.putExtra("u",u);
                        intent3.putExtra("audi",audi);
                        intent3.putExtra("aula",aula);
                        intent3.putExtra("espi",espi);
                        intent3.putExtra("banq",banq);
                        intent3.putExtra("coc",coc);
                        intent3.putExtra("imp",imp);
                        intent3.putExtra("ima",ima);
                        startActivity(intent3);
                        break;
                    case 3:
                        Name = getResources().getString(R.string.salci);
                        area = getResources().getString(R.string.ciar);
                        altura = getResources().getString(R.string.cial);
                        u = getResources().getString(R.string.ciu);
                        audi = getResources().getString(R.string.ciau);
                        aula = getResources().getString(R.string.ciaul);
                        espi = getResources().getString(R.string.cies);
                        banq = getResources().getString(R.string.ciba);
                        coc = getResources().getString(R.string.cico);
                        imp = getResources().getString(R.string.ciim);
                        ima = "3";
                        Intent intent4 = new Intent(getActivity(), SalDesActivity.class);
                        intent4.putExtra("Name",Name);
                        intent4.putExtra("area",area);
                        intent4.putExtra("altura",altura);
                        intent4.putExtra("u",u);
                        intent4.putExtra("audi",audi);
                        intent4.putExtra("aula",aula);
                        intent4.putExtra("espi",espi);
                        intent4.putExtra("banq",banq);
                        intent4.putExtra("coc",coc);
                        intent4.putExtra("imp",imp);
                        intent4.putExtra("ima",ima);
                        startActivity(intent4);
                        break;
                    case 4:
                        Name = getResources().getString(R.string.salep);
                        area = getResources().getString(R.string.epar);
                        altura = getResources().getString(R.string.epal);
                        u = getResources().getString(R.string.epu);
                        audi = getResources().getString(R.string.epau);
                        aula = getResources().getString(R.string.epaul);
                        espi = getResources().getString(R.string.epes);
                        banq = getResources().getString(R.string.epba);
                        coc = getResources().getString(R.string.epco);
                        imp = getResources().getString(R.string.epim);
                        ima = "4";
                        Intent intent5 = new Intent(getActivity(), SalDesActivity.class);
                        intent5.putExtra("Name",Name);
                        intent5.putExtra("area",area);
                        intent5.putExtra("altura",altura);
                        intent5.putExtra("u",u);
                        intent5.putExtra("audi",audi);
                        intent5.putExtra("aula",aula);
                        intent5.putExtra("espi",espi);
                        intent5.putExtra("banq",banq);
                        intent5.putExtra("coc",coc);
                        intent5.putExtra("imp",imp);
                        intent5.putExtra("ima",ima);
                        startActivity(intent5);
                        break;
                    case 5:
                        Name = getResources().getString(R.string.salgi);
                        area = getResources().getString(R.string.girar);
                        altura = getResources().getString(R.string.giral);
                        u = getResources().getString(R.string.giru);
                        audi = getResources().getString(R.string.girau);
                        aula = getResources().getString(R.string.giraul);
                        espi = getResources().getString(R.string.gires);
                        banq = getResources().getString(R.string.girba);
                        coc = getResources().getString(R.string.girco);
                        imp = getResources().getString(R.string.girim);
                        ima = "5";
                        Intent intent6 = new Intent(getActivity(), SalDesActivity.class);
                        intent6.putExtra("Name",Name);
                        intent6.putExtra("area",area);
                        intent6.putExtra("altura",altura);
                        intent6.putExtra("u",u);
                        intent6.putExtra("audi",audi);
                        intent6.putExtra("aula",aula);
                        intent6.putExtra("espi",espi);
                        intent6.putExtra("banq",banq);
                        intent6.putExtra("coc",coc);
                        intent6.putExtra("imp",imp);
                        intent6.putExtra("ima",ima);
                        startActivity(intent6);
                        break;
                    case 6:
                        Name = getResources().getString(R.string.salsu);
                        area = getResources().getString(R.string.suar);
                        altura = getResources().getString(R.string.sual);
                        u = getResources().getString(R.string.suu);
                        audi = getResources().getString(R.string.suau);
                        aula = getResources().getString(R.string.suaul);
                        espi = getResources().getString(R.string.sues);
                        banq = getResources().getString(R.string.suba);
                        coc = getResources().getString(R.string.suco);
                        imp = getResources().getString(R.string.suim);
                        ima = "6";
                        Intent intent7 = new Intent(getActivity(), SalDesActivity.class);
                        intent7.putExtra("Name",Name);
                        intent7.putExtra("area",area);
                        intent7.putExtra("altura",altura);
                        intent7.putExtra("u",u);
                        intent7.putExtra("audi",audi);
                        intent7.putExtra("aula",aula);
                        intent7.putExtra("espi",espi);
                        intent7.putExtra("banq",banq);
                        intent7.putExtra("coc",coc);
                        intent7.putExtra("imp",imp);
                        intent7.putExtra("ima",ima);
                        startActivity(intent7);
                        break;
                    case 7:
                        Name = getResources().getString(R.string.salco);
                        area = getResources().getString(R.string.coar);
                        altura = getResources().getString(R.string.coal);
                        u = getResources().getString(R.string.cou);
                        audi = getResources().getString(R.string.coau);
                        aula = getResources().getString(R.string.coaul);
                        espi = getResources().getString(R.string.coes);
                        banq = getResources().getString(R.string.coba);
                        coc = getResources().getString(R.string.coco);
                        imp = getResources().getString(R.string.coim);
                        ima = "7";
                        Intent intent8 = new Intent(getActivity(), SalDesActivity.class);
                        intent8.putExtra("Name",Name);
                        intent8.putExtra("area",area);
                        intent8.putExtra("altura",altura);
                        intent8.putExtra("u",u);
                        intent8.putExtra("audi",audi);
                        intent8.putExtra("aula",aula);
                        intent8.putExtra("espi",espi);
                        intent8.putExtra("banq",banq);
                        intent8.putExtra("coc",coc);
                        intent8.putExtra("imp",imp);
                        intent8.putExtra("ima",ima);
                        startActivity(intent8);
                        break;
                    case 8:
                        Name = getResources().getString(R.string.salbo);
                        area = getResources().getString(R.string.boar);
                        altura = getResources().getString(R.string.boal);
                        u = getResources().getString(R.string.bou);
                        audi = getResources().getString(R.string.boau);
                        aula = getResources().getString(R.string.boaul);
                        espi = getResources().getString(R.string.boes);
                        banq = getResources().getString(R.string.boba);
                        coc = getResources().getString(R.string.boco);
                        imp = getResources().getString(R.string.boim);
                        ima = "8";
                        Intent intent9 = new Intent(getActivity(), SalDesActivity.class);
                        intent9.putExtra("Name",Name);
                        intent9.putExtra("area",area);
                        intent9.putExtra("altura",altura);
                        intent9.putExtra("u",u);
                        intent9.putExtra("audi",audi);
                        intent9.putExtra("aula",aula);
                        intent9.putExtra("espi",espi);
                        intent9.putExtra("banq",banq);
                        intent9.putExtra("coc",coc);
                        intent9.putExtra("imp",imp);
                        intent9.putExtra("ima",ima);
                        startActivity(intent9);
                        break;
                    case 9:
                        Name = getResources().getString(R.string.salsa);
                        area = getResources().getString(R.string.saar);
                        altura = getResources().getString(R.string.saal);
                        u = getResources().getString(R.string.sau);
                        audi = getResources().getString(R.string.saau);
                        aula = getResources().getString(R.string.saaul);
                        espi = getResources().getString(R.string.saes);
                        banq = getResources().getString(R.string.saba);
                        coc = getResources().getString(R.string.saco);
                        imp = getResources().getString(R.string.saim);
                        ima = "9";
                        Intent intent10 = new Intent(getActivity(), SalDesActivity.class);
                        intent10.putExtra("Name",Name);
                        intent10.putExtra("area",area);
                        intent10.putExtra("altura",altura);
                        intent10.putExtra("u",u);
                        intent10.putExtra("audi",audi);
                        intent10.putExtra("aula",aula);
                        intent10.putExtra("espi",espi);
                        intent10.putExtra("banq",banq);
                        intent10.putExtra("coc",coc);
                        intent10.putExtra("imp",imp);
                        intent10.putExtra("ima",ima);
                        startActivity(intent10);
                        break;
                    case 10:
                        Name = getResources().getString(R.string.salca);
                        area = getResources().getString(R.string.caar);
                        altura = getResources().getString(R.string.caal);
                        u = getResources().getString(R.string.cau);
                        audi = getResources().getString(R.string.caau);
                        aula = getResources().getString(R.string.caaul);
                        espi = getResources().getString(R.string.caes);
                        banq = getResources().getString(R.string.caba);
                        coc = getResources().getString(R.string.caco);
                        imp = getResources().getString(R.string.caim);
                        ima = "10";
                        Intent intent11 = new Intent(getActivity(), SalDesActivity.class);
                        intent11.putExtra("Name",Name);
                        intent11.putExtra("area",area);
                        intent11.putExtra("altura",altura);
                        intent11.putExtra("u",u);
                        intent11.putExtra("audi",audi);
                        intent11.putExtra("aula",aula);
                        intent11.putExtra("espi",espi);
                        intent11.putExtra("banq",banq);
                        intent11.putExtra("coc",coc);
                        intent11.putExtra("imp",imp);
                        intent11.putExtra("ima",ima);
                        startActivity(intent11);
                        break;
                    case 11:
                        Name = getResources().getString(R.string.salfa);
                        area = getResources().getString(R.string.faar);
                        altura = getResources().getString(R.string.faal);
                        u = getResources().getString(R.string.fau);
                        audi = getResources().getString(R.string.faau);
                        aula = getResources().getString(R.string.faaul);
                        espi = getResources().getString(R.string.faes);
                        banq = getResources().getString(R.string.faba);
                        coc = getResources().getString(R.string.faco);
                        imp = getResources().getString(R.string.faim);
                        ima = "11";
                        Intent intent12 = new Intent(getActivity(), SalDesActivity.class);
                        intent12.putExtra("Name",Name);
                        intent12.putExtra("area",area);
                        intent12.putExtra("altura",altura);
                        intent12.putExtra("u",u);
                        intent12.putExtra("audi",audi);
                        intent12.putExtra("aula",aula);
                        intent12.putExtra("espi",espi);
                        intent12.putExtra("banq",banq);
                        intent12.putExtra("coc",coc);
                        intent12.putExtra("imp",imp);
                        intent12.putExtra("ima",ima);
                        startActivity(intent12);
                        break;
                    case 12:
                        Name = getResources().getString(R.string.salin);
                        area = getResources().getString(R.string.inar);
                        altura = getResources().getString(R.string.inal);
                        u = getResources().getString(R.string.inu);
                        audi = getResources().getString(R.string.inau);
                        aula = getResources().getString(R.string.inaul);
                        espi = getResources().getString(R.string.ines);
                        banq = getResources().getString(R.string.inba);
                        coc = getResources().getString(R.string.inco);
                        imp = getResources().getString(R.string.inim);
                        ima = "12";
                        Intent intent13 = new Intent(getActivity(), SalDesActivity.class);
                        intent13.putExtra("Name",Name);
                        intent13.putExtra("area",area);
                        intent13.putExtra("altura",altura);
                        intent13.putExtra("u",u);
                        intent13.putExtra("audi",audi);
                        intent13.putExtra("aula",aula);
                        intent13.putExtra("espi",espi);
                        intent13.putExtra("banq",banq);
                        intent13.putExtra("coc",coc);
                        intent13.putExtra("imp",imp);
                        intent13.putExtra("ima",ima);
                        startActivity(intent13);
                        break;
                    case 13:
                        Name = getResources().getString(R.string.salla);
                        area = getResources().getString(R.string.lpar);
                        altura = getResources().getString(R.string.lpal);
                        u = getResources().getString(R.string.lpu);
                        audi = getResources().getString(R.string.lpau);
                        aula = getResources().getString(R.string.lpaul);
                        espi = getResources().getString(R.string.lpes);
                        banq = getResources().getString(R.string.lpba);
                        coc = getResources().getString(R.string.lpco);
                        imp = getResources().getString(R.string.lpim);
                        ima = "13";
                        Intent intent14 = new Intent(getActivity(), SalDesActivity.class);
                        intent14.putExtra("Name",Name);
                        intent14.putExtra("area",area);
                        intent14.putExtra("altura",altura);
                        intent14.putExtra("u",u);
                        intent14.putExtra("audi",audi);
                        intent14.putExtra("aula",aula);
                        intent14.putExtra("espi",espi);
                        intent14.putExtra("banq",banq);
                        intent14.putExtra("coc",coc);
                        intent14.putExtra("imp",imp);
                        intent14.putExtra("ima",ima);
                        startActivity(intent14);
                        break;
                    case 14:
                        Name = getResources().getString(R.string.salsan);
                        area = getResources().getString(R.string.santar);
                        altura = getResources().getString(R.string.santal);
                        u = getResources().getString(R.string.santu);
                        audi = getResources().getString(R.string.santau);
                        aula = getResources().getString(R.string.santaul);
                        espi = getResources().getString(R.string.santes);
                        banq = getResources().getString(R.string.santba);
                        coc = getResources().getString(R.string.santco);
                        imp = getResources().getString(R.string.santim);
                        ima = "14";
                        Intent intent15 = new Intent(getActivity(), SalDesActivity.class);
                        intent15.putExtra("Name",Name);
                        intent15.putExtra("area",area);
                        intent15.putExtra("altura",altura);
                        intent15.putExtra("u",u);
                        intent15.putExtra("audi",audi);
                        intent15.putExtra("aula",aula);
                        intent15.putExtra("espi",espi);
                        intent15.putExtra("banq",banq);
                        intent15.putExtra("coc",coc);
                        intent15.putExtra("imp",imp);
                        intent15.putExtra("ima",ima);
                        startActivity(intent15);
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
        items.add(new ListSalon(" Eterna primavera"," "));
        items.add(new ListSalon(" Girardot"," "));
        items.add(new ListSalon(" Sucre"," "));
        items.add(new ListSalon(" Córdoba"," "));
        items.add(new ListSalon(" Bolivar"," "));
        items.add(new ListSalon(" Santander"," "));
        items.add(new ListSalon(" Capiro"," "));
        items.add(new ListSalon(" Farallones"," "));
        items.add(new ListSalon(" Ingrumá"," "));
        items.add(new ListSalon(" Las palmas"," "));
        items.add(new ListSalon(" Santafé"," "));


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
