package domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Competition")
@XmlRootElement
public class Competition
        implements Serializable, ICompetition
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompetition")
    private Integer idCompetition;
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
    @JoinTable(name = "Competition_has_Team", joinColumns =
    {
        @JoinColumn(name = "Competition", referencedColumnName = "idCompetition")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    })
    @ManyToMany
    private List<Team> teamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private List<Match> matchList;

    public Competition()
    {
    }

    public Competition(Integer idCompetition)
    {
        this.idCompetition = idCompetition;
    }

    public Competition(Integer idCompetition, Date dateFrom)
    {
        this.idCompetition = idCompetition;
        this.dateFrom = dateFrom;
    }

    @Override
    public Integer getId()
    {
        return idCompetition;
    }

    public void setId(Integer idCompetition)
    {
        this.idCompetition = idCompetition;
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
        int hash = 0;
        hash += (idCompetition != null ? idCompetition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition))
        {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.idCompetition == null && other.idCompetition != null) || (this.idCompetition != null && !this.idCompetition.equals(other.idCompetition)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Competition[ idCompetition=" + idCompetition + " ]";
    }
}
