package com.luisaamariles.ichr_movil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class CambiarConActivity extends AppCompatActivity implements View.OnClickListener {
    Button bAceptar, bCancelar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cambiar);

        bAceptar = (Button) findViewById(R.id.bAceptar1);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) findViewById(R.id.bCancelar1);
        bCancelar.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bAceptar1:
                Intent intent = new Intent(this, LogginActivity.class);
                startActivity(intent);
                break;
            case R.id.bCancelar1:
                Intent intent2 = new Intent(this, LogginActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
