package com.example.android.workingtitle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateFlashcardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flashcard);
    }

    public void createCard(View view) {
        // TODO


        Intent intent = new Intent(this, ChooseDeckActivity.class);
        startActivity(intent);
    }
}
