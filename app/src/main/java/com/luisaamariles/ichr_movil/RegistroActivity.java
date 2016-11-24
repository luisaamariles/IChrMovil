package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    String nombreu, apellido , pais,correo, nusuario, contrasena, rcontrasena, id, existe;
    Button bAceptar, bCancelar;
    EditText eNombreu, eApellido, eDireccion, ePais, eCiudad, eCorreo,eUsuario, eContrasena, eRcontrasena;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer ban=0;
    ArrayList<UsuarioBD> info;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.registro);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();

        getSupportActionBar().hide();

        eNombreu = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        ePais = (EditText) findViewById(R.id.ePais);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eUsuario= (EditText) findViewById(R.id.eUsuario);

        bAceptar = (Button) findViewById(R.id.bAceptar);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        bCancelar.setOnClickListener(this);

        existe = "null";
        info = new ArrayList<UsuarioBD>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null) {
            nombreu = user.getDisplayName();
            eUsuario.setText(nombreu);
            correo = user.getEmail();
            eCorreo.setText(correo);
        }

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("usuario").child("usuario "+nombreu).exists()){
                    info.add(dataSnapshot.child("usuario").child("usuario "+nombreu).getValue(UsuarioBD.class));
                    eNombreu.setText(info.get(0).getNombre());
                    eNombreu.setFocusable(false);
                    eApellido.setText(info.get(0).getApellido());
                    eApellido.setFocusable(false);
                    ePais.setText(info.get(0).getPais());
                    ePais.setFocusable(false);
                    eUsuario.setText(nombreu);
                    eUsuario.setFocusable(false);
                    eCorreo.setText(correo);
                    eCorreo.setFocusable(false);
                    existe = "ok";
                }else{
                    if(ban==0) {
                        Alerta();
                        ban=1;
                    }
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

    }

    public void Alerta(){
        AlertDialog.Builder ad = new AlertDialog.Builder(RegistroActivity.this);
        ad.setTitle("Importante");
        ad.setMessage("Para continuar debe registrar sus datos!");
        ad.setPositiveButton("Ok", null);
        ad.create();
        //show dialog
        ad.show();

    }
    public void onClick(View v) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        switch (v.getId()) {

            case R.id.bAceptar:
                Firebase firebd;
                nombreu=eNombreu.getText().toString();
                apellido=eApellido.getText().toString();
                pais=ePais.getText().toString();
                correo=eCorreo.getText().toString();
                nusuario=eUsuario.getText().toString();


                if (existe.equals("ok")){
                    Intent intent3 = new Intent(this, MainActivity.class);
                    startActivity(intent3);
                    finish();
                }else {
                    firebd = firebasedatos.child("usuario").child("usuario "+ nusuario);
                    UsuarioBD usuario = new UsuarioBD(nombreu,apellido,pais,correo,nusuario);
                    firebd.setValue(usuario);
                    AlertDialog.Builder ad = new AlertDialog.Builder(RegistroActivity.this);
                    ad.setTitle("Bienvenido");
                    ad.setMessage("Tu registro ha sido exitoso, ahora puedes conocer toda la información de tu interes");
                    ad.create();
                    ad.show();
                    new CountDownTimer(2000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
                            Intent intent3 = new Intent(RegistroActivity.this, MainActivity.class);
                            startActivity(intent3);
                            finish();
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();


                }


                break;
            case R.id.bCancelar:
                if (user==null) {
                    Intent intent2 = new Intent(this, LogginActivity.class);
                    startActivity(intent2);
                }else {
                    AlertDialog.Builder ad = new AlertDialog.Builder(RegistroActivity.this);
                    ad.setMessage("cerrando sesión");
                    ad.create();
                    ad.show();

                    new CountDownTimer(2000, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
                            LoginManager.getInstance().logOut();
                            FirebaseAuth.getInstance().signOut();
                            Intent intent = new Intent (getApplicationContext(), LogginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }

                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();

                }
                break;
        }
    }

}
