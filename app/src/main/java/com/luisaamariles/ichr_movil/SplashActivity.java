package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class SplashActivity extends AppCompatActivity {
    Integer id;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.splash);
    getSupportActionBar().hide();


        prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
        if(prefs.getInt("var",-1)==1){

        }else {
            id=0;
            editor.putString("id", id.toString());
            editor.commit();
        }
    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent intent = new Intent(SplashActivity.this,LogginActivity.class);
                startActivity(intent);
            }
        }
    };
    timerThread.start();
}

    @Override
    protected void onPause() {

        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
