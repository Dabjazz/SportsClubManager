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
import javax.ejb.Stateless;
import javax.jws.WebService;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
@WebService(name = "MatchSvc")
@Stateless
public class MatchService
{
    public List<MatchresultWs> getMatches(String competitiondate, String league, String typeOfSport)
    {
        try
        {
            DtoFactory dtoFactory = new DtoFactory();

            List<MatchresultWs> results = new LinkedList<MatchresultWs>();

            System.out.println("competitiondate " + competitiondate);
            System.out.println("liga " + league);
            System.out.println("sportart " + typeOfSport);

            ITypeOfSportDto t = dtoFactory.getTypeOfSportMapper().getByName(typeOfSport);

            ILeagueDto l = dtoFactory.getLeagueMapper().getByName(league, t);

            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(competitiondate);

            List<ICompetitionDto> competitions = dtoFactory.getLeagueMapper().getCompetitionsByDate(l, date);

            System.out.println("Competitionscount: " + competitions.size());
            for (ICompetitionDto competition : competitions)
            {
                for (int matchId : competition.getMatchList())
                {
                    IMatchDto match = dtoFactory.getMatchMapper().getById(matchId);
                    IMatchresultDto matchresult = dtoFactory.getMatchresultMapper().getById(match.getMatchresult());

                    System.out.println("match form " + match.getDateFrom() + " to " + match.getDateTo());
                    System.out.println("machtresult: " + matchresult.getPointsHometeam() + ":" + matchresult.getPointsForeignteam());
                    System.out.println("pointshometeam: " + match.getHometeam());
                    System.out.println("pointsforeignteam: " + match.getForeignteam());
                    System.out.println("-----------------------------");
                }
            }

            for (ICompetitionDto competition : competitions)
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
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(MatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(MatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NotFoundException ex)
        {
            Logger.getLogger(MatchService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
