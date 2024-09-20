package com.advancia.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KebabLogin {
		
		public static void main(String[] args) {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/EsercizioKebab/");
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}

}
