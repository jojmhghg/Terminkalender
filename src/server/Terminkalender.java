/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.hilfsklassen.Zeit;
import server.hilfsklassen.Monat;
import server.hilfsklassen.Datum;
import java.util.LinkedList;

/**
 *
 * @author Tim Meyer
 */
public class Terminkalender {

    private final LinkedList<Termin> terminkalender;
    private int idCounter;
    
    Terminkalender(){
        terminkalender = new LinkedList<>();
        idCounter = 1;
    }
       
    /**
     * TODO
     * 
     * @param datum
     * @param beginn
     * @param ende
     * @param titel
     * @return 
     */
    public Termin getTermin(Datum datum, Zeit beginn, Zeit ende, String titel){
        /*TODO: suche in terminkalender nach dem Termin und gebe ihn dann zurück */ 
        return terminkalender.getFirst(); //muss angepasst werden
    }
    
    /**
     * fügt dem Terminkalender einen Termin hinzu
     * 
     * @param termin 
     * @throws server.TerminException 
     */
    public void addTermin(Termin termin) throws TerminException{
        if(terminBereitsVorhanden(termin)){
            throw new TerminException("Termin existiert bereits!");
        }
        terminkalender.add(termin);
    }
    
    /**
     * gibt alle Termine im Monat 'monat' in LinkedList zurück
     * 
     * @param monat
     * @return 
     * @throws server.TerminException 
     */
    public Terminkalender getTermineImMonat(Monat monat) throws TerminException{
        Terminkalender monatsauszug = new Terminkalender();
        
        for(Termin termin : terminkalender){
            if(termin.getDatum().getMonat() == monat.getWert()){
                monatsauszug.addTermin(termin);
            }
        }
        
        return monatsauszug;
    }
    
    /**
     * gibt alle Termine der übergebenen Kalenderwoche in LinkedList zurück
     * 
     * @param kalenderwoche
     * @return 
     * @throws server.TerminException 
     */
    public Terminkalender getTermineInWoche(int kalenderwoche) throws TerminException{
        Terminkalender wochenauszug = new Terminkalender();
        
        for(Termin termin : terminkalender){
            if(termin.getDatum().getKalenderwoche() == kalenderwoche){
                wochenauszug.addTermin(termin);
            }
        }
        
        return wochenauszug;
    }

    /**
     * TODO
     * 
     * @param termin
     * @return 
     */
    private boolean terminBereitsVorhanden(Termin termin){
        /*TODO: teste für alle Elemente von 'terminkalender' ob datum, beginn, 
                ende und titel gleich wie bei 'termin' sind, wenn ja return true */
        return false;
    }
}