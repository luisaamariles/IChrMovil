package com.luisaamariles.ichr_movil;

import android.os.Bundle;
import android.widget.FrameLayout;
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
 * Created by Luisa Maria Amariles on 14/11/2016.
 */
public class MiperfilActivity extends MainActivity {

    ArrayList<UsuarioBD> info;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    String nombreus,correus,nombre;
    TextView eNombre, eUsuario, eEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.perfil, contentFrameLayout);
        getSupportActionBar().show();

        eUsuario= (TextView) findViewById(R.id.userres);
        eNombre= (TextView) findViewById(R.id.nombreres);
        eEmail= (TextView) findViewById(R.id.mailres);


        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        info = new ArrayList<UsuarioBD>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null) {
            nombreus = user.getDisplayName();
            correus = user.getEmail();
        }

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("usuario").child("usuario "+nombreus).exists()){
                    info.add(dataSnapshot.child("usuario").child("usuario "+nombreus).getValue(UsuarioBD.class));
                    Actualizar();

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

    }
    public void Actualizar(){
        eNombre.setText(info.get(0).getNombre()+" "+info.get(0).getApellido());
        eUsuario.setText(info.get(0).getUsuario());
        eEmail.setText(info.get(0).getCorreo());
    }

}
