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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author xtilyn
 */
public class Session implements Serializable{

    private final int timeLimitMinutes;
    private final Deck deck;
    private final ArrayList<FlashCard> cardsInSession;

    private double sessionScore;
    private ArrayList<FlashCard> queue;

    Session(int time, Deck d) {
        timeLimitMinutes = time;
        deck = d;
        queue = new ArrayList<>();
        cardsInSession = new ArrayList<>(deck.getDeckContents());
    }

    public void setScore(double s) {
        sessionScore = s;
    }

    public int getTimeLimitMinutes() {
        return timeLimitMinutes;
    }

    public double getSessionScore() {
        return sessionScore;
    }

    public void endSession() {
        // TODO
    }

    private void evaluateSessionScore() {
        // TODO
    }

    public void scheduleSpacedRep() {
        // TODO
    }

}