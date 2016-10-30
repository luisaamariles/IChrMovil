package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    String nombreu, apellido, direccion, pais, ciudad, correo, contrasena, rcontrasena, id;
    Button bAceptar, bCancelar;
    EditText eNombreu, eApellido, eDireccion, ePais, eCiudad, eCorreo, eContrasena, eRcontrasena;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer id2;


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
        eDireccion = (EditText) findViewById(R.id.eDireccion);
        ePais = (EditText) findViewById(R.id.ePais);
        eCiudad = (EditText) findViewById(R.id.eCiudad);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        eRcontrasena= (EditText) findViewById(R.id.eRContrasena);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        bCancelar.setOnClickListener(this);
        id=prefs.getString("id","");
        id2= Integer.parseInt(id);
    }

    public void onClick(View v) {
        Firebase firebd;
        nombreu=eNombreu.getText().toString();
        apellido=eApellido.getText().toString();
        direccion=eDireccion.getText().toString();
        pais=ePais.getText().toString();
        ciudad=eCiudad.getText().toString();
        correo=eCorreo.getText().toString();
        contrasena=eContrasena.getText().toString();
        rcontrasena=eRcontrasena.getText().toString();

        switch (v.getId()) {
            case R.id.bAceptar:
                firebd = firebasedatos.child("usuario "+id2);
                Usuario usuario = new Usuario(nombreu,apellido,direccion,pais,ciudad,correo,contrasena,String.valueOf(id2));
                firebd.setValue(usuario);
                id2++;
                editor.putString("id",id2.toString());
                editor.commit();
                if(prefs.getInt("var",-1)==1){
                    Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"vali",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(this, LogginActivity.class);
                startActivity(intent);
                break;
            case R.id.bCancelar:
                Intent intent2 = new Intent(this, LogginActivity.class);
                startActivity(intent2);
                break;
        }
    }

}
