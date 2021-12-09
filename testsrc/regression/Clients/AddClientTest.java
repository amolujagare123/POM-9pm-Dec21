package regression.Clients;

import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

public class AddClientTest extends DoLogin {

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("Rupali");
        addClient.setClientSurname("More");
        addClient.setContainerLanguage("Spanish");
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("pqr");
        addClient.setClientCity("Pune");
        addClient.setClientState("MH");
        addClient.setClientZip("898988");
        addClient.setCountry("Hungary");
        addClient.setGender("Female");
        addClient.setBirthDate("12/17/1984");
        addClient.setClientPhone("898998");
        addClient.setClientMobile("89898");
        addClient.setClientFax("8989");
        addClient.setClientEmail("a@b.com");
        addClient.setClientWeb("www.xyz.com");
        addClient.setClientVat("767676");
        addClient.setClientTax("6767");

         addClient.clickBtnSave();



    }
}
