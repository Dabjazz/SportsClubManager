/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.message;

import java.io.Serializable;
import javamessaging.contract.IMemberDepartmentMessage;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class MemberDepartmentMessage
        implements Serializable, IMemberDepartmentMessage
{
    private IPlayerDto player;
    private IDepartmentDto department;

    public MemberDepartmentMessage(IPlayerDto playerDto, IDepartmentDto department)
    {
        this.player = playerDto;
        this.department = department;
    }

    @Override
    public IPlayerDto getMember()
    {
        return player;
    }

    @Override
    public IDepartmentDto getDepartment()
    {
        return department;
    }
}
