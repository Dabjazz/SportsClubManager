package database.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import database.DatabaseManager;
import domain.*;
import domain.contract.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.easymock.EasyMock;
import org.junit.*;

/**
 *
 * @author Thomas
 */
public class AddressTest
{
    @Before
    public void setUp()
    {
        DatabaseManager.clearDatabase();
    }

    @Test
    public void GetAndSetTest()
    {
        try
        {
            IAddress expected = EasyMock.createMock(IAddress.class);

            EasyMock.expect(expected.getStreet()).andReturn("Teststreet");

            DomainFacade.getInstance().set(expected);

            List<IAddress> actuals = DomainFacade.getInstance().getAll(IAddress.class);
            IAddress actual = actuals.get(0);

            Assert.assertEquals(1, actuals.size());
            Assert.assertEquals(expected.getStreet(), actual.getStreet());
        }
        catch (CouldNotSaveException ex)
        {
            Assert.fail("A exception is thrown");
        }
    }

    @Test
    public void GetAndDeleteTest()
    {
        try
        {
            IAddress expected = EasyMock.createMock(IAddress.class);

            EasyMock.expect(expected.getStreet()).andReturn("Teststreet");

            DomainFacade.getInstance().set(expected);
            DomainFacade.getInstance().getAll(expected);

            List<IAddress> actuals = DomainFacade.getInstance().getAll(IAddress.class);

            Assert.assertEquals(0, actuals.size());
        }
        catch (CouldNotSaveException ex)
        {
            Logger.getLogger(AddressTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void GetAndSetMultipleTest()
    {
        List<IAddress> expecteds = new LinkedList<>();

        for (int i = 0; i < 2; i++)
        {
            try
            {
                ICountry country = EasyMock.createMock(ICountry.class);

                IAddress expected = EasyMock.createMock(IAddress.class);
                EasyMock.expect(expected.getCountry()).andReturn(country);
                EasyMock.expect(expected.getPostalCode()).andReturn(new Random().nextInt());
                EasyMock.expect(expected.getStreet()).andReturn("Teststreet" + i);
                EasyMock.expect(expected.getStreetNumber()).andReturn(new Random().nextInt());
                EasyMock.expect(expected.getVillage()).andReturn("Testvillage" + i);

                expecteds.add(expected);
                DomainFacade.getInstance().set(expected);
            }
            catch (CouldNotSaveException ex)
            {
                Assert.fail("A exception is thrown");
            }
        }

        List<IAddress> actuals = DomainFacade.getInstance().getAll(IAddress.class);

        Assert.assertEquals(expecteds.size(), actuals.size());

        for (int i = 0; i < expecteds.size(); i++)
        {
            IAddress expected = expecteds.get(i);
            IAddress actual = actuals.get(i);
            Assert.assertEquals(expected.getStreet(), actual.getStreet());
            Assert.assertEquals(expected.getVillage(), actual.getVillage());
        }
    }
}
