package com.ShoppersStack_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressForm_Page {
	
	public AddressForm_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Office")
	private WebElement officeRbtn;
	
	@FindBy(id = "Name")
	private WebElement nameTf;
	
	@FindBy(xpath = "//input[contains(@id,'House')]")
	private WebElement houseTf;
	
	@FindBy(xpath = "//input[contains(@id,'Street')]")
	private WebElement streetTf;
	
	@FindBy(id = "Landmark")
	private WebElement landmarkTf;
	
	@FindBy(id = "Country")
	private WebElement countryDD;
	
	@FindBy(id = "State")
	private WebElement stateDD;
	
	@FindBy(id = "City")
	private WebElement cityDD;
	
	@FindBy(id = "Pincode")
	private WebElement pincodeTf;
	
	@FindBy(xpath = "//input[contains(@id,'Phone')]")
	private WebElement phoneNumberTf;
	
	@FindBy(id = "addAddress")
	private WebElement addAddressBtn;

	public WebElement getOfficeRbtn() {
		return officeRbtn;
	}

	public WebElement getNameTf() {
		return nameTf;
	}

	public WebElement getHouseTf() {
		return houseTf;
	}

	public WebElement getStreetTf() {
		return streetTf;
	}

	public WebElement getLandmarkTf() {
		return landmarkTf;
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getStateDD() {
		return stateDD;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getPincodeTf() {
		return pincodeTf;
	}

	public WebElement getPhoneNumberTf() {
		return phoneNumberTf;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}

}
