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
        //TODO: teste ob username in benutzerliste vorhanden ist, wenn ja: werfe Fehler
        //TODO: teste ob email in benutzerliste vorhanden ist, wenn ja: werfe Fehler
        benutzerliste.add(new Benutzer(username, passwort, email));
    }
    
}
