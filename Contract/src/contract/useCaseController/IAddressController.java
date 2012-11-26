/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.ICountryDto;

/**

 @author Thomas
 */
public interface IAddressController
{
    ICountryDto getCountryByName(String text);

    ICountryDto getCountryById(int country);
}
