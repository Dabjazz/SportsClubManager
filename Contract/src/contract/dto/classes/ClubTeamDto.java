package contract.dto.classes;

import contract.domain.ICompetition;
import contract.domain.ILeague;
import contract.domain.IMatch;
import java.io.Serializable;
import java.util.*;
import contract.dto.IClubTeamDto;
import contract.dto.ICompetitionDto;

public class ClubTeamDto
        extends TeamDto
        implements Serializable, IClubTeamDto {

    private List<Integer> departmentList = new LinkedList<>();
    private List<Integer> trainerList = new LinkedList<>();
    private List<Integer> playerList = new LinkedList<>();

    public ClubTeamDto() {
        super();
    }
    private static HashMap<contract.domain.IClubTeam, ClubTeamDto> clubTeams = new HashMap<>();

    public static ClubTeamDto copy(contract.domain.IClubTeam clubTeam) {
        ClubTeamDto a;

        if (clubTeams.containsKey(clubTeam)) {
            a = clubTeams.get(clubTeam);
        } else {
            a = new ClubTeamDto();

            // Competition list
            List<Integer> competitionList = new LinkedList<>();

            for (ICompetition competition : clubTeam.getCompetitionList()) {
                competitionList.add(competition.getId());
            }

            a.setCompetitionList(competitionList);

            // description
            a.setDescription(clubTeam.getDescription());

            // league
            a.setLeague(clubTeam.getLeague().getId());

            // match list
            List<Integer> matchList = new LinkedList<>();

            for (IMatch match : clubTeam.getMatchList()) {
                matchList.add(match.getId());
            }

            a.setMatchList(matchList);

            // name
            a.setName(clubTeam.getName());

            // department list
            List<Integer> departmentList = new LinkedList<>();

            for (contract.domain.IDepartment t : clubTeam.getDepartmentList()) {
                departmentList.add(t.getId());
            }
            a.setDepartmentList(departmentList);

            // trainer list
            List<Integer> trainerList = new LinkedList<>();

            for (contract.domain.ITrainer t : clubTeam.getTrainerList()) {
                trainerList.add(t.getId());
            }
            a.setTrainerList(trainerList);

            // player list
            List<Integer> playerList = new LinkedList<>();

            for (contract.domain.IPlayer t : clubTeam.getPlayerList()) {
                playerList.add(t.getId());
            }
            a.setPlayerList(playerList);

            clubTeams.put(clubTeam, a);
        }

        return a;
    }

    @Override
    public List<Integer> getDepartmentList() {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<Integer> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public List<Integer> getTrainerList() {
        return trainerList;
    }

    @Override
    public void setTrainerList(List<Integer> trainerList) {
        this.trainerList = trainerList;
    }

    @Override
    public List<Integer> getPlayerList() {
        return playerList;
    }

    @Override
    public void setPlayerList(List<Integer> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return getName();
    }
}
