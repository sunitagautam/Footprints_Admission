package admission_onlineForm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;

public class AutoITChildImage extends BaseTest {
	@FindBy(xpath="//span[@class='btn btn-primary'][1]")
	WebElement childPhoto;
	
	WebDriver driver;
	WebDriverWait wait;

	// Initializing the page Objects/webElement
		public static String downloadPath = "C:\\Users\\admin\\Downloads";
		String filePath_child = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Veer.jpeg";

	public AutoITChildImage(WebDriver driver) {
		this.driver = driver;
		// Use Duration to specify the timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000)); // Adjust timeout as needed
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("deprecation")
	public void ChildImage() throws IOException {
		childPhoto.click();
       Runtime.getRuntime().exec("C:\\Users\\SunitaGautam\\Desktop\\childImage.exe");
		
	}


}
