/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.helper.observer;

import contract.dto.IClubTeamDto;
import contract.dto.ITypeOfSportDto;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface SelectedSportsValue {
    
    void sportSelected(List<ITypeOfSportDto> sport);
    
    List<IClubTeamDto> getClubTeamsBySport(ITypeOfSportDto sport);
}
