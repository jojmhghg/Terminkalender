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
class Anfrage {
    Termin termin;
    String absender;
    
    Anfrage(Termin termin, String absender){
        this.termin = termin;
        this.absender = absender;
    }
}
