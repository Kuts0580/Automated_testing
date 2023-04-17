package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class  Log_In {
    private WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        //Thread.sleep(1000);
        driver.quit();
    }
    @Given("I access the eLMIS Log In Page")
    public void i_access_the_elmis_log_in_page() {
        driver.get("https://fe-demo.elmis-fe.com/");
    }
    @When("I enter a user name")
    public void i_enter_a_user_name() {
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("kutemba");
    }
    @And("I enter a password")
    public void i_enter_a_password() {
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("kutemba@123");
    }
    @And("I select a node")
    public void i_select_a_node() {
        driver.findElement(By.cssSelector("[value=\"10\"]")).click();//Dispensary
       //driver.findElement(By.cssSelector("[value=\"27\"]")).click();//MCH
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button()  {
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

    }
    @Then("I should be able to access eLmis front page")
    public void i_should_be_able_to_access_elmis_front_page() throws InterruptedException {
        //WebElement LogIn_Success_Message = driver.findElement(By.xpath("//div[@class='about-box']/h5[@class='heading']"));
       // Assert.assertEquals(LogIn_Success_Message.getText(),"eLMIS Facility Edition");
        Thread.sleep(3000);
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://fe-demo.elmis-fe.com/dashboard";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
