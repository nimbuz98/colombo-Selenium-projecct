package com.pragmatictestlabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSelenium {

    @Test
    public void helloSelenium(){

        //setup web browser
        WebDriverManager.edgedriver().setup();

        //open a web browser
        WebDriver driver = new EdgeDriver();


        //Navigating to the login screen(Type URL- https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");

        //Type username - standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password - secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click the login
        driver.findElement(By.id("login-button")).click();

        //verify / check the product label is available in the landing page after the login page
        Assert.assertEquals( driver.findElement(By.cssSelector("span.title")).getText() ,"Products");

        //close the browser
        driver.quit();




    }

}
