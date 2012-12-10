/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import java.util.*;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
class DepartmentHeadDto
        implements IDepartmentHeadDto
{
    private IMemberDto member;
    private List<IDepartmentDto> departmentList;

    public DepartmentHeadDto(IMemberDto member)
    {
        this.member = member;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }

    @Override
    public List<IDepartmentDto> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<IDepartmentDto> departmentList)
    {
        this.departmentList = departmentList;
    }
}
