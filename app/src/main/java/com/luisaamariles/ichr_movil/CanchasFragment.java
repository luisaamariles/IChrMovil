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
public class CanchasFragment extends Fragment implements View.OnClickListener{
    Button bReservart,bReservarg;
    View v;
    public CanchasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_canchas, container, false);
        bReservart = (Button) v.findViewById(R.id.Reservat);
        bReservart.setOnClickListener(this);
        bReservarg = (Button) v.findViewById(R.id.Reservag);
        bReservarg.setOnClickListener(this);
        return v;
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Reservat:
                Intent intent = new Intent(getActivity(), ReservaGenActivity.class);
                startActivity(intent);
                break;
            case R.id.Reservag:
                Intent intent2 = new Intent(getActivity(), ReservaGenActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
