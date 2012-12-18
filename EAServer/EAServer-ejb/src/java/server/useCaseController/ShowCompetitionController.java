/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.IShowCompetitionController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        List<ICompetitionDto> list = new LinkedList<ICompetitionDto>();
        try
        {
            list =  dtoFactory.getCompetitionMapper().getAll();
        }
        catch(NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches)
    {
        List<IMatchDto> matchList = new ArrayList<IMatchDto>();

        try
        {
            for (Integer id : matches)
            {
                matchList.add(dtoFactory.getMatchMapper().getById(id));
            }
        }
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team)
    {
        List<IPlayerDto> playerList = new ArrayList<IPlayerDto>();

        try
        {
            for (Integer playerID : team.getPlayerList())
            {
                playerList.add(dtoFactory.getPlayerMapper().getById(playerID));
            }
        }
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
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
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
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
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
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
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
