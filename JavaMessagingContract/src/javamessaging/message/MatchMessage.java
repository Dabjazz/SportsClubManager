/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.message;

import java.io.Serializable;
import javamessaging.contract.IMatchMessage;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class MatchMessage
        implements Serializable, IMatchMessage
{
    private IMemberDto member;
    private ICompetitionDto competition;
    private IClubTeamDto clubTeam;

    public MatchMessage(IMemberDto member, ICompetitionDto competition, IClubTeamDto clubTeam)
    {
        this.member = member;
        this.competition = competition;
        this.clubTeam = clubTeam;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }

    @Override
    public IClubTeamDto getClubTeam()
    {
        return clubTeam;
    }

    @Override
    public ICompetitionDto getCompetition()
    {
        return competition;
    }
}
