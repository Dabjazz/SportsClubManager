/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.useCaseController.IAddMemberToTeamController;
import java.util.List;
import server.dto.mapper.DtoFactory;

/**

 @author Lucia
 */
public class AddMemberToTeamController
        implements IAddMemberToTeamController
{
    private static AddMemberToTeamController singleton = null;
    DtoFactory dtoFactory = new DtoFactory();

    public static AddMemberToTeamController getInstance()
    {
        if (singleton == null)
        {
            singleton = new AddMemberToTeamController();
        }
        return singleton;
    }

    //TODO implement those methodes - too brainfu... right now
    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
