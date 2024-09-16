package admission_onlineFormTestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import admission_onlineForm.AdmissionForm_ViaExcel;
import admission_onlineForm.AutoITImageUpload;
import generics.BaseTest;
import generics.FWUtils;

public class AutoITImageuploadTestScripts extends BaseTest{
	
	@BeforeMethod
	public void OpenAdmisisonForm_Page() throws InterruptedException {
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
		// other WebDriver setup code
	}

	@Test()
	public void imageUpload()throws InterruptedException, IOException 
	{
		AutoITImageUpload ad_form = new AutoITImageUpload(driver);
		ad_form.Images();
	}


}
