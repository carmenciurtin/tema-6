import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HTMLForm {

    public static void main(String[] args) {
        campuriDate();
    }

    public static void campuriDate() {
        RemoteWebDriver driver = null;
        try {
            driver = WebBrowserManager.getRemoteChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement comment = driver.findElement(By.name("comments"));
            WebElement fileUpload = driver.findElement(By.name("filename"));

            WebElement hiddenInput = driver.findElement(By.name("hiddenField"));

            List<WebElement> checkBoxes = driver.findElements(By.name("checkboxes[]"));
            List<WebElement> radioButtons = driver.findElements(By.name("radioval"));

            Select select = new Select(driver.findElement(By.name("multipleselect[]")));
            Select dropDown = new Select(driver.findElement(By.name("dropdown")));

            WebElement cancelButton = driver.findElement(By.cssSelector("input[type='reset']"));


            username.sendKeys("alba ca zapada");
            password.sendKeys("cei7pitici");

            comment.clear();
            comment.sendKeys("categoria povesti");

            fileUpload.sendKeys("C:\\Users\\Radu\\IdeaProjects\\Screenshot.png");

            //hiddenInput.sendKeys("element ascuns");
            System.out.println(hiddenInput.getAttribute("value"));
            checkBoxes.get(1).click();

            radioButtons.get(2).click();

            select.deselectAll();
            select.selectByValue("ms1");
            select.selectByValue("ms2");

            dropDown.selectByIndex(2);

            submitButton.click();


        } catch (Exception | Error e) {
            e.printStackTrace();
            if (driver != null) {

                File file = driver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("C:\\Users\\Radu\\IdeaProjects\\Screenshot3.png");
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
