/*
 * ~~~ erstmal fertig ~~~
 * 
 * 
 */
package server;

/**
 *
 * @author Tim Meyer
 */
public class BenutzerException extends Exception {

    private final String message;
        
    public BenutzerException(String message) {
        this.message = message;
    }
        
    @Override
    public String getMessage(){
        return message;
    }
    
}
