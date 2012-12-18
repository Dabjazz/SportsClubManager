/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.*;
import java.util.List;
import javax.ejb.Remote;
/**

 @author Lucia
 */
@Remote
public interface INewCompetitionRemote
{
    List<IRoleDto> getRoles(Integer memberId);
    List<ITypeOfSportDto> getTypeOfSports(Integer memberId);    
    List<ITeamDto> getTeams(ITypeOfSportDto sport);
    void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList);
}
