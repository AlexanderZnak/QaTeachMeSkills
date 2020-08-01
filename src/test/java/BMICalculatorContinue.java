import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMICalculatorContinue {
    WebDriver driver;

    @Test
    public void checkUsUnits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        Select select = new Select(driver.findElement(By.name("opt1")));
        select.selectByValue("pounds");
        driver.findElement(By.name("wg")).clear();
        driver.findElement(By.name("wg")).sendKeys("100");
        Select select1 = new Select(driver.findElement(By.name("opt2")));
        select1.selectByValue("3");
        Select select2 = new Select(driver.findElement(By.name("opt3")));
        select2.selectByValue("4");
        driver.findElement(By.name("cc")).click();
        double pounds = Double.parseDouble(driver.findElement(By.name("wg")).getAttribute("value"));
        double ft = Double.parseDouble(driver.findElement(By.name("opt2")).getAttribute("value"));
        double ic = Double.parseDouble(driver.findElement(By.name("opt3")).getAttribute("value"));
        double result = 703.0 * (pounds/ ((ft*12.0 + ic) * (ft*12.0 + ic)));
        BigDecimal dcml = new BigDecimal(result);
        dcml = dcml.setScale(2, RoundingMode.HALF_UP);
        String s = dcml.toString();
        Assert.assertEquals(driver.findElement(By.name("us")).getAttribute("value"), s);
    }

    @Test
    public void checkUkUnits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("70");
        driver.findElement(By.name("ht")).sendKeys("150");
        driver.findElement(By.name("cc")).click();
        double weight = Double.parseDouble(driver.findElement(By.name("wg")).getAttribute("value"));
        double height = Double.parseDouble(driver.findElement(By.name("ht")).getAttribute("value"));
        double si = weight / ((height/100.0) * (height/100.0));
        BigDecimal dcml = new BigDecimal(si);
        dcml = dcml.setScale(2, RoundingMode.HALF_UP);
        double result = Double.parseDouble(dcml.toString()) * 6.35;
        BigDecimal dcml2 = new BigDecimal(result);
        dcml2 = dcml2.setScale(2, RoundingMode.HALF_UP);
        String s = dcml2.toString();
        Assert.assertEquals(driver.findElement(By.name("uk")).getAttribute("value"), s);
    }

    @Test
    public void checkSiStarvationKgCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("59.6");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Starvation");
    }

    @Test
    public void checkSiUnderWeightKgCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("60");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Underweight");
    }

    @Test
    public void checkSiUnderWeightKgCms2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("74");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Underweight");
    }

    @Test
    public void checkSiNormalKgCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("74.4");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Normal");
    }

    @Test
    public void checkSiNormalKgCms2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("100");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Normal");
    }

    @Test
    public void checkSiOverWeightKgCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("100.4");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Overweight");
    }

    @Test
    public void checkSiOverWeightKgCms2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("120");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Overweight");
    }

    @Test
    public void checkSiObeseKgCms() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("120.4");
        driver.findElement(By.name("ht")).sendKeys("200");
        driver.findElement(By.name("cc")).click();
        Assert.assertEquals(driver.findElement(By.name("desc")).getAttribute("value"), "Your category is Obese");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
