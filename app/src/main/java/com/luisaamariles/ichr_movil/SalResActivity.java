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
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class SalResActivity extends AppCompatActivity implements View.OnClickListener{
    String Nombre,ids,usuario, salon, fecha, hora, precio;
    TextView Nomb;
    Button Reserva;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer ids2;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.salres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

       // prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
       // editor = prefs.edit();

        Nomb = (TextView) findViewById(R.id.nomsal);
        Reserva = (Button) findViewById(R.id.Reservare);
        Reserva.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);

        //ids = prefs.getString("ids", "");
        //ids2 = Integer.parseInt(ids);

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
        usuario="camila";
        salon="Antioquia";
        fecha="12/11/16";
        hora="12:00am 1:pm";
        precio="$200.000";
        /*ids2++;
        editor.putString("ids",ids2.toString());
        editor.putInt("var4",1);
        editor.commit();*/
        firebd = firebasedatos.child("Reservas").child("reservasal"+" "+usuario);
        ReservaSalBD reservasal = new ReservaSalBD(usuario,salon,fecha,hora,precio);
        firebd.setValue(reservasal);
        Toast.makeText(this,"Reservado!", Toast.LENGTH_SHORT).show();
    }
}
