/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.*;

/**
 *
 * @author Tim Meyer
 */
public interface LauncherInterface extends Remote{
    
    public void einloggen(String username, String passwort) throws RemoteException;

}

