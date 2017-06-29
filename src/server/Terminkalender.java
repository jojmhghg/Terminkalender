/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.LinkedList;

/**
 *
 * @author Tim Meyer
 */
public class Terminkalender {

    private final LinkedList<Termin> terminkalender;
    
    Terminkalender(){
        terminkalender = new LinkedList<>();
    }
    
    /**
     * fügt dem Terminkalender einen Termin hinzu
     * 
     * @param termin 
     */
    public void addTermin(Termin termin){
        terminkalender.add(termin);
    }
    
    /**
     * gibt alle Termine im Monat 'monat' in LinkedList zurück
     * 
     * @param monat
     * @return 
     */
    public LinkedList<Termin> getTermineImMonat(Monat monat){
        LinkedList<Termin> monatsauszug = new LinkedList<>();
        
        for(Termin termin : terminkalender){
            if(termin.getDatum().getMonat() == monat.getWert()){
                monatsauszug.add(termin);
            }
        }
        
        return monatsauszug;
    }
    
    /**
     * gibt alle Termine der übergebenen Kalenderwoche in LinkedList zurück
     * 
     * @param kalenderwoche
     * @return 
     */
    public LinkedList<Termin> getTermineInWoche(int kalenderwoche){
        LinkedList<Termin> wochenauszug = new LinkedList<>();
        
        for(Termin termin : terminkalender){
            if(termin.getDatum().getKalenderwoche() == kalenderwoche){
                wochenauszug.add(termin);
            }
        }
        
        return wochenauszug;
    }
}
