package server.utils;

import contract.domain.CouldNotFetchException;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;
import server.domain.classes.Competition;
import server.domain.classes.League;
import server.domain.classes.Member;
import server.domain.classes.TypeOfSport;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class HibernateTestDatabase
{

    private static final String CLASSENDING = ".class";
    private static final String EMPTYSTRING = "";
    private static final String METHODBEGINNING = "get";
    private static final String PACKAGENAME = "server.domain.classes";

    public void runGetterTest()
    {
        try
        {
            Class[] classes = getAllClasses();
            for (Class clazz : classes)
            {
                System.out.println("-------------------------");
                System.out.println(clazz.toString());
                System.out.println("-------------------------");
                for (Object obj : DomainFacade.getInstance().getAll(clazz))
                {
                    iterateGetMethodsOfObject(obj);
                }
            }
        } catch (ClassNotFoundException ex)
        {
        } catch (CouldNotFetchException ex)
        {
            Logger.getLogger(HibernateTestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runQueryTests()
    {
        try
        {
            System.out.println("getAll");
            TypeOfSport sport = DomainFacade.getInstance().getAll(TypeOfSport.class).get(0);

            System.out.println("getByName");
            League l = DomainFacade.getInstance().getByName(League.class, "Handballliga");

            System.out.println("getClubTeamsByTypeOfSport");
            DomainFacade.getInstance().getClubTeamsByTypeOfSport(sport);

            System.out.println("getDepartmentsBySport");
            DomainFacade.getInstance().getDepartmentsBySport(sport);

            System.out.println("getLeagueByNameAndTypeOfSport");
            DomainFacade.getInstance().getLeageByNameAndTypeOfSport(sport, l.getName());

            System.out.println("getCompetitionsByDate");
            DomainFacade.getInstance().getCompetitionsByDate(new Date(), new Date(1387584000));

            System.out.println("getMemberByName");
            Member memberByName = DomainFacade.getInstance().getMemberByName("Markus", "Mohanty");

            System.out.println("getMemberByUsername");
            DomainFacade.getInstance().getMemberByUsername("mmo7528");

            System.out.println("getAll");
            Competition competition = DomainFacade.getInstance().getAll(Competition.class).get(0);

            System.out.println("getMatchesByCompetition");
            DomainFacade.getInstance().getMatchesByCompetition(competition);

        } catch (CouldNotFetchException ex)
        {
            Logger.getLogger(HibernateTestDatabase.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public Class[] getAllClasses() throws ClassNotFoundException
    {
        ArrayList<Class> classes = new ArrayList<Class>();
        try
        {
            File dir = new File(Thread.currentThread().getContextClassLoader().getResource(PACKAGENAME.replaceAll("\\.", "/")).getFile());
            if (dir.exists())
            {
                String[] files = dir.list();
                for (String s : files)
                {
                    if (s.endsWith(CLASSENDING))
                    {
                        String classname = s.replace(CLASSENDING, EMPTYSTRING);
                        classes.add(Class.forName(PACKAGENAME + "." + classname));
                    }
                }
            }
            return classes.toArray(new Class[classes.size()]);
        } catch (NullPointerException ex)
        {
            throw new ClassNotFoundException(PACKAGENAME, ex);
        }
    }

    public void iterateGetMethodsOfObject(Object obj) throws ClassNotFoundException
    {
        try
        {
            Method[] methods = obj.getClass().getMethods();
            for (Method m : methods)
            {
                if (m.getName().startsWith(METHODBEGINNING))
                {
                    m.invoke(obj);
                }
            }
        } catch (IllegalAccessException ex)
        {
            Logger.getLogger(HibernateTestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex)
        {
            Logger.getLogger(HibernateTestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex)
        {
            Logger.getLogger(HibernateTestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
