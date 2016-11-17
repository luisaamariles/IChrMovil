package com.luisaamariles.ichr_movil;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment implements View.OnClickListener{
    String selected,id,nombre, apellido, cedula,telefono, direccion, correo,profesion, motivo;
    Button bAceptar, bCancelar;
    EditText eNombrer, eApellidor, eDireccionr, eCedula, eTelefono, eCorreor,eProfesion, eMotivo;
    View v;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Integer idr2;

    private String FIREBASE_URL="https://ichrmovil.firebaseio.com/";
    private Firebase firebasedatos;
    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_registro, container, false);

        Firebase.setAndroidContext(getActivity());
        firebasedatos = new Firebase(FIREBASE_URL);

        //prefs =getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        //editor=prefs.edit();

        eNombrer = (EditText) v.findViewById(R.id.eNombre1);
        eApellidor = (EditText) v.findViewById(R.id.eApellido1);
        eDireccionr = (EditText) v.findViewById(R.id.eDireccion2);
        eCedula = (EditText) v.findViewById(R.id.eCedula);
        eTelefono = (EditText) v.findViewById(R.id.eTelefono);
        eCorreor = (EditText) v.findViewById(R.id.eCorreo2);
        eProfesion= (EditText) v.findViewById(R.id.eProfesion);
        bAceptar = (Button) v.findViewById(R.id.Registrar);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) v.findViewById(R.id.Rcancelar);
        bCancelar.setOnClickListener(this);
        Spinner spinner = (Spinner) v.findViewById(R.id.motivo2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.motivo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());
        //=prefs.getString("idr","");
        //idr2= Integer.parseInt(id);

        return v;
    }
    public class SpinnerListener implements AdapterView.OnItemSelectedListener {

        // Metodo onItemSelected en el que indicamos lo que queremos hacer
        // cuando sea seleccionado un elemento del Spinner
        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            selected= parent.getItemAtPosition(pos).toString();
        }
        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing.
        }
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Registrar:
                Firebase firebd;
                nombre=eNombrer.getText().toString();
                apellido=eApellidor.getText().toString();
                cedula=eCedula.getText().toString();
                telefono=eTelefono.getText().toString();
                direccion=eDireccionr.getText().toString();
                correo=eCorreor.getText().toString();
                profesion=eProfesion.getText().toString();
                motivo=selected;
                firebd = firebasedatos.child("Registro").child("registro "+ cedula);
                RegistroBD registro = new RegistroBD(nombre,apellido,cedula,telefono,direccion,correo,profesion,motivo);
                firebd.setValue(registro);
               /* idr2++;
                editor.putString("idr",idr2.toString());
                editor.putInt("var3",1);
                editor.commit();*/
                Toast.makeText(getActivity(),"Registro iniciado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Rcancelar:
                Toast.makeText(getActivity(),"Registro cancelado", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
