package com.luisaamariles.ichr_movil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class ConsActivity extends AppCompatActivity{
    private ListCons[] datos;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos,firebasedatos2;

    String Nombre, mini,tenis,spa,minihora,tenishora,spahora, acomodacion,fechasal,horasal,precio,salon,
    hab,fechahabin,fechahabsal,precihab;
    ListView listView;
    ArrayList<ReservaGenBD> info;
    ArrayList<ReservaGenBD> info2;
    ArrayList<ReservaGenBD> info3;
    ArrayList<ReservaSalBD> info4;
    ArrayList<ReservaHabBD> info5;
    ArrayList<String> list,list2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cons);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("usuario");
        info = new ArrayList<ReservaGenBD>();
        info2 = new ArrayList<ReservaGenBD>();
        info3 = new ArrayList<ReservaGenBD>();
        info4 = new ArrayList<ReservaSalBD>();
        info5 = new ArrayList<ReservaHabBD>();
        list = new ArrayList<String>();
        list2 = new ArrayList<String>();

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Reservas");

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("reservaMini Golf "+Nombre).exists()){
                    info.add(dataSnapshot.child("reservaMini Golf "+Nombre).getValue(ReservaGenBD.class));
                    mini=info.get(0).getTipo();
                    minihora=info.get(0).getHora();
                    list.add("Mini Golf");
                }
                if(dataSnapshot.child("reservaTenis "+Nombre).exists()){
                    info2.add(dataSnapshot.child("reservaTenis "+Nombre).getValue(ReservaGenBD.class));
                    tenis=info2.get(0).getTipo();
                    tenishora=info2.get(0).getHora();
                    list.add("Tenis");
                }
                if(dataSnapshot.child("reservaSpa "+Nombre).exists()){
                    info3.add(dataSnapshot.child("reservaSpa "+Nombre).getValue(ReservaGenBD.class));
                    spa=info3.get(0).getTipo();
                    spahora=info3.get(0).getHora();
                    list.add("Spa");
                }
                if(dataSnapshot.child("reservaSal "+Nombre).exists()){
                    info4.add(dataSnapshot.child("reservaSal "+Nombre).getValue(ReservaSalBD.class));
                    acomodacion=info4.get(0).getAcomodacion();
                    fechasal=info4.get(0).getFecha();
                    horasal=info4.get(0).getHora();
                    precio=info4.get(0).getPrecio();
                    salon=info4.get(0).getSalon();
                    list.add("Salón");
                }
                if(dataSnapshot.child("reservaHab "+Nombre).exists()){
                    info5.add(dataSnapshot.child("reservaHab "+Nombre).getValue(ReservaHabBD.class));
                    hab=info5.get(0).getHabitacion();
                    fechahabin=info5.get(0).getFechain();
                    fechahabsal=info5.get(0).getFechasal();
                    precihab=info5.get(0).getPrecio();
                    list.add("Habitación");
                }

                Actualizar();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        //info = new ArrayList<UsuarioBD>();

    }
    public void Actualizar(){
        if (minihora.equals("13")) {
            minihora="1";
        } else if (minihora.equals("14")) {
            minihora = "2";
        } else if (minihora.equals("15")) {
            minihora= "3";
        } else if (minihora.equals("16")) {
            minihora = "4";
        } else if (minihora.equals("17")) {
            minihora = "5";
        } else if (minihora.equals("18")) {
            minihora = "6";
        } else if (minihora.equals("19")) {
            minihora = "7";
        }
        if (tenishora.equals("13")) {
            tenishora="1";
        } else if (tenishora.equals("14")) {
            tenishora = "2";
        } else if (tenishora.equals("15")) {
            tenishora= "3";
        } else if (tenishora.equals("16")) {
            tenishora = "4";
        } else if (tenishora.equals("17")) {
            tenishora = "5";
        } else if (tenishora.equals("18")) {
            tenishora = "6";
        } else if (tenishora.equals("19")) {
            tenishora = "7";
        }
        if (spahora.equals("13")) {
            spahora="1";
        } else if (spahora.equals("14")) {
            spahora = "2";
        } else if (spahora.equals("15")) {
            spahora= "3";
        } else if (spahora.equals("16")) {
            spahora = "4";
        } else if (spahora.equals("17")) {
            spahora = "5";
        } else if (spahora.equals("18")) {
            spahora = "6";
        } else if (spahora.equals("19")) {
            spahora = "7";
        }
        if (horasal.equals("13")) {
            horasal="1";
        } else if (horasal.equals("14")) {
            horasal = "2";
        } else if (horasal.equals("15")) {
            horasal= "3";
        } else if (horasal.equals("16")) {
            horasal = "4";
        } else if (horasal.equals("17")) {
            horasal = "5";
        } else if (horasal.equals("18")) {
            horasal = "6";
        } else if (horasal.equals("19")) {
            horasal = "7";
        }else if (horasal.equals("20")) {
            horasal = "8";
        }
        int size=list.size();
        for(int x=0;x<size;x++) {
            if(list.get(x)=="Mini Golf"){
                list2.add("Reserva a las "+minihora);
            }else if(list.get(x)=="Tenis"){
                list2.add("Reserva a las "+tenishora);
            }else if(list.get(x)=="Spa") {
                list2.add("Reserva a las " + spahora);
            }else if(list.get(x)=="Salón") {
                list2.add("Reserva del salon "+salon+" a las" + horasal+" el "+fechasal+" con acomodación "+acomodacion+" por el valor de "+precio);
            }else if(list.get(x)=="Habitación"){
                list2.add("Reserva de la habitación "+hab+" con ingreso el "+fechahabin+" y salida el "+fechahabsal+" por el valor de "+precihab);
            }
        }
        if(size==5) {
            datos = new ListCons[]{
                    new ListCons(list.get(0),list2.get(0)),
                    new ListCons(list.get(1),list2.get(1)),
                    new ListCons(list.get(2),list2.get(2)),
                    new ListCons(list.get(3),list2.get(3)),
                    new ListCons(list.get(4),list2.get(4)),
            };
        }else if(size==4){
            datos = new ListCons[]{
                    new ListCons(list.get(0),list2.get(0)),
                    new ListCons(list.get(1),list2.get(1)),
                    new ListCons(list.get(2),list2.get(2)),
                    new ListCons(list.get(3),list2.get(3)),
            };
        }else if(size==3){
            datos = new ListCons[]{
                    new ListCons(list.get(0), list2.get(0)),
                    new ListCons(list.get(1), list2.get(1)),
                    new ListCons(list.get(2), list2.get(2)),
            };
        }else if(size==2){
            datos = new ListCons[]{
                    new ListCons(list.get(0), list2.get(0)),
                    new ListCons(list.get(1), list2.get(1)),
            };
        }else if(size==1){
            datos = new ListCons[]{
                    new ListCons(list.get(0), list.get(0)),
            };
        }else if(size==0){
            AlertDialog.Builder ad = new AlertDialog.Builder(ConsActivity.this);
            ad.setMessage("No tiene ninguna reserva!");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        }
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
                        intent.putExtra("name",list.get(0));
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        Intent intent2 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        intent2.putExtra("name",list.get(1));
                        startActivity(intent2);
                        finish();
                        break;
                    case 2:
                        Intent intent3 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        intent3.putExtra("name",list.get(2));
                        startActivity(intent3);
                        finish();
                        break;
                    case 3:
                        Intent intent4 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        intent4.putExtra("name",list.get(3));
                        startActivity(intent4);
                        finish();
                        break;
                    case 4:
                        Intent intent5 = new Intent(ConsActivity.this, InfoConsActivity.class);
                        intent5.putExtra("name",list.get(4));
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
