package stepsDefinitions;

import com.google.common.io.Files;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

        WebDriver driver;
        String LocationChrome;
        WebElement loginTextField, signInButton, passwordField, submitLogin, logOut;

        @Given("I launch chrome browser")
        public void i_launch_chrome_browser() {
                LocationChrome = "C:\\Program Files\\Chromedriver\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", LocationChrome);

        }

        @Given("I login to Alpha")
        public void i_login_to_alpha() throws InterruptedException {
                driver = new ChromeDriver();
                driver.get("https://wealth-test.psg.co.za/secure/accesscontrol-ui/auth/user-identifier?affiliateCode=psgWealthInvestmentPlatform");
                driver.manage().window().maximize();
                Thread.sleep(1000);
                loginTextField = driver.findElement(By.cssSelector("#username"));
                loginTextField.click();
                Thread.sleep(1000);
                loginTextField.sendKeys("9307215032087");
                Thread.sleep(1000);
                takeScreenShot("C:/Users/9109151100088/IdeaProjects/Alpha/src/main/resources/screenshots/USERNAME.png");
                Thread.sleep(5000);
                signInButton = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
                signInButton.click();
                Thread.sleep(25000);
                passwordField = driver.findElement(By.xpath("//input[@id='passwordInput']"));
                if(passwordField.isDisplayed()){
                        passwordField.sendKeys("Thabo#10");
                }else{
                        Thread.sleep(25000);
                }
                takeScreenShot("C:/Users/9109151100088/IdeaProjects/Alpha/src/main/resources/screenshots/PASSWORD.png");
                submitLogin = driver.findElement(By.id("submitButton"));
                submitLogin.click();
                Thread.sleep(33000);
                takeScreenShot("C:/Users/9109151100088/IdeaProjects/Alpha/src/main/resources/screenshots/HOMESCREEN.png");

        }

        @When("I access my investment Portfolio")
        public void i_access_my_investment_Portfolio() {
                System.out.println("Nkina");
        }

        @When("I logout of Alpha")
        public void i_logout_of_Alpha() throws InterruptedException {
                Thread.sleep(20000);
                logOut = driver.findElement(By.xpath("//button[@class='button small outline mr-2 d-none d-md-inline-flex']//span[contains(text(),'Logout')]"));
                Thread.sleep(30000);
                logOut.click();
                Thread.sleep(20000);
                takeScreenShot("C:/Users/9109151100088/IdeaProjects/Alpha/src/main/resources/screenshots/LOGOUT.png");
                driver.quit();
        }

        public void takeScreenShot(String filePathName) {
                var camera = (TakesScreenshot) driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);
                try {
                        Files.move(screenshot, new File(filePathName));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}