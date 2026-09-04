package com.example.firebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "students";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT," +
                "phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    // CREATE
    public boolean insertStudent(String name, String email, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);

        long result = db.insert(TABLE_NAME, null, values);

        return result != -1;
    }

    // READ
    public Cursor getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM students", null);
    }

    // UPDATE
    public boolean updateStudent(String id, String name,
                                 String email, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);

        int result = db.update(
                TABLE_NAME,
                values,
                "id=?",
                new String[]{id}
        );

        return result > 0;
    }

    // DELETE
    public boolean deleteStudent(String id) {

        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(
                TABLE_NAME,
                "id=?",
                new String[]{id}
        );

        return result > 0;
    }
}