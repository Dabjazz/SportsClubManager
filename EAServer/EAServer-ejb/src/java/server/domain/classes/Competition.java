package server.domain.classes;

import contract.domain.ICompetition;
import contract.domain.ILeague;
import contract.domain.IMatch;
import contract.domain.ITeam;
import contract.domain.ITypeOfSport;
import contract.domain.IAddress;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Competition")
@XmlRootElement
public class Competition
        implements Serializable, ICompetition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Payment")
    private Double payment;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @JoinTable(name = "Competition_has_Team", joinColumns =
    {
        @JoinColumn(name = "Competition", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Team> teamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private List<Match> matchList;
    @JoinColumn(name = "Address", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Address address;
    @JoinColumn(name = "League_idLeague", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private League league;

    public Competition()
    {
    }

    public Competition(Integer idCompetition)
    {
        this.id = idCompetition;
    }

    public Competition(Integer idCompetition, Date dateFrom)
    {
        this.id = idCompetition;
        this.dateFrom = dateFrom;
    }

    @Override
    public ITypeOfSport getSport()
    {
        return league.getTypeOfSport();
    }

    @Override
    public void setSport(ITypeOfSport sport)
    {
        if(league == null)
        {
            this.league = new League();
        }
        this.league.setTypeOfSport((TypeOfSport)sport);
    }

    @Override
    public League getLeague()
    {
        return league;
    }

    @Override
    public void setLeague(ILeague league)
    {
        this.league = (League) league;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer idCompetition)
    {
        this.id = idCompetition;
    }

    @Override
    public Date getDateFrom()
    {
        return dateFrom;
    }

    @Override
    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    @Override
    public Date getDateTo()
    {
        return dateTo;
    }

    @Override
    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    @Override
    public Double getPayment()
    {
        return payment;
    }

    @Override
    public void setPayment(Double payment)
    {
        this.payment = payment;
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

    @XmlTransient
    @Override
    public List<IMatch> getMatchList()
    {
        List<IMatch> result = new LinkedList<>();

        for (Match d : matchList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setMatchList(List<IMatch> matchList)
    {
        List<Match> result = new LinkedList<>();

        for (IMatch d : matchList)
        {
            result.add((Match) d);
        }

        this.matchList = result;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Competition other = (Competition) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public IAddress getAddress()
    {
        return this.address;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public void setAddress(IAddress address)
    {
        this.address = (Address) address;
    }
}
