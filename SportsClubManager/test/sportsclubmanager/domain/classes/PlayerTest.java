/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.classes.Player;
import sportsclubmanager.domain.contract.*;

/**

 @author Thomas
 */
public class PlayerTest
{
    public PlayerTest()
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
        Player a = new Player();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Player a = new Player();

        Assert.assertTrue(a instanceof IPlayer);
    }

    @Test
    public void typeOfSportListTest()
    {
        Player a = new Player();

        List<ITypeOfSport> expected = new LinkedList<ITypeOfSport>();
        List<ITypeOfSport> actual;

        expected.add(EasyMock.createMock(ITypeOfSport.class));
        expected.add(EasyMock.createMock(ITypeOfSport.class));
        expected.add(EasyMock.createMock(ITypeOfSport.class));
        expected.add(EasyMock.createMock(ITypeOfSport.class));

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertEquals(expected, actual);
    }
}
