//登陆的Action
package com.dbyl.libarary.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dbyl.libarary.pageAction.HomePage;
import com.dbyl.libarary.pageAction.LoginPage;
import com.dbyl.libarary.utils.PageFactory;

public class CommonLogin {

	private static WebDriver driver;  //private static是私有的,不能在其他类使用,只能通过静态方法调用,可以防止对变量的修改

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;

	public static HomePage login(String email, String password)
			throws Exception {
		loginPage = new LoginPage(getDriver());
		loginPage.waitForPageLoad();
		loginPage.typeUserName(email);
		loginPage.typePassword(password);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.isPrestentProfile(), "login failed");

		return (HomePage) PageFactory.getPage(HomePage.class, getDriver());
	}

	public static HomePage login() throws Exception {
		return CommonLogin.login("13282774643", "appium123");
	}

	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}

}
