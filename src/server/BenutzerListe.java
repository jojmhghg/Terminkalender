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
public class BenutzerListe {
    
    private final LinkedList<Benutzer> benutzerliste;
    
    BenutzerListe(){
        benutzerliste = new LinkedList<>();
    }
    
    /**
     * fügt der Benutzerliste einen Benutzer hinzu
     * 
     * @param username
     * @param passwort
     * @param email
     * @throws server.BenutzerException 
     */
    public void addBenutzer(String username, String passwort, String email) throws BenutzerException{
        if(existiertBenutzer(username)){
            //TODO: teste ob username in benutzerliste vorhanden ist, wenn ja: werfe Fehler
        }
        //TODO: teste ob email in benutzerliste vorhanden ist, wenn ja: werfe Fehler
        benutzerliste.add(new Benutzer(username, passwort, email));
    }
    
    public boolean existiertBenutzer(String username){
        boolean result = false;
        for(Benutzer benutzer : benutzerliste){
            if(benutzer.getUsername().equals(username)){
                result = true;
            }
        }
        
        return result;
    }
    
    /**
     * 
     * @param username
     * @return 
     * @throws server.BenutzerException 
     */
    public Benutzer getBenutzer(String username) throws BenutzerException{
        Benutzer result = null;        
        if(!existiertBenutzer(username)){
            throw new BenutzerException(username + " existiert nicht!");
        }
        for(Benutzer benutzer : benutzerliste){
            if(benutzer.getUsername().equals(username)){
                result = benutzer;
            }
        }
        return result;
    }
    
}

