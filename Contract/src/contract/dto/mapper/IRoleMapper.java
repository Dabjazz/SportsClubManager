/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

/**
 *
 * @author Lucia
 */
public interface IRoleMapper<IRoleDto>
{
    public IRoleDto getMemberById(Integer id) throws IdNotFoundException;
}
