/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;
import java.util.List;

/**

 @author Lucia
 */
public interface INewCompetitionRmiService
        extends Remote
{
    List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException;
    
    List<ITypeOfSportDto> getTypeOfSports(Integer memberId)
            throws RemoteException;
    
    List<ITeamDto> getTeams(ITypeOfSportDto sport)
            throws RemoteException;
    
    void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList)
            throws RemoteException;    
}
