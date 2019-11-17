package sda.selenium.first;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstSeleniumTests {

    public WebDriver driver;

    public void HighlightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void testGoogleSearch()
    {
        WebElement searchBar = driver.findElement(By.name("q"));
        HighlightElement(driver,searchBar);
        searchBar.sendKeys("selenium tutorial");

        /*WebElement searchButton = driver.findElement(By.name("btnK"));
        HighlightElement(driver,searchButton);
        String titleOfPage = driver.getTitle();

        assertThat(titleOfPage).isEqualTo("Google");*/
    }

    @Test
    public void testDriverOrders()
    {
        String textToPass = "selenium tutorial";

        WebElement searchBar = driver.findElement(By.name("q"));
        HighlightElement(driver,searchBar);
        searchBar.sendKeys(textToPass);
        WebElement divnextTosearchBar = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf.emcat.emcav > div.RNNXgb > div > div.a4bIc > div"));
        String textFromDiv = divnextTosearchBar.getText();
        assertThat(textFromDiv).isEqualTo(textToPass);
    }

    @Test
    public void findingElementsOnDevTo()
    {
        driver.get("https://dev.to");
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/div[1]/a[2]"));
        HighlightElement(driver,logo);
    }

    @Test
    public void findingMultipleElementOnDevTo()
    {
        driver.get("https://dev.to");
        List<WebElement> listOfMultipleElements = driver.findElements(By.className("sidebar-nav-element"));
        for (WebElement element : listOfMultipleElements)
        {
            HighlightElement(driver, element);
        }
    }

    @Test
    public void continueWithoutError()
    {
        driver.get("https://dev.to");
       //WebElement notFoundElement = driver.findElement(By.className("korwin spiewa"));
        List<WebElement> listOfNotFoundElements = driver.findElements(By.className("we all live in the yellow submarine"));
    }

    @Test
    public void ClickOnElementIfListIsBiggerThatZero()
    {
        driver.get("https://dev.to");
        List<WebElement> listOfMultipleElements = driver.findElements(By.className("sidebar-nav-elemsdfghjkent"));
        if(listOfMultipleElements.size() > 0)
        {
            listOfMultipleElements.get(0).click();
        }
        else
            {
                driver.close();
            }
    }
    
}
