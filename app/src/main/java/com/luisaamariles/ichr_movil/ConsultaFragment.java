package com.luisaamariles.ichr_movil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultaFragment extends Fragment implements View.OnClickListener{

    Button bConsultar;
    View v;
    public ConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_consulta, container, false);
        bConsultar = (Button) v.findViewById(R.id.Consultar);
        bConsultar.setOnClickListener(this);
        return v;
    }
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(), ConsActivity.class);
        startActivity(intent);

    }
}
