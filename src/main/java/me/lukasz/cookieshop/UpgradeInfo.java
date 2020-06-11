package me.lukasz.cookieshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpgradeInfo
{

    private WebDriver webDriver;
    private String id;

    public UpgradeInfo(WebDriver webDriver, String id)
    {
        this.webDriver = webDriver;
        this.id = id;
    }

    public int getPrice()
    {
        if(id.equalsIgnoreCase("upgrade0"))return 0;
        String price = webDriver.findElement(By.id("productPrice" + id)).getText();
        if(price==null||price.equalsIgnoreCase(""))return 99999999;
        price = price.replace(".", "");
        price = price.replace(" millions", "00000");
        int prices = Integer.parseInt(price.replace(",", ""));
        return prices;
    }

    public int getOwned()
    {
        String owned = webDriver.findElement(By.id("productOwned" + id)).getText();
        if(owned==null||owned.equalsIgnoreCase(""))return 0;
        int owneds = Integer.parseInt(owned);
        return owneds;
    }

    public UpgradeInfo setId(String id)
    {
        this.id = id;
        return this;
    }
}
