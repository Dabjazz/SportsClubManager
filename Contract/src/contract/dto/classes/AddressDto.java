package contract.dto.classes;

import contract.dto.IAddressDto;
import java.io.Serializable;
import java.util.HashMap;

public class AddressDto
        implements Serializable, IAddressDto
{
    private int id;
    private String street;
    private int streetNumber;
    private String village;
    private int postalCode;
    private int country;
    private static HashMap<contract.domain.IAddress, AddressDto> addresses = new HashMap<>();

    AddressDto(int id)
    {
        this.id = id;
    }

    public static AddressDto copy(contract.domain.IAddress address)
    {
        AddressDto a;

        if (addresses.containsKey(address))
        {
            a = addresses.get(address);
        }
        else
        {
            a = new AddressDto(address.getId());

            a.setStreet(address.getStreet());
            a.setPostalCode(address.getPostalCode());
            a.setStreetNumber(address.getStreetNumber());
            a.setVillage(address.getVillage());
            a.setCountry(address.getCountry().getId());

            addresses.put(address, a);
        }

        return a;
    }

    public AddressDto()
    {
    }

    @Override
    public String getStreet()
    {
        return street;
    }

    @Override
    public void setStreet(String street)
    {
        this.street = street;
    }

    @Override
    public int getStreetNumber()
    {
        return streetNumber;
    }

    @Override
    public void setStreetNumber(int streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getVillage()
    {
        return village;
    }

    @Override
    public void setVillage(String village)
    {
        this.village = village;
    }

    @Override
    public int getPostalCode()
    {
        return postalCode;
    }

    @Override
    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    @Override
    public int getCountry()
    {
        return country;
    }

    @Override
    public void setCountry(int country)
    {
        this.country = country;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
}