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
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("pqr");
        addClient.setClientCity("Pune");
        addClient.setClientState("MH");
        addClient.clickBtnSave();



    }
}
