package com.luisaamariles.ichr_movil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroFragment extends Fragment implements View.OnClickListener{
    String selected;
    Button bAceptar, bCancelar;
    View v;
    public RegistroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_registro, container, false);
        bAceptar = (Button) v.findViewById(R.id.Registrar);
        bAceptar.setOnClickListener(this);
        bCancelar = (Button) v.findViewById(R.id.Rcancelar);
        bCancelar.setOnClickListener(this);
        Spinner spinner = (Spinner) v.findViewById(R.id.motivo2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.motivo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SpinnerListener());

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
                Toast.makeText(getActivity(),"Registro iniciado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Rcancelar:
                Toast.makeText(getActivity(),"Registro cancelado", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
