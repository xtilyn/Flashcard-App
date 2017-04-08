/*
 * Copyright (C) 2017 xtilyn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.example.android.workingtitle;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private Cursor dbContents;

    private static OfflineDataHandler offlineDataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
        setContentView(R.layout.activity_main);
        Realm myRealm = Realm.getInstance(config);
        offlineDataHandler = new OfflineDataHandler(myRealm);
    }

    public static OfflineDataHandler getOfflineDataHandler() {
        return offlineDataHandler;
    }


//    public void onDeleteDataClick(View view) {
//        dbManager.removeAllData();
//        Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show();
//    }

//    private void initFlashCards() {
//        dbContents.moveToFirst();
//        while (dbContents.moveToNext()) {
//            FlashCard newCard = new FlashCard(
//                    Integer.parseInt(dbContents.getString(0)),
//                    dbContents.getString(1),
//                    dbContents.getString(2),
//                    Integer.parseInt(dbContents.getString(3)),
//                    Deck.findByTitle(dbContents.getString(4)));
//            flashCards.add(newCard);
//            newCard.getDeck().addNewCard(newCard);
//        }
//        FlashCard.setTotalFlashcards(flashCards);
//    }

//    private void initDecks() {
//        Set<String> hs = new HashSet<>();
//        List<String> temp2 = new ArrayList<>();
//        while (dbContents.moveToNext()) {
//            temp2.add(dbContents.getString(4));
//        }
//        hs.addAll(temp2);
//        temp2.clear();
//        temp2.addAll(hs);
//        for (String deckTitle : temp2) {
////            decks.add(new Deck(deckTitle));
//        }
//        Deck.setTotalDecks(decks);
//    }

    public void onDashBoardButtonClicked(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void onNewButtonClicked(View view) {
        Intent intent = new Intent(this, CreateFlashcardActivity.class);
        startActivity(intent);
    }

    public void onSettingsButtonClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onAboutButtonClicked(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /*
    NOTE GUI:
    a. Built-in cliparts to be added in a card
    b. Icons for decks
    c. Nav drawer activity: "start session" in the main content
    d. Add SessionActivity.java
    e. After selecting a new session, give user option which deck, and
        choices to choose from number of cards to include (add opt to select all
        cards)
    d. Add button to skip card during session
    e. When a user rates a card; set new card rating(FlashCard),
        and transfer card (Deck)
    f. updateDeck() in GUI (such that right cards are displayed after
        modifications/changed ratings/etc):
    g. Feature to google search image via webview
    */

}
