/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.contract;

import javamessaging.stubs.*;


/**

 @author Thomas
 */
public interface IMemberDepartmentMessage
{
    IPlayerDto getMember();
    
    IDepartmentDto getDepartment();
}
