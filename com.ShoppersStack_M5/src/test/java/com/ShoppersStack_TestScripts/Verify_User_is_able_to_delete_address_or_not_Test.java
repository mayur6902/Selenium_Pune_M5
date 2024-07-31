package com.ShoppersStack_TestScripts;

import org.testng.annotations.Test;

import com.ShoppersStack_genericUtility.Base_Test;
import com.ShoppersStack_pom.MyAddress_Page;
import com.ShoppersStack_pom.MyProfile_Page;

public class Verify_User_is_able_to_delete_address_or_not_Test extends Base_Test {

	@Test
	public void deleteAddress() throws InterruptedException {

		homePage.getAccountSettings().click();
		homePage.getMyProfileBtn().click();

		MyProfile_Page myProfile = new MyProfile_Page(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddress_Page myAddress=new MyAddress_Page(driver);
		Thread.sleep(1000);
		myAddress.getDeleteBtn().click();
		Thread.sleep(1000);
		myAddress.getYesBtn().click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

}
