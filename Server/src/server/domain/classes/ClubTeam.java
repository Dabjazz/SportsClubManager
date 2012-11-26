package server.domain.classes;

import contract.domain.ITrainer;
import contract.domain.IPlayer;
import contract.domain.IDepartment;
import contract.domain.IClubTeam;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "ClubTeam")
@XmlRootElement
public class ClubTeam
        extends Team
        implements Serializable, IClubTeam
{
    @JoinTable(name = "Department_has_Team", joinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Department", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Department> departmentList;
    @JoinTable(name = "Team_has_Player", joinColumns =
    {
        @JoinColumn(name = "ClubTeam_idClubTeam", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Player_idPlayer", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Player> players;
    @ManyToMany(mappedBy = "clubTeamList")
    private List<Trainer> trainerList;

    public ClubTeam()
    {
    }

    public ClubTeam(Integer idTeam)
    {
        super(idTeam);
    }

    @Override
    public String toString()
    {
        return getName();
    }
    
    
    
    @XmlTransient
    @Override
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : players)
        {
            result.add((IPlayer)d);
        }

        return result;
    }

    @Override
    public void setPlayerList(List<IPlayer> players)
    {
        List<Player> result = new LinkedList<>();

        for (IPlayer d : players)
        {
            if (d instanceof Player)
            {
                result.add((Player) d);
            }
            else
            {
                result.add(new Player(d));
            }
        }

        this.players = result;
    }

    @XmlTransient
    @Override
    public List<IDepartment> getDepartmentList()
    {
        List<IDepartment> result = new LinkedList<>();

        for (Department d : departmentList)
        {
            result.add((IDepartment)d);
        }

        return result;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        List<Department> result = new LinkedList<>();

        for (IDepartment d : departmentList)
        {
            result.add((Department) d);
        }

        this.departmentList = result;
    }

    @XmlTransient
    @Override
    public List<ITrainer> getTrainerList()
    {
        List<ITrainer> result = new LinkedList<>();

        for (Trainer d : trainerList)
        {
            result.add((ITrainer)d);
        }

        return result;
    }

    @Override
    public void setTrainerList(List<ITrainer> trainerList)
    {
        List<Trainer> result = new LinkedList<>();

        for (ITrainer d : trainerList)
        {
            result.add((Trainer) d);
        }

        this.trainerList = result;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubTeam))
        {
            return false;
        }
        ClubTeam other = (ClubTeam) object;
        if ((super.getId() == null && other.getId() != null) || (super.getId() != null && !super.getId().equals(other.getId())))
        {
            return false;
        }
        return true;
    }

    @Override
    public Integer getId()
    {
        return super.getId();
    }

}
