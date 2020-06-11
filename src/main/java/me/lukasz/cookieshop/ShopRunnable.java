package me.lukasz.cookieshop;

import me.lukasz.CookieClicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.TimerTask;

public class ShopRunnable extends TimerTask
{

    private WebDriver webDriver;
    private int i = 0;

    public ShopRunnable(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    @Override
    public void run()
    {
        if(i % 5 == 0)
        {
            i++;
            return;
        }
        CookieClicker.contineCicking = false;
        UpgradeInfo upgradeInfo = new UpgradeInfo(webDriver, "nop");
        //
        new CookieShop(webDriver, 1, "upgrade0").buyID(100);
        //
        if (upgradeInfo.setId("0").getOwned() <= 50)
        {
            new CookieShop(webDriver, 1, "product0").buyID(15);
        }
        if (upgradeInfo.setId("1").getOwned() <= 40)
        {
            new CookieShop(webDriver, 1, "product1").buyID(100);
        }
        if (upgradeInfo.setId("2").getOwned() <= 35)
        {
            new CookieShop(webDriver, 1, "product2").buyID(1100);
        }
        if (upgradeInfo.setId("3").getOwned() <= 20)
        {
            new CookieShop(webDriver, 1, "product3").buyID(12000);
        }
        if (upgradeInfo.setId("4").getOwned() <= 10)
        {
            new CookieShop(webDriver, 1, "product4").buyID(130000);
        }
        if (upgradeInfo.setId("5").getOwned() <= 5)
        {
            new CookieShop(webDriver, 1, "product5").buyID(1400000);
        }
        CookieClicker.contineCicking = true;
        i++;
    }

}
