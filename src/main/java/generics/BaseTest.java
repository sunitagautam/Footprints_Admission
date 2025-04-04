package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest implements IAutoConstant {
    // Non-static WebDriver instance to avoid issues in parallel execution
    protected static WebDriver driver;
    
    protected int passCount = 0, failCount = 0;

    @BeforeClass
    @Parameters("sBrowser")
    public void openBrowser(String sBrowser) {
        if (sBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome driver initialized");
            
        } else if (sBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (sBrowser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + sBrowser);
        }
        
        driver.manage().window().maximize();
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        System.out.println("WebDriver initialized: " + (driver != null));

    }

    @BeforeMethod
    
   //  for regular Admission
   public void openApplication() {
     driver.get(Admission_URL);
     }
    
    //  for Corporate Admission
//   public void openApplicationForm_Corporate() {
//       driver.get(Corporate_Admission_URL);
//   }
    
//For Summer Camp Admission
//    public void openApplicationForm_Corporate() {
//        driver.get(Summer_Camp_Admission);
//    }
    
    @AfterMethod
    public void handleTestResult(ITestResult res) {
        int status = res.getStatus();
        String methodName = res.getName();
        
        if (status == ITestResult.SUCCESS) {
            passCount++;
        } else if (status == ITestResult.FAILURE) {
            failCount++;
            String path = PHOTO_PATH + methodName + ".png";
            FWUtils.take_Screen_Shoot(driver, path);
        }
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
          //driver.quit(); // Use quit() instead of close() to ensure the browser process is terminated
          driver.close();
        }
    }

    @AfterSuite
    public void printReport() {
        Reporter.log("PassCount: " + passCount, true);
        Reporter.log("FailCount: " + failCount, true);
        FWUtils.set_XL_Data(REPORT_PATH, "result", 1, 0, passCount);
        FWUtils.set_XL_Data(REPORT_PATH, "result", 1, 1, failCount);
    }
}
