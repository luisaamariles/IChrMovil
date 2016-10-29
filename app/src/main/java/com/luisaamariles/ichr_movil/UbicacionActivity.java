package com.luisaamariles.ichr_movil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * Created by Luisa Maria Amariles on 22/10/2016.
 */
public class UbicacionActivity extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.ubicacion, contentFrameLayout);
        getSupportActionBar().show();
    }
}
