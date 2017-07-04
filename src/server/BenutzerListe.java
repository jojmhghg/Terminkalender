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
    private Benutzer eingeloggterBenutzer;
    private boolean eingeloggt;
    
    BenutzerListe(){
        benutzerliste = new LinkedList<>();
        eingeloggt = false;
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
        if(usernameAlreadyUsed(username)){
            throw new BenutzerException("Username" +username+ "existiert bereits!");
        }
        //TODO: teste ob email in benutzerliste vorhanden ist, wenn ja: werfe Fehler
        benutzerliste.add(new Benutzer(username, passwort, email));
    }
    
    /**
     * gibt Benutzer zu übergebenen username zurück oder wirft Fehler falls
     * dieser nicht vorhanden ist
     * 
     * @param username
     * @param passwort
     * @throws BenutzerException 
     */
    public void einloggen(String username, String passwort) throws BenutzerException{
        Benutzer gesuchterBenutzer = null; /* sobald TODO's implementiert: '= null' entfernen */
        //TODO: teste ob username in benutzerliste, wenn nein: werfe Fehler, wenn ja: gesuchterBenutzer = gefundener Benutzer aus der Liste
        //TODO: teste ob passwort mit dem passwort des benutzers aus der Liste übereinstimmt, wenn nein: werfe Fehler
        eingeloggterBenutzer = gesuchterBenutzer;
        eingeloggt = true;
    }
    
    /**
     * 
     * @return
     * @throws BenutzerException 
     */
    public Benutzer getEingeloggterBenutzer() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer;
    }
    
    /**
     * Testet ob als Argument übergebener username bereits existiert
     * 
     * @param username
     * @return 
     */
    public boolean usernameAlreadyUsed(String username) {
        
        //TODO: impl. einer Funktion um zu schauen ob username schon existiert
        try{
            return username.equals(getBenutzer(username).getUsername());
        }catch (BenutzerException e){
            return false;
        }
    }
    
}
