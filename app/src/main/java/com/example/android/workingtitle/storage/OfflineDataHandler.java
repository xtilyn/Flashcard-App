package com.example.android.workingtitle.storage;

import com.example.android.workingtitle.logic.Deck;
import com.example.android.workingtitle.logic.FlashCard;
import com.example.android.workingtitle.logic.Session;

import java.util.ArrayList;
import java.util.List;
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
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 2017-04-03.
 */

public class OfflineDataHandler {

    private Realm myRealm;
    private List<Deck> decks;
    private List<FlashCard> flashCards;
    private List<Session> sessions;

    public OfflineDataHandler(Realm myRealm) {
        this.myRealm = myRealm;
        decks = retrieveDecks();
        flashCards = retrieveCards();
        sessions = retrieveSessions();
    }

    List<Deck> getDecks() {
        return new ArrayList<>(decks);
    }

    List<FlashCard> getFlashCards() {
        return new ArrayList<>(flashCards);
    }

    List<Session> getSessions() {
        return new ArrayList<>(sessions);
    }

    void saveFlashCard(final FlashCard flashCard) {
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                FlashCard c = myRealm.copyToRealm(flashCard);
            }
        });
    }

    private ArrayList<FlashCard> retrieveCards() {
        ArrayList<FlashCard> flashCards = new ArrayList<>();
        RealmResults<FlashCard> totalCards = myRealm.where(FlashCard.class).findAll();
        for (FlashCard flashCard : totalCards) {
            flashCards.add(flashCard);
        }
        return flashCards;
    }

    private ArrayList<Deck> retrieveDecks() {
        ArrayList<Deck> decks = new ArrayList<>();
        RealmResults<Deck> totalDecks = myRealm.where(Deck.class).findAll();
        for (Deck deck : totalDecks) {
            decks.add(deck);
        }
        return decks;
    }

    private ArrayList<Session> retrieveSessions() {
        ArrayList<Session> sessions = new ArrayList<>();
        RealmResults<Session> totalSessions = myRealm.where(Session.class).findAll();
        for (Session session : totalSessions) {
            sessions.add(session);
        }
        return sessions;
    }

    void saveDeck(final Deck deck) {
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Deck d = myRealm.copyToRealm(deck);
            }
        });
    }

    void saveSession(final Session session) {
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Session s = myRealm.copyToRealm(session);
            }
        });
    }

    void removeCard(final FlashCard flashCard) {
        // TODO
    }

    void removeDeck(final Deck deck) {
        // TODO remove deck and its associated contents
    }

}
