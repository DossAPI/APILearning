package org.IntegratingDDT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	
	@Test(dataProvider="data")
	public void login(String email,String password) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.linkText("Log out")).click();

	}
	
	@DataProvider(name="data")
	public String[][] sendData() throws IOException {
	
		
		return ReadExcel.readExcel();
	}

}
