/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;
import java.util.*;

/**

 @author Thomas
 */
public interface IMembershipRmiService
        extends Remote
{
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
            throws RemoteException;

    public List<ITypeOfSportDto> getAllSports()
            throws RemoteException;

    public List<IRoleDto> getRoles(Integer id)
            throws RemoteException;

    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
            throws RemoteException;
    
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected)
            throws RemoteException;
}
