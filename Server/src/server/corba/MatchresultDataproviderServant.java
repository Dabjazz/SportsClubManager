/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.corba;

import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.dto.ITypeOfSportDto;
import contract.dto.ILeagueDto;
import contract.dto.IMatchDto;
import contract.dto.ICompetitionDto;
import contract.dto.IMatchresultDto;
import java.rmi.RemoteException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import org.omg.CORBA.ORB;
import server.corba.generated.*;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
public class MatchresultDataproviderServant
        extends MatchresultDataproviderPOA
{
    private ORB orb;
    private DtoFactory dtoFactory = new DtoFactory();

    public void setORB(ORB orb_val)
    {
        orb = orb_val;
    }

    @Override
    public MatchresultListCorba getMatchresults(String typeOfSport, String league, String competitiondate)
    {
        try
        {
            List<MatchresultCorba> results = new LinkedList<>();

            ITypeOfSportDto t = dtoFactory.getTypeOfSportMapper().getByName(typeOfSport);

            ILeagueDto l = dtoFactory.getLeagueMapper().getByName(league, t);

            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(competitiondate);

            for (ICompetitionDto competition : l.getCompetitionList(date))
            {
                for (int matchId : competition.getMatchList())
                {
                    IMatchDto match = dtoFactory.getMatchMapper().getById(matchId);
                    IMatchresultDto matchresult = match.getMatchresult();

                    results.add(new MatchresultCorba(matchresult.getId(), match.getDateFrom().toString(), match.getHometeam().getName(), match.getForeignteam().getName(), matchresult.getPointsHometeam(), matchresult.getPointsForeignteam()));
                }
            }

            return new MatchresultListCorba((MatchresultCorba[]) results.toArray());
        }
        catch (NotFoundException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean isMatchresultFinal(MatchresultCorba matchresult)
    {
        try
        {
            IMatchresultDto m = dtoFactory.getMatchresultMapper().getById(matchresult.Id);

            return m.IsFinal();
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void shutdown()
    {
        orb.shutdown(false);
    }
}
