package com.luisaamariles.ichr_movil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class HabResActivity extends AppCompatActivity implements View.OnClickListener{
    String Nombre;
    TextView Nomb;
    Button Reserva;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.habres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Nomb = (TextView) findViewById(R.id.nomhab);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);
        Reserva = (Button) findViewById(R.id.Reservar);
        Reserva.setOnClickListener(this);

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
        Toast.makeText(this,"Reservado!", Toast.LENGTH_SHORT).show();
    }
}
