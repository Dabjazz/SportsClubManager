/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1.contract;

import applicationclient1.stubs.IDepartmentDto;
import applicationclient1.stubs.IMemberDto;

/**

 @author Thomas
 */
public interface IMemberDepartmentMessage
{
    IMemberDto getMember();
    
    IDepartmentDto getDepartment();
}
