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

import com.facebook.login.LoginManager;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    String nombreu, apellido, direccion, pais, ciudad, correo, nusuario, contrasena, rcontrasena, id;
    Button bAceptar, bCancelar;
    EditText eNombreu, eApellido, eDireccion, ePais, eCiudad, eCorreo,eUsuario, eContrasena, eRcontrasena;
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
        ePais = (EditText) findViewById(R.id.ePais);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        eUsuario= (EditText) findViewById(R.id.eUsuario);
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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        switch (v.getId()) {

            case R.id.bAceptar:
                Firebase firebd;
                nombreu=eNombreu.getText().toString();
                apellido=eApellido.getText().toString();
                pais=ePais.getText().toString();
                correo=eCorreo.getText().toString();
                nusuario=eUsuario.getText().toString();
                contrasena=eContrasena.getText().toString();
                rcontrasena=eRcontrasena.getText().toString();

                if (user==null){
                    firebd = firebasedatos.child("usuario").child("usuario "+ nusuario);
                    UsuarioBD usuario = new UsuarioBD(nombreu,apellido,pais,correo,nusuario,contrasena);
                    firebd.setValue(usuario);
                    id2++;
                    editor.putString("id",id2.toString());
                    editor.putInt("var",1);
                    editor.commit();

                    Toast.makeText(this,"Registrado!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, LogginActivity.class);
                    startActivity(intent);
                }else {

                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }

                break;
            case R.id.bCancelar:
                if (user==null) {
                    Intent intent2 = new Intent(this, LogginActivity.class);
                    startActivity(intent2);
                }else {
                    Toast.makeText(RegistroActivity.this,"sesión cerrada",Toast.LENGTH_SHORT).show();
                    LoginManager.getInstance().logOut();
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent (getApplicationContext(), LogginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                break;
        }
    }

}
