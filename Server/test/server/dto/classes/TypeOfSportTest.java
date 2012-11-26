/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.TypeOfSportDto;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import contract.dto.ITypeOfSportDto;

/**

 @author Thomas
 */
public class TypeOfSportTest
{
    public TypeOfSportTest()
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
        TypeOfSportDto a = new TypeOfSportDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        TypeOfSportDto a = new TypeOfSportDto();

        Assert.assertTrue(a instanceof ITypeOfSportDto);
    }

    @Test
    public void copyTest()
    {
        contract.domain.ITypeOfSport t4 = EasyMock.createMock(contract.domain.ITypeOfSport.class);
                EasyMock.expect(t4.getId()).andReturn(2).anyTimes();
        EasyMock.expect(t4.getName()).andReturn("name4").anyTimes();
        EasyMock.expect(t4.getDescription()).andReturn("description4").anyTimes();
        EasyMock.replay(t4);

        contract.dto.ITypeOfSportDto actual = TypeOfSportDto.copy(t4);

        Assert.assertEquals(t4.getDescription(), actual.getDescription());
        Assert.assertEquals(t4.getName(), actual.getName());
    }

    @Test
    public void nameTest()
    {
        TypeOfSportDto a = new TypeOfSportDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        TypeOfSportDto a = new TypeOfSportDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void playerListTest()
    {
        TypeOfSportDto a = new TypeOfSportDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setPlayerList(expected);
        actual = a.getPlayerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
