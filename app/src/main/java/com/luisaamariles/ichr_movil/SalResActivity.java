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
 * Created by Luisa Maria Amariles on 25/10/2016.
 */
public class SalResActivity extends AppCompatActivity implements View.OnClickListener {
    String Nombre, Nombre2, salon, fecha, fechad, fecham, hora, horas, precio, acomodacion, idh, estado;
    TextView Nomb, precio1;
    Button Reserva;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer idg;
    private String FIREBASE_URL = "https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos, firebasedatos2;
    ArrayList<SalaBD> info;
    ArrayList<CanchaBD> info2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.salres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Salon");

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        Nomb = (TextView) findViewById(R.id.nomsal);
        Reserva = (Button) findViewById(R.id.Reservare);
        Reserva.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);
        precio1 = (TextView) findViewById(R.id.precioe);

        info = new ArrayList<SalaBD>();
        info2 = new ArrayList<CanchaBD>();

        idh = prefs.getString("idg", "");
        idg = Integer.parseInt(idh);


        final String nom = Nombre;
        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(nom).exists()) {
                    info.add(dataSnapshot.child(nom).getValue(SalaBD.class));
                    precio = info.get(0).getPrecio();
                    actualizar();

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.acomo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acomod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner2 = (Spinner) findViewById(R.id.fechevend);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fechad, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner3 = (Spinner) findViewById(R.id.fechevenm);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.fecham, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new SpinnerListener());
        Spinner spinner4 = (Spinner) findViewById(R.id.horeve);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.hora, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new SpinnerListener());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Nombre2 = user.getDisplayName();
        }
        firebasedatos2 = new Firebase(FIREBASE_URL);

    }

    public void actualizar() {
        precio1.setText(precio);
    }

    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            Spinner spinner = (Spinner) parent;
            if (spinner.getId() == R.id.acomo) {
                acomodacion = parent.getItemAtPosition(pos).toString();
                //do this
            } else if (spinner.getId() == R.id.fechevend) {
                //do this
                fechad = parent.getItemAtPosition(pos).toString();
            } else if (spinner.getId() == R.id.fechevenm) {

                fecham = parent.getItemAtPosition(pos).toString();
            } else if (spinner.getId() == R.id.horeve) {

                hora = parent.getItemAtPosition(pos).toString();
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
        if(idg == 1){
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Importante");
            ad.setMessage("Ya hizo una reserva, si desea cambiar de horario debe cancelarla!");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        }
        if (hora.equals("8 am")) {
            horas = "8";
        }
        if (hora.equals("9 am")) {
            horas = "9";
        }
        if (hora.equals("10 am")) {
            horas = "10";
        }
        if (hora.equals("11 am")) {
            horas = "11";
        }
        if (hora.equals("12 m")) {
            horas = "12";
        }
        if (hora.equals("1 pm")) {
            horas = "13";
        }
        if (hora.equals("2 pm")) {
            horas = "14";
        }
        if (hora.equals("3 pm")) {
            horas = "15";
        }
        if (hora.equals("4 pm")) {
            horas = "16";
        }
        if (hora.equals("5 pm")) {
            horas = "17";
        }
        if (hora.equals("6 pm")) {
            horas = "18";
        }
        if (hora.equals("7 pm")) {
            horas = "19";
        }
        if (hora.equals("8 pm")) {
            horas = "20";
        }
        final String horario = horas;
        firebasedatos2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Fecha").child(fecham).child(fechad).child(horario).exists()) {
                    info2.add(dataSnapshot.child("Fecha").child(fecham).child(fechad).child(horario).getValue(CanchaBD.class));
                    estado = info2.get(0).getEstado();

                    if (idg == 0) {
                        actualizarBase();
                    }
                }else{
                    AlertDialog.Builder ad = new AlertDialog.Builder(SalResActivity.this);
                    ad.setTitle("Importante");
                    ad.setMessage("Esta fecha no se encuentra disponible");
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
        salon = Nombre;
        fecha = fechad + " " + fecham;
        Firebase firebd,firebd2;
        if (estado.equals("0")) {
            idg = 1;
            editor.putString("idg", idg.toString());
            editor.putInt("var5", 1);
            editor.commit();
            estado = "1";
            firebd = firebasedatos2.child("Reservas").child("reservaSal" + " " + Nombre2);
            ReservaSalBD reservasal = new ReservaSalBD(Nombre2, salon, fecha, hora, precio, acomodacion);
            firebd.setValue(reservasal);
            firebd2 = firebasedatos2.child("Fecha").child(fecham).child(fechad).child(horas);
            CanchaBD cambioestado = new CanchaBD(estado);
            firebd2.setValue(cambioestado);
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Reserva realizada!");
            ad.setMessage("Recuerde que solo puede hacer una reserva");
            ad.setPositiveButton("Ok", null);
            ad.create();
            ad.show();
        }else{
            info2.clear();
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
}
