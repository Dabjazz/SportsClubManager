package contract.dto.classes;

import contract.domain.*;
import contract.dto.IPlayerDto;
import java.io.Serializable;
import java.util.*;

public class PlayerDto
        extends RoleDto
        implements Serializable, IPlayerDto
{
    private List<Integer> typeOfSportList;
    private List<Integer> clubTeamList;
    private static HashMap<IPlayer, PlayerDto> players = new HashMap<>();

    public static PlayerDto copy(IPlayer player)
    {
        PlayerDto a;

        if (players.containsKey(player))
        {
            a = players.get(player);
        }
        else
        {
            a = copy(player, new PlayerDto());

            List<Integer> l = new LinkedList<>();

            for (ITypeOfSport t : player.getTypeOfSportList())
            {
                l.add(t.getId());
            }
            a.setTypeOfSportList(l);

            List<Integer> c = new LinkedList<>();

            for (IClubTeam t : player.getClubTeams())
            {
                c.add(t.getId());
            }

            a.setClubTeamList(c);

            players.put(player, a);
        }

        return a;
    }

    @Override
    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }

    @Override
    public void setClubTeamList(List<Integer> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return clubTeamList;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
