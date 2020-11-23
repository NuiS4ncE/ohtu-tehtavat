
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    private int kasvatuskoko;                                    // näin paljon isompi kuin vanha
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this.kasvatuskoko = OLETUSKASVATUS;
        taulukonAlustus(KAPASITEETTI);
        alkioidenLkm = 0;
    }

    public int[] taulukonAlustus(int kapasiteetti) {
        taulukko = new int[kapasiteetti];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        return taulukko;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        this.kasvatuskoko = OLETUSKASVATUS;
        taulukonAlustus(kapasiteetti);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if(kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        this.kasvatuskoko = kasvatuskoko;
        taulukonAlustus(kapasiteetti);
    }

    public void lisaa(int luku) {
        if (!kuuluu(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == taulukko.length) {
                int[] taulukkoUusi = new int[taulukko.length + OLETUSKASVATUS];
                kopioiTaulukko(taulukko, taulukkoUusi);
                taulukko = new int[alkioidenLkm + OLETUSKASVATUS];
                kopioiTaulukko(taulukkoUusi, taulukko);
            }
        }
    }

    public boolean kuuluu(int luku) {
        int kuuluuLkm = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                kuuluuLkm++;
            }
        }
        if (kuuluuLkm > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean poista(int luku) {
        boolean loytyi = false;
        int poistoIndeksi = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                loytyi = true;
                poistoIndeksi = i;
                taulukko[i] = 0;
                break;
            }
        }
        if (loytyi) {
            for (int j = poistoIndeksi; j < alkioidenLkm - 1; j++) {
                apu = taulukko[j];
                taulukko[j] = taulukko[j + 1];
                taulukko[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + taulukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += taulukko[i];
                tuotos += ", ";
            }
            tuotos += taulukko[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.mahtavuus(); i++) {
            b.lisaa(a.taulukko[i]);
        }
        return b;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.mahtavuus(); i++) {
            if (a.taulukko[i] != b.taulukko[i]) {
                b.poista(i);
            }
        }
        return b;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.mahtavuus(); i++) {
            b.lisaa(a.taulukko[i]);
        }
        for (int i = 0; i < b.mahtavuus(); i++) {
            a.poista(b.taulukko[i]);
        }
 
        return a;
    }
        
}
