package com.ludi.tt_ludi;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Actualizar extends AppCompatActivity implements View.OnClickListener{

    private static final String USER_URL = "http://ludi.mx/api/usuario";

    public static final String KEY_IDUSER = "idusuario";
    public static final String KEY_USUARIO = "usuario";
    public static final String KEY_NOMBRE = "nombre";
    public static final String KEY_PESO = "peso";
    public static final String KEY_ESTATURA = "estatura";
    public static final String KEY_EDAD = "edad";

    private EditText editTextUsuario;
    private EditText editTextNombre;
    private EditText editTextPeso;
    private EditText editTextEstatura;
    private EditText editTextEdad;


    private TextView txtRegister,txtRegister2;
    private String id;

    private Button buttonUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        this.id = (getApplicationContext().getSharedPreferences("ludi", 0)).getString("id",null);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setTypeface(myTypeFace);

        txtRegister2 = (TextView) findViewById(R.id.txtRegister2);
        txtRegister2.setTypeface(myTypeFace);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextUsuario.setTypeface(myTypeFace2);
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextNombre.setTypeface(myTypeFace2);
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
        editTextPeso.setTypeface(myTypeFace2);
        editTextEstatura = (EditText) findViewById(R.id.editTextEstatura);
        editTextEstatura.setTypeface(myTypeFace2);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);
        editTextEdad.setTypeface(myTypeFace2);



        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);

        retrieveUser(this.id);
    }

    private void updateUser(String id){
        final String idUser = id;
        final String usuario = editTextUsuario.getText().toString().trim();
        final String nombre = editTextNombre.getText().toString().trim();
        final String peso = editTextPeso.getText().toString().trim();
        final String estatura = editTextEstatura.getText().toString().trim();
        final String edad = editTextEdad.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.PUT, USER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("Usuario actualizado: "+response);
                        if(response.equals("{\"message\":OK}")){
                            System.out.println("bien");
                        }else{
                            System.out.println("mal");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        System.out.println("No se pudo actualizar al usuario "+idUser);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_IDUSER,idUser);
                params.put(KEY_USUARIO,usuario);
                params.put(KEY_NOMBRE,nombre);
                params.put(KEY_PESO,peso);
                params.put(KEY_ESTATURA, estatura);
                params.put(KEY_EDAD, edad);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void retrieveUser(final String idUser){


        StringRequest stringRequest = new StringRequest(Request.Method.GET, USER_URL+"/"+idUser,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String usuario = "", nombre= "", peso = "", estatura = "",  edad = "";

                        try {

                            JSONArray array = new JSONArray(response);
                            JSONObject reader = array.getJSONObject(0);
                            nombre = reader.getString(KEY_NOMBRE);
                            usuario = reader.getString(KEY_USUARIO);
                            peso = reader.getString(KEY_PESO);
                            estatura = reader.getString(KEY_ESTATURA);
                            edad = reader.getString(KEY_EDAD);

                            System.out.println("Obtenido usuario "+reader.getString("idusuario"));

                        } catch (JSONException e) { e.printStackTrace();}

                        editTextUsuario.setText(usuario);
                        editTextNombre.setText(nombre);
                        editTextPeso.setText(peso);
                        editTextEstatura.setText(estatura);
                        editTextEdad.setText(edad);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Usuario no se puso obtener el usuario "+idUser);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.btnActividades):
                updateUser(this.id);
                break;
            case (R.id.buttonRegreso):
                finish();
                break;

        }
    }

}
