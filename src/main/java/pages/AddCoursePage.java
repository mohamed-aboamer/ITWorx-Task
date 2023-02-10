package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.browser.BrowserActions;
import utilities.browser.JavaScriptWait;
import utilities.element.ElementActions;
import utilities.element.JavaScriptManager;
import utilities.element.WebElementWait;

public class AddCoursePage {
    private WebDriver driver;
    static String currentTime= String.valueOf(System.currentTimeMillis());
    public static String courseName = "test_course"+currentTime;
    By courseNameInput= By.xpath("//input[@id='txtCourseName']");
    By gradeDropMenu= By.xpath("//select[@id='courseGrade']");

    By courseTeacherDropMenu= By.xpath("//div[@id='teacherOnBehalf']");
    By firstTeacher= By.xpath("//ul//li//a[@id='lblCourseOwnerProfilePic']");
    By createButton=By.xpath("//button[@id='btnSaveAsDraftCourse']");
    By coursesList=By.xpath("//a[@id='btnMyCoursesList'] | //a[contains(@href,'/Course')]");
    public AddCoursePage(WebDriver driver){this.driver=driver;}

    public CoursesPage fillBasicInfo() throws InterruptedException {
        ElementActions.type(driver,courseNameInput,courseName);
        ElementActions.selectByVisibleText(driver,gradeDropMenu,"5");
        ElementActions.doClick(driver,courseTeacherDropMenu);
        ElementActions.doClick(driver,firstTeacher);
        ElementActions.doClick(driver,createButton);
        //BrowserActions.closeAlert(driver);
        Thread.sleep(2000);
        ElementActions.doClick(driver,coursesList);
        return new CoursesPage(driver);
    }

}
