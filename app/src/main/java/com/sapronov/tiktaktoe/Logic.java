package com.sapronov.tiktaktoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logic implements Serializable {

    private int counter;
    private final int[][] buttonsId;
    private List<Integer> emptyButtonsID;

    public Logic(int[][] buttonsId) {
        counter = 0;
        this.buttonsId = buttonsId;
        emptyButtonsID = new ArrayList<>();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int[][] getButtonsId() {
        return buttonsId;
    }

    public List<Integer> getEmptyButtonsID() {
        return emptyButtonsID;
    }

    public void setEmptyButtonsID(List<Integer> emptyButtonsID) {
        this.emptyButtonsID = emptyButtonsID;
    }

    public boolean isFinish() {
        return counter == 9;
    }

    public String getPlayerName() {
        if(counter % 2 == 0){
            return "X";
        }else return "0";
    }

    public void resetCounter() {
        counter = 0;
    }

    public boolean checkWin(String[][] buttonsText) {
        counter++;
        refreshEmptyButtons(buttonsText);
        for (int i = 0; i < 3; i++) {
            if (buttonsText[i][0].equals(buttonsText[i][1])
                    && buttonsText[i][0].equals(buttonsText[i][2])
                    && !buttonsText[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttonsText[0][i].equals(buttonsText[1][i])
                    && buttonsText[0][i].equals(buttonsText[2][i])
                    && !buttonsText[0][i].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttonsText[0][0].equals(buttonsText[1][1])
                    && buttonsText[0][0].equals(buttonsText[2][2])
                    && !buttonsText[0][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttonsText[0][2].equals(buttonsText[1][1])
                    && buttonsText[0][2].equals(buttonsText[2][0])
                    && !buttonsText[0][2].equals("")) {
                return true;
            }
        }
        return false;
    }

    private void refreshEmptyButtons(String[][] buttonsText) {
        emptyButtonsID.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttonsText[i][j].equals("")) {
                    emptyButtonsID.add(buttonsId[i][j]);
                }
            }
        }
    }

    public int randomId() {
        Random random = new Random();
        return emptyButtonsID.get(random.nextInt(emptyButtonsID.size())) ;
    }
}