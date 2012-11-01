/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dndhelpermk2.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaligor
 */
public class getIP {

    public List<String> getLocalHostAddresses() {

        List<String> addresses = new ArrayList<String>();

        try {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface ni = e.nextElement();
                Enumeration<InetAddress> e2 = ni.getInetAddresses();
                while (e2.hasMoreElements()) {
                    addresses.add(e2.nextElement().getHostAddress());
                }
            }
            URL u = new URL("http://whatismyip.org");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    u.openStream()));
            addresses.add(in.readLine());
            in.close();
        } catch (Exception ignore) {
            System.out.println("Something went wrong");
        }

        return addresses;
    }

    public InetAddress getLocalIP() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
        }
        return null;
    }
}
