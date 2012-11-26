package server.dto.mapper;

import contract.domain.*;
import contract.dto.IPlayerDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.PlayerDto;

/**

 @author Thomas
 */
public class PlayerMapper
        implements IMapper<IPlayerDto>
{
    private static PlayerMapper controller;

    PlayerMapper()
    {
    }

    public static IMapper<IPlayerDto> getInstance()
    {
        if (controller == null)
        {
            controller = new PlayerMapper();
        }

        return controller;
    }

    public contract.domain.IPlayer getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPlayer a = DomainFacade.getInstance().getByID(contract.domain.IPlayer.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IPlayerDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPlayer a = DomainFacade.getInstance().getByID(contract.domain.IPlayer.class, id);
            return PlayerDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IPlayerDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IPlayerDto> result = new LinkedList<>();

            for (contract.domain.IPlayer a : DomainFacade.getInstance().getAll(contract.domain.IPlayer.class))
            {
                result.add(PlayerDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IPlayerDto value)
    {
        Integer rv = 0;
        try
        {

            server.domain.classes.Player p = createDomain(value);
            rv = DomainFacade.getInstance().set(p);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(PlayerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return rv;
        }
    }

    private server.domain.classes.Player createDomain(IPlayerDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Player player = new server.domain.classes.Player(value.getId());

        List<Integer> permissionList = value.getPermisssionList();
        List<Integer> typeOfSportList = value.getTypeOfSportList();

        LinkedList<contract.domain.IPermission> p = new LinkedList<>();
        for (int id : permissionList)
        {
            p.add(new PermissionMapper().getDomainById(id));
        }
        player.setPermissionList(p);

        LinkedList<contract.domain.ITypeOfSport> typeOfSports = new LinkedList<>();
        for (int id : typeOfSportList)
        {
            typeOfSports.add(new TypeOfSportMapper().getDomainById(id));
        }
        player.setTypeOfSportList(typeOfSports);

        return player;
    }

    @Override
    public void delete(IPlayerDto value)
    {
        try
        {
            server.domain.classes.Player p = createDomain(value);
            DomainFacade.getInstance().delete(p);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PlayerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public IPlayerDto getNew()
    {
        return new PlayerDto();
    }
}
