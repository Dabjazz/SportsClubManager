/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.util.*;

/**

 @author Thomas
 */
public class MemberDto
        implements IMemberDto
{
    private String username;
    private String prename;
    private String lastname;

    public MemberDto(String username, String prename, String lastname)
    {
        this.username = username;
        this.prename = prename;
        this.lastname = lastname;
    }

    @Override
    public String getPrename()
    {
        return prename;
    }

    @Override
    public String getLastname()
    {
        return lastname;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public List<IRoleDto> getRoleList()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString()
    {
        return username;
    }
}
