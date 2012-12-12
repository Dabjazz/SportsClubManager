package contract.dto.classes;

import contract.domain.*;
import contract.dto.IClubTeamDto;
import java.io.Serializable;
import java.util.*;

public class ClubTeamDto
        extends TeamDto
        implements Serializable, IClubTeamDto
{
    private Integer parentClubTeam;
    private List<Integer> departmentList = new LinkedList<>();
    private List<Integer> trainerList = new LinkedList<>();
    private List<Integer> playerList = new LinkedList<>();

      public ClubTeamDto( )
    {
        super();
    }
      
    public ClubTeamDto(int id)
    {
        super(id);
    }
    private static HashMap<IClubTeam, ClubTeamDto> clubTeams = new HashMap<>();

    public static ClubTeamDto copy(IClubTeam clubTeam)
    {
        ClubTeamDto a;

        if (clubTeams.containsKey(clubTeam))
        {
            a = clubTeams.get(clubTeam);
        }
        else
        {
            a = new ClubTeamDto(clubTeam.getId());

            // Competition list
            List<Integer> competitionList = new LinkedList<>();

            for (ICompetition competition : clubTeam.getCompetitionList())
            {
                competitionList.add(competition.getId());
            }

            a.setCompetitionList(competitionList);

//            a.setParentClubTeam(clubTeam.getParentClubTeam().getId());

            // description
            a.setDescription(clubTeam.getDescription());

            // league
            a.setLeague(clubTeam.getLeague().getId());

            // match list
            List<Integer> matchList = new LinkedList<>();

            for (IMatch match : clubTeam.getMatchList())
            {
                matchList.add(match.getId());
            }

            a.setMatchList(matchList);

            // name
            a.setName(clubTeam.getName());

            // department list
            List<Integer> departmentList = new LinkedList<>();

            for (IDepartment t : clubTeam.getDepartmentList())
            {
                departmentList.add(t.getId());
            }
            a.setDepartmentList(departmentList);

            // trainer list
            List<Integer> trainerList = new LinkedList<>();

            for (ITrainer t : clubTeam.getTrainerList())
            {
                trainerList.add(t.getId());
            }
            a.setTrainerList(trainerList);

            // player list
            List<Integer> playerList = new LinkedList<>();

            for (IPlayer t : clubTeam.getPlayerList())
            {
                playerList.add(t.getId());
            }
            a.setPlayerList(playerList);

            clubTeams.put(clubTeam, a);
        }

        return a;
    }

    

    @Override
    public Integer getParentClubTeam()
    {
        return parentClubTeam;
    }

    @Override
    public void setParentClubTeam(Integer parentClubTeam)
    {
        this.parentClubTeam = parentClubTeam;
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
