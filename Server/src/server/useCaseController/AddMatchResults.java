/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.useCaseController.IAddMatchResults;
import contract.dto.ICompetitionDto;
import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**

 @author EnjoX
 */
public class AddMatchResults
        implements IAddMatchResults
{
    private static AddMatchResults singleton = null;
    DtoFactory access = new DtoFactory();

    private AddMatchResults()
    {
    }

    ;
    
    public static AddMatchResults getInstance()
    {
        if (singleton == null)
        {
            singleton = new AddMatchResults();
        }
        return singleton;
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        try
        {
            return access.getCompetitionMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {

        List<ITeamDto> teamList = new ArrayList<>();
        try
        {
            for (Integer id : team)
            {

                teamList.add(access.getTeamMapper().getById(id));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teamList;
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {

        List<IMatchDto> matchList = new ArrayList<>();

        try
        {
            for (Integer id : match)
            {
                matchList.add(access.getMatchMapper().getById(id));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {
        try
        {
            Integer matchresultId = access.getMatchresultMapper().set(matchresult);
            match.setMatchresult(matchresultId);
            access.getMatchMapper().set(match);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
