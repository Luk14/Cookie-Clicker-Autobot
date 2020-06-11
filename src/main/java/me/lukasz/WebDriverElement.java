package me.lukasz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverElement
{

    private WebDriver webDriver;

    public WebDriverElement(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void createWeb()
    {
        this.webDriver.manage().window().maximize();
    }

    public void goToURL(String url)
    {
        this.webDriver.get(url);
    }

    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

}
