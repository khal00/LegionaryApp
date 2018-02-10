package com.krzysztof.legionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.krzysztof.legionaryapp.R;
import com.krzysztof.legionaryapp.QuizActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// EditText where user input his name

        final EditText userNameInputEditText = findViewById(R.id.user_name_EditText);

// toast messages with social classes descriptions

        final RadioButton romanCitizenButton = (RadioButton) findViewById(R.id.roman_citizen_radio_button);
        romanCitizenButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), R.string.roman_citizen_tooltip, Toast.LENGTH_LONG).show();
                return true;
            }
        });

        final RadioButton foederatiButton = (RadioButton) findViewById(R.id.foederati_radio_button);
        foederatiButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), R.string.foederati_tooltip, Toast.LENGTH_LONG).show();
                return true;
            }
        });

        final RadioButton slaveButton = (RadioButton) findViewById(R.id.slave_radio_button);
        slaveButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), R.string.slave_tooltip, Toast.LENGTH_LONG).show();
                return true;
            }
        });


//        method to change activity and start the quiz

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isEmpty(userNameInputEditText)) {
                    Toast.makeText(view.getContext(), R.string.no_user_name, Toast.LENGTH_LONG).show();

                } else if (romanCitizenButton.isChecked()) {
                    final Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("user_name", userNameInputEditText.getText().toString());
                    startActivity(intent);

                } else if (foederatiButton.isChecked()) {
                    final Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("user_name", userNameInputEditText.getText().toString());
                    startActivity(intent);

                } else if (slaveButton.isChecked()) {
                    Toast.makeText(view.getContext(), R.string.slave_button_checked_string, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(view.getContext(), R.string.no_button_checked, Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    //    method to check if name is empty
    private boolean isEmpty(EditText userInput) {
        return userInput.getText().toString().trim().length() == 0;
    }


}