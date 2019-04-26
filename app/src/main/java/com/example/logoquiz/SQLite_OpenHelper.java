package com.example.logoquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_ID = "idNote";
    public static final String USU= "usu";
    private static final String PASS = "pass";
    private static final String NOMBRE = "nombre";
    private static final String CORREO = "correo";
    private static final String EDAD = "edad";
    private static final String GENERO = "genero";
    private static final String DATABASE = "Notas";
    private static  final String TABLE = "usuarios";

    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE +" (" +
                TABLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                USU +" TEXT,"+ PASS +" TEXT"+NOMBRE+" ,TEXT"+CORREO+" TEXT"+EDAD+"TEXT"+GENERO+"TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Método para abrir base de datos
    public void abrir(){
        this.getWritableDatabase();
    }


    //Método para cerrar base de datos
    public void cerrar(){
        this.close();
    }

    //Metodo que permite insertar registros en la tabla
    public void insertarReg(String nom, String correo, String contrasena,String usuario,String genero, String edad){

        ContentValues valores = new ContentValues();
        valores.put("nombre",nom);
        valores.put("correo",correo);
        valores.put("pass", contrasena);
        valores.put("usu",usuario);
        valores.put("edad", edad);
        valores.put("genero",genero);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

    public Cursor ConsultarUsuPas(String usu, String pass) throws SQLException {
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuarios",new String[]{"_ID",
                "Nombre","Correo","Contrasena","Usuario"},
                "Usuario like '"+usu+"' " +
                        "and Contrasena like '"+pass+"'",null,null,null,null);
        Log.d("cursor",""+mcursor.getCount());
        return mcursor;

    }
}
