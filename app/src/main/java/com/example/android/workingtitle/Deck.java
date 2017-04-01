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

public class Deck {

    // TODO maximum deck size?

    private static int numberOfDecks;

    private String title;
    private ArrayList<FlashCard> deckContents;
    private ArrayList<FlashCard> cardsByLevel;
    private ArrayList<FlashCard> easyCards;
    private ArrayList<FlashCard> mediumCards;
    private ArrayList<FlashCard> hardCards;
    private ArrayList<FlashCard> unratedCards;

    Deck(String title) {
        this.title = title.isEmpty() ? "Untitled" : title;
        deckContents = new ArrayList<>();
        cardsByLevel = new ArrayList<>();
        numberOfDecks++;
    }

    public String getTitle() {
        return title;
    }

    public static int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void addNewCard(FlashCard card) {
        if (!(this.deckContents.size() <= 100))
            deckContents.add(card);
    }

    public void removeCard(FlashCard card) {
        int index = -1;
        for (int count = 0; count < deckContents.size(); count++) {
            if (deckContents.get(count).equals(card)) {
                index = count;
            }
        }
        if (index != -1) {
            deckContents.remove(index);
            removeFromRatingList(card);
        }
    }

    private void removeFromRatingList(FlashCard card) {
        switch (card.getRating()) {
            case FlashCard.EASY:
                easyCards.remove(card);
                break;
            case FlashCard.MEDIUM:
                mediumCards.remove(card);
                break;
            case FlashCard.HARD:
                hardCards.remove(card);
                break;
            default:
                unratedCards.remove(card);
                break;
        }
    }

    public ArrayList<FlashCard> getDeckContents() {
        return this.deckContents;
    }

//    private void organizeDeckByLevel() {
//        // hard cards at beginning of list
//        cardsByLevel.clear();
//        for (FlashCard hardCard : hardCards) {
//            cardsByLevel.add(hardCard);
//        }
//        for (FlashCard mediumCard : mediumCards) {
//            cardsByLevel.add(mediumCard);
//        }
//        for (FlashCard easyCard : easyCards) {
//            cardsByLevel.add(easyCard);
//        }
//    }

    public void moveToRatingList(FlashCard card, ArrayList<FlashCard> fromRatingList,
                                 ArrayList<FlashCard> toRatingList) {
        fromRatingList.remove(card);
        toRatingList.add(card);
    }

    public void addToEasyCards(FlashCard card) {
        easyCards.add(card);
    }

    public void addToMediumCards(FlashCard card) {
        mediumCards.add(card);
    }

    public void addToHardCards(FlashCard card) {
        hardCards.add(card);
    }

    public void addToUnratedCards(FlashCard card) {
        unratedCards.add(card);
    }

    public ArrayList<FlashCard> getEasyCards() {
        return easyCards;
    }

    public ArrayList<FlashCard> getMediumCards() {
        return mediumCards;
    }

    public ArrayList<FlashCard> getHardCards() {
        return hardCards;
    }

//    private boolean isInThisDeck(FlashCard card) {
//        for (FlashCard c : this.deckContents) {
//            if (c.equals(card)) {
//                return true;
//            }
//        }
//        return false;
//    }



}