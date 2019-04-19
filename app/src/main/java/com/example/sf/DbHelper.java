package com.example.sf;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper
{ public DbHelper(Context context, String name, CursorFactory factory, int version)
{ super(context, name, factory, version); }
public DbHelper(Context context)
{
    // null porque se va a usar el SQLiteCursor

    super(context, "sf.db", null, 1); }

    @Override public void onCreate(SQLiteDatabase db)
    { String sql = "CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, apellido TEXT NOT NULL,email TEXT NOT NULL,password TEXT NOT NULL)";
    db.execSQL(sql); }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    { db.execSQL("DROP TABLE IF EXISTS usuario"); onCreate(db); } }