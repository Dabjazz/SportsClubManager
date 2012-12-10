/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface INewCompetitionController {
    
    List<IRoleDto> getRoles(Integer memberId);
    List<ITypeOfSportDto> getTypeOfSports(Integer memberId);    
    List<ITeamDto> getTeams(ITypeOfSportDto sport);
    void setCompetition(ICompetitionDto competition, IMemberDto member);
    
}
