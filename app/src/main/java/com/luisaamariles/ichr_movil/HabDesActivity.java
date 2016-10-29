package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class HabDesActivity extends AppCompatActivity implements View.OnClickListener{
    TextView Nomb, Desc;
    String Nombre, Descrip,ima;
    ImageView Ima;
    Button bReservarh;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.habdes);
        //getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Nomb = (TextView) findViewById(R.id.nombrehab);
        Desc = (TextView) findViewById(R.id.descrip);
        Ima = (ImageView) findViewById(R.id.imagehab);

        bReservarh = (Button) findViewById(R.id.res);
        bReservarh.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("Name");
        Nomb.setText(Nombre);
        Descrip= extras.getString("Desc");
        Desc.setText(Descrip);
        ima = extras.getString("ima");
        switch (ima) {
            case "0":
            Ima.setImageResource(R.drawable.apartasuites);
                break;
            case "1":
                Ima.setImageResource(R.drawable.suiteantioquia);
                break;
            case "2":
                Ima.setImageResource(R.drawable.suitepresidencial);
                break;
            case "3":
                Ima.setImageResource(R.drawable.suitepisoejecutivo);
                break;
            case "4":
                Ima.setImageResource(R.drawable.suites2);
                break;
            case "5":
                Ima.setImageResource(R.drawable.juniorsuitesking);
                break;
            case "6":
                Ima.setImageResource(R.drawable.juniortwin);
                break;
            case "7":
                Ima.setImageResource(R.drawable.superiorking);
                break;
            case "8":
                Ima.setImageResource(R.drawable.superiortwin);
                break;
            case "9":
                Ima.setImageResource(R.drawable.ejecutiva);
                break;
            case "10":
                Ima.setImageResource(R.drawable.discapacitados);
                break;


        }
       // Toast.makeText(this,Nombre,Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this , HabResActivity.class);
        intent.putExtra("name",Nombre);
        startActivity(intent);
    }
}
