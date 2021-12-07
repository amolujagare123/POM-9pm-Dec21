package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPass;
import pages.Login;

public class ForgotPassTest {

    @Test
    public void forgotPassTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://[::1]/ip/index.php/sessions/login");

        Login login = new Login(driver);

        login.clickForgotPass();

        ForgotPass forgotPass = new ForgotPass(driver);
        forgotPass.setTxtEmail("amol@gmail.com");
        forgotPass.clickSubmit();
    }
}
