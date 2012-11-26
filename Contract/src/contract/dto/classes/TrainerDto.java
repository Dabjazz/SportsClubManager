package contract.dto.classes;

import java.io.Serializable;
import java.util.*;
import contract.dto.ITrainerDto;

public class TrainerDto
        extends RoleDto
        implements Serializable, ITrainerDto
{
    private List<Integer> clubTeamList = new LinkedList<>();
    private List<Integer> typeOfSportList = new LinkedList<>();
    private static HashMap<contract.domain.ITrainer, TrainerDto> trainers = new HashMap<>();

    public static TrainerDto copy(contract.domain.ITrainer trainer)
    {
        TrainerDto a;

        if (trainers.containsKey(trainer))
        {
            a = trainers.get(trainer);
        }
        else
        {
            a = copy(trainer, new TrainerDto());

            List<Integer> clubTeamList = new LinkedList<>();

            for (contract.domain.IClubTeam c : trainer.getClubTeamList())
            {
                clubTeamList.add(c.getId());
            }

            a.setClubTeamList(clubTeamList);

            List<Integer> typeOfSportList = new LinkedList<>();

            for (contract.domain.ITypeOfSport t : trainer.getTypeOfSportList())
            {
                typeOfSportList.add(t.getId());
            }
            a.setTypeOfSportList(typeOfSportList);

            trainers.put(trainer, a);
        }

        return a;
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return clubTeamList;
    }

    @Override
    public void setClubTeamList(List<Integer> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
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
}
