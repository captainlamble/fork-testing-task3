package com.stv.factory.factorypages;

import com.stv.framework.core.lib.WigglePageURLs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.stv.framework.core.drivers.MyDriver;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//ul[@class='FooterGroupLink FooterColLink1']/*/a[@href=\"/login\"]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"dvSearch\"]/form")
    private WebElement searchForm;

    @FindBy(xpath = "//*[@id=\"ui-id-1\"]")
    private WebElement dropdownMenu;


    public LoginPage() {
        driver = MyDriver.getDriver();
        driver.get(WigglePageURLs.START_URL + "login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);

        clickOnAllowCookiesIfVisible();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickSearchButton() {
        searchForm.click();
    }

    public boolean checkDropdownMenu() {
        return dropdownMenu.isDisplayed();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void quit() {
        driver.quit();
    }
}
