package com.luisaamariles.ichr_movil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaFragment extends Fragment implements View.OnClickListener{

    Button bConsultar;
    String nombreus,nombreus2;
    EditText Usuario;
    View v;
    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;

    public ConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_consulta, container, false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user!=null) {
            nombreus = user.getDisplayName();
            Toast.makeText(getActivity(),nombreus,Toast.LENGTH_SHORT).show();
        }
        Usuario = (EditText) v.findViewById(R.id.eNombre1);


        bConsultar = (Button) v.findViewById(R.id.Consultar);
        bConsultar.setOnClickListener(this);
        return v;
    }
    public void onClick(View v) {
        nombreus2 = Usuario.getText().toString();
        Toast.makeText(getActivity(),nombreus2,Toast.LENGTH_SHORT).show();
        if(nombreus2.equals(nombreus)) {
            Intent intent = new Intent(getActivity(), ConsActivity.class);
            intent.putExtra("usuario", nombreus);
            startActivity(intent);
        }else{
            Toast.makeText(getActivity(),"No es el usuario actual",Toast.LENGTH_SHORT).show();
            Usuario.setText(" ");
        }

    }
}
