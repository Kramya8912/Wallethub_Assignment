package com.wallethub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.base.CoreSuper;

public class FacebookLoginPage extends CoreSuper{
	
	
	@FindBy(id="email") WebElement userName_txt;
	@FindBy(id="pass") WebElement password_txt;
	@FindBy(id="u_0_3") WebElement submit_Btn;
	
	
	public FacebookLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String user) {
		userName_txt.clear();
		userName_txt.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password_txt.clear();
		password_txt.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		submit_Btn.click();
	}
	
	public HomePage doLogin() {
		
		enterUserName(prop.getProperty("username"));
		enterPassword(prop.getProperty("password"));
		clickOnLogin();
		return new HomePage();
		
	}
	
	public String getTitle() {
		String loginPageTitle=driver.getTitle();
		return loginPageTitle;
	}
	
}
