package com.example.lab6_a156620;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.lab6_a156620.SuperMarketContract.CustomerEntry;

/**
 * Created by User on 23/11/2017.
 */

public class SuperMarketDBHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_CUSTOMER_TABLE = "CREATE TABLE " + CustomerEntry.TABLE_NAME +
            " (" + CustomerEntry._ID + " INTEGER PRIMARY KEY," + CustomerEntry.COLUMN_NAME +
            " TEXT NOT NULL," + CustomerEntry.COLUMN_CITY + " TEXT NOT NULL" + ");";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CustomerEntry.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SuperMarket.   db";

    public SuperMarketDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_CUSTOMER_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion  , int newVersion){
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
