package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private int edellinen;
    
 
    public void plus(int luku) {
        tulos += luku;
        this.edellinen = luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
        this.edellinen = luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }

    public int edellinen() {
        return edellinen;
    }
}