import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserManager {

    public static ChromeDriver getChromedriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
