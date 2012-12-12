/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaclient;

import corbaContract.generated.*;
import java.io.*;
import java.util.logging.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

/**
 @author Thomas
 */
public class CorbaClient
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
            throws IOException, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed
    {
        try
        {

            String[] args1 = new String[]
            {
                "-ORBInitialPort", "2050"
            };
            // create and initialize the ORB
            ORB orb = ORB.init(args1, null);
            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            // resolve the Object Reference in Naming
            MatchresultDataprovider matchresultDataprovider = MatchresultDataproviderHelper.narrow(ncRef.resolve_str("HelloObject"));
            System.out.println("Obtained a handle on server object: " + matchresultDataprovider);

            System.out.println("Insert exit to close the programm");
            System.out.println("Press enter button to start request");

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String command = reader.readLine();

            while (!"exit".equals(command))
            {
                System.out.println("Insert a type of sport:");
                String typeOfSport = reader.readLine();

                System.out.println("Insert a league:");
                String league = reader.readLine();

                System.out.println("Insert a date:");
                String competitiondate = reader.readLine();

                MatchresultListCorba matchresults = matchresultDataprovider.getMatchresults(typeOfSport, league, competitiondate);

                System.out.println();
                System.out.println("Results");

                for (MatchresultCorba matchresult : matchresults.matchresults)
                {
                    System.out.println("-----------------------------------------");
                    System.out.println("Id:\t" + matchresult.Id);
                    System.out.println("Hometeam:\t" + matchresult.hometeam);
                    System.out.println("Points:\t" + matchresult.pointsHometeam);
                    System.out.println("Foreignteam:\t" + matchresult.foreignteam);
                    System.out.println("Points:\t" + matchresult.pointsForeignteam);

                    System.out.println();
                    System.out.println("Is final version:\t " + matchresultDataprovider.isMatchresultFinal(matchresult));
                    System.out.println("-----------------------------------------");
                }

                command = reader.readLine();
            }

            //helloStub.shutdown();
        }
        catch (InvalidName ex)
        {
            Logger.getLogger(CorbaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
