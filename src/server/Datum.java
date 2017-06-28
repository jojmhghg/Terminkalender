/*
 * TODO: Exception-Texte verbessern, evtl Methode um Monat von int zu String umwandeln
 */
package server;

/**
 *
 * @author Tim Meyer
 */
public class Datum {
    private int tag;
    private int monat;
    private int jahr;
    
    Datum(int tag, int monat, int jahr) throws DatumException{
        if(monat > 12 || monat < 1){
            throw new DatumException("Monat " + monat + " existiert nicht!");
        }
        this.monat = monat;
        
        switch(monat % 2){
            case 1:
                if(tag > 31 || tag < 1){
                    throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
                }
                this.tag = tag;
                break;
                
            case 0:
                if(monat == 2 && tag > 29){
                    throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
                }
                if(monat == 2 && !istSchaltjahr(jahr) && tag > 28){
                    throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
                }
                if(tag > 30 || tag < 1){
                    throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
                }
                this.tag = tag;
                break;

            default:
                
                break; 
        }
        this.tag = tag;
        
        this.jahr = jahr;
    }

    public int getTag(){
        return tag;
    }
    
    public int getMonat(){
        return monat;
    }
    
    public int getJahr(){
        return jahr;
    }
    
    private boolean istSchaltjahr(int jahr){
        boolean result = false;
        
        if(jahr % 4 == 0 && jahr % 100 != 0){
            result = true;
        }
        if(jahr % 400 == 0){
            result = true;
        }
        
        return result;
    }
     
    public static class DatumException extends Exception {

        private final String message;
        
        public DatumException(String message) {
            this.message = message;
        }
        
        @Override
        public String getMessage(){
            return message;
        }
    }
}
