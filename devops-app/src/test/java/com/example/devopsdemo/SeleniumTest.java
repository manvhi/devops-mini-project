package com.example.devopsdemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    @Test
    public void testAddAndDeleteTaskUI() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open the app
        driver.get("http://localhost:8080");
        Thread.sleep(1000);

        // ✅ ADD TASK
        WebElement input = driver.findElement(By.id("taskInput"));
        input.sendKeys("Selenium Test Task");
        Thread.sleep(1000);

        // Click Add Task button
        WebElement addButton = driver.findElement(By.tagName("button"));
        addButton.click();
        Thread.sleep(1000);

        // Verify task appears
        String pageContent = driver.getPageSource();
        assertTrue(pageContent.contains("Selenium Test Task"));

        // Show popup — Task Added
        js.executeScript("alert('✅ Task Added Successfully! Verified by Selenium.')");
        Thread.sleep(3000);

        // Dismiss popup
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        // ✅ DELETE TASK
        WebElement deleteButton = driver.findElement(By.className("delete-btn"));
        deleteButton.click();
        Thread.sleep(1000);

        // Reload page
        driver.navigate().refresh();
        Thread.sleep(1000);

        // Verify task is removed
        String pageAfterDelete = driver.getPageSource();
        assertFalse(pageAfterDelete.contains("Selenium Test Task"));

        // Show popup — Task Deleted
        js.executeScript("alert('✅ Task Deleted Successfully! Verified by Selenium.')");
        Thread.sleep(3000);

        // Dismiss popup
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        System.out.println("✅ Add and Delete both verified by Selenium!");

        driver.quit();
    }
}