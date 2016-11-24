package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
 * Created by Luisa Maria Amariles on 24/10/2016.
 */
public class HabResActivity extends AppCompatActivity implements View.OnClickListener {
    String Nombre, idh, nombre, usuario, numhab, fechaind, fechainm, fechasald, fechasalm, fechain, fechasal, precio, habit1, habit2, dispo,
            estado1, estado2, Nombre2, hab1, hab, estado, estadod, estadof;
    TextView Nomb, precio1;
    Button Reserva;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer ida, ban = 0, ban1 = 0;
    ArrayList<HabBD> info;
    ArrayList<HabBD> info2;
    ArrayList<CanchaBD> info3;
    ArrayList<CanchaBD> info4;

    private String FIREBASE_URL = "https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos, firebasedatos2;
    ArrayAdapter<CharSequence> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.habres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Habitacion");

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        Nomb = (TextView) findViewById(R.id.nomhab);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);
        Reserva = (Button) findViewById(R.id.Reservar);
        Reserva.setOnClickListener(this);
        precio1 = (TextView) findViewById(R.id.precio);

        info = new ArrayList<HabBD>();
        info2 = new ArrayList<HabBD>();
        info3 = new ArrayList<CanchaBD>();
        info4 = new ArrayList<CanchaBD>();

        habit2 = " ";
        habit1 = " ";

        Toast.makeText(HabResActivity.this, Nombre, Toast.LENGTH_LONG).show();
        final String nom = Nombre;
        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(nom).child("1").exists()) {
                    info.add(dataSnapshot.child(nom).child("1").getValue(HabBD.class));
                    precio = info.get(0).getPrecio();
                    hab = info.get(0).getHab();
                    estado1 = info.get(0).getEstado();

                }
                if (dataSnapshot.child(nom).child("2").exists()) {
                    info2.add(dataSnapshot.child(nom).child("2").getValue(HabBD.class));
                    hab1 = info2.get(0).getHab();
                    estado2 = info2.get(0).getEstado();

                }
                actualizar();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        idh = prefs.getString("ida", "");
        ida = Integer.parseInt(idh);


        Spinner spinner2 = (Spinner) findViewById(R.id.fechind);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fechad, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner3 = (Spinner) findViewById(R.id.fechinm);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fecham, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner4 = (Spinner) findViewById(R.id.fechsad);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.fechad, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner5 = (Spinner) findViewById(R.id.fechsam);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.fecham, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(new SpinnerListener());
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Nombre2 = user.getDisplayName();
        }
        firebasedatos2 = new Firebase(FIREBASE_URL);

    }

    public void actualizar() {
        precio1.setText(precio);

        Spinner spinner = (Spinner) findViewById(R.id.dispo);
        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Toast.makeText(HabResActivity.this, habit1 + habit2, Toast.LENGTH_LONG).show();
        if (estado1.equals("0")) {
            adapter.add(hab);

        }
        if (estado2.equals("0")) {
            adapter.add(hab1);

        }

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
        //adapter.add(hab);
        //adapter.add(hab1);
    }

    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            Spinner spinner = (Spinner) parent;
            if (spinner.getId() == R.id.dispo) {
                dispo = parent.getItemAtPosition(pos).toString();
                //do this
            } else if (spinner.getId() == R.id.fechind) {
                //do this
                fechaind = parent.getItemAtPosition(pos).toString();
            } else if (spinner.getId() == R.id.fechinm) {

                fechainm = parent.getItemAtPosition(pos).toString();
            } else if (spinner.getId() == R.id.fechsad) {

                fechasald = parent.getItemAtPosition(pos).toString();
            } else if (spinner.getId() == R.id.fechsam) {

                fechasalm = parent.getItemAtPosition(pos).toString();
            }

        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
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
        if (ida == 1) {
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Importante");
            ad.setMessage("Ya hizo una reserva, si desea cambiar de horario debe cancelarla!");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        }

        final String diai = fechaind, dias = fechasald, mesi = fechainm, mesa = fechasalm;
        firebasedatos2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("FechaHab").child(mesi).child(diai).exists()) {
                    info3.add(dataSnapshot.child("FechaHab").child(mesi).child(diai).getValue(CanchaBD.class));
                    estado = info3.get(0).getEstado();
                    if (ida == 0 && ban == 1 && ban1 == 1) {
                        actualizarFecha();
                    }
                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(HabResActivity.this);
                    ad.setTitle("Importante");
                    ad.setMessage("Esta fecha de entrada no se encuentra disponible");
                    ad.setPositiveButton("Ok", null);
                    ad.create();
                    ad.show();
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

    }

    public void actualizarFecha(){

        final String diai = fechaind, dias = fechasald, mesi = fechainm, mesa = fechasalm;
        firebasedatos2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child("FechaHab").child(mesa).child(dias).exists()) {
                    info4.add(dataSnapshot.child("FechaHab").child(mesa).child(dias).getValue(CanchaBD.class));
                    estadod = info4.get(0).getEstado();
                    if (ida == 0) {
                        actualizarBase();
                    }
                } else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(HabResActivity.this);
                    ad.setTitle("Importante");
                    ad.setMessage("Esta fecha de salida no se encuentra disponible");
                    ad.setPositiveButton("Ok", null);
                    ad.create();
                    ad.show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

            public void actualizarBase() {

        Firebase firebd, firebd2, firebd3,firebd4;
        if (estado.equals("0") && estadod.equals("0")) {
            ida = 1;
            editor.putString("ida", ida.toString());
            editor.putInt("var6", 1);
            editor.commit();
            estado = "1";
            estadod="1";

            fechain= fechaind +" "+fechainm;
            fechasal= fechasald+" "+fechasalm;

            firebd = firebasedatos2.child("Reservas").child("reservahab" + " " + Nombre2);
            ReservaHabBD reservahab = new ReservaHabBD(Nombre2, dispo, fechain, fechasal, precio, Nombre);
            firebd.setValue(reservahab);
            firebd2 = firebasedatos2.child("FechaHab").child(fechainm).child(fechaind);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
            firebd3 = firebasedatos2.child("FechaHab").child(fechasalm).child(fechasald);
            CanchaBD cambioestado2 = new CanchaBD(estadod);
            firebd3.setValue(cambioestado2);
            firebd4 = firebasedatos.child(Nombre).child(dispo);
            CanchaBD cambioestado3 = new CanchaBD("1");
            firebd4.setValue(cambioestado3);
            AlertDialog.Builder ad = new AlertDialog.Builder(HabResActivity.this);
            ad.setTitle("Reserva realizada!");
            ad.setMessage("Recuerde que solo puede hacer una reserva");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        } else {

            if(estado.equals("1")) {
                info3.clear();
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("Importante");
                ad.setMessage("Esta fecha de entrada ya se encuentra reservada!");
                ad.setPositiveButton("Ok", null);
                ad.create();
                if (!(this).isFinishing()) {
                    //show dialog
                    ad.show();

                }
            }
            if(estadod.equals("1")) {
                info4.clear();
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("Importante");
                ad.setMessage("Esta fecha de salida ya se encuentra reservada!");
                ad.setPositiveButton("Ok", null);
                ad.create();
                if (!(this).isFinishing()) {
                    //show dialog
                    ad.show();

                }
            }

        }
    }
}
