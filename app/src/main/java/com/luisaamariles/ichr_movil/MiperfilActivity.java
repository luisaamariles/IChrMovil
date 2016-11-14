package com.luisaamariles.ichr_movil;

import android.os.Bundle;
import android.widget.FrameLayout;

/**
 * Created by Luisa Maria Amariles on 14/11/2016.
 */
public class MiperfilActivity extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.perfil, contentFrameLayout);
        getSupportActionBar().show();
    }

}
