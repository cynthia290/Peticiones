package com.example.peticiones.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.peticiones.R;
import com.example.peticiones.model.Persona;

import java.util.List;

public class adaptadorPersona extends BaseAdapter {

    List<Persona> lp;
    Context c;

    public adaptadorPersona(List<Persona> lp, Context c) {
        this.lp = lp;
        this.c = c;
    }

    @Override
    public int getCount() { return lp.size(); }

    @Override
    public Object getItem(int i) { return lp.get(i); }

    @Override
    public long getItemId(int i) { return lp.get(i).getId(); }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        LayoutInflater li = LayoutInflater.from(c);
        convertview = (View) li.inflate(R.layout.item, null);
        Persona p = (Persona) getItem(i);

        TextView txtNombre = (TextView) convertview.findViewById(R.id.txtNombre);
        TextView txtApellido = (TextView) convertview.findViewById(R.id.txtApellido);
        TextView txtEdad = (TextView) convertview.findViewById(R.id.txtEdad);

        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());
        txtEdad.setText(p.getEdad().toString());

        return convertview;

    }
}
