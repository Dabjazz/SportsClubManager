/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.MatchresultDto;
import java.util.Random;
import org.junit.*;
import contract.dto.IMatchresultDto;

/**

 @author Thomas
 */
public class MatchresultTest
{
    public MatchresultTest()
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
        MatchresultDto a = new MatchresultDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        MatchresultDto a = new MatchresultDto();

        Assert.assertTrue(a instanceof IMatchresultDto);
    }

    @Test
    public void pointsHometeamTest()
    {
        MatchresultDto a = new MatchresultDto();

        double expected = new Random().nextDouble();
        double actual = Integer.MAX_VALUE;

        a.setPointsHometeam(expected);
        actual = a.getPointsHometeam();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void pointsForeignteamTest()
    {
        MatchresultDto a = new MatchresultDto();

        double expected = new Random().nextDouble();
        double actual = Integer.MAX_VALUE;

        a.setPointsForeignteam(expected);
        actual = a.getPointsForeignteam();

        Assert.assertEquals(expected, actual, 0);
    }
}
