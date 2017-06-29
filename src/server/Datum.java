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
    
    Datum(int tag, Monat monat, int jahr) throws DatumException{

        if(!existiertTagInMonat(tag, monat.getWert(), jahr)){
            throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
        }
        this.tag = tag;
        this.monat = monat.getWert();
        this.jahr = jahr;
    }

    //Setter:
    public void setTag(int tag) throws DatumException{
        if(!existiertTagInMonat(tag, monat, jahr)){
            throw new DatumException("Monat " + monat + " hat keinen Tag " + tag);
        }
        this.tag = tag;
    }
    public void setMonat(Monat monat){
        this.monat = monat.getWert();
    }
    public void setJahr(int jahr){
        this.jahr = jahr;
    }
    
    //Getter:
    public int getTag(){
        return tag;
    }    
    public int getMonat(){
        return monat;
    }    
    public int getJahr(){
        return jahr;
    }
    
    /**
     * testet ob übergebener Tag im Monat 'monat' und Jahr 'jahr' existiert
     * 
     * @param tag
     * @param monat
     * @param jahr
     * @return 
     */
    private boolean existiertTagInMonat(int tag, int monat, int jahr){
        switch(monat % 2){
            case 1:
                if(tag > 31 || tag < 1){
                    return false;
                }
                break;
                
            case 0:
                /* Februar mehr als 29 Tage? */
                if(monat == 2 && tag > 29){
                    return false;
                }
                /* Februar mehr als 28 Tage, wenn kein Schaltjahr? */
                if(monat == 2 && !istSchaltjahr(jahr) && tag > 28){
                    return false;
                }
                if(tag > 30 || tag < 1){
                    return false;
                }
                break;

            default:

                break; 
        }
        
        return true;
    }
    
    /**
     * test ob das als Argument übergebene Jahr ein Schaltjahr ist
     * 
     * @param jahr
     * @return 
     */
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
    
    /**
     * Exception-Klasse für Klasse Datum
     */
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
