package com.sapronov.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private int[][] buttonsId = new int[3][3];
    private Logic logic;
//    private Switch swich=findViewById(R.id.switch1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String id = "button_" + i + j;
                buttons[i][j] = findViewById(getResources().getIdentifier(id, "id", getPackageName()));
                buttonsId[i][j]=buttons[i][j].getId();
            }
        }
        logic=new Logic(buttonsId);
    }

    public void answer(View view) {
        Button button = (Button) view;
        String player;
        if (logic.isPlayerTurn()) {
            player = "X";
            button.setText(player);
        } else {
            player = "0";
            button.setText(player);
        }
        button.setClickable(false);
        makeStep(player);
    }

    private void makeStep(String text) {
        if (logic.isFinish()) {
            showMessage("Nobody won, it was a draw!");
            logic.restcounter();
            resetButtons();
        }
        if (logic.checkWin(setAnswers())) {
            showMessage("The Player " + text + " won, congratulations!");
            logic.restcounter();
            resetButtons();
        }
    }

    private void resetButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setClickable(true);
            }
        }
    }

    private String[][] setAnswers() {
        String[][] buttonsText = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonsText[i][j] = buttons[i][j].getText().toString();
            }
        }
        return buttonsText;
    }

    private void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}