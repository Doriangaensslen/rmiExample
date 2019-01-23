/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

/**
 *
 * @author dorian
 */
public class DateClient {

    public static String url = "rmi://localhost/date";

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            IDateProvider date = (IDateProvider) registry.lookup(url);
            System.out.println(date.getDate());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
