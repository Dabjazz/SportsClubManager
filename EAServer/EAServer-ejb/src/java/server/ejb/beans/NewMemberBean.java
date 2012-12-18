/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.*;
import contract.ejb.business.INewMemberRemote;
import java.rmi.RemoteException;
import java.util.List;
import server.useCaseController.NewMemberController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberBean implements INewMemberRemote
{
    public NewMemberBean()
    {
        super();
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        NewMemberController.getInstance().setNewMember(member, address);
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        return NewMemberController.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        return NewMemberController.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeams)
    {
        NewMemberController.getInstance().setNewPlayer(member, address, clubTeams);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeams)
    {
        NewMemberController.getInstance().setNewTrainer(member, address, clubTeams);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
    {
        return NewMemberController.getInstance().getTypeOfSports(typOfSportsList);
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        return NewMemberController.getInstance().getClubTeamsByTypeOfSport(sport);
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        return NewMemberController.getInstance().getAllSports();
    }
}
