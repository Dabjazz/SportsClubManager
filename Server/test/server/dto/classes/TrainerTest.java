/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.TrainerDto;
import contract.dto.ITrainerDto;
import java.util.*;
import org.junit.*;

/**

 @author Thomas
 */
public class TrainerTest
{
    public TrainerTest()
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
        TrainerDto a = new TrainerDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        TrainerDto a = new TrainerDto();

        Assert.assertTrue(a instanceof ITrainerDto);
    }

    @Test
    public void clubTeamListTest()
    {
        TrainerDto a = new TrainerDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;


        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertEquals(expected, actual);
    }
}
