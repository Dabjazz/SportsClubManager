package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.*;

public class ClubTeam
        extends Team
        implements Serializable, IClubTeam
{
    private List<Integer> departmentList = new LinkedList<>();
    private List<Integer> trainerList = new LinkedList<>();
    private List<Integer> playerList = new LinkedList<>();

     ClubTeam()
    {
        super();
    }
    
    private static HashMap<domain.contract.IClubTeam, ClubTeam> clubTeams = new HashMap<>();

    public static ClubTeam copy(domain.contract.IClubTeam clubTeam)
    {
        ClubTeam a;

        if (clubTeams.containsKey(clubTeam))
        {
            a = clubTeams.get(clubTeam);
        }
        else
        {
            a = new ClubTeam();

            List<Integer> l = new LinkedList<>();

            for (domain.contract.IDepartment t : clubTeam.getDepartmentList())
            {
                l.add(t.getId());
            }
            a.setDepartmentList(l);

            List<Integer> l2 = new LinkedList<>();

            for (domain.contract.ITrainer t : clubTeam.getTrainerList())
            {
                l.add(t.getId());
            }
            a.setTrainerList(l2);

            List<Integer> l3 = new LinkedList<>();

            for (domain.contract.IPlayer t : clubTeam.getPlayerList())
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
}
