package regression.Clients;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.FileInputStream;
import java.io.IOException;

import static util.DataProviderUtil.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String
   surname,String language,String address1 ,String address2 ,
    String city,String state,String zip,String country,
     String gender,String birthdate,String phone,String mobile,
      String fax,String email,String web,String vat,String tax,String expected,String xpathActual)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setContainerLanguage(language);
        addClient.setClientAdd1(address1);
        addClient.setClientAdd2(address2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthdate);
        addClient.setClientPhone(phone);
        addClient.setClientMobile(mobile);
        addClient.setClientFax(fax);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(vat);
        addClient.setClientTax(tax);

        addClient.clickBtnSave();

        String actual="";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"wrong output");


    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return  getMyData("Data/InvoicePlane.xlsx","Sheet1");
    }
}
