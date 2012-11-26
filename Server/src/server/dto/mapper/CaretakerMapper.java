/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ICaretakerDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.CaretakerDto;

/**

 @author Thomas
 */
public class CaretakerMapper
        implements IMapper<ICaretakerDto>
{
    private static CaretakerMapper controller;

    CaretakerMapper()
    {
    }

    public static IMapper<ICaretakerDto> getInstance()
    {
        if (controller == null)
        {
            controller = new CaretakerMapper();
        }

        return controller;
    }

    public contract.domain.ICaretaker getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(contract.domain.ICaretaker.class, id);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ICaretakerDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ICaretaker a = DomainFacade.getInstance().getByID(contract.domain.ICaretaker.class, id);
            return CaretakerDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ICaretakerDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ICaretakerDto> result = new LinkedList<>();

            for (contract.domain.ICaretaker a : DomainFacade.getInstance().getAll(contract.domain.ICaretaker.class))
            {
                result.add(CaretakerDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ICaretakerDto value)
    {
        try
        {
            server.domain.classes.Caretaker address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICaretakerDto value)
    {
        try
        {
            server.domain.classes.Caretaker address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Caretaker createDomain(ICaretakerDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Caretaker caretaker = new server.domain.classes.Caretaker(value.getId());

        LinkedList<contract.domain.IPermission> permissionList = new LinkedList<>();
        for (int id : value.getPermisssionList())
        {
            permissionList.add(new PermissionMapper().getDomainById(id));
        }

        caretaker.setPermissionList(permissionList);

        caretaker.setMember(new MemberMapper().getDomainById(value.getMember()));

        caretaker.setName(value.getName());
        caretaker.setDescription(value.getDescription());

        return caretaker;
    }

    @Override
    public ICaretakerDto getNew()
    {
        return new CaretakerDto();
    }
}
