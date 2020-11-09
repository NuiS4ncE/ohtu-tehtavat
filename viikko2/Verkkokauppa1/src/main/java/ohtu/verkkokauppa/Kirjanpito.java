package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Kirjanpito implements KirjanpitoInterface{

    
    private ArrayList<String> tapahtumat;

    @Autowired
    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
