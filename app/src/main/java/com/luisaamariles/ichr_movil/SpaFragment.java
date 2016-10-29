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
public class SpaFragment extends Fragment implements View.OnClickListener{

    Button bReservas;
    View v;
    public SpaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_spa, container, false);
        bReservas = (Button) v.findViewById(R.id.Reservas);
        bReservas.setOnClickListener(this);

        return v;

    }
    public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReservaGenActivity.class);
                startActivity(intent);

    }
}
