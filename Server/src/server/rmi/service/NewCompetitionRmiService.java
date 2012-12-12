/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.IAddressDto;
import contract.dto.IMemberDto;
import contract.dto.ICompetitionDto;
import contract.dto.ICountryDto;
import contract.dto.IMatchDto;
import contract.dto.IRoleDto;
import contract.dto.ITeamDto;
import contract.dto.ITypeOfSportDto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import contract.rmi.services.INewCompetitionRmiService;
import server.useCaseController.NewCompetitionController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionRmiService
        extends UnicastRemoteObject
        implements INewCompetitionRmiService
{
    public NewCompetitionRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList)
            throws RemoteException
    {
        NewCompetitionController.getInstance().setCompetition(competition, address, country, matchList);
    }

    @Override
    public List<ITeamDto> getTeams(ITypeOfSportDto sport)
            throws RemoteException
    {
        return NewCompetitionController.getInstance().getTeams(sport);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException
    {
        return NewCompetitionController.getInstance().getRoles(memberId);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(Integer memberId)
            throws RemoteException
    {
        return NewCompetitionController.getInstance().getTypeOfSports(memberId);
    }
}
