import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BMICalculator {
     WebDriver driver;

    @Test
    public void clickCalculator() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://healthunify.com/bmicalculator/");
            driver.findElement(By.name("cc")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            String siUnits = driver.findElement(By.name("si")).getAttribute("value");
            String usUnits = driver.findElement(By.name("us")).getAttribute("value");
            String ukUnits = driver.findElement(By.name("uk")).getAttribute("value");
            Assert.assertEquals(siUnits, "NaN");
            Assert.assertEquals(usUnits, "NaN");
            Assert.assertEquals(ukUnits, "NaN");
    }

    @Test
    public void checkWeightValid() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("10.1");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        String s = driver.findElement(By.name("si")).getAttribute("value");
        Assert.assertEquals(s, "4.89");
    }

    @Test
    public void checkWeightInvalid() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("10");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        Alert alert = driver.switchTo().alert();
        String s = alert.getText();
        alert.accept();
        Assert.assertEquals(s, "Weight should be greater than 10kgs");
    }

    @Test
    public void checkWeightInvalid2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("          ");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        Alert alert = driver.switchTo().alert();
        String s = alert.getText();
        alert.accept();
        Assert.assertEquals(s,"Weight should be greater than 10kgs");
    }

    @Test
    public void checkWeightInvalid3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("@#$%");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        String siUnits = driver.findElement(By.name("si")).getAttribute("value");
        String usUnits = driver.findElement(By.name("us")).getAttribute("value");
        String ukUnits = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(siUnits, "NaN");
        Assert.assertEquals(usUnits, "NaN");
        Assert.assertEquals(ukUnits, "NaN");
    }

    @Test
    public void checkWeightInvalid4() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("asdfg");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        String siUnits = driver.findElement(By.name("si")).getAttribute("value");
        String usUnits = driver.findElement(By.name("us")).getAttribute("value");
        String ukUnits = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(siUnits, "NaN");
        Assert.assertEquals(usUnits, "NaN");
        Assert.assertEquals(ukUnits, "NaN");
    }

    @Test
    public void checkWeightInvalid5() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("<script>alert(111);</script>");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        String siUnits = driver.findElement(By.name("si")).getAttribute("value");
        String usUnits = driver.findElement(By.name("us")).getAttribute("value");
        String ukUnits = driver.findElement(By.name("uk")).getAttribute("value");
        Assert.assertEquals(siUnits, "NaN");
        Assert.assertEquals(usUnits, "NaN");
        Assert.assertEquals(ukUnits, "NaN");
    }

    @Test
    public void checkWeightKgToPounds() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("30");
        String kg = driver.findElement(By.name("wg")).getAttribute("value");
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByValue("pounds");
        String pounds = driver.findElement(By.name("wg")).getAttribute("value");
        Assert.assertEquals(Double.parseDouble(pounds), Double.parseDouble(kg) * 2.2);
    }

    @Test
    public void checkWeightKgToPounds2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("30.1");
        String kg = driver.findElement(By.name("wg")).getAttribute("value");
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByValue("pounds");
        String pounds = driver.findElement(By.name("wg")).getAttribute("value");
        BigDecimal dcml = new BigDecimal(Double.parseDouble(kg) * 2.2);
        dcml = dcml.setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(pounds, dcml.toString());
    }

    @Test
    public void checkWeightPoundsToKg() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        Select select = new Select(driver.findElement(By.tagName("select")));
        select.selectByValue("pounds");
        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("30");
        String pound = driver.findElement(By.name("wg")).getAttribute("value");
        select.selectByValue("kilograms");
        String kg = driver.findElement(By.name("wg")).getAttribute("value");
        Assert.assertEquals(Double.parseDouble(kg), Double.parseDouble(pound) / 2.2);
    }

    @Test
    public void checkWeightPoundsToKg2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        Select select = new Select(driver.findElement(By.tagName("select")));
        select.selectByValue("pounds");
        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("30.1");
        String pound = driver.findElement(By.name("wg")).getAttribute("value");
        select.selectByValue("kilograms");
        String kg = driver.findElement(By.name("wg")).getAttribute("value");
        Assert.assertEquals(Double.parseDouble(kg), Double.parseDouble(pound) / 2.2);
    }

    @Test
    public void checkHeightFtToCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        Select select = new Select(driver.findElement(By.name("opt2")));
        select.selectByValue("2");
        String exp = driver.findElement(By.name("opt2")).getAttribute("value");
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.name("ht")).getAttribute("value")), Math.round(Integer.parseInt(exp) * 30.48));
    }

    @Test
    public void checkHeightInchesToCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        Select select = new Select(driver.findElement(By.name("opt3")));
        select.selectByValue("1");
        String exp = driver.findElement(By.name("opt3")).getAttribute("value");
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.name("ht")).getAttribute("value")), Math.round(Integer.parseInt(exp) * 2.54) + 30);
    }

    @Test
    public void checkHeightCmsToFtAndInches() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("ht")).sendKeys("64");
        Assert.assertEquals(driver.findElement(By.name("opt2")).getAttribute("value"), "2" );
        Assert.assertEquals(driver.findElement(By.name("opt3")).getAttribute("value"), "1" );
    }

    @Test
    public void checkHeightInvalid() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("cc")).click();
        Alert alert = driver.switchTo().alert();
        String s = alert.getText();
        alert.accept();
        Assert.assertEquals(s, "Height should be taller than 33cms");
    }

    @Test
    public void checkHeightInvalid2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("ht")).sendKeys("!@#$$");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("si")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("us")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("uk")).getAttribute("value"), "NaN");
    }

    @Test
    public void checkHeightInvalid3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("ht")).sendKeys("asdf");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("si")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("us")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("uk")).getAttribute("value"), "NaN");
    }

    @Test
    public void checkHeightInvalid4() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("ht")).sendKeys("<script>alert(111);</script>");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("si")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("us")).getAttribute("value"), "NaN");
        Assert.assertEquals(driver.findElement(By.name("uk")).getAttribute("value"), "NaN");
    }

    @Test
    public void checkSiUnits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        double weight = Double.parseDouble(driver.findElement(By.name("wg")).getAttribute("value"));
        double height = Double.parseDouble(driver.findElement(By.name("ht")).getAttribute("value"));
        double expected = weight / ((height/100.0) * (height/100.0));
        BigDecimal dcml = new BigDecimal(expected);
        dcml = dcml.setScale(2, RoundingMode.HALF_UP);
        String s = dcml.toString();
        Assert.assertEquals(driver.findElement(By.name("si")).getAttribute("value"), s);
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
