/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.INewCompetitionController;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 @author EnjoX
 */
public class NewCompetitionController
        implements INewCompetitionController
{
    private static INewCompetitionController INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    public static INewCompetitionController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new NewCompetitionController();
        }
        return INSTANCE;
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member)
    {
        try
        {
            List<IDepartmentDto> departmentList = dtoFactory.getDepartmentMapper().getAll();
            for (IDepartmentDto dep : departmentList)
            {
                List<Integer> sportList = dep.getTypeOfSportList();
                for (Integer sportId : sportList)
                {
                    if (sportId == competition.getSport())
                    {
                        List<Integer> userRolesIds = member.getRoleList();
                        for (Integer role : userRolesIds)
                        {
                            if (dtoFactory.getRoleMapper().getById(role).getId() == dep.getDepartmentHead())
                            {
                                dtoFactory.getCompetitionMapper().set(competition);
                            }
                        }
                    }
                }
            }
        }
        catch (RemoteException | IdNotFoundException | NotFoundException ex)
        {
            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITeamDto> getTeams(ITypeOfSportDto sport)
    {
        try
        {
            List<ILeagueDto> leagueList = dtoFactory.getLeagueMapper().getAll();
            List<ITeamDto> teamList = new ArrayList<>();

            for (ILeagueDto l : leagueList)
            {
                if (l.getTypeOfSport().equals(sport))
                {
                    for (Integer id : l.getTeamList())
                    {
                        try
                        {
                            teamList.add(dtoFactory.getTeamMapper().getById(id));
                        }
                        catch (IdNotFoundException ex)
                        {
                            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            return teamList;

        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        //RoleMapper
        List<IRoleDto> roleList = new ArrayList<>();
        try
        {
            IMemberDto member = dtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList())
            {
                roleList.add(dtoFactory.getRoleMapper().getById(role));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(Integer memberId)
    {
        IAdminDto admin = null;

        try
        {
            IMemberDto member = dtoFactory.getMemberMapper().getById(memberId);

            for (Integer role : member.getRoleList())
            {
                IRoleDto r = dtoFactory.getRoleMapper().getById(role);

                if (r instanceof IDepartmentHeadDto)
                {
                    return findTypeOfSport((IDepartmentHeadDto) r);
                }
                else if (r instanceof IAdminDto)
                {
                    admin = (IAdminDto) r;
                }
            }

            if (admin != null)
            {
                return dtoFactory.getTypeOfSportMapper().getAll();
            }
        }
        catch (RemoteException | IdNotFoundException | NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return new ArrayList<>();
    }

    private List<ITypeOfSportDto> findTypeOfSport(IDepartmentHeadDto depHead) throws RemoteException, IdNotFoundException
    {
        HashMap<Integer, IDepartmentDto> departmentList = new HashMap<Integer, IDepartmentDto>();

        for (Integer id : depHead.getDepartmentList())
        {
            try
            {
                IDepartmentDto d = dtoFactory.getDepartmentMapper().getById(id);

                if (departmentList.containsKey(d.getId()))
                {
                    continue;
                }

                departmentList.put(d.getId(), d);
            }
            catch (RemoteException | IdNotFoundException ex)
            {
                Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<ITypeOfSportDto> sportList = new LinkedList<ITypeOfSportDto>();

        for (IDepartmentDto d : departmentList.values())
        {
            List<Integer> sportIDs = d.getTypeOfSportList();

            for (Integer i : sportIDs)
            {
                sportList.add(dtoFactory.getTypeOfSportMapper().getById(i));
            }
        }

        return sportList;
    }
}
