package com.basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseUserandAgent {
	
	public WebDriver driver;

	Properties prop;

	@BeforeClass
	public void lauchdriver() throws IOException {
		prop = new Properties();
		FileInputStream PropertyFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
	
		prop.load(PropertyFile);

		driver = new EdgeDriver();
		driver.get(prop.getProperty("urluser"));
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void CloseDriver() {
		driver.quit();
	}

}
