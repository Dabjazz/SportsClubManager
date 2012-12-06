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
    void setCompetition(ICompetitionDto competition, IMemberDto member);
    List<ITeamDto> getTeams();
    
}
