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
    private Firebase firebasedatos;

    String Nombre, mini,tenis,spa,minihora,tenishora,spahora;
    ListView listView;
    ArrayList<ReservaGenBD> info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cons);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("usuario");
        info = new ArrayList<ReservaGenBD>();
        ArrayList<String> list = new ArrayList<String>();

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);
        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Reservas").child("reservaMini Golf "+Nombre).exists()){
                    info.add(dataSnapshot.child("reservaMini Golf "+Nombre).getValue(ReservaGenBD.class));
                    Toast.makeText(ConsActivity.this,"mini",Toast.LENGTH_SHORT).show();
                    mini=info.get(0).getTipo();
                    minihora=info.get(0).getHora();

                }
                if(dataSnapshot.child("Reservas").child("reservaTenis "+Nombre).exists()){
                    info.add(dataSnapshot.child("reservaTenis "+Nombre).getValue(ReservaGenBD.class));
                    Toast.makeText(ConsActivity.this,"tenis",Toast.LENGTH_SHORT).show();
                    tenis=info.get(0).getTipo();
                    tenishora=info.get(0).getHora();
                }
                if(dataSnapshot.child("Reservas").child("reservaSpa "+Nombre).exists()){
                    info.add(dataSnapshot.child("reservaSpa "+Nombre).getValue(ReservaGenBD.class));
                    Toast.makeText(ConsActivity.this,"Spa",Toast.LENGTH_SHORT).show();
                    spa=info.get(0).getTipo();
                    spahora=info.get(0).getHora();
                }

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        //info = new ArrayList<UsuarioBD>();



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
