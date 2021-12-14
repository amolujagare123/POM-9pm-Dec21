package dbTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static util.DataProviderUtil.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String
   surname,String language,String address1 ,String address2 ,
    String city,String state,String zip,String country,
     String gender,String birthdate,String phone,String mobile,
      String fax,String email,String web,String vat,String tax) throws ClassNotFoundException, SQLException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1 );
        expected.add(address2 );
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(mobile);
        expected.add(fax);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setContainerLanguage(language); // english
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

        Class.forName("com.mysql.cj.jdbc.Driver");

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url,user,pass);

        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(rs.getString("client_country"));
            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"wrong output");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return  getMyData("Data/InvoicePlane.xlsx","dbTesting");
    }
}
