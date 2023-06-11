
    package org.example;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

    /**
     * 1. Parcurgeți primele 4 link-uri de la pagina https://testpages.herokuapp.com/styled/index.html.
     * <p>
     * 2. Localizați elementele de pe fiecare pagină.
     * Elementele care se pot click-ui se vor click-ui, iar pentru cele care au text se va afișa la consolă textul de pe ele.
     */
    public class Exercitiul2 {

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            String basicWebPageExample = "//a[@id='basicpagetest']";
            WebElement webPageExample = driver.findElement(By.xpath(basicWebPageExample));
            webPageExample.click();
            String xIndex = "//a[@href]";
            WebElement paragraph = driver.findElement(By.className("explanation"));
            System.out.println(paragraph.getText());
            WebElement firstParagraph = driver.findElement(By.className("main"));
            System.out.println(firstParagraph.getText());
            WebElement secondParagraph = driver.findElement(By.className("sub"));
            System.out.println(secondParagraph.getText());
            WebElement index = driver.findElement(By.xpath(xIndex));
            String xPathEvilTester = "//a[@target='_blank'][contains(text(), 'EvilTester.com')]";
            WebElement evilTesterr = driver.findElement(By.xpath(xPathEvilTester));
            evilTesterr.click();
            String xPathCompediumElements = "//a[@target='_blank'][contains(text(), 'Compendium Developments')]";
            WebElement compediumDevelopments = driver.findElement(By.xpath(xPathCompediumElements));
            compediumDevelopments.click();
            Thread.sleep(2000);
            index.click();
            Thread.sleep(2000);
            System.out.println("");
            driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");
            String xPathAttributeParagraph = "//div[@class='explanation']";
            WebElement attributeParagraph = driver.findElement(By.xpath(xPathAttributeParagraph));
            System.out.println(attributeParagraph.getText());
            String xpathCustomAttributeTitle = "//h2[contains(text(), 'Custom Attribute and JavaScript Added')]";
            WebElement customAttributeTitle = driver.findElement(By.xpath(xpathCustomAttributeTitle));
            System.out.println(customAttributeTitle.getText());
            String xPathNextAttributes = "//div[@class='centered']";
            WebElement nextAttributes = driver.findElement(By.xpath(xPathNextAttributes));
            System.out.println(nextAttributes.getText());
            String xPathJavaScriptAdded = "//h2[contains(text(), 'Dynamic JavaSript Added')]";
            WebElement javaScriptAdded = driver.findElement(By.xpath(xPathJavaScriptAdded));
            System.out.println(javaScriptAdded.getText());
            String xPathCustomId = "//p[@class = 'inline-explanation'][contains(text(), 'nextid')]";
            WebElement customId = driver.findElement(By.xpath(xPathCustomId));
            System.out.println(customId.getText());
        }
    }

