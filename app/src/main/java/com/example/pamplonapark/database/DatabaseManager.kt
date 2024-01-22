package com.example.pamplonapark.database

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, "pamplonapark.db", null, 1)
{
    override fun onCreate(db: SQLiteDatabase)
    {
        try
        {
            db.execSQL("CREATE TABLE IF NOT EXISTS Login_User_PamplonaPark(" +
                    "username TEXT PRIMARY KEY," +
                    "token TEXT);");
        }
        catch (err: SQLException)
        {
            Log.e("DatabaseManager", "Error creating table: " + err.message);
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        try
        {
            db.execSQL("DROP TABLE IF EXISTS Login_User_PamplonaPark;");
            onCreate(db);
        }
        catch (err : SQLException)
        {
            Log.e("DatabaseManager", "Error creating table: " + err.message);
        }
    }

    /*fun insert(params : ContentValues)
    {
        this.writableDatabase.insert("Users", null, params);
    }

    fun select(sql : String, params : Array<String>) : Cursor
    {
        return this.readableDatabase.rawQuery(sql, params);
    }

    fun update(params : ContentValues, pk_old_user : String)
    {
        this.writableDatabase.update("Users", params, "dni = ?", arrayOf(pk_old_user));
    }

    fun delete(pk_old_user : String)
    {
        this.writableDatabase.delete("Users", "dni = ?", arrayOf(pk_old_user));
    }*/
}