package contract.dto.classes;

import contract.domain.ILeague;
import contract.dto.ITeamDto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TeamDto
        implements Serializable, ITeamDto {

    private int id;
    private String name;
    private String description;
    private List<Integer> competitionList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer league;
    private static HashMap<contract.domain.ITeam, TeamDto> teams = new HashMap<>();

    public TeamDto() {
    }

    public TeamDto(int id) {

        this.id = id;
    }

    public static TeamDto copy(contract.domain.ITeam team) {
        TeamDto a;

        if (teams.containsKey(team)) {
            a = teams.get(team);
        } else {
            a = new TeamDto(team.getId());

            a.setName(team.getName());
            a.setDescription(team.getDescription());
            a.setLeague(team.getLeague().getId());
            for (contract.domain.ICompetition c : team.getCompetitionList()) {
                a.competitionList.add(c.getId());
            }

            for (contract.domain.IMatch c : team.getMatchList()) {
                a.matchList.add(c.getId());
            }

            teams.put(team, a);
        }

        return a;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<Integer> getCompetitionList() {
        return competitionList;
    }

    @Override
    public void setCompetitionList(List<Integer> competitionList) {
        this.competitionList = competitionList;
    }

    @Override
    public List<Integer> getMatchList() {
        return matchList;
    }

    @Override
    public void setMatchList(List<Integer> matchList) {
        this.matchList = matchList;
    }

    @Override
    public Integer getLeague() {
        return league;
    }

    @Override
    public void setLeague(Integer league) {
        this.league = league;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setLeague(ILeague league) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
