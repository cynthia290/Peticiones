package com.example.peticiones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.peticiones.adaptadores.adaptadorPersona;
import com.example.peticiones.model.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.lst);

    }

    public void onClick(View v) {
        JsonArrayRequest json = new JsonArrayRequest(
                Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/lista",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Gson g = new Gson();
                        Type t = new TypeToken<List<Persona>>(){}.getType();

                        List<Persona> lp = g.fromJson(response.toString(), t);
                        adaptadorPersona ap = new adaptadorPersona(lp, getApplicationContext());
                        lst.setAdapter(ap);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

        VolleyS.getInstance(this).getMyRequestQueue().add(json);

    }
}