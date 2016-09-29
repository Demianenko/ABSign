package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 22.09.2016.
 */
public class Page {
    protected WebDriver driver;
    public WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait(driver, 120);
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public void switchToFrame(String framePath){
        driver.switchTo().frame(driver.findElement(By.xpath(framePath)));
    }
    public void switchToWindow(int numberOfWindow){
        driver.switchTo().window(driver.getWindowHandles().toArray()[numberOfWindow].toString());
    }
    public void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }
    public WebElement waitElementForClick(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public void waitForAjax() {
        int timeoutInSeconds = 60;
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
                for (int i = 0; i< timeoutInSeconds; i++) {
                    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long)numberOfAjaxConnections;
                        //System.out.println("Number of active jquery ajax calls: " + n);
                        if (n.longValue() == 0L)
                            break;
                    }
                }
            }
            else {
                //System.out.println("Web driver: " + wd + " cannot execute javascript");
            }
        }
        catch ( WebDriverException e) {
            System.out.println("MeLog: AJax 5 second left");
            System.out.println(e);
        }
    }
    public void selectDropdownByVisibleText(WebElement selector, String choose) {
        waitForAjax();
        try {
            if (selector!=null) {
                Select mainOfficeLocationList = new Select(selector);
                mainOfficeLocationList.selectByVisibleText(choose);
            }
        }
        catch (WebDriverException e) {
        }
        waitForAjax();
    }
    public void selectDropdownByValue(WebElement selector, String choose) {
        waitForAjax();
        try {
            if (selector!=null) {
                Select mainOfficeLocationList = new Select(selector);
                mainOfficeLocationList.selectByValue(choose);
            }
        }
        catch (WebDriverException e) {
        }
        waitForAjax();
    }
}
