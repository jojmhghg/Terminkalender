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
    
    public void addTermin(Termin termin){
        terminkalender.add(termin);
    }
    
    public LinkedList<Termin> getTermineImMonat(String monat){
        return terminkalender;
    }
}
