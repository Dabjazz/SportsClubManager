/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IShowCompetitionController;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 @author EnjoX
 */
public class ShowCompetitionController
        implements IShowCompetitionController
{
    private static ShowCompetitionController INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    private ShowCompetitionController()
    {
    }

    public static IShowCompetitionController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ShowCompetitionController();
        }
        return INSTANCE;
    }

    @Override
    public List<ICompetitionDto> getCompetitions()
    {
        try
        {
            return dtoFactory.getCompetitionMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(ShowCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches)
    {
        List<IMatchDto> matchList = new ArrayList<>();

        try
        {
            for (Integer id : matches)
            {
                matchList.add(dtoFactory.getMatchMapper().getById(id));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ShowCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team)
    {
        List<IPlayerDto> playerList = new ArrayList<>();

        try
        {
            for (Integer playerID : team.getPlayerList())
            {
                playerList.add(dtoFactory.getPlayerMapper().getById(playerID));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
        }
        return playerList;
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        try
        {
            return dtoFactory.getTeamMapper().getById(hometeam);
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IClubTeamDto getClubTeam(Integer hometeam)
    {
        try
        {
            return dtoFactory.getClubTeamMapper().getById(hometeam);
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IMatchresultDto getMatchresult(Integer matchresult)
    {
        try
        {
            return dtoFactory.getMatchresultMapper().getById(matchresult);
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
