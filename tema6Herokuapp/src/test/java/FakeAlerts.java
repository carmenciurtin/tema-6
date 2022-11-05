import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class FakeAlerts {

    public static void main(String[] args) {
        // alertBoxTest();
        modalDialogTest();
    }

    public static void alertBoxTest() throws MalformedURLException {
        RemoteWebDriver driver = null;
        try {
            driver = WebBrowserManager.getRemoteChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");

            WebElement showAlertBox = driver.findElement(By.id("fakealert"));
            showAlertBox.click();

            WebElement modalText1 = driver.findElement(By.id("dialog-text"));
            System.out.println(modalText1.getText());

            WebElement okButton = driver.findElement(By.id("dialog-ok"));
            okButton.click();

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void modalDialogTest() {
        ChromeDriver driver = WebBrowserManager.getChromedriver();
        try {
            driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");

            WebElement showModalBox = driver.findElement(By.id("modaldialog"));
            for (int i = 0; i <= 1; i++) {
                System.out.println("Iteratia curenta: " + i);
                showModalBox.click();

                WebElement modalText2 = driver.findElement(By.id("dialog-text"));
                System.out.println(modalText2.getText());

                if (i == 0) {
                    WebElement okButton = driver.findElement(By.id("dialog-ok"));
                    okButton.click();
                } else {
                    WebElement clickAnywhere = driver.findElement(By.cssSelector("div.page-body"));
                    clickAnywhere.click();
                }
                System.out.println("-------------------");
                // throw new Exception();
            }
        } catch (Exception e) {
            File file = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\Radu\\IdeaProjects\\Screenshot2.png");
            try {
                FileUtils.copyFile(file, destFile);
            }
            catch (IOException eIO){
                System.out.println(eIO.getMessage());
            }
        } finally {
                driver.quit();
        }
    }
}