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

/**
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class SalDesActivity extends AppCompatActivity implements View.OnClickListener{
    String Name, area, altura, u, audi, aula, espi, banq, coc, imp,ima;
    ImageView Ima;
    TextView Nomb, Area, Alt, U, Audi, Aula, Espi, Banq, Coc, Imp;
    Button bReservars;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.saldes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Nomb = (TextView) findViewById(R.id.nombresal);
        Area = (TextView) findViewById(R.id.area);
        Alt = (TextView) findViewById(R.id.altura);
        U = (TextView) findViewById(R.id.u);
        Audi = (TextView) findViewById(R.id.auditorio);
        Aula = (TextView) findViewById(R.id.aula);
        Espi = (TextView) findViewById(R.id.espina);
        Banq = (TextView) findViewById(R.id.banquete);
        Coc = (TextView) findViewById(R.id.coctel);
        Imp = (TextView) findViewById(R.id.imperial);
        Ima = (ImageView) findViewById(R.id.imagesal);
        bReservars = (Button) findViewById(R.id.res2);
        bReservars.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Name = extras.getString("Name");
        Nomb.setText(Name);
        area = extras.getString("area");
        Area.setText(area);
        altura = extras.getString("altura");
        Alt.setText(altura);
        u = extras.getString("u");
        U.setText(u);
        audi = extras.getString("audi");
        Audi.setText(audi);
        aula = extras.getString("aula");
        Aula.setText(aula);
        espi = extras.getString("espi");
        Espi.setText(espi);
        banq = extras.getString("banq");
        Banq.setText(banq);
        coc = extras.getString("coc");
        Coc.setText(coc);
        imp = extras.getString("imp");
        Imp.setText(imp);
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
            case "11":
                Ima.setImageResource(R.drawable.discapacitados);
                break;
            case "12":
                Ima.setImageResource(R.drawable.discapacitados);
                break;
            case "13":
                Ima.setImageResource(R.drawable.discapacitados);
                break;
            case "14":
                Ima.setImageResource(R.drawable.discapacitados);
                break;
            case "15":
                Ima.setImageResource(R.drawable.discapacitados);
                break;
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
        Intent intent = new Intent(this , SalResActivity.class);
        intent.putExtra("name",Name);
        startActivity(intent);
    }
}
