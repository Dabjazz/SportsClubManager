/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.io.*;
import java.util.List;

/**

 @author Thomas
 */
public interface IMembershipController
        extends Serializable
{
    List<IRoleDto> getRoles(Integer id) throws NetworkFailureException;

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports) throws NetworkFailureException;

    List<IClubTeamDto> getClubTeams(List<Integer> playerList) throws NetworkFailureException;

    List<ITypeOfSportDto> getAllSports() throws NetworkFailureException;

    IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected) throws NetworkFailureException;
    
    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)throws NetworkFailureException;

}
