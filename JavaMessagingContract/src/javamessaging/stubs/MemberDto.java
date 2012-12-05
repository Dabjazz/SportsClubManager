/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.util.*;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class MemberDto
        implements IMemberDto
{
    private String username;

    public MemberDto(String username)
    {
        this.username = username;
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
