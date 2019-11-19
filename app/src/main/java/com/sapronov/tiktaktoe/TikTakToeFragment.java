package com.sapronov.tiktaktoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TikTakToeFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private Button[][] buttons = new Button[3][3];
    private int[][] buttonsId = new int[3][3];
    private Logic logic;
    private View viewFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment_tiktaktoe, container, false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String id = "button_" + i + j;
                buttons[i][j] = viewFragment.findViewById(getResources().getIdentifier(id, "id", getActivity().getPackageName()));
                buttons[i][j].setOnClickListener(this::answer);
                buttonsId[i][j] = buttons[i][j].getId();
            }
        }
        Button reset = viewFragment.findViewById(R.id.reset_button);
        reset.setOnClickListener(this::useResetButton);
        if (savedInstanceState == null) {
            logic = new Logic(buttonsId);
        } else {
            logic = (Logic) savedInstanceState.getSerializable("Logic_object");
        }
        Switch toggle = viewFragment.findViewById(R.id.switch1);
        toggle.setOnCheckedChangeListener(this);
        return viewFragment;
    }

    private void makeStep(String playerName, Button button) {
        button.setText(playerName);
        button.setClickable(false);
        if (logic.checkWin(setAnswers())) {
            showMessage("The Player " + playerName + " won, congratulations!");
            resetButtons();
        } else if (logic.isFinish()) {
            showMessage("Nobody won, it was a draw!");
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
        logic.resetCounter();
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
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    public void answer(View view) {
        Button button = (Button) view;
        Switch toggle = viewFragment.findViewById(R.id.switch1);
        makeStep(logic.getPlayerName(), button);
        if (toggle.isChecked() && logic.getPlayerName().equals("0")) {
            Button random = viewFragment.findViewById(logic.randomId());
            makeStep(logic.getPlayerName(), random);
        }
    }

    public void useResetButton(View view) {
        resetButtons();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (logic.getPlayerName().equals("0")) {
            Button random = viewFragment.findViewById(logic.randomId());
            makeStep(logic.getPlayerName(), random);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Logic_object", logic);
    }
}