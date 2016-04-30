package com.ludi.tt_ludi;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ludi.tt_ludi.qr.IntentIntegrator;
import com.ludi.tt_ludi.qr.IntentResult;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, ActividadesFragment.OnFragmentInteractionListener,
        NoticiasFragment.OnFragmentInteractionListener, InicioFragment.OnFragmentInteractionListener
                    {


                        Button btnActividades, btnNoticias,btnAvance;
                        private IntentIntegrator integrator;
                        boolean fragmentTransaction = false;
                        MediaPlayer botonsonido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonsonido = MediaPlayer.create(MainActivity.this, R.raw.inicio);

        btnActividades = (Button) findViewById(R.id.btnActividades);
        btnNoticias = (Button) findViewById(R.id.btnNoticias);
        btnAvance = (Button) findViewById(R.id.btnAvance);

        integrator = new IntentIntegrator(this);

        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        btnActividades.setTypeface(myTypeFace2);
        btnActividades.setOnClickListener(this);
        btnNoticias.setTypeface(myTypeFace2);
        btnNoticias.setOnClickListener(this);
        btnAvance.setTypeface(myTypeFace2);
        btnAvance.setOnClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent actualizar = new Intent(MainActivity.this, Informacion.class);
            MainActivity.this.startActivity(actualizar);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;


        if (id == R.id.nav_actividades) {
            // Handle the camera action
            botonsonido.start();
            fragment = new ActividadesFragment();
            fragmentTransaction = true;

        }  else if (id == R.id.nav_inicio) {
            botonsonido.start();
            fragment = new InicioFragment();
            fragmentTransaction = true;

        } else if (id == R.id.nav_noticias) {
            botonsonido.start();
            fragment = new NoticiasFragment();
            fragmentTransaction = true;


        } else if (id == R.id.nav_realidadAumentada) {
            botonsonido.start();
            Intent ra = new Intent(MainActivity.this, Libro.class);
            MainActivity.this.startActivity(ra);

        } else if (id == R.id.nav_perfil) {
            botonsonido.start();
            Intent actualizar = new Intent(MainActivity.this, Actualizar.class);
            MainActivity.this.startActivity(actualizar);

        } else if (id == R.id.nav_cerrarSesison) {
            botonsonido.start();
            Intent siguiente = new Intent(this, Inicio.class);
            SharedPreferences.Editor editor = (getApplicationContext().getSharedPreferences("ludi", 0)).edit();
            editor.remove("id");
            editor.commit();

            Intent siguiente5 = new Intent(MainActivity.this, Inicio.class);
            MainActivity.this.startActivity(siguiente5);

        }

        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_nav_drawer, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.btnActividades):
                integrator.initiateScan();
                botonsonido.start();

                /*
                ActividadesFragment fragment2 = new ActividadesFragment();
                getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_nav_drawer, fragment2)
                            .commit();
                getSupportActionBar().setTitle("Actividades");
                */
                break;

            case (R.id.btnNoticias):
                botonsonido.start();
                NoticiasFragment fragment3 = new NoticiasFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_nav_drawer, fragment3)
                        .commit();
                getSupportActionBar().setTitle("Noticias");
                break;

            case (R.id.btnAvance):
                botonsonido.start();
                Intent avance = new Intent(this, Avance.class);
                MainActivity.this.startActivity(avance);
                getSupportActionBar().setTitle("Avance");
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        System.out.println("resultCode: "+resultCode);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Class destino = null;

        if (scanResult != null) {
            String resultado = scanResult.getContents();

            switch (resultado){
                case "verduras":
                    destino = InstruccionesAct4.class;
                    break;
                case "cereales":
                    destino = InstruccionesAct5.class;
                    break;
                case "carne":
                    destino = InstruccionesAct2.class;
                    break;
                case "bebidas":
                    destino = InstruccionesAct1.class;
                    break;
                case "plato":
                    destino = InstruccionesAct3.class;
                    break;
            }
            Intent siguiente = new Intent(MainActivity.this, destino);
            startActivity(siguiente);
        }
    }
}
