package ui;

import java.io.IOException;

import model.TuringMasterClass;

public class turingUI {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        TuringMasterClass myTuringMachine = new TuringMasterClass();

        try {
            myTuringMachine.loadOpsFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis() - startTime;
        
        System.out.println((finishTime));
    }

}