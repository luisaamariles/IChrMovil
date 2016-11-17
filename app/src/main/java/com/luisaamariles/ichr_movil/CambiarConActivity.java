package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class CambiarConActivity extends AppCompatActivity implements View.OnClickListener {
    Button bAceptar, bCancelar;
    EditText contrasena,rcontrasena;
    String contraseña,rcontraseña;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cambiar);

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        contrasena=(EditText) findViewById(R.id.eContrasena);
        rcontrasena=(EditText) findViewById(R.id.eRContrasena2);
        bAceptar = (Button) findViewById(R.id.bAceptar1);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) findViewById(R.id.bCancelar1);
        bCancelar.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bAceptar1:
                Firebase firebd;
                contraseña=contrasena.getText().toString();
                firebd = firebasedatos.child("usuario").child("usuario luisa123");
                Map<String,Object> nuevacontrasena = new HashMap<>();
                nuevacontrasena.put("contrasena",contraseña);
                firebd.updateChildren(nuevacontrasena);
                Toast.makeText(this,"Cambio realizado!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LogginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bCancelar1:
                Intent intent2 = new Intent(this, LogginActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
