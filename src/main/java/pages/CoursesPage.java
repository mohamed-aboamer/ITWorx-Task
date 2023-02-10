package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.element.ElementActions;

import java.util.List;

public class CoursesPage {
    private WebDriver driver;

    By addCourseButton=By.xpath("//button[@id='btnListAddCourse']");
    By sortByList= By.xpath("//select[@id='CoursesOrderBy']");
    public By courseNameCreated=By.xpath("//*[contains(text(),"+AddCoursePage.courseName+")]");
    public String CoursePageTitle="Courses";

    public CoursesPage(WebDriver driver){
        this.driver=driver;
    }


    public AddCoursePage addCourse(){
        ElementActions.doClick(driver,addCourseButton);
        return new AddCoursePage(driver);
    }

    public CoursesPage sortBy(String sortTybe){
        ElementActions.selectByVisibleText(driver,sortByList,sortTybe);
        return this;
    }
}
