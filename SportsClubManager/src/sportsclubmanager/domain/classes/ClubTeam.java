package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import sportsclubmanager.domain.contract.*;

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
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTeam")
    private Integer idTeam;
    @ManyToMany(mappedBy = "clubTeamList")
    private List<Department> departmentList;
    @JoinTable(name = "Team_has_Trainer", joinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Trainer", referencedColumnName = "idRole")
    })
    @ManyToMany
    private List<Trainer> trainerList;
    //rebuild table to member connection not role connection
    @JoinTable(name = "Team_Has_Player", joinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Player", referencedColumnName = "idRole")
    })
    @ManyToMany
    private List<Player> players;

    public ClubTeam()
    {
    }

    public ClubTeam(Integer idTeam)
    {
        this.idTeam = idTeam;
    }

    @XmlTransient
    @Override
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : players)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setPlayerList(List<IPlayer> players)
    {
        List<Player> result = new LinkedList<>();

        for (IPlayer d : players)
        {
            result.add((Player) d);
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
            result.add(d);
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
            result.add(d);
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
        hash += (idTeam != null ? idTeam.hashCode() : 0);
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
        if ((this.idTeam == null && other.idTeam != null) || (this.idTeam != null && !this.idTeam.equals(other.idTeam)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.ClubTeam[ idTeam=" + idTeam + " ]";
    }
}