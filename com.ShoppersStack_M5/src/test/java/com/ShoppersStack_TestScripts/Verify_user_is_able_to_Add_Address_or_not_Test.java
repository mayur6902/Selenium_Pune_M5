package com.ShoppersStack_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ShoppersStack_genericUtility.Base_Test;
import com.ShoppersStack_genericUtility.Listeners_Utility;
import com.ShoppersStack_pom.AddressForm_Page;
import com.ShoppersStack_pom.MyAddress_Page;
import com.ShoppersStack_pom.MyProfile_Page;
import com.aventstack.extentreports.Status;
@Listeners(Listeners_Utility.class)
public class Verify_user_is_able_to_Add_Address_or_not_Test extends Base_Test {

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
		test.log(Status.INFO, "Home Page is Displayed");
		homePage.getAccountSettings().click();
		homePage.getMyProfileBtn().click();

		test.log(Status.INFO, "MyProfile Page is Displayed");
		MyProfile_Page myProfile = new MyProfile_Page(driver);
		myProfile.getMyAddressBtn().click();

		test.log(Status.INFO, "MyAddress Page is Displayed");
		MyAddress_Page myAddress = new MyAddress_Page(driver);
		myAddress.getAddAddressBtn().click();

		test.log(Status.INFO, "AddressForm Page is Displayed");
		AddressForm_Page addressForm = new AddressForm_Page(driver);
		addressForm.getOfficeRbtn().click();
		addressForm.getNameTf().sendKeys(file.readExcelData("Sheet1", 1, 0));
		addressForm.getHouseTf().sendKeys(file.readExcelData("Sheet1", 1, 1));
		addressForm.getStreetTf().sendKeys(file.readExcelData("Sheet1", 1, 2));
		addressForm.getLandmarkTf().sendKeys(file.readExcelData("Sheet1", 1, 3));
		
		webDriverUtil.selectByValue(addressForm.getCountryDD(),file.readPropertyData("country"));
		webDriverUtil.selectByValue(addressForm.getStateDD(),file.readPropertyData("state"));
		webDriverUtil.selectByValue(addressForm.getCityDD(),file.readPropertyData("city"));
		
//		addressForm.getCountryDD().sendKeys(file.readPropertyData("country"));
//		addressForm.getStateDD().sendKeys(file.readPropertyData("state"));
//		addressForm.getCityDD().sendKeys(file.readPropertyData("city"));
		addressForm.getPincodeTf().sendKeys(file.readExcelData("Sheet1", 1, 4));
		addressForm.getPhoneNumberTf().sendKeys(file.readExcelData("Sheet1", 1, 5));
		addressForm.getAddAddressBtn().click();

	}

}
