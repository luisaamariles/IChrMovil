package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class LogginActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    EditText Name,Pass;
    Button bSesion;
    String Nombre,Contrasena, Mail;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        getSupportActionBar().hide();

       /* prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();*/

        Name = (EditText) findViewById(R.id.eName);
        Pass= (EditText) findViewById(R.id.ePass);
        bSesion = (Button) findViewById(R.id.bIsesion);
        bSesion.setOnClickListener(this);

        /*if(prefs.getInt("var",-1)==1){
            Intent intent = new Intent(this, NavActivity.class);
            intent.putExtra("Name",prefs.getString("nombre",""));
            intent.putExtra("Pass",prefs.getString("contraseña",""));
            intent.putExtra("Email",prefs.getString("mail",""));

            startActivity(intent);
            finish();
        }*/
    }
    public void onClick(View v){
        /*String vacio1= Name.getText().toString();
        String a,b;
        String vacio2= Pass.getText().toString();

        editor.putString("nombre",Nombre);
        editor.putString("contraseña",Contrasena);
        editor.putString("mail",Mail);
        editor.commit();

        if (vacio1.equals("") || vacio2.equals("")) {
            Toast.makeText(this,"Campos Vacios",Toast.LENGTH_SHORT).show();
        }else{a=prefs.getString("nombre","");
            b=prefs.getString("contraseña","");
            if(vacio1.equals(a)&& vacio2.equals(b)) {*/
                Intent intent = new Intent(this, MainActivity.class);
                /*intent.putExtra("Name",prefs.getString("nombre",""));
                intent.putExtra("Pass",prefs.getString("contraseña",""));
                intent.putExtra("Email",prefs.getString("mail",""));
                editor.putInt("var",1);
                editor.commit();*/
                startActivity(intent);
                finish();

           /* }else{
                Toast.makeText(this,"Registrese!",Toast.LENGTH_SHORT).show();
            }

        }*/
    }
    public void handleOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.registro:
                Intent intent2 = new Intent(this, RegistroActivity.class);
                startActivityForResult(intent2, 1234);
               // Name.setText("");
               // Pass.setText("");
                break;
            case R.id.Rpass:
                Intent intent3 = new Intent(this, CambiarConActivity.class);
                startActivity(intent3);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {

        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Log.d("mensaje","no se cargaron datos");
        }
    }
}
