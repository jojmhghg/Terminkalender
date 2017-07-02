/*
 * TODO: alles mit todo markiert + Metoden für getTermineImMonat & getTermineInWoche
 * implementieren
 * 
 */
package server;

import java.util.LinkedList;

/**
 *
 * @author Tim Meyer
 */
public class Benutzer {
    
    private final String username;
    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
    private Terminkalender terminkalender;
    //TODO Liste für offene Anfragen
    private LinkedList<String> Kontaktliste; 
    //TODO Meldungen
    
    /**
     * Konstruktor der Klasse Benutzer
     * 
     * @param username
     * @param passwort
     * @throws server.Benutzer.BenutzerException 
     */
    Benutzer(String username, String passwort) throws BenutzerException{
        if(username.length() < 4 || username.length() > 12){
            throw new BenutzerException("Der Username sollte zwischen 4 und 12 Zeichen lang sein");
        }
        if(passwort.length() < 4 || passwort.length() > 12){
            throw new BenutzerException("Das Passwort sollte zwischen 4 und 12 Zeichen lang sein");
        }
        
        this.username = username;
        this.passwort = passwort;
        this.nachname = "";
        this.vorname = "";
        this.email = "";
        this.terminkalender = new Terminkalender();
    } 
    
    //Getter:
    public String getUsername(){
        return username;
    }
    public String getPasswort(){
        return passwort;
    }
    public String getNachname(){
        return nachname;
    }
    public String getVorname(){
        return vorname;
    }
    public String getEmail(){
        return email;
    }
    
    //Setter:
    public void setNachname(String nachname){
        this.nachname = nachname;
    }
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPasswort(String neuesPasswort) throws BenutzerException{
        if(passwort.length() < 4 || passwort.length() > 12){
            throw new BenutzerException("Das Passwort sollte zwischen 4 und 12 Zeichen lang sein");
        }
        this.passwort = neuesPasswort;
    }
    
    /**
     * fügt Terminkalender einen Termin hinzu
     * 
     * @param termin 
     * @throws server.TerminException 
     */
    public void addTermin(Termin termin) throws TerminException{
        terminkalender.addTermin(termin);
    }
       
}
