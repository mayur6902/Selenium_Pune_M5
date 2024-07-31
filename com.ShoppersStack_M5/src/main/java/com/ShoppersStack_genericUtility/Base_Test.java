package com.ShoppersStack_genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShoppersStack_pom.Home_Page;
import com.ShoppersStack_pom.Login_Page;
import com.ShoppersStack_pom.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public File_Utility file = new File_Utility();
	public WebDriver driver;
	public static WebDriver sDriver;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriverWait wait;
	public Java_Utility java = new Java_Utility();
	public Webdriver_Utility webDriverUtil=new Webdriver_Utility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
		spark = new ExtentSparkReporter(Framework_Constants.reportPath + java.localDateTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest("Demo");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");
		String browser = file.readPropertyData("browser");
		String url = file.readPropertyData("url");
		
//		String browser = System.getProperty("browser");
//		String url = System.getProperty("url");

		if (browser.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.contains("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Enter Valid Browser Name");
		}
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);
		homePage = new Home_Page(driver);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("@BeforeMethod");
		welcomePage = new Welcome_Page(driver);
		WebElement ele = welcomePage.getLoginBtn();

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Thread.sleep(3000);
		ele.click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTf().sendKeys(file.readPropertyData("username"));
		loginPage.getPasswordTf().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		homePage.getAccountSettings().click();
		homePage.getLogOutBtn().click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
		report.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}

}
