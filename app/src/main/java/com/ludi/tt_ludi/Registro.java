package com.ludi.tt_ludi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.media.MediaPlayer;
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

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    private static final int LONG_DELAY = 3500;

    private static final String REGISTER_URL = "http://ludi.mx/api/usuario";

    public static final String KEY_ID = "idtipousuario";
    public static final String KEY_USERNAME = "usuario";
    public static final String KEY_NAME = "nombre";
    public static final String KEY_DATE = "edad";
    public static final String KEY_WEIGHT = "peso";
    public static final String KEY_HEIGHT = "estatura";

    private EditText editTextUserName;
    private EditText editTextName;
    private EditText editTextDate;
    private EditText editTextWeight;
    private EditText editTextHeight;

    private TextView txtRegister;


    private Button buttonRegister,buttonRegreso;

    MediaPlayer botonsonido,botonsalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        botonsonido = MediaPlayer.create(Registro.this, R.raw.regreso);
        botonsalida = MediaPlayer.create(Registro.this, R.raw.inicio);
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setTypeface(myTypeFace);


        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserName.setTypeface(myTypeFace2);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setTypeface(myTypeFace2);

        editTextDate= (EditText) findViewById(R.id.editTextDate);
        editTextDate.setTypeface(myTypeFace2);

        editTextWeight= (EditText) findViewById(R.id.editTextWeight);
        editTextWeight.setTypeface(myTypeFace2);

        editTextHeight= (EditText) findViewById(R.id.editTextHeight);
        editTextHeight.setTypeface(myTypeFace2);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

        buttonRegreso = (Button) findViewById(R.id.buttonRegreso);
        buttonRegreso.setOnClickListener(this);
    }

    private void registerUser(){

        final String userName = editTextUserName.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final String weight = editTextWeight.getText().toString().trim();
        final String height = editTextHeight.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(Registro.this, response, Toast.LENGTH_LONG).show();
                        System.out.println("dddddddddd"+response);
                        if(response.equals("{\"message\":OK}")){
                            System.out.println("bien");
                        }else{

                            AlertDialog alertDialog = new AlertDialog.Builder(Registro.this).create();
                            alertDialog.setTitle("¡Oops!");
                            alertDialog.setMessage(""+response);
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            System.out.println("mal");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(Registro.this,error.toString(),Toast.LENGTH_LONG).show();
                        System.out.println("aaaaaaaaaa:: "+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_ID,"2");
                params.put(KEY_USERNAME,userName);
                params.put(KEY_NAME,name);
                params.put(KEY_DATE, date);
                params.put(KEY_WEIGHT,weight);
                params.put(KEY_HEIGHT, height);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.buttonRegreso):
                botonsonido.start();
                finish();
                break;
            case (R.id.buttonRegister):
                botonsalida.start();
                registerUser();
                break;

        }
    }

    @Override
    public void onBackPressed(){

    }
}