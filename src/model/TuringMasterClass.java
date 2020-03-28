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

            System.out.println(opsS);
            if (opsS != null) {

                runLineOp(opsS);

            }

        } while (opsS != null);

        br.close();

    }

    public void runLineOp(String opsS) throws IOException {

        char[] ops = opsS.toCharArray();

        for (int i = 0; i < ops.length; i++) {

            Element current = firstElement;
            while (current != null) {

                System.out.println(current.getL());
                current = current.getNextE();

            }

            switch (ops[i]) {

                case '0':// cabeza 0

                    switch (ops[i + 1]) {

                        case '0':// Escribir en el archivo

                            writeOnFile(0);
                            i = i + 1;

                            break;

                        case '1': // cargar desde el archivo

                            readFromFile(0, ops[i + 2]);
                            i = i + 2;

                            break;

                        case '2':
                            delete(0);
                            i = i + 1;
                            break;

                        default:
                            break;
                    }

                    break;

                case '1':// cabeza 1

                    switch (ops[i + 1]) {

                        case '0':// leer

                            writeOnFile(1);
                            i = i + 1;

                            break;

                        case '1':

                            readFromFile(1, ops[i + 2]);
                            i = i + 2;

                            break;

                        case '2':
                            delete(1);
                            i = i + 1;
                            break;

                        default:
                            break;
                    }

                    break;

                case '2':// cabeza 2

                    switch (ops[i + 1]) {

                        case '0':// leer

                            writeOnFile(2);
                            i = i + 1;

                            break;

                        case '1':

                            readFromFile(2, ops[i + 2]);

                            i = i + 2;

                            break;

                        case '2':
                            delete(2);
                            i = i + 1;
                            break;

                        default:
                            break;
                    }

                    break;
            }

        }

    }

    public void writeOnFile(int headN) throws IOException {

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

    public void readFromFile(int headN, char l) {

        if (firstElement == null) {
            firstElement = new Element(l);
            c0 = firstElement;
            c1 = firstElement;
            c2 = firstElement;
            listLeght++;
        } else {

            Element newE = new Element(l);

            switch (headN) {

                case 0:
                    Element currentc0 = firstElement;
                    firstElement = newE;
                    firstElement.setNextE(currentc0.getNextE());
                    c0 = firstElement;
                    listLeght++;
                    break;

                case 1:

                    Element currentc1 = c1;
                    // System.out.println(currentc1.getL());
                    Element prec1 = c1.getPrevE();

                    c1 = newE;
                    c1.setPrevE(prec1);
                    c1.setNextE(currentc1);
                    // System.out.println(c1.getL());
                    if (listLeght == 2) {
                        c2 = c1;
                    }
                    listLeght++;

                    break;

                case 2:
                    Element currentc2 = c2;
                    // System.out.println(currentc1.getL());
                    c2 = newE;
                    c2.setPrevE(currentc2);

                    break;

            }
        }

    }

    public void delete(int headN) {

        if (listLeght == 1) {
            firstElement = null;
            c0 = firstElement;
            c1 = firstElement;
            c2 = firstElement;
            listLeght--;
        } else {
            switch (headN) {
                case 0:
                    c0 = firstElement.getNextE();
                    firstElement = c1;

                    listLeght--;
                    break;

                case 1:

                    Element prec1 = c1.getPrevE();
                    Element nexc1 = c1.getNextE();

                    c1 = prec1;
                    c1.setNextE(nexc1);

                    listLeght--;
                    break;
                case 2:
                    c2 = c2.getPrevE();
                    c2.setNextE(null);
                    listLeght--;
                    break;
            }
        }

    }

}