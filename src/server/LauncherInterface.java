/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.*;
import java.util.LinkedList;
import server.hilfsklassen.Datum;
import server.hilfsklassen.Zeit;

/**
 *
 * @author Tim Meyer
 */
public interface LauncherInterface extends Remote{
    public void createUser(String username, String passwort, String email) throws RemoteException, BenutzerException;
    public void einloggen(String username, String passwort) throws RemoteException, BenutzerException;
    public void addTermin(Datum datum, Zeit beginn, Zeit ende, String titel) throws RemoteException, BenutzerException, TerminException;
    public void removeTermin(int id) throws RemoteException, BenutzerException;
    public void addKontakt(String username) throws RemoteException, BenutzerException;
    public void removeKontakt(String username) throws BenutzerException, RemoteException;
    public LinkedList<String> getKontakte() throws BenutzerException, RemoteException;

}

