package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.Firebase;


/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class HabResActivity extends AppCompatActivity implements View.OnClickListener{
    String Nombre, idh, nombre, usuario, numhab, fechain, fechasal, precio, id;
    TextView Nomb;
    Button Reserva;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer idh2;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.habres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

       // prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
       // editor = prefs.edit();

        Nomb = (TextView) findViewById(R.id.nomhab);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);
        Reserva = (Button) findViewById(R.id.Reservar);
        Reserva.setOnClickListener(this);

       // idh = prefs.getString("idh", "");
        //idh2 = Integer.parseInt(idh);

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
    public void onClick(View v) {
        Firebase firebd;
        usuario="daniela";
        numhab="201";
        fechain="12/11/16";
        fechasal="12/12/16";
        precio="$200.000";
        /*idh2++;
        editor.putString("idh",idh2.toString());
        editor.putInt("var2",1);
        editor.commit();*/
        firebd = firebasedatos.child("Reservas").child("reservahab"+" "+usuario);
        ReservaHabBD reservahab = new ReservaHabBD(usuario,numhab,fechain,fechasal,precio);
        firebd.setValue(reservahab);

        Toast.makeText(this,"Reservado!", Toast.LENGTH_SHORT).show();
    }
}
