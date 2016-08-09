
/**
package com.alexaguilar.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.alexaguilar.miscontactos.R;
import com.alexaguilar.miscontactos.pojo.Contacto;

import java.util.ArrayList;

 * Created by Alex on 07/08/16.

public class ConstructorContacto {
}
*/


package com.alexaguilar.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.alexaguilar.miscontactos.R;
import com.alexaguilar.miscontactos.pojo.Contacto;
import java.util.ArrayList;



/**
 * Created by Alex on 07/08/16.
 */
public class ConstructorContacto {

    private static final int LIKE = 1;

    private Context context;
    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarSeisContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarSeisContactos (BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Lazzy");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cute_dog);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Perro policia");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.chi);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Guia");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.negro);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Galgo");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.labrador);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Compañia");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.perfil);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cobrador");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.perro);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Pastor");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.pastor);
        db.insertarContacto(contentValues);

    }


    public int darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_ID_PET, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

        return contacto.getId();
        
    }


    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }



}
