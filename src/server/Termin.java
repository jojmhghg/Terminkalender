/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 * 
 * @author Tim Meyer
 */
public class Termin {   
    
    Datum datum;
    Zeit beginn;
    Zeit ende;
    String titel;
    String notiz;
    String ort;
    //User[] teilnehmer;
      
    Termin(Datum datum, Zeit beginn, Zeit ende, String titel){
        this.datum = datum;
        this.beginn = beginn;
        this.ende = ende;
        this.titel = titel;
        this.notiz = "";
        this.ort = "";
    }
    
    //Getter 
    public Datum getDatum(){
        return datum;
    }
    public Zeit getBeginn(){
        return beginn;
    }
    public Zeit getEnde(){
        return ende;
    }
    public String getTitel(){
        return titel;
    }
    public String getNotiz(){
        return notiz;
    }
    public String getOrt(){
        return ort;
    }
    
    // Setter
    public void setNotiz(String notiz){
        this.notiz = notiz;
    }
    
    public void setOrt(String ort){
        this.ort = ort;
    }
    
}


