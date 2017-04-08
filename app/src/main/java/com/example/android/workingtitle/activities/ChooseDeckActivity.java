package com.example.android.workingtitle.activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.workingtitle.fragments.CreateDeckFragment;
import com.example.android.workingtitle.logic.Deck;
import com.example.android.workingtitle.logic.FlashCard;
import com.example.android.workingtitle.R;

import java.util.ArrayList;

public class ChooseDeckActivity extends AppCompatActivity {

    private ArrayList<String> deckTitleList;
    ArrayAdapter adapter;
    private FlashCard newCard;
    private Deck newDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deck);
        deckTitleList = new ArrayList<>();
        displayAvailableDecks();
    }

    private void displayAvailableDecks() {
        for (int i = 0; i < MainActivity.getOfflineDataHandler().getDecks().size(); i++) {
            deckTitleList.add(MainActivity.getOfflineDataHandler().getDecks().get(i).getTitle());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deckTitleList);
        ListView listView = (ListView) findViewById(R.id.listview_for_decks);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String selectedDeck = String.valueOf(parent.getItemAtPosition(position));
//                        onSpecificDeckSelected(selectedDeck);
//                    }
//                }
//        );
    }

//    private void getDecksFromDb() {
//        Cursor res = MainActivity.getDbManager().getAllData();
//        if (res.getCount() == 0) {
//            showMessage("Error", "No data found");
//        } else {
//            StringBuilder buffer = new StringBuilder();
//            while (res.moveToNext()) {
//                buffer.append("ID: " + res.getString(0) + "\n");
//                buffer.append("FRONT: " + res.getString(1) + "\n");
//                buffer.append("BACK: " + res.getString(2) + "\n");
//                buffer.append("RATING: " + res.getString(3) + "\n");
//                buffer.append("DECK: " + res.getString(4) + "\n\n");
//            }
//            showMessage("Data", buffer.toString());
//        }
//    }

//    private void showMessage(String title, String message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.show();
//    }

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
        String front = getIntent().getExtras().getString("frontContent");
        String back = getIntent().getExtras().getString("backContent");
        EditText titleEditText = (EditText) findViewById(R.id.deck_title);
        String associatedDeck = titleEditText.getText().toString();

        MainActivity.getOfflineDataHandler().saveFlashCard(
                new FlashCard(front, back, -1, new Deck(associatedDeck)));
        goToDashBoard();
    }

//    private void updateData(String front, String back, int rating, String deck) {
//        MainActivity.getDbManager().insertData(front, back, rating, deck);
//        newDeck = new Deck(associatedDeck);
//        newCard = new FlashCard(
//                MainActivity.getDbManager().getIDByContents(front, back, String.valueOf(-1), associatedDeck),
//                front, back, -1, newDeck
//        );
//        Deck.addDeckToList(newDeck);
//        newDeck.addNewCard(newCard);
//        FlashCard.addFlashcardToList(newCard);
//        deckStringList.add(associatedDeck);
//        adapter.notifyDataSetChanged();
//    }

    private void goToDashBoard() {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        startActivity(intent);
    }

//    // TODO duplicate code
//    private void onSpecificDeckSelected(String chosenDeck) {
//        String front = getIntent().getExtras().getString("frontContent");
//        String back = getIntent().getExtras().getString("backContent");
//        Deck deck = Deck.findByTitle(chosenDeck);
//        newCard = new FlashCard(
//                MainActivity.getDbManager().getIDByContents(front, back, String.valueOf(-1), associatedDeck),
//                front, back, -1, newDeck
//        );
//        FlashCard.addFlashcardToList(newCard);
//        deck.addNewCard(newCard);
//        MainActivity.getDbManager().insertData(front, back, -1, deck.getTitle());
//        goToDashBoard();
//    }

    // TODO if the calling activity was chooseDeckActivity, make toast "new flashcard added"

}
