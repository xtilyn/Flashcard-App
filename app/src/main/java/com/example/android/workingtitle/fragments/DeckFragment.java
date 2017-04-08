package com.example.android.workingtitle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.workingtitle.logic.Deck;
import com.example.android.workingtitle.R;
import com.example.android.workingtitle.activities.FlashcardsActivity;

import java.util.ArrayList;


/**
 *
 */
public class DeckFragment extends Fragment {

    private ArrayList<String> deckStringList;

    public DeckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deck, container, false);
        deckStringList = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, deckStringList);
        createList();
        ListView listView = (ListView) view.findViewById(R.id.listview_for_deck_in_dashboard);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedDeck = String.valueOf(parent.getItemAtPosition(position));
                        // TODO
                        goToFlashcards(selectedDeck);
                    }
                }
        );
        return view;
    }

    private void goToFlashcards(String specifiedDeck) {
        Intent intent = new Intent(getActivity(), FlashcardsActivity.class);
        intent.putExtra("selectedDeck", specifiedDeck);
        getActivity().startActivity(intent);
    }

    private void createList() {
        // TODO duplicate method
        for (int i = 0; i < Deck.getNumberOfDecks(); i++) {
            deckStringList.add(Deck.getTotalDecks().get(i).getTitle());
        }
    }
}
