package com.example.arooba.loginexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arooba on 1/18/2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DatabaseName = "LoginExampleDB.db";
    public static final String Table = "LoginExampleTable";

    public static final String UNameColumn = "Username";
    public static final String pswdColumn = "Password";




    public DBHelper(Context context) {
        super(context,DatabaseName, null, 1);


    }
    //private static final String TableCreate="Create table LoginTbl(id integer primary key," +" Username text not null,Password text not null";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  "
                + Table+ "(" + UNameColumn
                + " text, " + pswdColumn
                + " text" +")");

    }

    public  void addData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(UNameColumn , "Arooba" );
        CV.put(pswdColumn , "Sheikh");
        db.insert(Table , null , CV);
        db.close();
    }
    public String LoginMethod(String inputuname){
        SQLiteDatabase   db=this.getReadableDatabase();

        Cursor cur = db.rawQuery("select * from " + Table , null );

        String Dbuname,dbpswd;
        dbpswd="Not Found";

        if (cur.moveToFirst()){
            do {
                Dbuname=cur.getString(0);
                if(Dbuname.equals(inputuname)){
                    dbpswd=cur.getString(1);
                    break;

                }
            }while (cur.moveToNext());

        }

        return dbpswd;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop Table if exists " + Table);
        onCreate(db);

    }
}
