package com.example.android.workingtitle;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 2017-04-02.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private ArrayList<String> cards;

    public CustomAdapter(@NonNull Context context, ArrayList<String> c) {
        super(context, R.layout.custom_row, c);
        cards = new ArrayList<>(c);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String deck = getItem(position);
        TextView deckTitle = (TextView) customView.findViewById(R.id.deck_title_for_custom_row);
        TextView numCardsInDeck = (TextView) customView.findViewById(R.id.number_of_cards);

        deckTitle.setText(deck);
        numCardsInDeck.setText(cards.size());

        return customView;
    }
}
