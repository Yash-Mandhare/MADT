package com.example.student;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "StudentDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Student (roll_no INTEGER, name TEXT, address TEXT, percentage REAL)");
        db.execSQL("INSERT INTO Student VALUES (1, 'Amit', 'Pune', 80.5)");
        db.execSQL("INSERT INTO Student VALUES (2, 'Sneha', 'Mumbai', 75.0)");
        db.execSQL("INSERT INTO Student VALUES (3, 'Raj', 'Delhi', 88.0)");
        db.execSQL("INSERT INTO Student VALUES (4, 'Priya', 'Nashik', 92.3)");
        db.execSQL("INSERT INTO Student VALUES (5, 'Arjun', 'Chennai', 70.5)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS Student");
        onCreate(db);
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Student", null);
    }
}
