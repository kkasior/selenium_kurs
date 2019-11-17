package sda.selenium.first.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    private WebDriver driver;

    public PageObject(WebDriver _driver)
    {
        this.driver = _driver;
        PageFactory.initElements(this.driver, this);
        this.driver.get("http://jsbin.com/osebed/2");
    }

    public By xd = By.cssSelector(""); //PAGE OBJECT

    @FindBy(how = How.CSS, using = "#fruits > option:nth-child(1)") //PAGE FACTORY
    public WebElement banana;

    public void ClickthatELement()
    {
        banana.click();
    }
}
