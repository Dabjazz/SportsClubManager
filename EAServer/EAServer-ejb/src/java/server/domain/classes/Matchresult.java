package server.domain.classes;

import contract.domain.IMatchresult;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "SportsGameResult")
@XmlRootElement
public class Matchresult
        implements Serializable, IMatchresult
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PointsHometeam")
    private double pointsHometeam;
    @Basic(optional = false)
    @Column(name = "PointsForeignteam")
    private double pointsForeignteam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchresult")
    private List<Match> matchList;
    @Column(name="Final")
    private boolean fin;

    public Matchresult()
    {
    }

    public Matchresult(Integer id)
    {
        this.id = id;
    }

    public Matchresult(Integer id, double pointsHometeam, double pointsForeignteam)
    {
        this.id = id;
        this.pointsHometeam = pointsHometeam;
        this.pointsForeignteam = pointsForeignteam;
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
    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    @Override
    public void setPointsHometeam(double pointsHometeam)
    {
        this.pointsHometeam = pointsHometeam;
    }

    @Override
    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }

    @Override
    public void setPointsForeignteam(double pointsForeignteam)
    {
        this.pointsForeignteam = pointsForeignteam;
    }

    @XmlTransient
    public List<Match> getMatchList()
    {
        return matchList;
    }

    public void setMatchList(List<Match> matchList)
    {
        this.matchList = matchList;
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
        if (!(object instanceof Matchresult))
        {
            return false;
        }
        Matchresult other = (Matchresult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Matchresult[ id=" + id + " ]";
    }

    @Override
    public boolean isFin()
    {
        return this.fin;
    }

    @Override
    public void setFin(boolean fin)
    {
        this.fin = fin;
    }
}
