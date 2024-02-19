package com.example.lewen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQL extends SQLiteOpenHelper {
    public static final String database = "lewen";

    public ConexionSQL(@Nullable Context context) {
        super(context, database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(user TEXT PRIMARY KEY, pwd TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
    }

    public boolean insertValues(String user, String pwd) {
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user", user);
        values.put("pwd", pwd);
        long resultado = bbdd.insert("usuarios", null, values);
        return resultado != -1;
    }

    public boolean verificarUsuario(String user) {
        SQLiteDatabase bbdd = this.getWritableDatabase();
        Cursor cursor = bbdd.rawQuery("SELECT * FROM usuarios WHERE user = ?", new String[]{user});
        return cursor.getCount() > 0;
    }

    public boolean verificarUsuarioContrasena(String user, String pwd) {
        SQLiteDatabase bbdd = this.getWritableDatabase();
        Cursor cursor = bbdd.rawQuery("SELECT * FROM usuarios WHERE user = ? AND pwd = ?", new String[]{user, pwd});
        return cursor.getCount() > 0;
    }
}