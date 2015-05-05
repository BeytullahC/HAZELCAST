import dao.local.CountriesFacadeLocal;
import model.entities.Countries;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by 912867 on 05.05.2015.
 */
public class TestClass {
    private static EJBContainer container;
    private static Context ctx;
    private static final String COUNTRY_TEST_ID = "TR";
    private static CountriesFacadeLocal daoSessionBean;

    @BeforeClass
    public static void setup() throws IOException, NamingException {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "./src/test/resources/glassfish");
        container = EJBContainer.createEJBContainer(properties);
        ctx = container.getContext();
        daoSessionBean = (CountriesFacadeLocal) ctx.lookup("java:global/classes/CountriesFacadeBean");

    }

    @Test
    public void TestSave() {

        Countries country = new Countries();
        country.setCountryId("TR");
        country.setCountryName("TURKEY");
        daoSessionBean.create(country);
        System.out.println("TEST OK");

    }

    @Test
    public void testTeamService() throws NamingException {

        CountriesFacadeLocal teamEjb = (CountriesFacadeLocal) ctx
                .lookup("java:global/classes/CountriesFacadeBean");
        Countries country = teamEjb.find(COUNTRY_TEST_ID);
        assertEquals(COUNTRY_TEST_ID, country.getCountryId());
        System.out.println("TEST OK2 " + country);
    }

    @AfterClass
    public static void teardown() {
        container.close();
    }

}
