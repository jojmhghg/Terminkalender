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
public class Zeit {
    int stunde;
    int minute;
    
    Zeit(int stunde, int minute) throws ZeitException{
        if(stunde > 23 || stunde < 0){
            throw new ZeitException("Stunde zwischen 0 und 23 wählen");
        }
        this.stunde = stunde;
      
        if(minute > 59 || minute < 0){
            throw new ZeitException("Minute zwischen 0 und 59 wählen");
        }
        this.minute = minute;
    }

    private static class ZeitException extends Exception {
        
        String message;
        
        public ZeitException(String message) {
            this.message = message;
        }
        
        @Override
        public String getMessage(){
            return message;
        }
    }
}
