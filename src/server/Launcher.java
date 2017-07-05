/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.LinkedList;
import server.hilfsklassen.Datum;
import server.hilfsklassen.Zeit;

/**
 *
 * @author Tim Meyer
 */
public class Launcher implements LauncherInterface{
    
    private BenutzerListe benutzerliste;
    private Benutzer eingeloggterBenutzer;
    private boolean eingeloggt;
    
    Launcher(){
        ladeBenutzerliste();
        eingeloggt = false;
    }

    /**
     * 
     * @param username
     * @param passwort
     * @param email
     * @throws BenutzerException 
     */
    @Override
    public void createUser(String username, String passwort, String email) throws BenutzerException{
        benutzerliste.addBenutzer(username, passwort, email);
    }
    
    /**
     * gibt Benutzer zu übergebenen username zurück oder wirft Fehler falls
     * dieser nicht vorhanden ist
     * 
     * @param username
     * @param passwort
     * @throws BenutzerException 
     */
    @Override
    public void einloggen(String username, String passwort) throws BenutzerException{
        Benutzer gesuchterBenutzer = null;
        //TODO: teste ob username in benutzerliste, wenn nein: werfe Fehler, wenn ja: gesuchterBenutzer = gefundener Benutzer aus der Liste
        //TODO: teste ob passwort mit dem passwort des benutzers aus der Liste übereinstimmt, wenn nein: werfe Fehler
        eingeloggterBenutzer = gesuchterBenutzer;
        eingeloggt = true;
    }
    
    /**
     * fügt dem eingeloggten Benutzer den Termin mit den übergebenen Parametern hinzu
     * 
     * @param datum
     * @param beginn
     * @param ende
     * @param titel
     * @throws BenutzerException
     * @throws TerminException 
     */
    @Override
    public void addTermin(Datum datum, Zeit beginn, Zeit ende, String titel) throws BenutzerException, TerminException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().addTermin(datum, beginn, ende, titel);
    }
    
    /**
     * entfernt den termin mit angegebener id
     * 
     * @param id
     * @throws BenutzerException 
     */
    @Override
    public void removeTermin(int id) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().removeTerminByID(id);
    }
    
    /**
     * 
     * @param username 
     * @throws server.BenutzerException 
     */
    @Override
    public void addKontakt(String username) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.addKontakt(username);
    }

    /**
     * 
     * @param username
     * @throws BenutzerException 
     */
    @Override
    public void removeKontakt(String username) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.removeKontakt(username);
    }
    
    /**
     *
     * @return
     * @throws BenutzerException
     */
    @Override
    public LinkedList<String> getKontakte() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getKontaktliste();
    }
    
    /**
     * Hilfsmethode um Benutzerliste zu füllen
     * 
     */
    private void ladeBenutzerliste() {
        //TODO: hier wird die Benutzerliste mit den Daten aus der DB gefüllt
    }
}
