package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public static Actions action;
    public static JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        action = new Actions(driver);
        js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://www.halooglasi.com/");

    }
    @After
    public void tearDown() {
//        driver.quit();
    }
}
