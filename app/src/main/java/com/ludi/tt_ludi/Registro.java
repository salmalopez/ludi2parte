package com.ludi.tt_ludi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://192.168.1.70:1337/api/user";

    public static final String KEY_USERNAME = "userName";
    public static final String KEY_NAME = "name";
    public static final String KEY_LASTNAME = "lastName";
    public static final String KEY_DATE = "date";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_HEIGHT = "height";

    private EditText editTextUserName;
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextDate;
    private EditText editTextWeight;
    private EditText editTextHeight;


    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextDate= (EditText) findViewById(R.id.editTextDate);
        editTextWeight= (EditText) findViewById(R.id.editTextWeight);
        editTextHeight= (EditText) findViewById(R.id.editTextHeight);


        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }

    private void registerUser(){
        final String userName = editTextUserName.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String lastName = editTextLastName.getText().toString().trim();
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
                params.put(KEY_USERNAME,userName);
                params.put(KEY_NAME,name);
                params.put(KEY_LASTNAME,lastName);
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
        if(v == buttonRegister){
            registerUser();
        }
    }
}