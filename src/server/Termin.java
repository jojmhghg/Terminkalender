/*
 * TODO: Methoden zum bearbeiten sind mit TODO markiert
 *          
 * 
 */
package server;

import server.hilfsklassen.Zeit;
import server.hilfsklassen.Datum;
import java.util.LinkedList;

/**
 * 
 * @author Tim Meyer
 */
public class Termin {   
    
    private final int id;
    private Datum datum;
    private Zeit beginn;
    private Zeit ende;
    private String titel;
    private String notiz;
    private String ort;
    private LinkedList<Teilnehmer>teilnehmer;
      
    Termin(Datum datum, Zeit beginn, Zeit ende, String titel, int id) throws TerminException{
        if(!anfangVorEnde(beginn, ende)){
            throw new TerminException("Startzeitpunkt darf nicht nach dem Endzeitpunkt liegen!");
        }
        
        this.id = id;
        this.datum = datum;
        this.beginn = beginn;
        this.ende = ende;
        this.titel = titel;
        this.notiz = "";
        this.ort = "";
        this.teilnehmer = new LinkedList<>();
    }

    /**
     * fügt der Teilnehmerliste 'teilnehmer' den Teilnehmer 'usename' hinzu
     * 
     * @param username 
     */
    public void addTeilnehmer(String username){
        //TODO: teste ob username in teilnehmerliste enthalten, wenn ja: werfe Fehler
        teilnehmer.add(new Teilnehmer(username));
    }
    
    //Getter 
    public int getID(){
        return id;
    }
    public Datum getDatum(){
        return datum;
    }
    public Zeit getBeginn(){
        return beginn;
    }
    public Zeit getEnde(){
        return ende;
    }
    public String getTitel(){
        return titel;
    }
    public String getNotiz(){
        return notiz;
    }
    public String getOrt(){
        return ort;
    }
    public final LinkedList<Teilnehmer> getTeilnehmerliste(){
        return teilnehmer;
    }
    
    // Setter
    public void setNotiz(String notiz){
        this.notiz = notiz;
    }   
    public void setOrt(String ort){
        this.ort = ort;
    }
    public void setTitel(String neuerTitel){
        titel = neuerTitel;
    }
    public void setBeginn(Zeit neuerBeginn) throws TerminException{
        if(!anfangVorEnde(neuerBeginn, ende)){
            throw new TerminException("Startzeitpunkt darf nicht nach dem Endzeitpunkt liegen!");
        }
        beginn = neuerBeginn;
    }
    public void setEnde(Zeit neuesEnde) throws TerminException{
        if(!anfangVorEnde(beginn, neuesEnde)){
            throw new TerminException("Startzeitpunkt darf nicht nach dem Endzeitpunkt liegen!");
        }
        ende = neuesEnde;
    }
    public void setDatum(Datum neuesDatum){
        datum = neuesDatum;
    }
    
    /**
     * 
     * @param beginn
     * @param ende
     * @return 
     */
    private boolean anfangVorEnde(Zeit beginn, Zeit ende){
        //TODO: impl. Funktion die testet ob beginng vor ende ist, dann return true, sonst false
        return true;
    }
    
}


