package com.ludi.tt_ludi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wikitude.architect.ArchitectView;
import com.wikitude.architect.StartupConfiguration;

import java.io.IOException;

public class Libro extends AppCompatActivity {

    private ArchitectView architectView;
    public static final String WIKITUDE_SDK_KEY = "zZuZ9k1/g3e+4jxajBLq5K0pJoiQx9370zwRdFF+xAnWLEuc2lT52Ug2ea/DMxaBeL1HgWzxzPTU5xLboDJUlSC5IAZ7CKHJQcsYansSyMe2DEaUbYGq5bGshFhed0q92+VonP9D6ZOZS9qr9rhRoApeCJcXC+CnnOwrnbxpibJTYWx0ZWRfX78gNtShlHPyz0t4uYNPpgiPejgn+/JG7jh5IH1zabSBLVU54B48W1xAurBoG42jdcjfsZ58YdRfo25/p/3jLuSyzWnD/uoiPW/63ApBzWlsBjw/onZBdHHfedJvKqXt/ExojHi847/UFdrjLdiYADdoGvxAQ/VReGYciv4xZdgdsba2TuzKeOEr11emt92bGO2cbyl9UqoDFI7iGKZsXBLvZuBePXozVTZRbXsm2CYj4SK67OIPaAT5SXm9CYd+tz348EH1L+lNufGY0GTEu4HVYzf5zUPKzK79G61nH/KAmjOWNhOWj8DmQ176jH6iHhEIuq2nJ6qkHvptlkJWeElrxUmYAe4ZbebutUW4M2ZjNTTI+3jy3Aus+Tkpnsz//Emo5bP4izcVHqLnEkzBFW3BSgwnYZrLLu4KioA0OkybNP/lUmoFVWoSDXWmwZ2+Ij8w9gLrI3V4UGiy8AFIXQiDkDknnI0SXRHMKLtJaCW31ZaMF2KU7vI=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        architectView = (ArchitectView)findViewById(R.id.architectView);
        final StartupConfiguration configuration = new StartupConfiguration(WIKITUDE_SDK_KEY);

        try{
            architectView.onCreate(configuration);
        }catch(RuntimeException e){
            e.printStackTrace();
            Toast.makeText(Libro.this, "No se ha podido crear la vista.", Toast.LENGTH_LONG).show();
            finish();
        }

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(this.architectView != null){
            this.architectView.onPostCreate();
        }
        try{
            if(this.architectView != null){
                this.architectView.load("videoAR/index.html");
            }else{
                Toast.makeText(Libro.this, "Architect View null", Toast.LENGTH_SHORT).show();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(this.architectView != null){
            this.architectView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(this.architectView != null){
            this.architectView.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(this.architectView != null){
            this.architectView.onResume();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if(this.architectView != null){
            this.architectView.onLowMemory();
        }
    }


}
