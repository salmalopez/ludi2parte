package com.ludi.tt_ludi;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inicio extends AppCompatActivity implements View.OnClickListener{

    Button btn_login, btn_register;

    //private static final String REGISTER_URL = "http://54.191.222.236/api/loginApp";
    private static final String REGISTER_URL = "http://ludi.mx/api/loginApp";

    public static final String KEY_USUARIO = "usuario";
    private static final int LONG_DELAY = 3500;

    private EditText editTextUserName;

    MediaPlayer botonsonido, btncancion;
    LinearLayout iniciolayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);



        iniciolayout = (LinearLayout) findViewById(R.id.iniciolayout);
        iniciolayout.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable animation = (AnimationDrawable) iniciolayout.getBackground();
                animation.start();
            }
        });

        botonsonido = MediaPlayer.create(Inicio.this, R.raw.inicio);
        btncancion = MediaPlayer.create(Inicio.this, R.raw.cancion);
        btncancion.start();
        btncancion.setLooping(true);


        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setTypeface(myTypeFace2);
        btn_login.setOnClickListener(this);


        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setTypeface(myTypeFace2);
        btn_register.setOnClickListener(this);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserName.setTypeface(myTypeFace2);
    }

    protected void onPause() {
        if (this.isFinishing()){ //basically BACK was pressed from this activity
            btncancion.stop();

        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                btncancion.stop();
            }
        }
        super.onPause();
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_register):
                //sonido

                botonsonido.start();
                //cargar actividad

                /*
                Intent siguiente = new Intent(Inicio.this, Registro.class);
                Inicio.this.startActivity(siguiente);
                */

                Intent siguiente = new Intent(Inicio.this, Escuela.class);
                Inicio.this.startActivity(siguiente);

                break;

            case (R.id.btn_login):
                botonsonido.start();

                btncancion.stop();
                final String usuario = editTextUserName.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response){

                                if(Integer.valueOf(response)>0){

                                    System.out.println("hola entro en si"+response);
                                    //if(true){
                                    SharedPreferences pref = getApplicationContext().getSharedPreferences("ludi", 0);
                                    SharedPreferences.Editor editor = pref.edit();
                                    editor.putString("id", response);
                                    editor.commit();

                                    Intent siguiente = new Intent(Inicio.this, MainActivity.class);
                                    Inicio.this.startActivity(siguiente);
                                    btncancion.stop();

                                }else{
                                    AlertDialog alertDialog = new AlertDialog.Builder(Inicio.this).create();
                                    alertDialog.setTitle("¡Oops!");
                                    alertDialog.setMessage("El usuario no se encuentra registrado.");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();

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
                        params.put(KEY_USUARIO,usuario);
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
                break;

        }
    }



}
