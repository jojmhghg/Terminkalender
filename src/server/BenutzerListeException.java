/*
 * 
 */
package server;

/**
 *
 * @author edwrard
 */
public class BenutzerListeException extends Exception {
    private final String message;
        
    public BenutzerListeException(String message) {
        this.message = message;
    }
        
    @Override
    public String getMessage(){
        return message;
    }
}
