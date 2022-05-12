package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MaxSteps {
    @Before
    public static void setUpClass(){ WebDriverManager.chromedriver().setup();}
    WebDriver driver = null;
    @Given("A sample web table")
    public void a_sample_web_table() {
        driver = new ChromeDriver();
    }
    @When("We have reached the table web page")
    public void we_have_reached_the_table_web_page() {
        driver.navigate().to("https://qavbox.github.io/demo/webtable/");
    }
    @Then("Displayl the maximum number in a column")
    public void displayl_the_maximum_number_in_a_column() {
        int max = 0;
        List<WebElement> i = driver.findElements(By.cssSelector("table#table02 > tbody > tr > td:nth-of-type(4)"));
        for (WebElement we: i){
            String temp = we.getText();
            int value = Integer.parseInt(temp);
            if((value > max)){
                max = value;
            }
        }
        System.out.println("Maximum age:"+ max);
    }
}
