/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.INewMemberRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.NewMember;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberRmiService
        extends UnicastRemoteObject
        implements INewMemberRmiService
{
    public NewMemberRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
            throws RemoteException
    {
        NewMember.getInstance().setNewMember(member, address);
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        return NewMember.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
            throws RemoteException
    {
        return NewMember.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeams)
            throws RemoteException
    {
        NewMember.getInstance().setNewPlayer(member, address, clubTeams);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeams)
            throws RemoteException
    {
        NewMember.getInstance().setNewTrainer(member, address, clubTeams);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
            throws RemoteException
    {
        return NewMember.getInstance().getTypeOfSports(typOfSportsList);
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws RemoteException
    {
        return NewMember.getInstance().getClubTeamsByTypeOfSport(sport);
    }

    @Override
    public List<ITypeOfSportDto> getAllSports() throws RemoteException
    {
        return NewMember.getInstance().getAllSports();
    }
}
