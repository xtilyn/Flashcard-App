package com.example.android.workingtitle.activities;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.workingtitle.logic.FlashCard;
import com.example.android.workingtitle.R;

import java.util.ArrayList;
import java.util.List;

public class FlashcardsActivity extends AppCompatActivity {

    private List<FlashCard> flashCardsInDeck;
    private List<String> flashCardsFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);
        flashCardsInDeck = new ArrayList<>();
        flashCardsFront = new ArrayList<>();
        String selectedDeck = getIntent().getExtras().getString("selectedDeck");
//        findDeckContents(selectedDeck);
        displayFlashcards();
    }

    private void displayFlashcards() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flashCardsFront);
        ListView listView = (ListView) findViewById(R.id.listview_for_flashcards);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FlashCard card =
                                findCardByFront(String.valueOf(parent.getItemAtPosition(position)));
                        showCardDetails(card);
                    }
                }
        );
    }

    private void showCardDetails(FlashCard card) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Answer: " + card.getBack() + "\nRating: " +
                card.getRating() + "\nDeck: " + card.getDeck().getTitle());
        builder.show();
    }

    // TODO move to FlashCard class
    private FlashCard findCardByFront(String f) {
        for (FlashCard card : flashCardsInDeck) {
            if (card.getFront().equals(f)) {
                return card;
            }
        } return null;
    }

//    // TODO create a hashmap in Deck class: String title = Deck deck
//    private void findDeckContents(String selectedDeck) {
//        for (Deck d : Deck.getTotalDecks()) {
//            if (d.getTitle().equals(selectedDeck)) {
//                flashCardsInDeck = d.getDeckContents();
//            }
//        }
//        setFlashCardsFront();
//    }

    private void setFlashCardsFront() {
        for (FlashCard card : flashCardsInDeck) {
            flashCardsFront.add(card.getFront());
        }
    }

}
