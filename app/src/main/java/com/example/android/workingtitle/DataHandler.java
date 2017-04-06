package com.example.android.workingtitle;

import android.content.Context;
import android.database.Cursor;

/**
 * 2017-04-03.
 */

class DataHandler {

    private DBManager dbManager;

    DataHandler(Context context) {
        this.dbManager = new DBManager(context);
    }

    public void removeAllData() {
        dbManager.removeAllData();
    }

    public Cursor getAllData() {
        return dbManager.getAllData();
    }

    public void insertData(String front, String back, int rating, String deck) {
        dbManager.insertData(front, back, rating, deck);
    }

    public int getIDByContents(String front, String back, String rating, String deck) {
        return dbManager.getIDByContents(front, back, rating, deck);
    }

}
