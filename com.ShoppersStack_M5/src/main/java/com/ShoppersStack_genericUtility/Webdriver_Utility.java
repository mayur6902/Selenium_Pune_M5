package com.ShoppersStack_genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {

	Java_Utility java=new Java_Utility();
	
	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void getWebPageScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) Base_Test.sDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(Framework_Constants.screenshotPath+java.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}

	public void getWebElementScreenShot(WebElement element) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(Framework_Constants.screenshotPath+java.localDateTime()+".png");
		FileHandler.copy(temp, dest);
	}

}
