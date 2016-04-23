package com.ludi.tt_ludi;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener,
        ActividadesFragment.OnFragmentInteractionListener,
        NoticiasFragment.OnFragmentInteractionListener,
        InicioFragment.OnFragmentInteractionListener
                    {


    Button btnActividades, btnNoticias,btnAvance;

    boolean fragmentTransaction = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnActividades = (Button) findViewById(R.id.btnActividades);
        btnNoticias = (Button) findViewById(R.id.btnNoticias);
        btnAvance = (Button) findViewById(R.id.btnAvance);




        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(),"DK.ttf");
        btnActividades.setTypeface(myTypeFace2);
        btnActividades.setOnClickListener(this);
        btnNoticias.setTypeface(myTypeFace2);
        btnNoticias.setOnClickListener(this);
        btnAvance.setTypeface(myTypeFace2);
        btnAvance.setOnClickListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/

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
            fragment = new ActividadesFragment();
            fragmentTransaction = true;

        }  else if (id == R.id.nav_inicio) {
            fragment = new InicioFragment();
            fragmentTransaction = true;

        } else if (id == R.id.nav_noticias) {
            fragment = new NoticiasFragment();
            fragmentTransaction = true;


        } else if (id == R.id.nav_realidadAumentada) {
            Intent ra = new Intent(MainActivity.this, Libro.class);
            MainActivity.this.startActivity(ra);

        } else if (id == R.id.nav_perfil) {
            Intent actualizar = new Intent(MainActivity.this, Actualizar.class);
            MainActivity.this.startActivity(actualizar);

        } else if (id == R.id.nav_cerrarSesison) {

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
                ActividadesFragment fragment2 = new ActividadesFragment();
                getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_nav_drawer, fragment2)
                            .commit();
                getSupportActionBar().setTitle("Actividades");
                break;

            case (R.id.btnNoticias):
                NoticiasFragment fragment3 = new NoticiasFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_nav_drawer, fragment3)
                        .commit();
                getSupportActionBar().setTitle("Noticias");
                break;

            case (R.id.btnAvance):
                Intent avance = new Intent(this, Avance.class);
                MainActivity.this.startActivity(avance);
                break;
        }
    }
}
