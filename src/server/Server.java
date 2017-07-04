/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.hilfsklassen.Monat;
import server.hilfsklassen.Datum;

/**
 *
 * @author Tim Meyer
 */
public class Server {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Datum test = new Datum(29, Monat.Juni, 2017);
            System.out.println(test.getKalenderwoche());
        } catch (Datum.DatumException e) {
            System.err.println(e.getMessage());
        }
    }      
    
}
