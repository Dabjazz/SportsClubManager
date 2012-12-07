/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import server.corba.CorbaServer;
import server.rmi.RmiServer;

/**
 @author Thomas
 */
public class Server
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
            throws IOException
    {
        // start rmi-server-thread 
        RmiServer rmiServer = new RmiServer(1099);
        new Thread(rmiServer).start();

        // start corba-server-thread
        CorbaServer corbaServer = new CorbaServer();
        new Thread(corbaServer).start();
    }
}
