package server.domain.classes;

import contract.domain.IDepartmentHead;
import contract.domain.IDepartment;
import contract.domain.IClubTeam;
import contract.domain.ITypeOfSport;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Department")
@XmlRootElement
public class Department
        implements Serializable, IDepartment
{
    @JoinColumn(name = "DepartmentHead_id", referencedColumnName = "id")
    @ManyToOne
    private DepartmentHead departmentHead;
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
    @JoinTable(name = "Department_has_Team", joinColumns =
    {
        @JoinColumn(name = "Department", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "id")
    })
    @ManyToMany
    private List<ClubTeam> clubTeamList;
    @JoinTable(name = "Department_has_TypeOfSport", joinColumns =
    {
        @JoinColumn(name = "Department_idDepartment", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "TypeOfSport", referencedColumnName = "id")
    })
    @ManyToMany
    private List<TypeOfSport> typeOfSports;
    
    public Department()
    {
    }
    
    public Department(Integer idDepartment)
    {
        this.id = idDepartment;
    }
    
    public Department(Integer idDepartment, String name)
    {
        this.id = idDepartment;
        this.name = name;
    }
    
    public Department(String name, String description, ITypeOfSport typeOfSport)
    {
        this.name = name;
        this.description = description;
        this.typeOfSports = new LinkedList<>();
        this.typeOfSports.add((TypeOfSport) typeOfSport);
    }
    
    public Department(String name, String description, ITypeOfSport... typeOfSports)
    {
        this.name = name;
        this.description = description;
        this.typeOfSports = new LinkedList<>();
        
        for (ITypeOfSport typeOfSport : typeOfSports)
        {
            this.typeOfSports.add((TypeOfSport) typeOfSport);
        }
    }
    
    @Override
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer idDepartment)
    {
        this.id = idDepartment;
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
    
    @XmlTransient
    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        List<ITypeOfSport> result = new LinkedList<>();
        
        for (TypeOfSport d : typeOfSports)
        {
            result.add((ITypeOfSport) d);
        }
        
        return result;
    }
    
    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSports)
    {
        List<TypeOfSport> result = new LinkedList<>();
        
        for (ITypeOfSport d : typeOfSports)
        {
            result.add((TypeOfSport) d);
        }
        
        this.typeOfSports = result;
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
        if (!(object instanceof Department))
        {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Department[ idDepartment=" + id + " ]";
    }
    
    @Override
    public IDepartmentHead getDepartmentHead()
    {
        return this.departmentHead;
    }
    
    @Override
    public void setDepartmentHead(IDepartmentHead departmentHead)
    {
        this.departmentHead = (DepartmentHead) departmentHead;
    }
}
