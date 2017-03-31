package com.example.android.workingtitle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 2017-03-29.
 */

public class DBManager extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "flashcards.db";
    private static final String TABLE_NAME = "flashcards_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "FRONT";
    private static final String COL_3 = "BACK";
    private static final String COL_4 = "RATING";
    private static final String COL_5 = "DECK";

    DBManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FRONT TEXT,BACK TEXT,RATING INTEGER,DECK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    boolean insertData(String front, String back, int rating, String deck) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, front);
        contentValues.put(COL_3, back);
        contentValues.put(COL_4, rating);
        contentValues.put(COL_5, deck);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

}
