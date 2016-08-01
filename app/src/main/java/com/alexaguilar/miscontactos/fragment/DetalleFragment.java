package com.alexaguilar.miscontactos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexaguilar.miscontactos.R;
import com.alexaguilar.miscontactos.adapter.ContactoAdaptador;
import com.alexaguilar.miscontactos.adapter.ContactoAdaptador2;
import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {

    ArrayList<Contacto> contactosPe;
    private RecyclerView listaPerritos;


    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);

        // esto ya existe en el fragment
        listaPerritos = (RecyclerView) v.findViewById(R.id.rvPerritos);

        /*
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPerritos.setLayoutManager(llm);
        */

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        listaPerritos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    // Manda los datos al adaptador
    //public ContactoAdaptador adaptador;
    public ContactoAdaptador2 adaptador;
    private void inicializarAdaptador(){
        //adaptador = new ContactoAdaptador(contactosPe, getActivity());
        adaptador = new ContactoAdaptador2(contactosPe, getActivity());
        listaPerritos.setAdapter(adaptador);
    }

    // Llena los datos
    public void inicializarListaContactos(){
        contactosPe = new ArrayList<Contacto>();

        contactosPe.add(new Contacto(R.drawable.cute_dog,"Lazzy",2));
        contactosPe.add(new Contacto(R.drawable.chi, "Perro policia", 1));
        contactosPe.add(new Contacto(R.drawable.negro, "Guia", 1));
        contactosPe.add(new Contacto(R.drawable.labrador,"Galgo",2));
        contactosPe.add(new Contacto(R.drawable.perfil, "Compañia", 3));
        contactosPe.add(new Contacto(R.drawable.perro, "Cobrador", 2));
    }

}
