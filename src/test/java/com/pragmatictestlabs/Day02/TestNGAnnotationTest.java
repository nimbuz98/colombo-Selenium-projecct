package com.pragmatictestlabs.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {

  private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        //setup web browser
        WebDriverManager.edgedriver().setup();

    }

    @BeforeMethod
    public void beforeMethod(){
        //open a web browser
        driver = new EdgeDriver();

        //Navigating to the login screen(Type URL- https://www.saucedemo.com/)
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(){
        if(driver!=null) {
            driver.quit();
        }
        //driver.close();
    }

    @Test
    public void helloSelenium(){


        //Type username - standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password -secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click the login
        driver.findElement(By.id("login-button")).click();

        //verify / check the product label is available in the landing page after the login page
        Assert.assertEquals( driver.findElement(By.cssSelector("span.title")).getText() ,"Products");

        //close the browser
        driver.quit();

    }
    @Test
    public void testMethod2(){
        System.out.println("2nd test");
        //your selenium code is here.
    }
}
