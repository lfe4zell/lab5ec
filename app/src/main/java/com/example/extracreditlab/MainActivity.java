package com.example.extracreditlab;


import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private String word, shuffledword, correctletters;
    private int guessesWrong, currentletter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Initialize Variables

        guessesWrong = currentletter = 0;
        correctletters = "";

        // Choose and Shuffle Secret Word

        ArrayList<String> words = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "CHERRY"));

        int randomW = (int) (Math.random() * words.size());
        word = words.get(randomW);

        ArrayList<String> wordlist = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(wordlist);
        shuffledword = TextUtils.join("", wordlist);

        TextView s = (TextView) findViewById(R.id.scrambled);
        s.setText(shuffledword);

    }

    public void onClick(View v) {

        // Get / uppercase player's guess

        EditText userGuess = findViewById(R.id.guessLetter);
        char guess = (userGuess.getText().toString()).toUpperCase().charAt(0);

        // Guess correct?

        if (guess == word.charAt(currentletter)) {
            correctletters += guess;
            TextView s = (TextView) findViewById(R.id.guessesCorrect);
            s.setText(correctletters);
            currentletter++;
            if (correctletters.equals(word)) {
                TextView w = (TextView) findViewById(R.id.win);
                w.setText("You won the game in " + currentletter + " guesses");
            }
        }

        // Guess incorrect

        else {
            guessesWrong++;
            TextView s = (TextView) findViewById(R.id.guessesWrong);
            s.setText(String.valueOf(guessesWrong));
        }

        // Clear previous input

        userGuess.setText("");

        int length = word.length();

        //after too many guesses, correct word is displayed for user

        if (guessesWrong == length) {
            TextView w = (TextView) findViewById(R.id.guessesCorrect);
            w.setText(word);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
