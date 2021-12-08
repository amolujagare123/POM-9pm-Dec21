package pages.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAdd1;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAdd2;

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;

    @FindBy (xpath="//input[@id='client_state']")
    WebElement clientState;

    @FindBy (xpath="//button[@id='btn-submit']")
    WebElement btnSave;

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    public void setClientAdd1(String add1)
    {
        clientAdd1.sendKeys(add1);
    }

    public void setClientAdd2(String add2)
    {
        clientAdd2.sendKeys(add2);
    }

    public void setClientCity(String city)
    {
        clientCity.sendKeys(city);
    }
    public void setClientState(String state)
    {
        clientState.sendKeys(state);
    }

    public void clickBtnSave()
    {
        btnSave.click();
    }
}
