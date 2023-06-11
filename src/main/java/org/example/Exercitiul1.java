package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Tema de weekend:
 * 1. Sa se navigheze pe: https://demoqa.com/
 * 2. Sa se dea click pe categoria "Elements"
 * 3. Sa se dea click pe categoria "Check Box"
 * 3. Sa se dea click pe semnul plus '+' pentru a face expand
 * 4. Sa se bifeze checkbox -ul 'Public'
 * 5. Sa se afiseze textul in urma bifei de 'Public'
 * 6. Sa se afiseze culoarea textului generat in urma bifei de 'Public'
 */

public class Exercitiul1 {

    public static WebDriver driver;
    public static String xPathElements = "//h5[text()='Elements']";

    public static String xPathCheckBox = "//*[@class ='text'][text() ='Check Box']";

    public static String xPathPlusButton = "//button[@aria-label = 'Expand all']";
    public static void main(String[] args) throws InterruptedException {
        //1. Sa se navigheze pe: https://demoqa.com/
        browserSetUp();
        openURL("https://demoqa.com/");
        wait(2000);
        //  2. Sa se dea click pe categoria "Elements".
        WebElement elementsPanel =  findElement(xPathElements);
        clickByJS(elementsPanel);
        // 3. Sa se dea click pe categoria "Check Box".
        wait(2000);
        findElement(xPathCheckBox).click();
        wait(2000);
        //4. Sa se dea click pe semnul plus '+' pentru a face expand
        findElement(xPathPlusButton).click();
        wait(2000);
        quitBrowser();




    }

    public static void browserSetUp() {
        log("Setting up Chrome browser.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebElement findElement(String xPath) {
        log("Trying to find: " + xPath);
        return driver.findElement(By.xpath(xPath));
    }

    public static void clickByJS(WebElement element){
        log("Clicking by JavaScript: " + element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    public static void quitBrowser() {
        log("Closing Chrome browser.");
        driver.quit();
    }

    public static void openURL(String url) {
        log("Opening URL: " + url);
        driver.get(url);
    }

    public static void log(String login) {
        System.out.println(login);
    }

    public static void wait(int millis) throws InterruptedException {
        log(String.format("Waiting for %d millis.", millis));
        Thread.sleep(millis);
    }
}