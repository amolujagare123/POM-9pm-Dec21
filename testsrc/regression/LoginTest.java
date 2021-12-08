package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utility.ConfigReader.getPassword;
import static utility.ConfigReader.getUsername;

public class LoginTest extends OpenUrl {

    @Test
    public void loginTest() throws IOException {

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();

    }
}
