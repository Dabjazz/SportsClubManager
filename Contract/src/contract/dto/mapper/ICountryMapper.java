/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.ICountryDto;

/**
 @author Thomas
 */
public interface ICountryMapper
        extends IMapper<ICountryDto>
{
    ICountryDto getByName(String name)
            throws IdNotFoundException;
}
