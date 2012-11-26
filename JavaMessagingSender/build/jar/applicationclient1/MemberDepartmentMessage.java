/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import applicationclient1.contract.IMemberDepartmentMessage;
import applicationclient1.stubs.*;
import java.io.*;

/**

 @author Thomas
 */
public class MemberDepartmentMessage
        implements Serializable, IMemberDepartmentMessage
{
    private IMemberDto member;
    private IDepartmentDto department;

    public MemberDepartmentMessage(IMemberDto member, IDepartmentDto department)
    {
        this.member = member;
        this.department = department;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }

    @Override
    public IDepartmentDto getDepartment()
    {
        return department;
    }
}
