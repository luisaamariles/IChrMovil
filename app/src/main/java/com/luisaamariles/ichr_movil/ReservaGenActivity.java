package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


/**
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class ReservaGenActivity extends AppCompatActivity implements View.OnClickListener{
    Button seis,siete,ocho,nueve,diez,once,doce,una,dos,tres,cuatro,cinco,seis1;

    String usuario, tipo, hora,codhora,Nombre,nombreus,estado,idg, idg1,idg2;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer idh,idr,ids,ban=0;
    Firebase firebd, firebd2;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos,firebasedatos2;
    ArrayList<CanchaBD> info;
    ArrayList<UsuarioBD> info2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.resgen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);


        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("cancha");
        if(Nombre.equals("Tenis")){
            firebasedatos = new Firebase(FIREBASE_URL).child("Cancha").child("Tenis");
        }else if(Nombre.equals("Mini Golf")){
            firebasedatos = new Firebase(FIREBASE_URL).child("Cancha").child("Mini Golf");
        }else if(Nombre.equals("Spa")){
            firebasedatos = new Firebase(FIREBASE_URL).child("Spa");
        }

        firebasedatos2 = new Firebase(FIREBASE_URL);

        seis = (Button) findViewById(R.id.sietea);
        seis.setOnClickListener(this);

        siete = (Button) findViewById(R.id.ochoa);
        siete.setOnClickListener(this);

        ocho = (Button) findViewById(R.id.nuevea);
        ocho.setOnClickListener(this);

        nueve = (Button) findViewById(R.id.dieza);
        nueve.setOnClickListener(this);

        diez = (Button) findViewById(R.id.oncea);
        diez.setOnClickListener(this);

        once = (Button) findViewById(R.id.docea);
        once.setOnClickListener(this);

        doce = (Button) findViewById(R.id.trecea);
        doce.setOnClickListener(this);

        una = (Button) findViewById(R.id.catorcea);
        una.setOnClickListener(this);

        dos = (Button) findViewById(R.id.quincea);
        dos.setOnClickListener(this);

        tres = (Button) findViewById(R.id.dieciseisa);
        tres.setOnClickListener(this);

        cuatro = (Button) findViewById(R.id.diecisietea);
        cuatro.setOnClickListener(this);

        cinco = (Button) findViewById(R.id.dieciochoa);
        cinco.setOnClickListener(this);

        seis1 = (Button) findViewById(R.id.diecinuevea);
        seis1.setOnClickListener(this);


        // idg = prefs.getString("idg", "");
        // idg2 = Integer.parseInt(idg);
        idg = prefs.getString("idh", "");
        idh = Integer.parseInt(idg);

        idg1 = prefs.getString("idr", "");
        idr = Integer.parseInt(idg1);

        idg2 = prefs.getString("ids", "");
        ids = Integer.parseInt(idg2);

        info = new ArrayList<CanchaBD>();
        info2 = new ArrayList<UsuarioBD>();

        Firebase firebd;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null) {
            nombreus = user.getDisplayName();
        }


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

        usuario=nombreus;
        tipo=Nombre;
        final String code;
        if(Nombre.equals("Spa")&& ids==1){
            Alerta();
        }
        if(Nombre.equals("Tenis")&& idr==1){
            Alerta();
        }
        if(Nombre.equals("Mini Golf")&& idh==1){
            Alerta();
        }
        switch (v.getId()) {

            case R.id.sietea:
                hora = "7";
                code = "7";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("7").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }
                            if(Nombre.equals("Spa")&& ids==0){
                                Actualizar();
                            }

                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });

                break;

            case R.id.ochoa:
                hora = "8";
                code = "8";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("8").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.nuevea:
                hora = "9";
                code = "9";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("9").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.dieza:
                hora = "10";
                code = "10";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("10").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.oncea:
                hora = "11";
                code = "11";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("11").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.docea:
                hora = "12";
                code = "12";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("12").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.trecea:
                hora = "13";
                code = "13";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("13").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.catorcea:
                hora = "14";
                code = "14";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("14").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.quincea:
                hora = "15";
                code = "15";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("15").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.dieciseisa:
                hora = "16";
                code = "16";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("16").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.diecisietea:
                hora = "17";
                code = "17";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("17").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.dieciochoa:
                hora = "18";
                code = "18";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("18").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

            case R.id.diecinuevea:
                hora = "19";
                code = "19";
                codhora=code;
                firebasedatos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(code).exists()){
                            info.add(dataSnapshot.child("19").getValue(CanchaBD.class));
                            estado=info.get(0).getEstado();

                            if(Nombre.equals("Mini Golf")&& idh==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Tenis")&& idr==0) {
                                Actualizar();
                            }

                            if(Nombre.equals("Spa")&& ids==0) {
                                Actualizar();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });
                break;

        }

    }

    public void Actualizar(){

        if (estado.equals("0")) {
            if(Nombre.equals("Mini Golf")) {
                idh = 1;
                editor.putString("idh", idh.toString());
                editor.putInt("var2", 1);
                editor.commit();
            }else if(Nombre.equals("Tenis")){
                idr = 1;
                editor.putString("idr", idr.toString());
                editor.putInt("var3", 1);
                editor.commit();
            }else if(Nombre.equals("Spa")){
                ids = 1;
                editor.putString("ids", ids.toString());
                editor.putInt("var4", 1);
                editor.commit();
            }
            estado="1";
            firebd = firebasedatos2.child("Reservas").child("reserva" + tipo + " " + usuario);
            ReservaGenBD reservagen = new ReservaGenBD(usuario, tipo, hora);
            firebd.setValue(reservagen);
            firebd2 = firebasedatos.child(codhora);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Reserva realizada!");
            ad.setMessage("Recuerde que solo puede hacer una reserva");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        } else {
            info.clear();
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Importante");
            ad.setMessage("Esta hora ya se encuentra reservada!");
            ad.setPositiveButton("Ok", null);
            ad.create();
            if(!(this).isFinishing())
            {
                //show dialog
                ad.show();

            }

        }


    }
    public void Alerta(){
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Importante");
        ad.setMessage("Ya hizo una reserva, si desea cambiar de horario debe cancelarla!");
        ad.setPositiveButton("Ok", null);
        ad.create();
        ad.show();

    }
}