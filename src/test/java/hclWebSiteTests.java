import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class hclWebSiteTests {
    @Test
    public void testLoadHclSiteAndGetPicture() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.hcl.com");

        WebElement closeButtonIFrame=driver.findElement(By.className("close-modal "));
        if(closeButtonIFrame.isDisplayed())
            closeButtonIFrame.click();

        WebElement acceptCookieButton=driver.findElement(By.id("onetrust-accept-btn-handler"));
        if(acceptCookieButton.isDisplayed())
            acceptCookieButton.click();

        WebElement leadershipButton=driver.findElement(By.xpath("//div/ul/li/a[text()='Leadership']"));
        explicitWait(driver,leadershipButton);

        if(leadershipButton.isDisplayed())
            leadershipButton.click();

        WebElement shivNadarH4=driver.findElement(By.xpath("//ul/li/div/h4[text()='Shiv Nadar']"));
        explicitWait(driver,shivNadarH4);
        Assert.assertTrue(shivNadarH4.isDisplayed(), "Shiv Nadar is presented in board of Directors");

        WebElement imgShivNadar = driver.findElement(By.xpath("//ul/li/div/h4[text()='Shiv Nadar']/ancestor::div/img"));
        String imagePath = imgShivNadar.getAttribute("src");

        try {
            BufferedImage image = ImageIO.read(new URL(imagePath));
            File myImage = new File(System.getProperty("user.dir") + "/target/shiv_nadar.jpg");
            if (myImage.createNewFile()) {
                System.out.println("File created: " + myImage.getName());
            } else {
                System.out.println("File already exists.");
            }
            ImageIO.write(image, "jpg", myImage);
        } catch (Exception e) {
            Assert.assertTrue(false, "Excception Occured while saving the image");
        }
        driver.close();
        driver.quit();

    }

    private void explicitWait(WebDriver driver, WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
