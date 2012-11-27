package server.domain.classes;

import contract.domain.ICountry;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Country")
@XmlRootElement
public class Country
        implements Serializable, ICountry
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Alpha3",nullable=true)
    private String alpha3;
    @Column(name = "Alpha2",nullable=true)
    private String alpha2;
    @Column(name = "TLD", nullable=true)
    private String tld;
    @Column(name = "Deutsch", nullable=true)
    private String deutsch;
    @Column(name = "Espanol", nullable=true)
    private String espanol;
    @Column(name = "Francaise", nullable=true)
    private String francaise;
    @Column(name = "Italiano", nullable=true)
    private String italiano;
    @Column(name = "Portugues", nullable=true)
    private String portugues;

    public Country()
    {
    }

    public Country(String name, String alpha3, String alpha2, String tld, String deutsch, String espanol, String francaise, String italiano, String portugues)
    {
        this.name = name;
        this.alpha3 = alpha3;
        this.alpha2 = alpha2;
        this.tld = tld;
        this.deutsch = deutsch;
        this.espanol = espanol;
        this.francaise = francaise;
        this.italiano = italiano;
        this.portugues = portugues;
    }

    public Country(Integer id)
    {
        this.id = id;
    }

    public Country(Integer id, String name)
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAlpha3()
    {
        return alpha3;
    }

    public void setAlpha3(String alpha3)
    {
        this.alpha3 = alpha3;
    }

    public String getAlpha2()
    {
        return alpha2;
    }

    public void setAlpha2(String alpha2)
    {
        this.alpha2 = alpha2;
    }

    public String getTld()
    {
        return tld;
    }

    @Override
    public void setTld(String tld)
    {
        this.tld = tld;
    }

    @Override
    public String getDeutsch()
    {
        return deutsch;
    }

    @Override
    public void setDeutsch(String deutsch)
    {
        this.deutsch = deutsch;
    }

    @Override
    public String getEspanol()
    {
        return espanol;
    }

    @Override
    public void setEspanol(String espanol)
    {
        this.espanol = espanol;
    }

    @Override
    public String getFrancaise()
    {
        return francaise;
    }

    public void setFrancaise(String francaise)
    {
        this.francaise = francaise;
    }

    public String getItaliano()
    {
        return italiano;
    }

    public void setItaliano(String italiano)
    {
        this.italiano = italiano;
    }

    public String getPortugues()
    {
        return portugues;
    }

    public void setPortugues(String portugues)
    {
        this.portugues = portugues;
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
        if (!(object instanceof Country))
        {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Country[ id=" + id + " ]";
    }
}
