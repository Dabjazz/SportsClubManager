/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IAddressDto;
import contract.dto.ICountryDto;
import javax.ejb.Remote;

@Remote
public interface IAddressRemote
{
    public ICountryDto getCountryByName(String text);

    public ICountryDto getCountryById(int country);

    public IAddressDto getById(Integer id);
}
