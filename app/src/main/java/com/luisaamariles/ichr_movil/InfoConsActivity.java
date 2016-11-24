package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Luisa Maria Amariles on 30/10/2016.
 */
public class InfoConsActivity extends AppCompatActivity implements View.OnClickListener {

    Button CancelarR;
    String nombre, nomres,Nombre,estado,hora,fecha,fechain,fechasal,fechad,fecham, fechad2,fecham2,
    ida1,idr1,ids1,idg1,idh1,horact,fechact,fechainact,fechasalact,horadef,pm,dispo,habitacion,habitacion2,
            habitacion3,precio;
    TextView nom;
    ArrayList<ReservaGenBD> info;
    ArrayList<ReservaSalBD> info2;
    ArrayList<ReservaHabBD> info3;
    ArrayList<CanchaBD> info4;
    ArrayList<HabBD> info5;
    Integer idh, idr, ids, idg, ida;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos,firebasedatos2;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.infocons);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Reservas");

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        CancelarR = (Button) findViewById(R.id.canres);
        CancelarR.setOnClickListener(this);
        nom = (TextView) findViewById(R.id.nombreres);
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("name");
        nom.setText(nombre);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Nombre = user.getDisplayName();
        }

        info = new ArrayList<ReservaGenBD>();
        info2 = new ArrayList<ReservaSalBD>();
        info3 = new ArrayList<ReservaHabBD>();
        info4 = new ArrayList<CanchaBD>();
        info5 = new ArrayList<HabBD>();

        ida1 = prefs.getString("ida", "");
        ida = Integer.parseInt(ida1);
        idh1 = prefs.getString("idh", "");
        idh = Integer.parseInt(idh1);
        idr1 = prefs.getString("idr", "");
        idr = Integer.parseInt(idr1);
        ids1 = prefs.getString("ids", "");
        ids = Integer.parseInt(ids1);
        idg1 = prefs.getString("idg", "");
        idg = Integer.parseInt(idg1);
        firebasedatos2 = new Firebase(FIREBASE_URL);
        if(nombre.equals("Mini Golf")){
            nomres="reservaMini Golf";
           // Toast.makeText(InfoConsActivity.this,nomres+" "+Nombre,Toast.LENGTH_LONG).show();
            firebasedatos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(nomres+" "+Nombre).exists()) {
                        info.add(dataSnapshot.child(nomres+" "+Nombre).getValue(ReservaGenBD.class));
                        horact = info.get(0).getHora();
                        Actualizar();
                       // Toast.makeText(InfoConsActivity.this,horact,Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }else if(nombre.equals("Tenis")){
            nomres="reservaTenis";
            firebasedatos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(nomres+" "+Nombre).exists()) {
                        info.add(dataSnapshot.child(nomres+" "+Nombre).getValue(ReservaGenBD.class));
                        horact = info.get(0).getHora();
                        Actualizar();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }else if(nombre.equals("Spa")){
            nomres="reservaSpa";
            firebasedatos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(nomres+" "+Nombre).exists()) {
                        info.add(dataSnapshot.child(nomres+" "+Nombre).getValue(ReservaGenBD.class));
                        horact = info.get(0).getHora();
                        Actualizar();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }else if(nombre.equals("Salón")){
            nomres="reservaSal";
            firebasedatos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(nomres+" "+Nombre).exists()) {
                        info2.add(dataSnapshot.child(nomres+" "+Nombre).getValue(ReservaSalBD.class));
                        horact = info2.get(0).getHora();
                        fechact=info2.get(0).getFecha();
                        ActSala();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }else if(nombre.equals("Habitación")){
            nomres="reservaHab";
            firebasedatos.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child(nomres+" "+Nombre).exists()) {
                        info3.add(dataSnapshot.child(nomres+" "+Nombre).getValue(ReservaHabBD.class));
                        fechain = info3.get(0).getFechain();
                        fechasal=info3.get(0).getFechasal();
                        dispo=info3.get(0).getHabitacion();
                        habitacion2=info3.get(0).getNumhab();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            firebasedatos2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child("Habitacion").child(dispo).exists()) {
                        info5.add(dataSnapshot.child("Habitacion").child(dispo).child("1").getValue(HabBD.class));
                        habitacion=info5.get(0).getHab();
                        precio=info5.get(0).getPrecio();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
            firebasedatos2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (dataSnapshot.child("Habitacion").child(dispo).exists()) {
                        info5.add(dataSnapshot.child("Habitacion").child(dispo).child("2").getValue(HabBD.class));
                        habitacion3=info5.get(0).getHab();
                        precio=info5.get(0).getPrecio();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
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
    public void Actualizar(){
        hora=horact;
    }
    public void ActSala(){
        hora=horact;
        String[] separated1 = hora.split(" ");
        horadef=separated1[0];
        pm=separated1[1];
        fecha=fechact;
        String[] separated = fecha.split(" ");
        fechad=separated[0];
        fecham=separated[1];
        if(horadef.equals("1")){
            horadef="13";
        }else if(horadef.equals("2")){
            horadef="14";
        }if(horadef.equals("3")){
            horadef="15";
        }if(horadef.equals("4")){
            horadef="16";
        }if(horadef.equals("5")){
            horadef="17";
        }if(horadef.equals("6")){
            horadef="18";
        }if(horadef.equals("7")){
            horadef="19";
        }if(horadef.equals("8") && pm.equals("pm")){
            horadef="20";
        }
    }
    public void onClick(View v) {
        Firebase firebd,firebd2,firebd3,firebd4;
        firebd = firebasedatos.child(nomres+" "+Nombre);
        firebd.removeValue();

        estado="0";

        if(nombre.equals("Mini Golf")){
            idh = 0;
            editor.putString("idh", idh.toString());
            editor.putInt("var2", 1);
            editor.commit();
            firebd2 = firebasedatos2.child("Cancha").child(nombre).child(hora);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
        }else if(nombre.equals("Tenis")){
            idr = 0;
            editor.putString("idr", idr.toString());
            editor.putInt("var3", 1);
            editor.commit();
            firebd2 = firebasedatos2.child("Cancha").child(nombre).child(hora);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
        }else if(nombre.equals("Spa")){
            ids = 0;
            editor.putString("ids", ids.toString());
            editor.putInt("var4", 1);
            editor.commit();
            firebd2 = firebasedatos2.child(nombre).child(hora);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
        }else if(nombre.equals("Salón")){
            idg = 0;
            editor.putString("idg", idg.toString());
            editor.putInt("var5", 1);
            editor.commit();

            firebd2 = firebasedatos2.child("Fecha").child(fecham).child(fechad).child(horadef);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
        }else if(nombre.equals("Habitación")){
            ida = 0;
            editor.putString("ida", ida.toString());
            editor.putInt("var6", 1);
            editor.commit();
            String[] separated = fechain.split(" ");
            fechad=separated[0];
            fecham=separated[1];
            String[] separated2 = fechasal.split(" ");
            fechad2=separated2[0];
            fecham2=separated2[1];
            firebd2 = firebasedatos2.child("FechaHab").child(fecham).child(fechad);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
            firebd3 = firebasedatos2.child("FechaHab").child(fecham2).child(fechad2);
            CanchaBD cambioestado1 = new CanchaBD(estado);
            firebd3.setValue(cambioestado1);
            if(habitacion.equals(habitacion2)) {
                firebd4 = firebasedatos2.child("Habitacion").child(dispo).child("1");
                HabBD cambioestado3 = new HabBD(habitacion,precio,"0");
                firebd4.setValue(cambioestado3);
            }else {
                firebd4 = firebasedatos2.child("Habitacion").child(dispo).child("2");
                HabBD cambioestado3 = new HabBD(habitacion3,precio,"0");
                firebd4.setValue(cambioestado3);
            }
        }
        alerta();
    }
    public void alerta(){
        AlertDialog.Builder ad = new AlertDialog.Builder(InfoConsActivity.this);
        ad.setTitle("Importante");
        ad.setMessage("Reserva cancelada!");
        ad.setPositiveButton("Ok", null);
        ad.create();
        if(!(this).isFinishing())
        {
            //show dialog
            ad.show();

        }
    }
}
