package com.ludi.tt_ludi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Escuela extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> estados, idestados, escuelas, idescuelas;
    Spinner spinner;
    private static final String ESTADOS_URL = "http://ludi.mx/api/estado";
    private static final String ESCUELAS_URL = "http://ludi.mx/api/escuela";
    public static final String KEY_ID_ESTADO = "idestado";
    public static final String KEY_NOMBRE_ESTADO = "nombre";
    public static final String KEY_ID_ESCUELA = "idescuela";
    public static final String KEY_NOMBRE_ESCUELA = "nombre";
    public static final String KEY_CLAVE_ESCUELA = "clave";
    private AutoCompleteTextView textViewEscuela, textViewEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        llenarEstados();
        llenarEscuelas("2");


        ArrayAdapter<String> autocompleteAdapterEstado = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, estados);
        textViewEstado = (AutoCompleteTextView)findViewById(R.id.estado);
        textViewEstado.setAdapter(autocompleteAdapterEstado);
        textViewEstado.setOnItemClickListener(this);


        ArrayAdapter<String> autocompleteAdapterEscuela = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, escuelas);
        textViewEscuela = (AutoCompleteTextView)findViewById(R.id.escuela);
        textViewEscuela.setAdapter(autocompleteAdapterEscuela);
        textViewEscuela.setOnItemClickListener(this);

    }

    private void llenarEstados(){
        estados = new ArrayList<String>();
        idestados = new ArrayList<String>();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, ESTADOS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int w;
                        JSONObject reader;
                        try {
                            JSONArray array = new JSONArray(response);
                            w=array.length();
                            for(int i=0; i<w; i++){
                                reader = array.getJSONObject(i);
                                estados.add(reader.getString(KEY_NOMBRE_ESTADO));
                                idestados.add(reader.getString(KEY_ID_ESTADO));
                            }

                        } catch (JSONException e) { e.printStackTrace();}
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No es posible cargar los estados.");
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

    private void llenarEscuelas(String idEstado){

        escuelas = new ArrayList<String>();
        idescuelas = new ArrayList<String>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, ESCUELAS_URL+"/"+idEstado,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int w;
                        JSONObject reader;
                        try {

                            JSONArray array = new JSONArray(response);
                            w=array.length();
                            for(int i=0; i<w; i++){
                                reader = array.getJSONObject(i);
                                escuelas.add(reader.getString(KEY_NOMBRE_ESCUELA)+" "+reader.getString(KEY_CLAVE_ESCUELA));
                                idescuelas.add(reader.getString(KEY_ID_ESCUELA));
                            }

                        } catch (JSONException e) { e.printStackTrace();}

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("No es posible cargar las escuelas.");
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

    private void mostrar(String w){
        AlertDialog alertDialog = new AlertDialog.Builder(Escuela.this).create();
        alertDialog.setTitle("Aviso");
        alertDialog.setMessage(w);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mostrar(view.toString());
        switch (view.getId()){
            case R.id.estado:
                mostrar("ESTADO "+idestados.get(position));
                break;
            case R.id.escuela:
                mostrar("ESCUELA  "+idescuelas.get(position));
                break;
        }

    }
}
