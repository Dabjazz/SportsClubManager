/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;

/**

 @author Lucia
 */
public interface ILogin
{
    IMemberDto getMemberByUserData(IUserDataDto userData)
            throws MemberNotFoundException;

    IMemberDto getMemberByUsername(String username)
            throws MemberNotFoundException;
}
