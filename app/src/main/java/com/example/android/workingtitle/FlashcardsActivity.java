package com.example.android.workingtitle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        findDeckContents(selectedDeck);
        displayFlashcards();
    }

    private void displayFlashcards() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flashCardsFront);
        ListView listView = (ListView) findViewById(R.id.listview_for_flashcards);
        listView.setAdapter(adapter);
    }

    // TODO create a hashmap in Deck class: String title = Deck deck
    private void findDeckContents(String selectedDeck) {
        for (Deck d : Deck.getTotalDecks()) {
            if (d.getTitle().equals(selectedDeck)) {
                flashCardsInDeck = d.getDeckContents();
            }
        }
        setFlashCardsFront();
    }

    private void setFlashCardsFront() {
        for (FlashCard card : flashCardsInDeck) {
            flashCardsFront.add(card.getFront());
        }
    }

}
