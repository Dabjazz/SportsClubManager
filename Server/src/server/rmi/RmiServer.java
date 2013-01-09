/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.util.logging.*;
import ldap.UserData;
import contract.rmi.IRmiServiceFactory;

/**
 runnable rmi-server

 start it - if possible - in a seperate thread

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServer
        implements Runnable
{
    private final int port;
    private boolean isRunning;

    /**
     RMI server to enable client-server communiation over rmi

     @param port where server runs locally
     */
    public RmiServer(int port)
    {
        this.port = port;
    }

    /**
     starts the rmi-server

     check server after start if it really runs!

     <code>isRunning()
     <code>
     */
    @Override
    public void run()
    {
        try
        {
            // start rmiregistry
            //LocateRegistry.createRegistry(port);
            Runtime.getRuntime().exec("rmiregistry");
            // set the codebase

            String policy = RmiServer.class.getProtectionDomain().getClassLoader().getResource("client.policy").getFile();
            String cb = "file://" + RmiServer.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + IRmiServiceFactory.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + server.rmi.service.LoginRmiService.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + server.dto.mapper.DtoFactory.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + contract.dto.IAddressDto.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + contract.dto.mapper.IMapper.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + contract.dto.classes.AddressDto.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            cb += " file://" + UserData.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            System.setProperty("java.rmi.server.codebase", cb);

//            System.setProperty("java.security.policy", policy);
//            System.setSecurityManager(new SecurityManager());

            IRmiServiceFactory rmiServiceFactory = new RmiServiceClientFactory();
            Naming.rebind("rmi://localhost:" + port + "/CommunicationFactory", rmiServiceFactory);
            isRunning = true;
            System.out.println("rmi server is running on port " + port);
        }
        catch (IOException ex)
        {
            Logger.getLogger(RmiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     check, if rmi-server is running

     @return
     */
    public boolean isRunning()
    {
        return isRunning;
    }
}
