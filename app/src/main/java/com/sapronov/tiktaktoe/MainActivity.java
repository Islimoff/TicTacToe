package com.sapronov.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private Logic logic=new Logic();
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String id = "button_" + i + j;
                buttons[i][j] = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            }
        }
    }

    public void answer(View view) {
        Button button = (Button) view;
        if (counter % 2 == 0) {
            button.setText("O");
        } else {
            button.setText("X");
        }
        button.setClickable(false);
        if (logic.checkWin(setAnswers())) {
            Toast.makeText(this, "aaaaaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
        } else {
            counter++;
        }
    }

    public String[][] setAnswers() {
        String[][] buttonsText = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonsText[i][j] = buttons[i][j].getText().toString();
            }
        }
        return buttonsText;
    }
}
