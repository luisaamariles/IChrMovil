package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class InfoConsActivity extends AppCompatActivity implements View.OnClickListener {

    Button CancelarR;
    String nombre, nomres;
    TextView nom;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.infocons);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Reservas");
        CancelarR = (Button) findViewById(R.id.canres);
        CancelarR.setOnClickListener(this);
        nom = (TextView) findViewById(R.id.nombreres);
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("name");
        nom.setText(nombre);
        if(nombre.equals("Mini Golf")){
            nomres="reservaMini Golf";
        }
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
    public void onClick(View v) {

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               /* if (dataSnapshot.child(nom).child("1").exists()) {
                    info.add(dataSnapshot.child(nom).child("1").getValue(HabBD.class));
                    precio = info.get(0).getPrecio();
                    hab = info.get(0).getHab();
                    estado1 = info.get(0).getEstado();

                }
                if (dataSnapshot.child(nom).child("2").exists()) {
                    info2.add(dataSnapshot.child(nom).child("2").getValue(HabBD.class));
                    hab1 = info2.get(0).getHab();
                    estado2 = info2.get(0).getEstado();

                }
                actualizar();*/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        Firebase firebd;

        firebd = firebasedatos.child("Reservas").child("reservahab2 daniela");
        firebd.removeValue();
        Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
    }
}
