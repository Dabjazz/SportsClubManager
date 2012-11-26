/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.NotFoundException;
import contract.domain.CouldNotSaveException;
import contract.domain.CouldNotFetchException;
import contract.domain.CouldNotDeleteException;
import java.util.*;
import java.util.logging.*;
import contract.dto.classes.MatchresultDto;
import contract.dto.IMatchresultDto;
import server.domain.DomainFacade;

/**

 @author Thomas
 */
public class MatchresultMapper
        implements IMapper<IMatchresultDto>
{
    private static MatchresultMapper controller;

    MatchresultMapper()
    {
    }

    public static IMapper<IMatchresultDto> getInstance()
    {
        if (controller == null)
        {
            controller = new MatchresultMapper();
        }

        return controller;
    }

    public contract.domain.IMatchresult getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMatchresult a = DomainFacade.getInstance().getByID(contract.domain.IMatchresult.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IMatchresultDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMatchresult a = DomainFacade.getInstance().getByID(contract.domain.IMatchresult.class, id);
            return MatchresultDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IMatchresultDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IMatchresultDto> result = new LinkedList<>();

            for (contract.domain.IMatchresult a : DomainFacade.getInstance().getAll(contract.domain.IMatchresult.class))
            {
                result.add(MatchresultDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IMatchresultDto value)
    {
        try
        {
            server.domain.classes.Matchresult matchresult = createDomain(value);

            return DomainFacade.getInstance().set(matchresult);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MatchresultMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMatchresultDto value)
    {
        try
        {
            server.domain.classes.Matchresult matchresult = createDomain(value);

            DomainFacade.getInstance().delete(matchresult);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MatchresultMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Matchresult createDomain(IMatchresultDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Matchresult matchresult = new server.domain.classes.Matchresult(value.getId());

        matchresult.setPointsForeignteam(value.getPointsForeignteam());
        matchresult.setPointsHometeam(value.getPointsHometeam());

        return matchresult;
    }

    @Override
    public IMatchresultDto getNew()
    {
        return new MatchresultDto();
    }
}
