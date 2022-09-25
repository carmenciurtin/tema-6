
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Alerts {

    public static void main(String[] args) {
       // alertBoxTest();
       // confirmBoxTest();
        promptBoxTest();
    }

    public static void alertBoxTest() throws IOException {
        ChromeDriver driver = null;
        try {
            driver = WebBrowserManager.getChromedriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            WebElement showAlertBox = driver.findElement(By.id("alertexamples"));
            showAlertBox.click();
            Alert alertBox = driver.switchTo().alert();
            System.out.println(alertBox.getText());
            alertBox.accept();
            System.out.println(isAlertOpened(driver));
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
    public static void confirmBoxTest(){
        ChromeDriver driver = null;
        try{
            driver = WebBrowserManager.getChromedriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            WebElement showConfirmBox = driver.findElement(By.id("confirmexample"));
            for (int i = 0; i <= 1; i++){
                System.out.println("Iteratia curenta: " + i);
                showConfirmBox.click();
                System.out.println("Alerta este deschisa dupa click pe buton: " + isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if (i == 0) {
                    alert.accept();
                }else{
                    alert.dismiss();
                }
                System.out.println(driver.findElement(By.id("confirmexplanation")).getText());
                System.out.println("Alerta este deschisa dupa ce s-a inchis: " + isAlertOpened(driver));
                System.out.println("-------------------");
            }

        }finally{
            if (driver != null) {
                driver.quit();
            }
        }

    }
    public static void promptBoxTest()  {
        ChromeDriver driver = WebBrowserManager.getChromedriver();

        try{
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            WebElement showPromptBox = driver.findElement(By.id("promptexample"));
            for (int i = 0; i <= 1; i++){
                System.out.println("Iteratia curenta: " + i);
                showPromptBox.click();
                System.out.println("Alerta este deschisa dupa click pe buton: " + isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if (i == 0) {
                    alert.accept();
                }else{
                    alert.dismiss();
                }
                System.out.println(driver.findElement(By.id("promptexplanation")).getText());
                System.out.println("Alerta este deschisa dupa ce s-a inchis: " + isAlertOpened(driver));
                System.out.println("-------------------");
                throw new Exception();
            }
        }
        catch(Exception e){
            File file = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File("C:\\Users\\Radu\\IdeaProjects\\Screenshot1.png");
            try {
                FileUtils.copyFile(file, destFile);
            }
            catch (IOException eIO){
                System.out.println(eIO.getMessage());
            }
        }
        finally{
            driver.quit();
        }
    }
    public static boolean isAlertOpened(ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
