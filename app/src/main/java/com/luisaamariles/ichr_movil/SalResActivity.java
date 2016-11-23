package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
public class SalResActivity extends AppCompatActivity implements View.OnClickListener{
    String Nombre,Nombre2, salon, fecha, hora, precio, estado;
    TextView Nomb, precio1;
    Button Reserva;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer ids2;
    String selected;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;
    ArrayList<SalaBD> info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.salres);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL).child("Salon");

        Nomb = (TextView) findViewById(R.id.nomsal);
        Reserva = (Button) findViewById(R.id.Reservare);
        Reserva.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        Nombre = extras.getString("name");
        Nomb.setText(Nombre);
        precio1 = (TextView) findViewById(R.id.precioe);

        info = new ArrayList<SalaBD>();

        final String nom=Nombre;
        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(nom).exists()){
                    info.add(dataSnapshot.child(nom).getValue(SalaBD.class));
                    estado=info.get(0).getEstado();
                    precio=info.get(0).getPrecio();
                    actualizar();

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


        Toast.makeText(SalResActivity.this,precio,Toast.LENGTH_LONG).show();
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
        if (user!=null) {
            Nombre2 = user.getDisplayName();
        }
    }

    public void actualizar(){
        precio1.setText(precio);
    }

    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            selected= parent.getItemAtPosition(pos).toString();
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

        Firebase firebd;

        firebd = firebasedatos.child("Reservas").child("reservasal"+" "+Nombre2);
        ReservaSalBD reservasal = new ReservaSalBD(Nombre2,salon,fecha,hora,precio);
        firebd.setValue(reservasal);
        Toast.makeText(this,"Reservado!", Toast.LENGTH_SHORT).show();
    }
}
