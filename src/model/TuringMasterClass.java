package model;

import java.io.*;
//import java.util.*;

public class TuringMasterClass {

    private Element firstElement;
    private Element c0, c1, c2;

    private PrintWriter pw;

    private int listLeght;

    public TuringMasterClass() throws IOException {

        pw = new PrintWriter(new FileWriter("data/out_turing.txt"));

        c0 = firstElement;
        c1 = firstElement;
        c2 = firstElement;

        listLeght = 0;

    }

    public Element getMidE() {

        Element current = firstElement;

        if (listLeght == 2) {
            return firstElement;
        } else {

            if (listLeght % 2 == 0) {

                for (int i = -1; i < listLeght / 2; i++) {

                    current = current.getNextE();

                }
            } else {
                for (int i = 0; i < listLeght / 2; i++) {

                    current = current.getNextE();

                }
            }

        }

        return current;

    }

    public Element getLastE() {

        Element current = firstElement;

        for (int i = 0; i < listLeght - 1; i++) {

            current = current.getNextE();

        }

        return current;

    }

    public void loadOpsFile() throws IOException {

        File fIn = new File("data/in_turing.txt");
        FileReader fr = new FileReader(fIn);
        BufferedReader br = new BufferedReader(fr);

        String opsS = null;
        do {

            opsS = br.readLine();

            // System.out.println(opsS);
            if (opsS != null) {

                runLineOp(opsS);

            }

        } while (opsS != null);

        br.close();

        pw.close();

        // Element current = firstElement;
        // while (current != null) {

        // System.out.print(current.getL());
        // current = current.getNextE();

        // }

    }

    public void runLineOp(String opsS) throws IOException {

        char[] ops = opsS.toCharArray();

        for (int i = 0; i < ops.length; i++) {

            switch (ops[i]) {

                case '0':// cabeza 0

                    switch (ops[i + 1]) {

                        case '0':// Escribir en el archivo

                            writeOnFile(0);
                            i = i + 1;

                            break;

                        case '1': // cargar desde el archivo

                            System.out.println(ops[i + 2]);
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
                            // System.out.println(ops[i + 2]);

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

    }

    public void readFromFile(int headN, char l) {

        if (firstElement == null) {
            firstElement = new Element(l);
            c0 = firstElement;
            c1 = firstElement;
            c2 = firstElement;
            // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
            // c2.getL());

            listLeght++;
        } else {

            Element newE = new Element(l);

            switch (headN) {

                case 0:
                    listLeght++;
                    Element currentc0 = firstElement;
                    firstElement = newE;
                    firstElement.setNextE(currentc0);
                    firstElement.getNextE().setPrevE(firstElement);
                    c0 = firstElement;
                    c1 = getMidE();
                    c2 = getLastE();
                    // System.out.println("c0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    Element currenta = firstElement;
                    while (currenta != null) {

                        System.out.print(currenta.getL());
                        currenta = currenta.getNextE();

                    }
                    break;

                case 1:

                    if (listLeght == 0) {
                        firstElement = newE;
                        c0 = firstElement;
                        c1 = firstElement;
                        c2 = firstElement;
                    } else if (listLeght == 1) {
                        c0.setNextE(newE);
                        c1 = c0.getNextE();
                        c1.setPrevE(c0);
                        listLeght++;
                        c2 = getLastE();
                        // System.out.println("\n1c0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                        // c2.getL());

                    } else {
                        Element currentc1 = c1;

                        c1 = newE;
                        c1.setPrevE(currentc1);
                        c1.setNextE(currentc1.getNextE());
                        c1.getPrevE().setNextE(c1);
                        c1.getNextE().setPrevE(c1);
                        listLeght++;

                        c1 = getMidE();
                        c2 = getLastE();
                        // System.out.println("\n2c0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                        // c2.getL());

                    }

                    // Element currentb = firstElement;
                    // while (currentb != null) {

                    // System.out.print(currentb.getL());
                    // currentb = currentb.getNextE();

                    // }

                    break;

                case 2:
                    Element currentc2 = c2;
                    // System.out.println(currentc1.getL());
                    listLeght++;
                    c2.setNextE(newE);
                    ;
                    c2 = getLastE();
                    c2.setPrevE(currentc2);

                    // System.out.println(getMidE());

                    c1 = getMidE();

                    // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    // Element currentc = firstElement;
                    // while (currentc != null) {

                    // System.out.print(currentc.getL());
                    // currentc = currentc.getNextE();

                    // }
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

            // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
            // c2.getL());

            // Element currentc = firstElement;
            // while (currentc != null) {

            // System.out.print(currentc.getL());
            // currentc = currentc.getNextE();

            // }
        } else {
            switch (headN) {
                case 0:
                    listLeght--;

                    firstElement = firstElement.getNextE();
                    firstElement.setPrevE(null);
                    if (firstElement.getNextE() != null) {
                        firstElement.getNextE().setPrevE(firstElement);
                    }

                    c0 = firstElement;
                    c1 = getMidE();
                    c2 = getLastE();

                    // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    // Element currentca = firstElement;
                    // while (currentca != null) {

                    // System.out.print(currentca.getL());
                    // currentca = currentca.getNextE();

                    // }
                    break;

                case 1:
                    listLeght--;

                    c1.getPrevE().setNextE(c1.getNextE());
                    c1.getNextE().setPrevE(c1.getPrevE());
                    c1 = getMidE();
                    c2 = getLastE();

                    // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    // Element currentcb = firstElement;
                    // while (currentcb != null) {

                    // System.out.print(currentcb.getL());
                    // currentcb= currentcb.getNextE();

                    // }
                    break;
                case 2:
                    listLeght--;

                    c2 = c2.getPrevE();
                    c2.setNextE(null);

                    c1 = getMidE();

                    // System.out.println("\nc0= " + c0.getL() + " c1= " + c1.getL() + " c2= " +
                    // c2.getL());

                    // Element currentcn = firstElement;
                    // while (currentcn != null) {

                    // System.out.print(currentcn.getL());
                    // currentcn = currentcn.getNextE();

                    // }
                    break;
            }
        }

    }

}