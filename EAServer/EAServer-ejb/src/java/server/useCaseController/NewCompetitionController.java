/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.classes.AddressDto;
import contract.dto.classes.CompetitionDto;
import contract.dto.classes.MatchresultDto;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.INewCompetitionController;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 * @author EnjoX
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
    public void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList)
    {
        try
        {

            ICountryDto c = dtoFactory.getCountryMapper().getByName(country.getName());
            Integer countryId = c.getId();
            address.setCountry(countryId);

            ((AddressDto) address).setId(null);
            int addressId = dtoFactory.getAddressMapper().set(address);
            competition.setAddress(addressId); //add address to competition

            ((CompetitionDto) competition).setId(null);
            int competitionId = dtoFactory.getCompetitionMapper().set(competition);

            //set default matchresult to avoid ERROR
            IMatchresultDto matchresult = dtoFactory.getMatchresultMapper().getNew();
            matchresult.setPointsForeignteam(0);
            matchresult.setPointsHometeam(0);
            matchresult.setFinal(false);
            ((MatchresultDto) matchresult).setId(null);
            Integer resultID = dtoFactory.getMatchresultMapper().set(matchresult);

            for (IMatchDto m : matchList)
            {
                m.setMatchresult(resultID);
                m.setCompetition(competitionId);
                dtoFactory.getMatchMapper().set(m);
            }

        } catch (IdNotFoundException ex)
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
            List<ITeamDto> teamList = new ArrayList<ITeamDto>();

            for (ILeagueDto l : leagueList)
            {
                if (l.getTypeOfSport().getId().equals(sport.getId()))
                {
                    for (Integer id : l.getTeamList())
                    {
                        try
                        {
                            teamList.add(dtoFactory.getTeamMapper().getById(id));
                        } catch (IdNotFoundException ex)
                        {
                            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            return teamList;

        } catch (NotFoundException ex)
        {
            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
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
            IMemberDto member = dtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList())
            {
                roleList.add(dtoFactory.getRoleMapper().getById(role));
            }
        } catch (IdNotFoundException ex)
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
                } else
                {
                    if (r instanceof IAdminDto)
                    {
                        admin = (IAdminDto) r;
                    }
                }
            }

            if (admin != null)
            {
                return dtoFactory.getTypeOfSportMapper().getAll();
            }
        } catch (NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }


        return new ArrayList<ITypeOfSportDto>();
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
            } catch (IdNotFoundException ex)
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
