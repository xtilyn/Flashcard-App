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

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FlashCard extends RealmObject {

    public static final int EASY = 3;
    public static final int MEDIUM = 2;
    public static final int HARD = 1;
    public static final int UNRATED = -1;

    private static List<FlashCard> totalFlashcards = new ArrayList<>();

    private String front;
    private String back;
    private Deck deck;
    private int rating;

    FlashCard(String f, String b, int r, Deck d) {
        setFront(f);
        setBack(b);
        setRating(r);
        setDeck(d);
    }

    public FlashCard(){}

    static void setTotalFlashcards(List<FlashCard> f) {
        totalFlashcards = f;
    }

    static List<FlashCard> getTotalFlashcards() {
        return new ArrayList<>(totalFlashcards);
    }

    static void addFlashcardToList(FlashCard f) {
        totalFlashcards.add(f);
    }

    static int getNumberOfFlashcards() {
        return totalFlashcards.size();
    }

    void setFront(String f) {
        front = f;
    }

    void setBack(String b) {
        back = b;
    }

    void setRating(int rate) {
        rating = rate;
    }

    void setDeck(Deck d) {
        deck = d;
    }

    int getRating() {
        return rating;
    }

    String getFront() {
        return front;
    }

    String getBack() {
        return back;
    }

    Deck getDeck() {
        return deck;
    }

    boolean equals(FlashCard otherCard) {
        final String otherCardFront = otherCard.getFront();
        final String otherCardBack = otherCard.getBack();
        return otherCardFront.equals(front) &&
                otherCardBack.equals(back);
    }

//    public void addFlashCard(final FlashCard card) {
//        mRealm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                long id = this.id.incrementAndGet();
//                card.setId(id);
//                realm.copyToRealm(card);
//            }
//        })
//    }

    @Override
    public String toString() {
        return front;
    }
}