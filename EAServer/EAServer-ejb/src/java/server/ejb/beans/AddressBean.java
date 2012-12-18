/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IAddressDto;
import contract.dto.ICountryDto;
import contract.ejb.business.IAddressRemote;
import javax.ejb.Stateless;
import server.useCaseController.AddressController;

@Stateless
public class AddressBean implements IAddressRemote
{
    public AddressBean()
    {
        super();
    }

    @Override
    public IAddressDto getById(Integer id)
    {
        return AddressController.getInstance().getById(id);
    }

    @Override
    public ICountryDto getCountryByName(String text)
    {
        return AddressController.getInstance().getCountryByName(text);
    }

    @Override
    public ICountryDto getCountryById(int country)
    {
        return AddressController.getInstance().getCountryById(country);
    }
}
