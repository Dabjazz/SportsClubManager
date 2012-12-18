package server.domain.classes;

import contract.domain.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "League")
@XmlRootElement
public class League
        implements Serializable, ILeague
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "TypeOfSport_idTypeOfSport", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeOfSport typeOfSport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private List<Team> teamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private List<Competition> competitions;

    public League()
    {
    }

    public League(Integer id)
    {
        this.id = id;
    }

    public TypeOfSport getTypeOfSport()
    {
        return typeOfSport;
    }

    public void setTypeOfSport(TypeOfSport typeOfSport)
    {
        this.typeOfSport = typeOfSport;
    }

    @Override
    public List<ICompetition> getCompetitions()
    {
        List<ICompetition> cl = new LinkedList<>();
        for (Competition c : competitions)
        {
            cl.add(c);
        }
        return cl;
    }

    @Override
    public void setCompetitions(List<ICompetition> competitions)
    {
        List<Competition> result = new LinkedList<>();

        for (ICompetition d : competitions)
        {
            result.add((Competition) d);
        }

        this.competitions = result;
    }

    public League(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    @Override
    public List<ITeam> getTeamList()
    {
        List<ITeam> result = new LinkedList<>();

        for (Team d : teamList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setTeamList(List<ITeam> teamList)
    {
        List<Team> result = new LinkedList<>();

        for (ITeam d : teamList)
        {
            result.add((Team) d);
        }

        this.teamList = result;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof League))
        {
            return false;
        }
        League other = (League) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.League[ id=" + id + " ]";
    }
}
