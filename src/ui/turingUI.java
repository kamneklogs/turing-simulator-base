package ui;

import java.io.IOException;
import model.TuringMasterClass;

public class turingUI {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // TuringMasterClass myTuringMachine = new TuringMasterClass();

        try {
            TuringMasterClass myTuringMachine = new TuringMasterClass();

            myTuringMachine.loadOpsFile();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis() - startTime;

        System.out.println("\n" + (finishTime));
    }

   

}