package com.example.sf;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

public class UsuarioDAO {

    private DbHelper _dbHelper;

    public UsuarioDAO(Context c) {
        _dbHelper = new DbHelper(c);
    }

    public void insertar(String nombre, String apellido, String email, String password)
            throws DAOException {
        Log.i("UsuarioDAO", "insertar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();
        try {
            String[] args = new String[]{nombre, apellido, email, password};
            db.execSQL("INSERT INTO usuario(nombre,apellido,email,password) VALUES(?,?,?,?)", args);
            Log.i("UsuarioDAO", "Se insertó");
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: Error al insertar: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public Usuario obtener() throws DAOException {
        Log.i("UsuarioDAO", "obtener()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        Usuario modelo = new Usuario();
        try {
            Cursor c = db.rawQuery("select id, nombre, apellido, email, password from usuario", null);

            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String nombre = c.getString(c.getColumnIndex("nombre"));
                    String apellido = c.getString(c.getColumnIndex("apellido"));
                    String email = c.getString(c.getColumnIndex("email"));
                    String password = c.getString(c.getColumnIndex("password"));
                    modelo.setId(id);
                    modelo.setNombre(nombre);
                    modelo.setApellido(apellido);
                    modelo.setEmail(email);
                    modelo.setPassword(password);
                }
                while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: El usuario no existe: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return modelo;
    }

    //consultar login
    public Usuario consultar(String usu, String pass) throws DAOException {

        Log.i("UsuarioDAO", "consultar()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        Usuario modelo = new Usuario();
        try {
            Cursor c = db.rawQuery("select id, nombre, apellido, email, password from usuario where email like '%" + usu + "%' and password like '%" + pass + "%' ", null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                do {
                    int id = c.getInt(c.getColumnIndex("id"));
                    String nombre = c.getString(c.getColumnIndex("nombre"));
                    String apellido = c.getString(c.getColumnIndex("apellido"));
                    String email = c.getString(c.getColumnIndex("email"));
                    String password = c.getString(c.getColumnIndex("password"));
                    modelo.setId(id);
                    modelo.setNombre(nombre);
                    modelo.setApellido(apellido);
                    modelo.setEmail(email);
                    modelo.setPassword(password);
                }
                while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: El usuario no existe: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return modelo;
    }

    public void eliminar ( int id) throws DAOException {
        Log.i("UsuarioDAO", "eliminar()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();
        try {
            String[] args = new String[]{String.valueOf(id)};
            db.execSQL("DELETE FROM usuario WHERE id=?", args);
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: Error al eliminar: " + e.getMessage());
        } finally {
                if (db != null) { db.close(); }
        }
    }

    public void eliminarTodos ()
            throws DAOException {
        Log.i("UsuarioDAO", "eliminarTodos()");
        SQLiteDatabase db = _dbHelper.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM usuario");
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: Error al eliminar todos: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public void actualizar(int id, String nombre, String apellido, String email, String password) throws DAOException {
        Log.i("UsuarioDAO", "actualizar()");
        SQLiteDatabase db = _dbHelper.getReadableDatabase();
        Usuario modelo = new Usuario();

        try {
            String[] args = new String[]{nombre, apellido, email, password, String.valueOf(id)};
            db.execSQL("UPDATE usuario SET nombre=?,apellido=?,email=?,password=? WHERE id=?", args);
            Log.i("UsuarioDAO", "Se actualizó");
        } catch (Exception e) {
            throw new DAOException("UsuarioDAO: El usuario no existe: " + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }
}



