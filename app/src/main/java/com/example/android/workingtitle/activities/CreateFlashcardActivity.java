package com.example.android.workingtitle.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.workingtitle.R;

public class CreateFlashcardActivity extends AppCompatActivity {

    private String frontContent;
    private String backContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flashcard);
    }

    private void setCardContents() {
        EditText frontEditText = (EditText) findViewById(R.id.frontEditText);
        EditText backEditText = (EditText) findViewById(R.id.backEditText);

        frontContent = frontEditText.getText().toString();
        backContent = backEditText.getText().toString();
    }

    public void onCreateButtonClicked(View view) {
        setCardContents();
        if (frontContent.isEmpty() || backContent.isEmpty())
            Toast.makeText(this, "One or more field is left blank", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(this, ChooseDeckActivity.class);
            intent.putExtra("frontContent", frontContent);
            intent.putExtra("backContent", backContent);
            startActivity(intent);
        }
    }

}
