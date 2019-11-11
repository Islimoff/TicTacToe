package com.sapronov.tiktaktoe;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private final List<Integer> buttons;
    private final List<Integer> answers = new ArrayList<>();

    public Logic(List<Integer> buttons) {
        this.buttons = buttons;
    }

    public void addAnswer(Integer id) {
        answers.add(id);
    }

    public boolean checkWin(){
       return true;
    }
}
