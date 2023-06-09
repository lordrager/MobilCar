//package com.example.mobilcar.Database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.mobilcar.Models.Classes.Car;
//import com.example.mobilcar.Models.Classes.Owner;
//
//
//public class OwnerDatabaseHelper extends SQLiteOpenHelper {
//
//    private static final int DATABASE_VERSION = 1;
//    private static final String DATABASE_NAME = "uSERmANAGER";
//
//    private static final String TABLE_CONTACTS = "OWNERS";
//    private static final String KEY_ID = "id";
//    private static final String KEY_NAME = "Name";
//    private static final String KEY_U_NAME = "UserName";
//    private static final String KEY_Email = "Email";
//    private static final String KEY_Pass = "Password";
//    private static final String KEY_Budget = "0";
//
//    private static final Car Key_Car = null;
//
//
//
//    public OwnerDatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS +
//                "(" + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT," + KEY_U_NAME + " TEXT," + KEY_Email + " TEXT," + KEY_Pass + " TEXT" + KEY_Budget + " ,REAL" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
//        onCreate(db);
//    }
//
//    public void onDeleteTable() {
//        SQLiteDatabase db = this.getWritableDatabase();
////        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
//        db.delete(TABLE_CONTACTS, null, null);
//        db.close();
//    }
//
//    void addOwner(Owner contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_U_NAME, contact.getUsername());
//        values.put(KEY_Email, contact.getEmail());
//        values.put(KEY_Pass, contact.getPassword());
//
//        db.insert(TABLE_CONTACTS, null, values);
//        db.close();
//    }
//
//   public Owner getOwner(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
////        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
////                        KEY_F_NAME, KEY_L_NAME, KEY_U_NAME, KEY_Email, KEY_Pass, String.valueOf(KEY_Budget)}, KEY_ID + "=?",
////                new String[] { String.valueOf(id) }, null, null, null, null);
//        String SELECT_QUERY = "SELECT * FROM " + TABLE_CONTACTS
//                + " WHERE " + KEY_ID + " = " + id;
//        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
//        if (cursor != null)
//            cursor.moveToFirst();
////        Owner owner = new Owner(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)), cursor.getString(5));
//        Owner owner = new Owner(cursor.getString(0),
//                cursor.getString(1), cursor.getString(2), cursor.getString(3),
//                cursor.getString(4));
//        return owner;
//    }
//
//
//    public int updateOwner(Owner contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_U_NAME, contact.getUsername());
//        values.put(KEY_Email, contact.getEmail());
//        values.put(KEY_Pass, contact.getPassword());
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(contact.getId())});
//    }
//
//    public void deleteOwner(Owner contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[]{String.valueOf(contact.getId())});
//        db.close();
//    }
//
//
//}
