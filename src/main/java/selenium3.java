import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ZDH on 2017/7/6.
 */

  public class selenium3  {
        public static void main(String[] args) {
            // Create a new instance of the Firefox driver
            // Notice that the remainder of the code relies on the interface,
            // not the implementation.

//		File pathToBinary = new File("/Applications/IBM Firefox.app/Contents/MacOS/firefox");
//		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//		FirefoxProfile firefoxProfile = new FirefoxProfile();
//    	System.setProperty("webdriver.gecko.driver", "/Applications/IBM Firefox.app/Contents/MacOS/firefox");
//		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);

//    	WebDriver driver = new FirefoxDriver();

//		WebDriver driver = new SafariDriver();

            System.setProperty("webdriver.chrome.driver", "D:/Program/chromedriver_win32/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

//		HtmlUnitDriver driver = new HtmlUnitDriver(true);


            // And now use this to visit Google
//        driver.get("https://www.google.com.hk");
            driver.navigate().to("http://www.baidu.com");
            // Alternatively the same thing can be done like this
            // driver.navigate().to("http://www.google.com");

            // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
            WebElement element = driver.findElement(By.name("wd"));

            // Enter something to search for
            element.sendKeys("Cheese!");

            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();

            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            // Google's search is rendered dynamically with JavaScript.
            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("cheese!");
                }
            });

            // Should see: "cheese! - Google Search"
            System.out.println("Page title is: " + driver.getTitle());

            //Close the browser
            driver.quit();
        }
    }