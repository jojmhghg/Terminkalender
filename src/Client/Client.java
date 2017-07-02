/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;


/**
 *
 * @author Tim Meyer
 */
public class Client {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Standart-IP-Adresse */
        String ip_addr = "localhost";
        if ((args.length > 2)){
            System.err.println("java -jar client.jar <Server-IP-Adresse>");
        }
        else{
            /* falls IP-Adresse übergeben wurde, wird diese gesetzt */
            if(args.length == 1){
                ip_addr = args[0];
            }
            try {
                Registry registry = LocateRegistry.getRegistry(ip_addr);
                Interface stub = (Interface) registry.lookup("Benutzer");
                
                //TODO: hier die Funktionalität des Clients implementieren!
            } 
            catch (NotBoundException | RemoteException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
      
    
}
