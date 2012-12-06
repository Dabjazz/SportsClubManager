/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import java.util.*;
import javamessaging.stubs.*;

/**
 @author Thomas
 */
public class MainSender
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        List<IPlayerDto> playerList = new LinkedList<IPlayerDto>();
        playerList.add(new PlayerDto(new MemberDto("tsc","Thomas", "Schwarz")));
        playerList.add(new PlayerDto(new MemberDto("luc","Lucia", "Ammann")));
        playerList.add(new PlayerDto(new MemberDto("mar","Markus","Mohanty")));

        for (int i = 0; i < 3; i++)
        {
            MatchPublisherJms matchPublisher = new MatchPublisherJms();

            IClubTeamDto clubTeam = new ClubTeamDto("Team " + new Date());
            clubTeam.setPlayerList(playerList);

            ICompetitionDto competition = new CompetitionDto("Competition " + new Date());

            matchPublisher.publish(clubTeam, competition);
        }



        MemberPublisherJms memberPublisher = new MemberPublisherJms();
        IDepartmentDto department = new DepartmentDto("Fussball");

        for (IPlayerDto player : playerList)
        {
            memberPublisher.publish(department, player);
        }
    }
}
