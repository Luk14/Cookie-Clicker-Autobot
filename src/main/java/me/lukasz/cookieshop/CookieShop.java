package me.lukasz.cookieshop;

import me.lukasz.CookieClicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieShop
{

    private WebDriver webDriver;
    private int buyAmount = 1;
    private String id;

    public CookieShop(WebDriver webDriver, int buyAmount, String id)
    {
        this.webDriver = webDriver;
        this.buyAmount = buyAmount;
        this.id = id;
    }

    public void buyID(int defValue)
    {
        if(getCookies() < defValue)return;
        UpgradeInfo upgradeInfo = new UpgradeInfo(webDriver, id.substring(id.length()-1));
        if(getCookies() < upgradeInfo.getPrice())return;
        try
        {
            int amount = getCookies()/upgradeInfo.getPrice();
            for(int i = 0; i < amount; i++)
            {
                webDriver.findElement(By.id(id)).click();
            }
        }
        catch (Exception e)
        {
            System.out.println("You are too poor to buy " + this.id);
        }
    }

    private int getCookies()
    {
        String name = webDriver.findElement(By.id("cookies")).getText();
        String[] names = name.split("\n");
        name = names[0].replace(" cookies", "");
        name = name.replace(".", "");
        name = name.replace(" million", "");
        name = name.replace(" ", "");
        return Integer.parseInt(name.replace(",", ""));
    }
}
