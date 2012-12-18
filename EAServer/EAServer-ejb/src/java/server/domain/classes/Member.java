package server.domain.classes;

import contract.domain.IRole;
import contract.domain.ICountry;
import contract.domain.IMember;
import contract.domain.IAddress;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "ClubMember")
@XmlRootElement
public class Member
        implements Serializable, IMember
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Prename")
    private String prename;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "MemberFrom")
    @Temporal(TemporalType.DATE)
    private Date memberFrom;
    @Column(name = "MemberTo")
    @Temporal(TemporalType.DATE)
    private Date memberTo;
    @Column(name = "Telephonenumber")
    private String telephonenumber;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "Gender")
    private Boolean gender;
    @JoinColumn(name = "Nationality", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country nationality;
    @JoinColumn(name = "Address", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Address address;
    @OneToMany(cascade= CascadeType.ALL,mappedBy="member")
    private List<Role> roleList;

    public Member()
    {
    }

    public Member(Integer id)
    {
        this.id = id;
    }

    public Member(Integer id, String prename, String lastname, Date dateOfBirth, Date memberFrom)
    {
        this.id = id;
        this.prename = prename;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.memberFrom = memberFrom;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public Integer getIdMember()
    {
        return id;
    }

    @Override
    public void setIdMember(Integer id)
    {
        this.id = id;
    }

    @Override
    public String getPrename()
    {
        return prename;
    }

    @Override
    public void setPrename(String prename)
    {
        this.prename = prename;
    }

    @Override
    public String getLastname()
    {
        return lastname;
    }

    @Override
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @Override
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Date getMemberFrom()
    {
        return memberFrom;
    }

    @Override
    public void setMemberFrom(Date memberFrom)
    {
        this.memberFrom = memberFrom;
    }

    @Override
    public Date getMemberTo()
    {
        return memberTo;
    }

    @Override
    public void setMemberTo(Date memberTo)
    {
        this.memberTo = memberTo;
    }

    @Override
    public String getTelephonenumber()
    {
        return telephonenumber;
    }

    @Override
    public void setTelephonenumber(String telephonenumber)
    {
        this.telephonenumber = telephonenumber;
    }

    @Override
    public String getEmailAddress()
    {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    @Override
    public Boolean getGender()
    {
        return gender;
    }

    @Override
    public void setGender(Boolean gender)
    {
        this.gender = gender;
    }

    @Override
    public ICountry getNationality()
    {
        return (ICountry)nationality;
    }

    @Override
    public void setNationality(ICountry nationality)
    {
        this.nationality = (Country) nationality;
    }

    @Override
    public IAddress getAddress()
    {
        return address;
    }

    @Override
    public void setAddress(IAddress address)
    {
        this.address = (Address) address;
    }

    @XmlTransient
    @Override
    public List<IRole> getRoleList()
    {
        List<IRole> result = new LinkedList<IRole>();

        for (Role d : roleList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setRoleList(List<IRole> roleList)
    {
        List<Role> result = new LinkedList<Role>();

        for (IRole d : roleList)
        {
            result.add((Role) d);
        }

        this.roleList = result;
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
        if (!(object instanceof Member))
        {
            return false;
        }
        Member other = (Member) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Member1[ id=" + id + " ]";
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public void setUsername(String username)
    {
        this.username = username;
    }
}
