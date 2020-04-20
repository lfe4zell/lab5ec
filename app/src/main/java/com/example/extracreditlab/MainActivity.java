package com.example.extracreditlab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

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
    }

    ArrayList<String> words = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "CHERRY"));

    //get random word from arraylist


        int randomW = (int)(Math.random() * words.size());
        String word = words.get(randomW);


    //split the word in individual letters
    ArrayList<String> wordlist = new ArrayList(Arrays.asList(word.split("")));
    Collections.shuffle(wordlist);
    String shuffledword = String.join(", ", wordlist);


        TextView s = (TextView) findViewById(R.id.scrambled);
        s.setText(shuffledword);


    int guessesWrong = 0;

    EditText userGuess = findViewById(R.id.guessLetter);
    String guess = userGuess.getText().toString();

    ListIterator<String> LI = wordlist.listIterator();
    String nxt = LI.next();


    if (guess.equals(nxt)) {
        guessesWrong ++;
        TextView s = (TextView) findViewById(R.id.guessesWrong);
        s.setText(guessesWrong);
    } else if {
        TextView s = (TextView) findViewById(R.id.guessesCorrect);
        s.setText(guess);
    }

    int length = word.length();
    //after too many guesses, correct word is displayed for user
        if (guessesWrong.equals(length)) {
        TextView w = (TextView) findViewById(R.id.guessesCorrect);
        w.setText(word);
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
