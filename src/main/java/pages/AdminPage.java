package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.element.ElementActions;

public class AdminPage {
    private WebDriver driver;
    By coursesList=By.xpath("//a[@id='btnMyCoursesList'] | //a[contains(@href,'/Course')]");

    public  String pageTitle= "Adminstration";
    public AdminPage(WebDriver driver){
        this.driver=driver;
    }


    public CoursesPage goToCoursesPage(){
        ElementActions.doClick(driver,coursesList);
        return new CoursesPage(driver);
    }




}
