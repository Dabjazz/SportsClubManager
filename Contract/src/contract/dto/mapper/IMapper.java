/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.IClubTeam;
import contract.dto.ITypeOfSport;
import java.io.Serializable;
import java.util.List;

/**
 @author Thomas
 */
public interface IMapper<T> extends Serializable
{
    T getNew();
    
    T getById(Integer id) throws IdNotFoundException;

    List<T> getAll() throws NotFoundException;

    Integer set(T value);
    
    void delete(T value);

}
