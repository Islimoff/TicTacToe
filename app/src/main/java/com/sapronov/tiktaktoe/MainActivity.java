package com.sapronov.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private Logic logic = new Logic(Arrays.asList(R.id.button1, R.id.button2, R.id.button3, R.id.button4
            , R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void answer(View view) {
        Button button = (Button) view;
        logic.addAnswer(button.getId());
        if (counter % 2 == 0) {
            button.setText("O");
        } else {
            button.setText("X");
        }
        button.setClickable(false);
        counter++;
    }
}
