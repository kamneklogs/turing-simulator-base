package model;

public class Element {

    private Element nextE, prevE;

    private char l;

    public Element(char l) {

        this.l = l;

    }

    public Element getNextE() {
        return nextE;
    }

    public void setNextE(Element nextE) {
        this.nextE = nextE;
    }

    public Element getPrevE() {
        return prevE;
    }

    public void setPrevE(Element prevE) {
        this.prevE = prevE;
    }

    public char getL() {
        return l;
    }

    public void setL(char l) {
        this.l = l;
    }

}