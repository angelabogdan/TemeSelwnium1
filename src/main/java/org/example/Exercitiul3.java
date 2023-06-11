package org.example;
/**3. Localizați cât mai multe elemente de pe pagina https://demoqa.com/elements,
 * de la tab-urile Text Box, Check Box, Radio Button, Web Tables, Radio Buttons,
 *Links. Folosiți cât mai multe strategii de localizare. Interacționați cu fiecare element.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercitiul3 {

    public static WebDriver driver;
    public static String xPathElements = "//h5[text()='Elements']";

    public static String xPathTextBox = "//*[@class ='text'][text() ='Text Box']";

    public static String xPathCheckBox = "//*[@class ='text'][text() ='Check Box']";

    public static String xPathRadioButton = "//*[@class ='text'][text() ='Radio Button']";

    public static String xPathWebTables = "//*[@class ='text'][text() ='Web Tables']";

    public static String xPathLinks = "//*[@class ='text'][text() ='Links']";

    public static void main(String[] args) throws InterruptedException {
        browserSetUp();
        openURL("https://demoqa.com");
        wait(2000);
        WebElement elementsPanel =  findElement(xPathElements);
        clickByJS(elementsPanel);
        findElement(xPathTextBox).click();
        wait(2000);
        findElement(xPathCheckBox).click();
        wait(2000);
        findElement(xPathRadioButton).click();
        wait(2000);
        findElement(xPathWebTables).click();
        wait(2000);
        findElement(xPathLinks).click();
        wait(2000);
        quitBrowser();



    }

    public static void browserSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebElement findElement(String xPath) {
        log("Trying to find: " + xPath);
        return driver.findElement(By.xpath(xPath));
    }

    public static void clickByJS(WebElement element) {
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
