/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.LinkedList;
import server.hilfsklassen.Datum;
import server.hilfsklassen.Monat;
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
        eingeloggterBenutzer.getTerminkalender().addTermin(datum, beginn, ende, titel, eingeloggterBenutzer.getUsername());
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
     * @param id
     * @param neuesDatum
     * @throws BenutzerException 
     */
    @Override
    public void changeTermindatum(int id, Datum neuesDatum) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setDatum(neuesDatum);
    }
    
    /**
     * 
     * @param id
     * @param neuerBeginn
     * @throws BenutzerException
     * @throws TerminException 
     */
    @Override
    public void changeTerminbeginn(int id, Zeit neuerBeginn) throws BenutzerException, TerminException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setBeginn(neuerBeginn);
    }
    
    /**
     * 
     * @param id
     * @param neuesEnde
     * @throws BenutzerException 
     * @throws server.TerminException 
     */
    @Override
    public void changeTerminende(int id, Zeit neuesEnde) throws BenutzerException, TerminException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setEnde(neuesEnde);
    }
    
    /**
     * 
     * @param id
     * @param neueNotiz
     * @throws BenutzerException 
     */
    @Override
    public void changeTerminnotiz(int id, String neueNotiz) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setNotiz(neueNotiz);
    }
    
    /**
     * 
     * @param id
     * @param neuerTitel
     * @throws BenutzerException 
     */
    @Override
    public void changeTermintitel(int id, String neuerTitel) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setTitel(neuerTitel);
    }
    
    /**
     * 
     * @param id
     * @param neuerOrt
     * @throws BenutzerException 
     */
    @Override
    public void changeTerminort(int id, String neuerOrt) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).setOrt(neuerOrt);
    }
    
    /**
     * 
     * @param id
     * @param username
     * @throws BenutzerException 
     */
    @Override
    public void addTerminteilnehmer(int id, String username) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        if(!benutzerliste.existiertBenutzer(username)){
            throw new BenutzerException("Benutzer: " + username + " exisitert nicht!");
        }
        eingeloggterBenutzer.getTerminkalender().getTerminByID(id).addTeilnehmer(username);
    }
    
    /**
     * 
     * @param altesPW
     * @param neuesPW
     * @throws BenutzerException 
     */
    @Override
    public void changePasswort(String altesPW, String neuesPW) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        if(!eingeloggterBenutzer.istPasswort(altesPW)){
            throw new BenutzerException("altes Passwort war falsch!");
        }
        eingeloggterBenutzer.setPasswort(neuesPW);
    }
    
    /**
     * 
     * @param neuerVorname
     * @throws BenutzerException 
     */
    @Override
    public void changeVorname(String neuerVorname) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.setVorname(neuerVorname);
    }
    
    /**
     * 
     * @param neuerNachname
     * @throws BenutzerException 
     */
    @Override
    public void changeNachname(String neuerNachname) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.setNachname(neuerNachname);
    }
    
    /**
     * 
     * @param neueEmail
     * @throws BenutzerException 
     */
    @Override
    public void changeEmail(String neueEmail) throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        eingeloggterBenutzer.setEmail(neueEmail);
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
     * 
     * @return
     * @throws BenutzerException 
     */
    @Override
    public String getUsername() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getUsername();
    }
    
    /**
     * 
     * @return
     * @throws BenutzerException 
     */
    @Override
    public String getVorname() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getVorname();
    }
    
    /**
     * 
     * @return
     * @throws BenutzerException 
     */
    @Override
    public String getNachname() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getNachname();
    }
    
    /**
     * 
     * @return
     * @throws BenutzerException 
     */
    @Override
    public String getEmail() throws BenutzerException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getEmail();
    }
    
    /**
     * 
     * @param kalenderwoche
     * @param jahr
     * @return
     * @throws BenutzerException
     * @throws TerminException 
     */
    @Override
    public Terminkalender getTermineInKalenderwoche(int kalenderwoche, int jahr) throws BenutzerException, TerminException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getTerminkalender().getTermineInWoche(kalenderwoche, jahr);
    }
    
    /**
     * 
     * @param monat
     * @param jahr
     * @return
     * @throws BenutzerException
     * @throws TerminException 
     */
    @Override
    public Terminkalender getTermineInMonat(Monat monat, int jahr) throws BenutzerException, TerminException{
        if(!eingeloggt){
            throw new BenutzerException("noch nicht eingeloggt");
        }
        return eingeloggterBenutzer.getTerminkalender().getTermineImMonat(monat, jahr);
    }
    
    /**
     * Hilfsmethode um Benutzerliste zu füllen
     * 
     */
    private void ladeBenutzerliste() {
        //TODO: hier wird die Benutzerliste mit den Daten aus der DB gefüllt
    }
}
