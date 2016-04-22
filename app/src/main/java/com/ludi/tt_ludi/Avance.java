package com.ludi.tt_ludi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Avance extends AppCompatActivity {

    private static final String WS_ESTATUS = "http://ludi.mx/api/estatus/";
    private String id;
    private TextView estatusAct1, estatusAct2, estatusAct3, estatusAct4, estatusAct5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.id = (getApplicationContext().getSharedPreferences("ludi", 0)).getString("id",null);
        estatusAct1 = (TextView) findViewById(R.id.btn_act1);
        estatusAct2 = (TextView) findViewById(R.id.btn_act2);
        estatusAct3 = (TextView) findViewById(R.id.btn_act3);
        estatusAct4 = (TextView) findViewById(R.id.btn_act4);
        estatusAct5 = (TextView) findViewById(R.id.btn_act5);

        getEstatus();

    }

    private void getEstatus(){


        StringRequest stringRequest = new StringRequest(Request.Method.GET, WS_ESTATUS+this.id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        actualizarEstatus(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No se pudo obtener el estatus del usuario "+id);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void actualizarEstatus(String json){

        Drawable tache = getResources().getDrawable(R.drawable.tache);
        Drawable paloma = getResources().getDrawable(R.drawable.paloma);

        try {
            JSONObject jsonObject;
            JSONArray jsonArray = new JSONArray(json);
            int idActividad;

            for(int i = 0; i < jsonArray.length(); i++){

                jsonObject = jsonArray.getJSONObject(i);
                idActividad = jsonObject.getInt("idactividad");

                if(idActividad == 1)
                    estatusAct1.setBackground(paloma);
                else if(idActividad == 2)
                    estatusAct2.setBackground(paloma);
                else if(idActividad == 3)
                    estatusAct3.setBackground(paloma);
                else if(idActividad == 4)
                    estatusAct4.setBackground(paloma);
                else if(idActividad == 5)
                    estatusAct5.setBackground(paloma);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

}
