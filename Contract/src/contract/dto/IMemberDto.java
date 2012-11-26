/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.Date;
import java.util.List;

/**

 @author Thomas
 */
public interface IMemberDto
        extends IDto
{
    void setId(Integer idMember);

    Integer getAddress();

    Date getDateOfBirth();

    String getEmailAddress();

    Boolean getGender();

    String getLastname();

    Date getMemberFrom();

    Date getMemberTo();

    Integer getNationality();
    
    String getPrename();

    List<Integer> getRoleList();

    String getTelephonenumber();
    
    String getUsername();
    
    void setUsername(String username);
    
    void setAddress(Integer address);

    void setDateOfBirth(Date dateOfBirth);

    void setEmailAddress(String emailAddress);

    void setGender(Boolean gender);

    void setLastname(String lastname);

    void setMemberFrom(Date memberFrom);

    void setMemberTo(Date memberTo);

    void setNationality(Integer nationality);

    void setPrename(String prename);

    void setRoleList(List<Integer> roleList);

    void setTelephonenumber(String telephonenumber);
}
