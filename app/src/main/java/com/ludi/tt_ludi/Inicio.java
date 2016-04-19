package com.ludi.tt_ludi;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.HashMap;
import java.util.Map;

public class Inicio extends AppCompatActivity implements View.OnClickListener{

    Button btn_login, btn_register;
    TextView txtTittle, txtRegister;


    private static final String REGISTER_URL = "http://ludi.mx/api/loginApp";

    public static final String KEY_USERNAME = "userName";

    private EditText editTextUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),"KGS.ttf");
        txtTittle = (TextView) findViewById(R.id.txtTittle);
        txtTittle.setTypeface(myTypeFace);


        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setTypeface(myTypeFace2);
        btn_login.setOnClickListener(this);

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setTypeface(myTypeFace2);
        btn_register.setOnClickListener(this);

        editTextUserName = (EditText) findViewById(R.id.editTextUsuario);
        editTextUserName.setTypeface(myTypeFace2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_register):
                Intent siguiente = new Intent(Inicio.this, Registro.class);
                Inicio.this.startActivity(siguiente);
                break;

            case (R.id.btn_login):
                final String userName = editTextUserName.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response){

                                if(Integer.valueOf(response)>0){

                                    SharedPreferences pref = getApplicationContext().getSharedPreferences("ludi", 0);
                                    SharedPreferences.Editor editor = pref.edit();
                                    editor.putString("id", response);
                                    editor.commit();

                                    Intent siguiente = new Intent(Inicio.this, MainActivity.class);
                                    Inicio.this.startActivity(siguiente);

                                }else{
                                    System.out.println("No fue posible iniciar sesión. La respuesta del servidor fue: "+response);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                System.out.println("No es posible iniciar sesión debido a un error inesperado: "+error);
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams(){

                        Map<String,String> params = new HashMap<String, String>();
                        params.put(KEY_USERNAME,userName);
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
                break;

        }
    }



}
