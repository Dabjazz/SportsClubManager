/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.io.*;
import java.util.List;

/**
 @author Thomas
 */
public interface IDepartmentHeadDto
        extends IRoleDto
{
    IMemberDto getMember();

    public List<IDepartmentDto> getDepartmentList();

    void setDepartmentList(List<IDepartmentDto> departments);
}
