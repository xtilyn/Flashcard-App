package com.example.android.workingtitle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseDeckActivity extends AppCompatActivity {

    private String associatedDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deck);
        displayDecks();
    }

    private void displayDecks() {
        // TODO
    }

    public void onCreateNewDeckBtnClick(View view) {
        // TODO
    }

    public void onSpecificDeckSelected(View view) {
        // TODO
    }

    private void insertToDatabase() {
        String front = getIntent().getExtras().getString("frontContent");
        String back = getIntent().getExtras().getString("backContent");

        MainActivity.getDbManager().insertData(front, back, -1, associatedDeck);
    }

}
