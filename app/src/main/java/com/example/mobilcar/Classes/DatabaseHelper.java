package com.example.mobilcar.Classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //table name
    public static final String TABLE_NAME = "PEOPLE";

    //table columns
    public static final String _ID = "_id";
    public static final String NAME = "name";

    //db info
    static final String DB_NAME = "INFO_TABLE";

    //db version
    static final int DB_VERSION = 1;

    //table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + "TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
