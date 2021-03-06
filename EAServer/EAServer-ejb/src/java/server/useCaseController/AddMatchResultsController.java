/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IAddMatchResultsController;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 *
 * @author EnjoX
 */
public class AddMatchResultsController
        implements IAddMatchResultsController
{

    private static AddMatchResultsController singleton = null;
    DtoFactory access = new DtoFactory();

    private AddMatchResultsController()
    {
    }

    public static AddMatchResultsController getInstance()
    {
        if (singleton == null)
        {
            singleton = new AddMatchResultsController();
        }
        return singleton;
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        try
        {
            return access.getCompetitionMapper().getAll();

        } catch (NotFoundException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LinkedList<ICompetitionDto>();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {

        List<ITeamDto> teamList = new ArrayList<ITeamDto>();
        try
        {
            for (Integer id : team)
            {

                teamList.add(access.getTeamMapper().getById(id));

            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {

        List<IMatchDto> matchList = new ArrayList<IMatchDto>();

        try
        {
            for (Integer id : match)
            {
                matchList.add(access.getMatchMapper().getById(id));
            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {

        Integer matchresultId = access.getMatchresultMapper().set(matchresult);
        match.setMatchresult(matchresultId);
        access.getMatchMapper().set(match);

    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        try
        {
            return access.getTeamMapper().getById(hometeam);
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMatchResultsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        //RoleMapper
        List<IRoleDto> roleList = new ArrayList<IRoleDto>();
        try
        {
            IMemberDto member = access.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList())
            {
                roleList.add(access.getRoleMapper().getById(role));
            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }
}
