package contract.dto.classes;

import java.io.Serializable;
import java.util.*;
import contract.dto.ICountryDto;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
public class CountryDto
        implements Serializable, ICountryDto
{
    private int id;
    private String name;
    private String alpha3;
    private String alpha2;
    private String tld;
    private String deutsch;
    private String espanol;
    private String francaise;
    private String italiano;
    private String portugues;

  public  CountryDto()
    {
    }

    CountryDto(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<contract.domain.ICountry, CountryDto> countries = new HashMap<>();

    public static CountryDto copy(contract.domain.ICountry country)
    {
        CountryDto a;

        if (countries.containsKey(country))
        {
            a = countries.get(country);
        }
        else
        {
            a = new CountryDto();

            a.setName(country.getName());
            a.setAlpha3(country.getAlpha3());
            a.setAlpha2(country.getAlpha2());
            a.setTld(country.getTld());
            a.setDeutsch(country.getDeutsch());
            a.setEspanol(country.getEspanol());
            a.setFrancaise(country.getFrancaise());
            a.setItaliano(country.getItaliano());
            a.setPortugues(country.getPortugues());

            countries.put(country, a);
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
    public String getAlpha3()
    {
        return alpha3;
    }

    @Override
    public void setAlpha3(String alpha3)
    {
        this.alpha3 = alpha3;
    }

    @Override
    public String getAlpha2()
    {
        return alpha2;
    }

    @Override
    public void setAlpha2(String alpha2)
    {
        this.alpha2 = alpha2;
    }

    @Override
    public String getTld()
    {
        return tld;
    }

    @Override
    public void setTld(String tld)
    {
        this.tld = tld;
    }

    @Override
    public String getDeutsch()
    {
        return deutsch;
    }

    @Override
    public void setDeutsch(String deutsch)
    {
        this.deutsch = deutsch;
    }

    @Override
    public String getEspanol()
    {
        return espanol;
    }

    @Override
    public void setEspanol(String espanol)
    {
        this.espanol = espanol;
    }

    @Override
    public String getFrancaise()
    {
        return francaise;
    }

    @Override
    public void setFrancaise(String francaise)
    {
        this.francaise = francaise;
    }

    @Override
    public String getItaliano()
    {
        return italiano;
    }

    @Override
    public void setItaliano(String italiano)
    {
        this.italiano = italiano;
    }

    @Override
    public String getPortugues()
    {
        return portugues;
    }

    @Override
    public void setPortugues(String portugues)
    {
        this.portugues = portugues;
    }

    @Override
    public String toString()
    {
        return this.getDeutsch();
    }
}
