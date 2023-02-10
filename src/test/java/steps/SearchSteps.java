package steps;

import assertion.Validation;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddCoursePage;
import pages.LoginPage;
import pages.AdminPage;
import pages.CoursesPage;




public class SearchSteps extends BaseTest {
    private static LoginPage loginPage;
    private static AdminPage adminPage;
    private static CoursesPage coursesPage;
    private static AddCoursePage addCoursePage;
    @Given("user open winjigo website")
    public void user_open_winjigo_website() {
        loginPage= new LoginPage(getDriver());
    }
    @Given("user sign in with valid {string} username and {string} password")
    public void user_sign_in_with_valid_username_and_password(String string, String string2) {
        adminPage=loginPage.login(string,string2);
        Validation.using(getDriver()).pageContainTitle(adminPage.pageTitle);

    }
    @When("open courses page from left side navigation bar")
    public void open_courses_page_from_left_side_navigation_bar() {
        coursesPage=adminPage.goToCoursesPage();
        Validation.using(getDriver()).pageContainTitle(coursesPage.CoursePageTitle);
    }
    @When("click on create course button")
    public void click_on_create_course_button() {
        addCoursePage=coursesPage.addCourse();
    }
    @When("fill course basic info then click save")
    public void fill_course_basic_info_then_click_save() throws InterruptedException {
        coursesPage=addCoursePage.fillBasicInfo();

    }
    @Then("course title is displayed in courses list page")
    public void course_title_is_displayed_in_courses_list_page() {
        coursesPage.sortBy("Creation Date Descending");
        Validation.using(getDriver()).shouldBeVisible(coursesPage.courseNameCreated);

    }
}
