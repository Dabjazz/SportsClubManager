package server.domain.classes;

import contract.domain.IClubTeam;
import contract.domain.ITrainer;
import contract.domain.ITypeOfSport;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Trainer")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class Trainer
        extends Role
        implements Serializable, ITrainer
{
    @JoinTable(name = "Team_has_Trainer", joinColumns =
    {
        @JoinColumn(name = "Trainer", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "ClubTeam", referencedColumnName = "id")
    })
    @ManyToMany
    private List<ClubTeam> clubTeamList;
    @ManyToMany(mappedBy = "trainerList")
    private List<TypeOfSport> typeOfSportList;

    public Trainer()
    {
    }

    public Trainer(int id)
    {
        super(id);
    }

    @XmlTransient
    @Override
    public List<IClubTeam> getClubTeamList()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (ClubTeam d : clubTeamList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        List<ClubTeam> result = new LinkedList<>();

        for (IClubTeam d : clubTeamList)
        {
            result.add((ClubTeam) d);
        }

        this.clubTeamList = result;
    }

    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        List<ITypeOfSport> l = new LinkedList<>();
        for(TypeOfSport t : typeOfSportList)
        {
            l.add(t);
        }
        return l;
    }

    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSportList)
    {
        for(ITypeOfSport t : typeOfSportList)
        {
            this.typeOfSportList.add((TypeOfSport)t);
        }
    }
}
