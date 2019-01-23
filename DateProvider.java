/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

/**
 *
 * @author dorian
 */
public class DateProvider implements Serializable, IDateProvider {

    public static String url = "rmi://localhost/date";
    private static final long serialVersionUID = 2342323442243234L;

    public DateProvider() {

    }

    @Override
    public Date getDate() throws RemoteException {
        return new Date();
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind(url, new DateProvider());
        System.out.println("Registry Gestartet und Objekt exportiert.");
        //Läuft im Hintergrund weiter...
        try {
            synchronized (reg) {
                reg.wait();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
