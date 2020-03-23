package model;

import java.io.*;
import java.util.*;

public class TuringMasterClass {

    private Element firstElement;
    private Element c0, c1, c2;

    private int listLeght;

    public TuringMasterClass() {

        c0 = firstElement;
        c1 = firstElement;
        c2 = firstElement;

        listLeght = 0;

    }

    public void loadOpsFile() throws IOException {

        File fIn = new File("data/in_turing.txt");
        FileReader fr = new FileReader(fIn);
        BufferedReader br = new BufferedReader(fr);

        String opsS = null;
        do {

            opsS = br.readLine();

            if (opsS != null) {

                runLineOp(opsS);

            }

        } while (opsS != null);

        br.close();

    }

    public void runLineOp(String opsS) throws IOException {

        char[] ops = opsS.toCharArray();

        for (int i = 0; i < ops.length; i++) {

            switch (ops[i]) {

                case '0':// cabeza 0

                    switch (ops[i + 1]) {

                        case '0':// leer

                            write(0);
                            i = i + 1;

                            break;

                        case '1':

                            read(0, ops[i + 2]);
                            i = i + 2;

                            break;

                        default:
                            break;
                    }

                    break;

                case '1':// cabeza 1

                    switch (ops[i + 1]) {
                        case '0':// leer

                            break;

                        default:
                            break;
                    }

                    break;

                case '2':// cabeza 2

                    switch (ops[i + 1]) {
                        case '0':// leer

                            break;

                        default:
                            break;
                    }

                    break;
            }

        }

    }

    public void write(int headN) throws IOException {

        File f = new File("data/out_turing.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(f));

        switch (headN) {
            case 0:

                if (firstElement != null) {
                    c0 = firstElement;
                    pw.println(c0.getL());
                } else {
                    pw.println("#");
                }

                break;

            case 1:
                if (c1 != null) {
                    pw.println(c1.getL());
                } else {
                    pw.println("#");
                }
                break;

            case 2:
                if (c2 != null) {
                    pw.println(c2.getL());
                } else {
                    pw.println("#");
                }
                break;
        }

        pw.close();

    }

    public void read(int headN, char l) {

        switch (headN) {

            case 0:
            
                break;

        }

    }

    public char delete(int headN) {
        char c = ' ';

        switch (headN) {
            case 0:
                c = c0.getL();
                break;

            case 1:
                c = c1.getL();
                break;
            case 2:
                c = c2.getL();
                break;
        }

        return c;
    }

}