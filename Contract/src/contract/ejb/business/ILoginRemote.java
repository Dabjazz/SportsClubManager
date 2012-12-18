/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import javax.ejb.Remote;

@Remote
public interface ILoginRemote {
    IMemberDto  getMemberByUserData(IUserDataDto userData);

    IMemberDto getMemberByUsername(String username);
}
