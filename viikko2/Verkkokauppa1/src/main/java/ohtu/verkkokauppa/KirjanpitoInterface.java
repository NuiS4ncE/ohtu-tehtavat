package ohtu.verkkokauppa;

public interface KirjanpitoInterface {
    
    public void lisaaTapahtuma(String tapahtuma);
    public ArrayList<String> getTapahtumat();
}