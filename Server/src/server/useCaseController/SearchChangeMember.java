/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 @author EnjoX
 */
public class SearchChangeMember
        implements ISearchChangeMember
{
    private static SearchChangeMember INSTANCE;
    private IMemberDto member;
    private DtoFactory dtoFactory = new DtoFactory();
    private IMemberController memberController = new MemberController();
    private IMembershipController membershipController = new MembershipController();

    private SearchChangeMember()
    {
    }

    public static ISearchChangeMember getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SearchChangeMember();
        }

        return INSTANCE;
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput)
    {
        try
        {
            List<IMemberDto> resultIMembers = new LinkedList<>();
            List<IMemberDto> memberList = dtoFactory.getMemberMapper().getAll();
            for (IMemberDto member : memberList)
            {
                if (member.getLastname().toLowerCase().contains(searchInput.toLowerCase())
                        || member.getPrename().toLowerCase().contains(searchInput.toLowerCase())
                        || member.getUsername().toLowerCase().contains(searchInput.toLowerCase()))
                {
                    resultIMembers.add(member);
                }
            }
            return resultIMembers;
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMemberDto getMember(Integer id)
    {
        try
        {
            return dtoFactory.getMemberMapper().getById(id);
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId)
    {
        try
        {
            //Auch nicht wirklich korrekt!!!!
            List<IDepartmentDto> depList = dtoFactory.getDepartmentMapper().getAll();
            for (IDepartmentDto dep : depList)
            {
                List<IClubTeamDto> clubList = new ArrayList<>();
                for (Integer club : dep.getClubTeamList())
                {
                    clubList.add(dtoFactory.getClubTeamMapper().getById(club));
                }

                for (IClubTeamDto team : clubList)
                {
                    if (team.getPlayerList().contains(memberId))
                    {
                        return dep;
                    }
                }
            }
        }
        catch (RemoteException | IdNotFoundException | NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IAddressDto getAddress(Integer addressId)
    {
        try
        {
            return dtoFactory.getAddressMapper().getById(addressId);
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountryDto getCountry(Integer countryID)
    {
        try
        {
            return dtoFactory.getCountryMapper().getById(countryID);
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        try
        {
            return dtoFactory.getDepartmentMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        List<IClubTeamDto> teamList = new ArrayList<>();
        try
        {
            for (Integer team : clubTeams)
            {
                teamList.add(dtoFactory.getClubTeamMapper().getById(team));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        NewMember.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        NewMember.getInstance().setNewTrainer(member, address, clubTeam);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        NewMember.getInstance().setNewPlayer(member, address, clubTeam);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
    {
        List<ITypeOfSportDto> typeOfSportReturnList = new ArrayList<>();
        try
        {
            for (Integer sportID : sportsList)
            {
                typeOfSportReturnList.add(dtoFactory.getTypeOfSportMapper().getById(sportID));

            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeOfSportReturnList;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports()
    {
        try
        {
            return dtoFactory.getTypeOfSportMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setSelectedMember(IMemberDto member)
    {
        this.member = member;
    }

    @Override
    public IMemberDto getSelectedMember()
    {
        return member;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        List<IClubTeamDto> cTeams = null;
        try
        {
            cTeams = dtoFactory.getClubTeamMapper().getClubTeamsByTypeOfSport(sport);
        }
        catch (RemoteException | ClubTeamNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cTeams;
    }

    @Override
    public IMemberController getMemberController()
    {
        return memberController;
    }

    @Override
    public IMembershipController getMembershipController()
    {
        return membershipController;
    }
}
