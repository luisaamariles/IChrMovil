package com.luisaamariles.ichr_movil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Luisa Maria Amariles on 20/10/2016.
 */
public class LogginActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    EditText Name, Pass;
    Button bSesion;
    String Nombre,act;
    Integer idh, idr, ids, idg;

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    private SignInButton mGoogleBtn;
    private static final int  RC_SIGN_IN = 1;
    private static final String TAG = "LogginActivity";

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    private  int opLog;// 1= google, 2= facebook


    private GoogleApiClient mGoogleApiClient;


//modificar la sesion inscribirse, cuando se logea con facebook o google saltar al formulario para agregar a la base de datos, poner una
    //sesion mi perfil con las datos de la base de datos
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.login);
        getSupportActionBar().hide();



        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email"));

        mGoogleBtn = (SignInButton) findViewById(R.id.sign_in_button) ;
        mGoogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener(){

                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(getApplicationContext(),"Error en login",Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult){
                handleFacebookAccessToken(loginResult.getAccessToken());
                opLog = 2;
            }
            @Override
            public void onCancel(){
                Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(FacebookException error){
                Toast.makeText(getApplicationContext(),"Error login Facebook",Toast.LENGTH_SHORT).show();
            }
        });

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    goRegActivity();
                }
            }

        };

        Name = (EditText) findViewById(R.id.eName);
        Pass= (EditText) findViewById(R.id.ePass);
        bSesion = (Button) findViewById(R.id.bIsesion);
        bSesion.setOnClickListener(this);

        prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
        if(prefs.getInt("var2",-1)==1){

        }else {
            idh=0;
            editor.putString("idh", idh.toString());
            editor.commit();
        }
        if(prefs.getInt("var3",-1)==1){

        }else {
            idr=0;
            editor.putString("idr", idr.toString());
            editor.commit();
        }
        if(prefs.getInt("var4",-1)==1){

        }else {
            ids=0;
            editor.putString("ids", ids.toString());
            editor.commit();
        }
        if(prefs.getInt("var5",-1)==1){

        }else {
            idg=0;
            editor.putString("idg", idg.toString());
            editor.commit();
        }


    }
    private void signIn() {
        opLog = 1;
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void onClick(View v){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
    }
    public void handleOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.registro:
                Intent intent2 = new Intent(this, RegistroActivity.class);
                startActivityForResult(intent2, 1234);

                break;
            case R.id.Rpass:
                Intent intent3 = new Intent(this, CambiarConActivity.class);
                startActivity(intent3);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(opLog == 1) {

            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                if (result.isSuccess()) {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = result.getSignInAccount();
                    firebaseAuthWithGoogle(account);
                } else {
                    // Google Sign In failed, update UI appropriately
                    // ...
                }
            }
        }else {
            callbackManager.onActivityResult(requestCode,resultCode,data);
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(LogginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
    private void handleFacebookAccessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Error en login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListener);
    }

    private void goRegActivity() {

            Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

    }
}
