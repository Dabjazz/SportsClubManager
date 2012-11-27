/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.ICountryDto;
import java.io.Serializable;

/**

 @author Thomas
 */
public interface IAddressController
        extends Serializable
{
    ICountryDto getCountryByName(String text);

    ICountryDto getCountryById(int country);
}
