package com.example.android.workingtitle;

import android.content.Intent;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseDeckActivity extends AppCompatActivity {

    private String associatedDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deck);
        displayAvailableDecks();
    }

    private void displayAvailableDecks() {
        // TODO loop through?
//        Button deckButton = new Button(this);

    }

    // TODO
    private void getDecksFromDb() {
        Cursor res = MainActivity.getDbManager().getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No data found");
        } else {
            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: " + res.getString(0) + "\n");
                buffer.append("FRONT: " + res.getString(1) + "\n");
                buffer.append("BACK: " + res.getString(2) + "\n");
                buffer.append("RATING: " + res.getString(3) + "\n");
                buffer.append("DECK: " + res.getString(4) + "\n\n");
            }
            showMessage("Data", buffer.toString());
        }
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void onCreateNewDeckBtnClick(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout)
                findViewById(R.id.fragment_in_chooseDeck);

        CreateDeckFragment fragment = new CreateDeckFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_in_chooseDeck,
                fragment,
                fragment.getTag()
        ).commit();
        constraintLayout.setVisibility(View.VISIBLE);
    }

    public void onCreateDeckBtnClick(View view) {
        EditText titleEditText = (EditText) findViewById(R.id.deck_title);
        associatedDeck = titleEditText.getText().toString();
        insertToDatabase();
        getDecksFromDb();
//        goToDashBoard();
    }

    private void goToDashBoard() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void onSpecificDeckSelected(View view) {
        // TODO textFile to store number of decks and their names
    }

    private void insertToDatabase() {
        String front = getIntent().getExtras().getString("frontContent");
        String back = getIntent().getExtras().getString("backContent");

        MainActivity.getDbManager().insertData(front, back, -1, associatedDeck);
    }

}
