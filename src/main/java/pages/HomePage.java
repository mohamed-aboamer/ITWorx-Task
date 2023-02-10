package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.element.ElementActions;

public class HomePage {
    private WebDriver driver;
    By emailInput=By.xpath("//input[@id='Email']");
    By passwordInput=By.xpath("//input[@id='inputPassword']");
    By loginButton=By.xpath("//input[@id='btnLogin']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * enter username then enter password then click on login
     * @param username string username
     *        password string password
     * @return
     */
    public HomePage login(String username,String password){
        ElementActions.type(driver,emailInput,username);
        ElementActions.type(driver,passwordInput,password);
        ElementActions.click(driver,loginButton);
        return this;
    }


}
