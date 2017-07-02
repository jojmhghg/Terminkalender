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
     * @param benutzer 
     * @throws server.BenutzerException 
     */
    public void addBenutzer(Benutzer benutzer) throws BenutzerException{
        if(benutzerliste.contains(benutzer.getUsername())){
            throw new BenutzerException("Benutzername existiert bereits");
        }
        benutzerliste.add(benutzer);
        //TODO: Benutzer auf Datei schreiben um ihn so zu speichern!
    }
    
    /**
     * gibt Benutzer zu übergebenen username zurück oder wirft Fehler falls
     * dieser nicht vorhanden ist
     * 
     * @param username
     * @return
     * @throws BenutzerException 
     */
    public Benutzer getBenutzer(String username) throws BenutzerException{
        for(Benutzer user : benutzerliste){
            if(username.equals(user.getUsername())){
                return user;
            }
        }
        throw new BenutzerException("Benutzer '" + username + "' existiert nicht!");
    }
    
    /**
     * füllt Benutzerliste mithilfe einer Datei welche die notwendigen Daten enthält
     * 
     */
    public void fillBenutzerliste(){
        //TODO: impl. Funktion um aus einer Datei die Liste zu füllen
    }
    
}
