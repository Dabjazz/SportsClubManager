/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.criterion.Restrictions;
import sportsclubmanager.domain.classes.*;
import sportsclubmanager.utils.HibernateUtil;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
public class DomainFacade
{
    /**
     returns all competitions in a time span

     @param from start of time span
     @param to end of time span
     @return all competitions between a timespan given
     */
    public static ArrayList<Competition> getCompetitionsByDate(Date from, Date to)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Competition where dateFrom >= :from and dateTo <= :to");
        query.setParameter("from", from);
        query.setParameter("to", to);
        return (ArrayList<Competition>) query.list();
    }

    /**
     returns a the department of a type of sport

     @param sport the sport the department belongs to
     @return the department of the sport
     */
    public static Department getDepartmentsBySport(TypeOfSport sport)
    {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from DepartmenthasTypeOfSport where typeOfSport = :sport");
//        query.setParameter("sport", sport);
//        DepartmenthasTypeOfSport temp = (DepartmenthasTypeOfSport) query.uniqueResult();
//        return temp.getDepartmentidDepartment();
        throw new NotYetImplementedException("new query to be written");
    }

    /**
     returns all matches of a competition

     @param competition the competition the matches are in
     @return all matches of the competition given
     */
    public static ArrayList<Match> getMatchesByCompetition(Competition competition)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Match where competition = :competition");
        query.setParameter("competition", competition);
        return (ArrayList<Match>) query.list();
    }

    /**
     returns a member with the firstname and lastname

     @param firstname the firstname of the member
     @param lastname the lastname of the member
     @return a member with the firstname and lastname given
     */
    public static Member getMemberByName(String firstname, String lastname)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Member1 where prename = :firstname and lastname = :lastname");
        return (Member) query.uniqueResult();
    }

    /**
     returns a object out of the database by its class with a specific name

     @param <T> the type of class
     @param clazz the class
     @param name name of the object
     @return a object with a name given
     */
    public static <T> T getByName(Class<T> clazz, String name)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (T) session.createCriteria(clazz).add(Restrictions.eq("name", name)).uniqueResult();
    }

    public static <T> void set(T expected)
            throws CouldNotSaveException
    {
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            session.saveOrUpdate(expected);
            t.commit();
        }
        catch (HibernateException ex)
        {
            throw new CouldNotSaveException(ex);
        }
    }

    public static <T> void delete(T expected)
            throws CouldNotDeleteException
    {
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            session.delete(expected);
            t.commit();
        }
        catch (HibernateException ex)
        {
            throw new CouldNotDeleteException(ex);
        }
    }

    public static <T> List<T> getAll(Class<T> clazz)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (List<T>) session.createCriteria(clazz).list();
    }
}
