import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseClass implements ITestListener {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void Wait () {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @BeforeTest
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown (){
        driver.close();
        driver.quit();

    }







}

