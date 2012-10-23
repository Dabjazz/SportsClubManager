/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Matchresult")
@XmlRootElement
public class Matchresult implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatchresult")
    private Integer idMatchresult;
    @Basic(optional = false)
    @Column(name = "PointsHometeam")
    private double pointsHometeam;
    @Basic(optional = false)
    @Column(name = "PointsForeignteam")
    private double pointsForeignteam;
    @Column(name = "Matchresultcol")
    private String matchresultcol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchresult")
    private Collection<Match> matchCollection;

    public Matchresult()
    {
    }

    public Matchresult(Integer idMatchresult)
    {
        this.idMatchresult = idMatchresult;
    }

    public Matchresult(Integer idMatchresult, double pointsHometeam, double pointsForeignteam)
    {
        this.idMatchresult = idMatchresult;
        this.pointsHometeam = pointsHometeam;
        this.pointsForeignteam = pointsForeignteam;
    }

    public Integer getIdMatchresult()
    {
        return idMatchresult;
    }

    public void setIdMatchresult(Integer idMatchresult)
    {
        this.idMatchresult = idMatchresult;
    }

    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    public void setPointsHometeam(double pointsHometeam)
    {
        this.pointsHometeam = pointsHometeam;
    }

    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }

    public void setPointsForeignteam(double pointsForeignteam)
    {
        this.pointsForeignteam = pointsForeignteam;
    }

    public String getMatchresultcol()
    {
        return matchresultcol;
    }

    public void setMatchresultcol(String matchresultcol)
    {
        this.matchresultcol = matchresultcol;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection()
    {
        return matchCollection;
    }

    public void setMatchCollection(Collection<Match> matchCollection)
    {
        this.matchCollection = matchCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idMatchresult != null ? idMatchresult.hashCode() : 0);
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
        if ((this.idMatchresult == null && other.idMatchresult != null) || (this.idMatchresult != null && !this.idMatchresult.equals(other.idMatchresult)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Matchresult[ idMatchresult=" + idMatchresult + " ]";
    }
    
}
