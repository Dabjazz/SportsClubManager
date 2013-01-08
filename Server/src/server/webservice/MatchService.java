/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.webservice;

import contract.dto.*;
import contract.dto.mapper.*;
import java.rmi.RemoteException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.jws.WebService;
import server.corba.MatchresultDataproviderServant;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
@WebService(name = "MatchSvc")
public class MatchService
{
    public List<MatchresultWs> getMatches(String competitiondate, String league, String typeOfSport)
    {
        try
        {
            DtoFactory dtoFactory = new DtoFactory();

            List<MatchresultWs> results = new LinkedList<>();

            ITypeOfSportDto t = dtoFactory.getTypeOfSportMapper().getByName(typeOfSport);

            ILeagueDto l = dtoFactory.getLeagueMapper().getByName(league, t);

            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(competitiondate);

            for (ICompetitionDto competition : l.getCompetitionsByDate(date))
            {
                for (int matchId : competition.getMatchList())
                {
                    IMatchDto match = dtoFactory.getMatchMapper().getById(matchId);
                    IMatchresultDto matchresult = dtoFactory.getMatchresultMapper().getById(match.getMatchresult());
                    ITeamDto hTeam = dtoFactory.getTeamMapper().getById(match.getHometeam());
                    ITeamDto fTeam = dtoFactory.getTeamMapper().getById(match.getForeignteam());

                    results.add(new MatchresultWs(matchresult.getId(), match.getDateFrom(), hTeam.getName(), fTeam.getName(), matchresult.getPointsHometeam(), matchresult.getPointsForeignteam()));
                }
            }

            return results;
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
}