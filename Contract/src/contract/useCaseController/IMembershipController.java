/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Thomas
 */
public interface IMembershipController
{
    List<IRoleDto> getRoles(Integer id);

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports);

    List<IClubTeamDto> getClubTeams(List<Integer> playerList);

    List<ITypeOfSportDto> getAllSports();
}
