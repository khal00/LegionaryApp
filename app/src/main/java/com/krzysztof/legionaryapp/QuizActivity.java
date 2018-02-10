package com.krzysztof.legionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.krzysztof.legionaryapp.R;

public class QuizActivity extends AppCompatActivity {

    Integer score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView GreetingsTextView = (TextView) findViewById(R.id.greetings_text_view);
        Intent intent = getIntent();

        String greetingsMessage = getString(R.string.greetings_string, intent.getStringExtra("user_name"));
        GreetingsTextView.setText(greetingsMessage);

    }


    //    this method calculates user score when user clicked submit button
    public void calculateScore(View view){


        RadioButton q1a1Button = findViewById(R.id.q1_a1_radio_button);

        if (q1a1Button.isChecked()){
            score++;

    }

        CheckBox q2a1CheckBox = findViewById(R.id.q2_a1_check_box);
        CheckBox q2a2CheckBox = findViewById(R.id.q2_a2_check_box);
        CheckBox q2a3CheckBox = findViewById(R.id.q2_a3_check_box);
        CheckBox q2a4CheckBox = findViewById(R.id.q2_a4_check_box);

        if (!q2a1CheckBox.isChecked() && !q2a2CheckBox.isChecked() && q2a3CheckBox.isChecked() && q2a4CheckBox.isChecked()) {

            score++;

        }

        EditText aeneidAuthorEditText = findViewById(R.id.aeneid_author_EditText);
        String aeneidAnswer = aeneidAuthorEditText.getText().toString();


        if (aeneidAnswer.equals("Virgil")){
            score++;

        }

        whatRank();

        Toast.makeText(view.getContext(), getString(R.string.user_score_string, score.toString(), whatRank()), Toast.LENGTH_LONG).show();

        score = 0;


    }

    public String whatRank() {

        String rank = null;

        if (score == 0){
            rank = getString(R.string.veles);
        }

        else if (score == 1){
            rank = getString(R.string.hastatus);
        }

        else if (score == 2){
            rank = getString(R.string.princeps);
        }

        else {
            rank = getString(R.string.triarius);
        }

        return rank;

    }

}