package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebElement driver;


public PageBase(WebDriver driver){
    PageFactory.initElements(driver,this);
}
}
