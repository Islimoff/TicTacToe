package com.sapronov.tiktaktoe;

public class Logic {

    private int counter;
    private final int[][] buttonsId;

    public Logic(int[][] buttonsId){
        counter=0;
        this.buttonsId=buttonsId;
    }

    public boolean isFinish() {
        return counter == 8;
    }
    public boolean isPlayerTurn () {
        return counter % 2 == 0;
    }

    public void restcounter(){
        counter=0;
    }

    public boolean checkWin(String[][] buttonsText) {
        counter++;
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
}
