package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        loginPage.refreshPage();
    }

    @AfterClass
    public void afterClass() {
        loginPage.quit();
    }

    @Test
    public void testDropdownMenuIsDisplayed() {
        loginPage.clickSearchButton();
        assertTrue(loginPage.checkDropdownMenu(), "Dropdown menu is displayed");
    }

    @Test
    public void testMyAccountIsNotLoaded() {
        loginPage.clickMyAccountButton();
        assertEquals(loginPage.getURL(), "https://www.wiggle.com/login",
                "My account page is not loaded, when user not signed in");
    }
}
