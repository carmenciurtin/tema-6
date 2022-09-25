import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;


public class HTML5Form {

    public static void main(String[] args) {
        campuriDate();
    }

    public static void campuriDate() {
        ChromeDriver driver = null;

        try {
            driver = WebBrowserManager.getChromedriver();

            driver.get("https://testpages.herokuapp.com/styled/html5-form-test.html");
            WebElement colour = driver.findElement(By.cssSelector("input[type='color']"));
            colour.click();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("document.getElementById('colour-picker').value = '#EE3A14'");

            WebElement date = driver.findElement(By.cssSelector("input[type='date']"));
            date.click();

            date.sendKeys(Keys.TAB);
            date.sendKeys("08");
            date.sendKeys("19");
            date.sendKeys("2022");

            WebElement dateTime = driver.findElement(By.cssSelector("input[type='datetime-local']"));
            dateTime.click();
            dateTime.clear();

            dateTime.sendKeys("08");
            dateTime.sendKeys("19");
            dateTime.sendKeys("2022");
            dateTime.sendKeys(Keys.TAB);
            dateTime.sendKeys("09");
            dateTime.sendKeys("00");

            dateTime.sendKeys("PM");

            WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
            email.clear();
            email.sendKeys("carmenciurtin@yahoo.com");

            WebElement month = driver.findElement(By.cssSelector("input[type='month']"));

            month.sendKeys("August");
            month.sendKeys(Keys.TAB);
            month.sendKeys("2022");

            WebElement number = driver.findElement(By.cssSelector("input[type='number']"));
            number.click();
            number.clear();
            number.sendKeys("11");

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            submitButton.click();

            //WebElement resetButton = driver.findElement(By.cssSelector("input[type='reset']"));
            //resetButton.click();


        } catch (Exception | Error e) {
            e.printStackTrace();
            if (driver != null) {

                File file = driver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("C:\\Users\\Radu\\IdeaProjects\\Screenshot4.png");
                try {
                    FileUtils.copyFile(file, destFile);
                } catch (IOException eIO) {
                    System.out.println(eIO.getMessage());
                }
            } else {
                System.out.println("eroare");
            }

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
