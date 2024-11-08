package admission_onlineForm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;

public class AutoITImageUpload extends BaseTest {

	@FindBy(xpath="//span[@class='btn btn-primary'][1]")
	WebElement childPhoto;
	@FindBy(id="center_id")
	WebElement selectCenter_dropdown;
	@FindBy(xpath="//*[@id='center_id']/optgroup[15]/option[1]")
	WebElement centerSelected;

	@FindBy(id="admission_id")
	WebElement admisionID;
	@FindBy(id="btn_step_0")
	WebElement nextBtn1;

	@FindBy(xpath="//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span")
	WebElement father_photo;
	//Mother section----------------------------------------------------------------------------------------
	@FindBy(xpath="//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span")
	WebElement mother_photo;


	WebDriver driver;
	WebDriverWait wait;

	// Initializing the page Objects/webElement
	public static String downloadPath = "C:\\Users\\admin\\Downloads";
	String childExe_File = "C:\\Users\\SunitaGautam\\Desktop\\childImage.exe";
	String fatherExe_exe = "C:\\Users\\SunitaGautam\\Desktop\\fatherImage.exe";
	String motherExe_exe = "C:\\Users\\SunitaGautam\\Desktop\\motherImage.exe";

	public AutoITImageUpload(WebDriver driver) {
		this.driver = driver;
		// Use Duration to specify the timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000)); // Adjust timeout as needed
		PageFactory.initElements(driver, this);
	}

	public void ChildImage() throws IOException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(childPhoto));	            
		actions.moveToElement(childPhoto).click().perform();
		Runtime.getRuntime().exec(childExe_File);

	}

	public void fatherImage() throws IOException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(father_photo));	            
		actions.moveToElement(father_photo).click().perform();
		Runtime.getRuntime().exec(fatherExe_exe);
		
	}
	
	public void motherImage() throws IOException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
				
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(mother_photo));	            
		actions.moveToElement(mother_photo).click().perform();
		Runtime.getRuntime().exec(motherExe_exe);

	}
	public void Images() throws IOException, InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(childPhoto));	            
		actions.moveToElement(childPhoto).click().perform();
		Runtime.getRuntime().exec(childExe_File);
		Thread.sleep(1000);

		
		Actions actions1 = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(father_photo));	            
		actions1.moveToElement(father_photo).click().perform();
		Runtime.getRuntime().exec(fatherExe_exe);
		Thread.sleep(1000);
		
		Actions actions2 = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(mother_photo));	            
		actions2.moveToElement(mother_photo).click().perform();
		Runtime.getRuntime().exec(motherExe_exe);

	}

}
