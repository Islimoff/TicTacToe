package com.sapronov.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counter=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void answer(View view)
    {
        Button button= (Button) view;
        if (counter%2==0){
            button.setText("O");
        }
        else{
            button.setText("X");
        }
        counter++;
    }
}
