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

public class FlashCard {

    public static final int EASY = 3;
    public static final int MEDIUM = 2;
    public static final int HARD = 1;
    public static final int UNRATED = -1;

    private String front;
    private String back;
    private int id;
    private String deck;
    private int rating;

    FlashCard(String f, String b, int i, int r, String d) {
        setFront(f);
        setBack(b);
        setID(i);
        setRating(r);
        setDeck(d);
    }

    void setFront(String f) {
        front = f;
    }

    void setBack(String b) {
        back = b;
    }

    void setID(int ID) {
        id = ID;
    }

    void setRating(int rate) {
        rating = rate;
    }

    void setDeck(String d) {
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

    String getDeck() {
        return deck;
    }

    int getID() {
        return id;
    }

    boolean equals(FlashCard otherCard) {
        final String otherCardFront = otherCard.getFront();
        final String otherCardBack = otherCard.getBack();
        return otherCardFront.equals(front) &&
                otherCardBack.equals(back);
    }

    @Override
    public String toString() {
        return front;
    }

}