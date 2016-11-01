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
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class ReservaGenActivity extends AppCompatActivity implements View.OnClickListener{
    Button seis,siete,ocho,nueve,diez,once,doce,una,dos,tres,cuatro,cinco,seis1,seisc,sietec,ochoc,nuevec,diezc,oncec,docec,unac, dosc, tresc,cuatroc, cincoc,seis1c;

    String idg,usuario, tipo, hora, precio, id;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer idg2;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.resgen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        seis = (Button) findViewById(R.id.sietea);
        seis.setOnClickListener(this);
        seisc = (Button) findViewById(R.id.siete);
        seisc.setOnClickListener(this);
        siete = (Button) findViewById(R.id.ochoa);
        siete.setOnClickListener(this);
        sietec = (Button) findViewById(R.id.ocho);
        sietec.setOnClickListener(this);
        ocho = (Button) findViewById(R.id.nuevea);
        ocho.setOnClickListener(this);
        ochoc = (Button) findViewById(R.id.nueve);
        ochoc.setOnClickListener(this);
        nueve = (Button) findViewById(R.id.dieza);
        nueve.setOnClickListener(this);
        nuevec = (Button) findViewById(R.id.diez);
        nuevec.setOnClickListener(this);
        diez = (Button) findViewById(R.id.oncea);
        diez.setOnClickListener(this);
        diezc = (Button) findViewById(R.id.once);
        diezc.setOnClickListener(this);
        once = (Button) findViewById(R.id.docea);
        once.setOnClickListener(this);
        oncec = (Button) findViewById(R.id.doce);
        oncec.setOnClickListener(this);
        doce = (Button) findViewById(R.id.trecea);
        doce.setOnClickListener(this);
        docec = (Button) findViewById(R.id.trece);
        docec.setOnClickListener(this);
        una = (Button) findViewById(R.id.catorcea);
        una.setOnClickListener(this);
        unac = (Button) findViewById(R.id.catorce);
        unac.setOnClickListener(this);
        dos = (Button) findViewById(R.id.quincea);
        dos.setOnClickListener(this);
        dosc = (Button) findViewById(R.id.quince);
        dosc.setOnClickListener(this);
        tres = (Button) findViewById(R.id.dieciseisa);
        tres.setOnClickListener(this);
        tresc = (Button) findViewById(R.id.dieciseis);
        tresc.setOnClickListener(this);
        cuatro = (Button) findViewById(R.id.diecisietea);
        cuatro.setOnClickListener(this);
        cuatroc = (Button) findViewById(R.id.diecisiete);
        cuatroc.setOnClickListener(this);
        cinco = (Button) findViewById(R.id.dieciochoa);
        cinco.setOnClickListener(this);
        cincoc = (Button) findViewById(R.id.dieciocho);
        cincoc.setOnClickListener(this);
        seis1 = (Button) findViewById(R.id.diecinuevea);
        seis1.setOnClickListener(this);
        seis1c = (Button) findViewById(R.id.diecinueve);
        seis1c.setOnClickListener(this);

        idg = prefs.getString("idg", "");
        idg2 = Integer.parseInt(idg);
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
        tipo="spa";
        hora="12/12/16";
        precio="$200.000";
        switch (v.getId()) {

            case R.id.sietea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                ReservaGenBD reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.siete:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ochoa:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ocho:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nuevea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nueve:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dieza:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.diez:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.oncea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.once:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.docea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.doce:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.trecea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.trece:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.catorcea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.catorce:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.quincea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.quince:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dieciseisa:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dieciseis:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.diecisietea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.diecisiete:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dieciochoa:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dieciocho:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.diecinuevea:
                idg2++;
                editor.putString("idg",idg2.toString());
                editor.putInt("var5",1);
                editor.commit();
                firebd = firebasedatos.child("Reservas").child("reserva"+tipo+idg2+" "+usuario);
                reservagen = new ReservaGenBD(usuario,tipo,hora,precio,String.valueOf(idg2));
                firebd.setValue(reservagen);
                Toast.makeText(this,"Reservado!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.diecinueve:
                Toast.makeText(this,"Cancelado!",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}