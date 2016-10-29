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
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class SalResActivity extends AppCompatActivity implements View.OnClickListener{
    String Nombre;
    TextView Nomb;
    Button Reserva;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.salres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Nomb = (TextView) findViewById(R.id.nomsal);
        Reserva = (Button) findViewById(R.id.Reservare);
        Reserva.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);

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
