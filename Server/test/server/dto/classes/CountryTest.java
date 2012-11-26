/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.CountryDto;
import java.util.Random;
import org.easymock.EasyMock;
import org.junit.*;
import contract.dto.ICountryDto;

/**

 @author Thomas
 */
public class CountryTest
{
    public CountryTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void emptyConstructorTest()
    {
        CountryDto a = new CountryDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        CountryDto a = new CountryDto();

        Assert.assertTrue(a instanceof ICountryDto);
    }

    @Test
    public void interfaceConstructorTest()
    {
        contract.domain.ICountry country = EasyMock.createMock(contract.domain.ICountry.class);
        EasyMock.expect(country.getAlpha2()).andReturn("1").anyTimes();
        EasyMock.expect(country.getAlpha3()).andReturn("2").anyTimes();
        EasyMock.expect(country.getDeutsch()).andReturn("3").anyTimes();
        EasyMock.expect(country.getEspanol()).andReturn("4").anyTimes();
        EasyMock.expect(country.getFrancaise()).andReturn("5").anyTimes();
        EasyMock.expect(country.getItaliano()).andReturn("6").anyTimes();
        EasyMock.expect(country.getName()).andReturn("7").anyTimes();
        EasyMock.expect(country.getPortugues()).andReturn("8").anyTimes();
        EasyMock.expect(country.getTld()).andReturn("9").anyTimes();
        EasyMock.replay(country);

        CountryDto actual = CountryDto.copy(country);

        Assert.assertEquals(country.getName(), actual.getName());
        Assert.assertEquals(country.getAlpha3(), actual.getAlpha3());
        Assert.assertEquals(country.getAlpha2(), actual.getAlpha2());
        Assert.assertEquals(country.getTld(), actual.getTld());
        Assert.assertEquals(country.getDeutsch(), actual.getDeutsch());
        Assert.assertEquals(country.getEspanol(), actual.getEspanol());
        Assert.assertEquals(country.getFrancaise(), actual.getFrancaise());
        Assert.assertEquals(country.getItaliano(), actual.getItaliano());
        Assert.assertEquals(country.getPortugues(), actual.getPortugues());


        CountryDto a = new CountryDto();
    }

    @Test
    public void nameTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void alpha3Test()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setAlpha3(expected);
        actual = a.getAlpha3();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void alpha2Test()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setAlpha2(expected);
        actual = a.getAlpha2();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void tldTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setTld(expected);
        actual = a.getTld();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void deutschTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDeutsch(expected);
        actual = a.getDeutsch();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void espanolTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setEspanol(expected);
        actual = a.getEspanol();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void francaiseTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setFrancaise(expected);
        actual = a.getFrancaise();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void italianoTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setItaliano(expected);
        actual = a.getItaliano();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void portuguesTest()
    {
        CountryDto a = new CountryDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setPortugues(expected);
        actual = a.getPortugues();

        Assert.assertSame(expected, actual);
    }
}
