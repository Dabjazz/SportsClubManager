/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.CouldNotDeleteException;
import contract.domain.CouldNotFetchException;
import contract.domain.CouldNotSaveException;
import contract.domain.IPermission;
import contract.dto.ICaretakerDto;
import contract.dto.classes.CaretakerDto;
import contract.dto.mapper.ICaretakerMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;
import server.domain.classes.Role;

/**

 @author Thomas
 */
public class CaretakerMapper
        implements ICaretakerMapper
{
    private static CaretakerMapper controller;

    CaretakerMapper()
    {
    }

    public static ICaretakerMapper getInstance()
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
            List<ICaretakerDto> result = new LinkedList<ICaretakerDto>();

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
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException  ex)
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
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Caretaker createDomain(ICaretakerDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Caretaker caretaker = new server.domain.classes.Caretaker(value.getId());

        LinkedList<contract.domain.IPermission> permissionList = new LinkedList<IPermission>();
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

    @Override
    public ICaretakerDto getMemberById(Integer id) throws IdNotFoundException 
    {
        ICaretakerDto caretakerDto = null;
        try
        {
            List<Role> all = DomainFacade.getInstance().getAll(server.domain.classes.Role.class);
            for(Role r : all)
            {
                if(r.getMember().getId().equals( id))
                {
                    if(r instanceof server.domain.classes.Caretaker)
                    {
                        caretakerDto=CaretakerDto.copy((server.domain.classes.Caretaker)r);
                    }
                }
            }

            return caretakerDto;
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

}
