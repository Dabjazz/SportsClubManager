package contract.dto.classes;

import java.io.Serializable;
import java.util.*;
import contract.dto.IClubTeamDto;

public class ClubTeamDto
        extends TeamDto
        implements Serializable, IClubTeamDto
{
    private List<Integer> departmentList = new LinkedList<>();
    private List<Integer> trainerList = new LinkedList<>();
    private List<Integer> playerList = new LinkedList<>();

   public  ClubTeamDto()
    {
        super();
    }
    
    private static HashMap<contract.domain.IClubTeam, ClubTeamDto> clubTeams = new HashMap<>();

    public static ClubTeamDto copy(contract.domain.IClubTeam clubTeam)
    {
        ClubTeamDto a;

        if (clubTeams.containsKey(clubTeam))
        {
            a = clubTeams.get(clubTeam);
        }
        else
        {
            a = new ClubTeamDto();

            List<Integer> l = new LinkedList<>();

            for (contract.domain.IDepartment t : clubTeam.getDepartmentList())
            {
                l.add(t.getId());
            }
            a.setDepartmentList(l);

            List<Integer> l2 = new LinkedList<>();

            for (contract.domain.ITrainer t : clubTeam.getTrainerList())
            {
                l.add(t.getId());
            }
            a.setTrainerList(l2);

            List<Integer> l3 = new LinkedList<>();

            for (contract.domain.IPlayer t : clubTeam.getPlayerList())
            {
                l.add(t.getId());
            }
            a.setPlayerList(l3);

            clubTeams.put(clubTeam, a);
        }

        return a;
    }

    @Override
    public List<Integer> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<Integer> departmentList)
    {
        this.departmentList = departmentList;
    }

    @Override
    public List<Integer> getTrainerList()
    {
        return trainerList;
    }

    @Override
    public void setTrainerList(List<Integer> trainerList)
    {
        this.trainerList = trainerList;
    }

    @Override
    public List<Integer> getPlayerList()
    {
        return playerList;
    }

    @Override
    public void setPlayerList(List<Integer> playerList)
    {
        this.playerList = playerList;
    }

    @Override
    public String toString()
    {
        return getName();
    }
    
    
}
