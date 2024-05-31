package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pc\\Desktop\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        //TODO

        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(1920, 1032));
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("chihab4real");
        driver.findElement(By.name("password")).sendKeys("chihab2024");
        driver.findElement(By.name("repeat_password")).sendKeys("chihab2024");
        driver.findElement(By.name("name")).sendKeys("Chihab");
        driver.findElement(By.name("name")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("name")).sendKeys("ChihabEddine Zitouni");
        driver.findElement(By.name("addressData")).click();
        driver.findElement(By.name("addressData")).sendKeys("Pozn");
        driver.findElement(By.name("addressData")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("addressData")).sendKeys("Poznan");
        driver.findElement(By.name("submit")).click();
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Login"));
        driver.close();
    }


}
