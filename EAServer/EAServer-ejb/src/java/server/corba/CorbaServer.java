/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.corba;

import java.io.IOException;
import java.util.logging.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.*;
import server.corba.generated.*;

/**
 @author Thomas
 */
public class CorbaServer
        implements Runnable
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new Thread(new CorbaServer()).start();
    }

    @Override
    public void run()
    {
        try
        {
            Runtime.getRuntime().exec("orbd -ORBInitialPort 2050");
            String[] args1 = new String[]
            {
                "-ORBInitialPort", "2050"
            };

            ORB orb = ORB.init(args1, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            MatchresultDataproviderServant helloServant = new MatchresultDataproviderServant();
            helloServant.setORB(orb);
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloServant);
            MatchresultDataprovider href = MatchresultDataproviderHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent cosName[] = ncRef.to_name("HelloObject");
            ncRef.rebind(cosName, href);
            System.out.println("Corba Server ready and waiting");
            orb.run();
        }
        catch (IOException ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (IOException ex)
//        {
//            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
        catch (NotFound ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (CannotProceed ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ServantNotActive ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (WrongPolicy ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (AdapterInactive ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InvalidName ex)
        {
            Logger.getLogger(CorbaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
