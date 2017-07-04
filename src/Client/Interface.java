/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Tim Meyer
 */
public interface Interface extends Remote {
    public String getUsername() throws RemoteException;
    public String getPasswort() throws RemoteException;
    public String getNachname() throws RemoteException;
    public String getVorname() throws RemoteException;
    public String getEmail() throws RemoteException;

    public void setNachname(String nachname) throws RemoteException;
    public void setVorname(String nachname) throws RemoteException;
    public void setEmail(String nachname) throws RemoteException;
    public void setPasswort(String nachname) throws RemoteException;
}
