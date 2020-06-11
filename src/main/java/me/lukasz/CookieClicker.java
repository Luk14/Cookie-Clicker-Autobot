package me.lukasz;

import me.lukasz.cookieshop.CookieShop;
import me.lukasz.cookieshop.ShopRunnable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class CookieClicker
{

    public static WebDriverElement webDriverElement;
    public static boolean contineCicking;

    public static void main(String[] args)
    {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriverElement = new WebDriverElement(webDriver);
        webDriverElement.createWeb();
        webDriverElement.goToURL("https://orteil.dashnet.org/cookieclicker/");
        contineCicking = true;
        Timer timer = new Timer();
        timer.schedule(new CookieClickRun(25, webDriverElement.getWebDriver()), 5000, 250);
        timer.schedule(new ShopRunnable(webDriver), 5000, 10000);
    }


}
