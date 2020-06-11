package me.lukasz;

import me.lukasz.cookieshop.CookieShop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Timer;
import java.util.TimerTask;

public class CookieClickRun extends TimerTask
{

    private int cps;
    private WebElement cookie;
    private WebDriver webDriver;

    public CookieClickRun(int cps, WebDriver webDriver)
    {
        this.cps = cps;
        this.webDriver = webDriver;
        this.cookie = webDriver.findElement(By.id("bigCookie"));
    }

    public void run()
    {
        if(CookieClicker.contineCicking)
        {
            for (int i = 0; i < cps; i++)
            {
                cookie.click();
            }
        }
    }
}
