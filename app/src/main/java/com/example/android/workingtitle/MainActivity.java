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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDashBoardButtonClicked(View view) {
        Intent intent = new Intent("com.example.android.workingtitle.DashboardActivity");
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
    a. Built-in cliparts/images to be added in a card
    b.
    c. Nav drawer activity: "start session" floating btn
    d. Add SessionActivity.java
    e. After selecting a new session, give user option which deck, and
        choices to choose from number of cards to include (add opt to select all
        cards)
    d. Add button to skip card during session
    e. When a user rates a card; set new card rating(FlashCard),
        and transfer card (Deck)
    f. updateDeck() in GUI (such that right cards are displayed after
        modifications/changed ratings/etc):
    */

}
