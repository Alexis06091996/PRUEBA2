package com.example.prueba_ii_parcial_chuquin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DeveloperBD extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="developer3.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_CONTACTOS="CREATE TABLE CONTACTOS (NOMBRE TEXT PRIMARY KEY,TELEFONO TEXT,CORREO TEXT)";



    public DeveloperBD(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i , int i1) {
       sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLA_CONTACTOS);
       sqLiteDatabase.execSQL(TABLA_CONTACTOS);

    }
    public void agregarContactos(String nombre,String telefono,String correo){

        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CONTACTOS VALUES ('"+nombre+"','"+telefono+"','"+correo+"')");
            bd.close();
        }
    }

    public List<ContactosModelo> mostrarCursos(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM CONTACTOS",null);
        List<ContactosModelo> cursos=new ArrayList<>();

        if(cursor.moveToFirst()){
            do{
                cursos.add(new ContactosModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            } while(cursor.moveToNext());
        }
        return cursos;
    }



    public void buscarCursos(ContactosModelo cursos, String nombre) {
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM CONTACTOS WHERE NOMBRE='"+nombre+"'",null);


        if(cursor.moveToFirst()){
            do{
         cursos.setTelefono(cursor.getString(1));
         cursos.setCorreo(cursor.getString(2));
            } while(cursor.moveToNext());
        }
    }


    public void editarCurso(String nombre,String telefono,String correo){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE CONTACTOS SET TELEFONO='"+telefono+"',CORREO='"+correo+"' WHERE NOMBRE='"+nombre+"'");
            bd.close();
        }
    }

    public void eliminarCurso(String nombre){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM CONTACTOS WHERE NOMBRE='"+nombre+"'");
            bd.close();
        }
    }

}

