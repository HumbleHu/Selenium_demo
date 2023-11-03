package com.example.selenium_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class seleniumDemo {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // 打印页面标题以确认页面已加载
        System.out.println("Page title is: " + driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        // 增加一个显示等待，以确保页面已经处理了表单提交
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement message = driver.findElement(By.id("message"));
        // 打印消息文本以确认操作成功
        System.out.println("Message is: " + message.getText());

        // 在关闭浏览器前等待一会儿，以便可以看到操作结果
        try {
            Thread.sleep(5000);  // 等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
