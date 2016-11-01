package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class InfoConsActivity extends AppCompatActivity implements View.OnClickListener {

    Button CancelarR;
    String nombre;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.infocons);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);
        CancelarR = (Button) findViewById(R.id.canres);
        CancelarR.setOnClickListener(this);
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
        Firebase firebd;

        firebd = firebasedatos.child("Reservas").child("reservahab2 daniela");
        firebd.removeValue();
        Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
    }
}
