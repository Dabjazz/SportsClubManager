package contract.dto.classes;

import contract.dto.ITypeOfSportDto;
import java.io.Serializable;
import java.util.*;

public class TypeOfSportDto
        implements Serializable, ITypeOfSportDto
{
    private int id;
    private String name;
    private String description;
    private List<Integer> playerList = new LinkedList<>();

    public TypeOfSportDto()
    {
    }

    TypeOfSportDto(int id)
    {
        this.id = id;
    }
    private static HashMap<contract.domain.ITypeOfSport, TypeOfSportDto> typeOfSports = new HashMap<>();

    public static TypeOfSportDto copy(contract.domain.ITypeOfSport typeOfSport)
    {
        TypeOfSportDto a;

        if (typeOfSports.containsKey(typeOfSport))
        {
            a = typeOfSports.get(typeOfSport);
        }
        else
        {
            a = new TypeOfSportDto(typeOfSport.getId());
            a.setName(typeOfSport.getName());
            a.setDescription(typeOfSport.getDescription());

            List<Integer> pls = new LinkedList<>();
            for (contract.domain.IPlayer p : typeOfSport.getPlayerList())
            {
                pls.add(p.getId());
            }
            a.setPlayerList(pls);

            typeOfSports.put(typeOfSport, a);
        }

        return a;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public List<Integer> getPlayerList()
    {
        return playerList;
    }

    @Override
    public void setPlayerList(List<Integer> playerList)
    {
        this.playerList = playerList;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
