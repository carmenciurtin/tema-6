import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class BrowserWindows {
    public static void main(String[] args) {

        newTabs();
    }
    public static void newTabs() {
        RemoteWebDriver driver = null;

        try {
            driver = WebBrowserManager.getRemoteChromeDriver();

            driver.get("https://demoqa.com/browser-windows");
            driver.manage().window().maximize();

            WebElement title = driver.findElement(By.className("main-header"));
            System.out.println(title.getText());

            WebElement newTab = driver.findElement(By.id("tabButton"));
            newTab.click();
            System.out.println("Text window 1: This is a sample page");

            WebElement newWindow = driver.findElement(By.id("windowButton"));
            newWindow.click();
            System.out.println("Text window 2: This is a sample page");

            WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
            newWindowMessage.click();
            System.out.println("Text window 3: Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");

        } catch (Exception | Error e) {
            e.printStackTrace();
            if (driver != null) {

                File file = driver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("C:\\Users\\Radu\\IdeaProjects\\Screenshot5.png");
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

