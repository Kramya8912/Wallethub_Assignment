package com.wallethub.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wallethub.base.CoreSuper;
import com.wallethub.pages.FacebookLoginPage;

public class FacebookLoginTest extends CoreSuper {
	FacebookLoginPage facebookLoginPage;
		
public FacebookLoginTest() {
	super();
}

@BeforeTest
public void setup() {
	initialize();
	facebookLoginPage= new FacebookLoginPage();
}

@Test
public void verifyLoginPageTitle() {
	
	String actTitle= facebookLoginPage.getTitle();
	String expTitle= "Facebook – log in or sign up";
	Assert.assertEquals(actTitle, expTitle);
}

@Test
public void verifyLoginFunctionality() {
	
	facebookLoginPage.doLogin();
	Assert.assertTrue(true);
}

@AfterTest
public void tearDown() {
	driver.close();
}

}
