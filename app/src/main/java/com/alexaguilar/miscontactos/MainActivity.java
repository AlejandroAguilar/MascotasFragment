package com.alexaguilar.miscontactos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/*
import android.support.v7.widget.Toolbar;


import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;
*/

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        */

        /* */
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);




        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        ///GridLayoutManager glm = new GridLayoutManager(this, 2);
        ///listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();

    }


    // Manda los datos al adaptador
    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    // Llena los datos
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.cute_dog,"Lazzy",2));
        contactos.add(new Contacto(R.drawable.chi,"Perro policia",1));
        contactos.add(new Contacto(R.drawable.negro,"Guia",1));
        contactos.add(new Contacto(R.drawable.labrador,"Galgo",2));
        contactos.add(new Contacto(R.drawable.perfil, "Compañia", 3));
        contactos.add(new Contacto(R.drawable.perro, "Cobrador", 2));
    }

    public void fabClicked(View v){
        Toast.makeText(this, "Subir", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorite:
                Intent intent=new Intent(this, FavoritosActivity.class);
                this.startActivity(intent);
                return true;

            case R.id.action_about:
                //Toast.makeText(this,"Acerca de ",Toast.LENGTH_SHORT).show();
                Intent intentAbout =new Intent(this, AboutActivity.class);
                this.startActivity(intentAbout);
                return true;

            case R.id.action_contacto:
                //Toast.makeText(this,"Contacto",Toast.LENGTH_SHORT).show();
                Intent intentContacto =new Intent(this, ContactoActivity.class);
                this.startActivity(intentContacto);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
