package com.example.android.genderanddevelopmentsurvey;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "gad.db";
    private static final String TABLE_NAME = "records";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_GENDER = "Gender";
    private static final String COLUMN_ADDRESS = "Address";
    private static final String COLUMN_BARANGAY = "Barangay";


    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE '" + TABLE_NAME + "' ('" +
                COLUMN_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT, '" +
                COLUMN_NAME + "' TEXT, '" +
                COLUMN_AGE + "' INTEGER, '" +
                COLUMN_GENDER + "' TEXT, '" +
                COLUMN_BARANGAY + "' TEXT, '" +
                COLUMN_ADDRESS + "' TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(db);
    }

    //    add person to the database
    public void addPerson(Person person) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, person.get_name());
        contentValues.put(COLUMN_AGE, person.get_age());
        contentValues.put(COLUMN_GENDER, person.get_gender());
        contentValues.put(COLUMN_ADDRESS, person.get_address());
        contentValues.put(COLUMN_BARANGAY, person.get_barangay());
        SQLiteDatabase db = getWritableDatabase();
//        db.insertOrThrow(TABLE_NAME, null, contentValues);
        db.insert(TABLE_NAME, null, contentValues);
    }

    //    delete row/entry from the database
    public void deletePerson(String personsName) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME + " = " + "'" + personsName + "'", null);
    }

    //    insert age and gender of the person
    public void insertAgeGender(String name, int age, String gender) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                COLUMN_AGE + " = " + age + ", " +
                COLUMN_GENDER + " = '" + gender +
                "' WHERE " +
                COLUMN_NAME + " = '" + name + "';");
    }
}
