package admission_onlineForm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generics.BaseTest;
import generics.FWUtils;

public class Admission_Form extends BaseTest{
	// page Factory

	@FindBy(id="center_id")
	WebElement selectCenter_dropdown;
	@FindBy(xpath="//*[@id='center_id']/optgroup[15]/option[1]")
	WebElement centerSelected;

	@FindBy(id="admission_id")
	WebElement admisionID;
	@FindBy(id="btn_step_0")
	WebElement nextBtn1;

	//Validations Message
	@FindBy(id="center_id-error")
	WebElement centerError;
	@FindBy(id="admission_id-error")
	WebElement admissionIDError;

	//Online Form_Step1 
	//child section:
	//@FindBy(css = "#admission_source")
	@FindBy(id="admission_source")
	WebElement adSource;
	@FindBy(xpath="//*[@id='admission_source']/option[2]")
	WebElement optionFB;
	@FindBy(xpath="//span[@class='btn btn-primary'][1]")
	WebElement childPhoto;
	//span[@class='btn btn-primary'][1]
	@FindBy(id="name")
	WebElement childName;
	@FindBy(id="last_name")
	WebElement lastName_Child;
	@FindBy(id="gender")
	WebElement gender_dropdown;
	@FindBy(xpath="//*[@id='gender']/option[2]")
	WebElement gender_boy;
	@FindBy(id="blood_group")
	WebElement blood_dropdown;
	@FindBy(xpath ="//*[@id='blood_group']//option[2]")
	WebElement blood_A;
	@FindBy(id="allergies")
	WebElement allgergies;
	@FindBy(id="date_of_birth")
	WebElement dOB;
	@FindBy(xpath="//*[@id='date_of_birth_root']//div//div//div//div//div[1]//select[1]")
	WebElement select_year;
	@FindBy(xpath="//*[@id='date_of_birth_root']//div//div//div//div//div[1]//select[1]//option[7]")
	WebElement year_2022;
	@FindBy(xpath="//*[@id='date_of_birth_table']//tbody//tr[2]//td[1]//div")
	WebElement select_DOB;
	@FindBy(id="enrollment_date")
	WebElement joiningDate_Calendar;
	@FindBy(xpath="//*[@id='enrollment_date_root']//div//div//div//div//div[1]//select[2]")
	WebElement monthSelect_dropdown;
	@FindBy(xpath="//*[@id='enrollment_date_root']//div//div//div//div//div[1]//select[2]//option[10]")
	WebElement monthSelected; //October
	@FindBy(xpath="//*[@id='enrollment_date_table']//tbody//tr[4]//td[6]//div")
	WebElement joiningDate;
	@FindBy(id="length")
	WebElement program_dropdown;
	@FindBy(xpath="//*[@id='length']/option[2]")
	WebElement program_AfterSchool;
	@FindBy(xpath="//*[@id='length']/option[3]")
	WebElement program_EveningProgram;
	@FindBy(xpath="//*[@id='length']/option[4]")
	WebElement program_ExtendedPreschool;
	@FindBy(xpath="//*[@id='length']/option[5]")
	WebElement program_fullDay;
	@FindBy(xpath="//*[@id='length']/option[6]")
	WebElement program_HalfDay;

	@FindBy(id="discount_availed")
	WebElement discount_dropdown;
	@FindBy(xpath="//*[@id='discount_availed']/option[2]")
	WebElement discount_sibling;
	@FindBy(id="sibling_reference")
	WebElement reference_AdmissionID;
	@FindBy(xpath="//*[@id='discount_availed']/option[3]")
	WebElement discount_singleParent;

	@FindBy(xpath="//*[@id='discount_availed']/option[4]")
	WebElement discount_staff;
	@FindBy(id="select2-staff_reference-container")
	WebElement employee_ReferenceID_dropdown;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchEmployee;
	@FindBy(xpath ="//*[@id='staff_reference']/option[5]")
	WebElement selectEmployee5;
	//Billing/Shipping Address------------------------------------------------------------------------------------------
	@FindBy(id="address1")
	WebElement flatNo;
	@FindBy(id="address2")
	WebElement landmark;
	@FindBy(id="state")
	WebElement state_dropdown;
	@FindBy(xpath="//*[@id='state']/option[28]")
	WebElement state_UP;
	@FindBy(id="city")
	WebElement cityName;
	@FindBy(id="pincode")
	WebElement pincode;

	//Father section----------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span")
	WebElement father_photo;
	@FindBy(id="father_name")
	WebElement fatherName;
	@FindBy(id="father_email")
	WebElement fatherEmail;
	@FindBy(id="father_phone")
	WebElement fatherPhone;
	@FindBy(id="father_employer_detail")
	WebElement father_employer;
	@FindBy(id="father_not_working")
	WebElement checkbox_WorkingF;
	@FindBy(id="Father_NA")
	WebElement skipDetails_checkboxF;
	@FindBy(id="father_name-error")
	WebElement fname_ErrorMsg;
	@FindBy(id="father_email-error")
	WebElement femail_ErrorMsg;
	@FindBy(id="father_phone-error")
	WebElement fphone_ErrorMsg;

	//Mother section----------------------------------------------------------------------------------------
	@FindBy(xpath="//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span")
	WebElement mother_photo;
	@FindBy(id="mother_name")
	WebElement motherName;
	@FindBy(id="mother_email")
	WebElement motherEmail;
	@FindBy(id="mother_phone")
	WebElement motherPhone;
	@FindBy(id="mother_employer_details")
	WebElement mother_employer;
	@FindBy(id="mother_not_working")
	WebElement checkbox_WorkingM; 
	@FindBy(xpath="//*[@id='mother_not_required']")
	WebElement skipDetails_checkboxM;
	@FindBy(id="mother_name-error")
	WebElement mname_ErrorMsg;
	@FindBy(id="mother_email-error")
	WebElement memail_ErrorMsg;
	@FindBy(id="mother_phone-error")
	WebElement mphone_ErrorMsg;

	@FindBy(name="btn_reset_1")
	WebElement backBtn_step1;
	@FindBy(id="btn_step_1")
	WebElement nextBtn_step1;

	//Photo validations Messages: 
	@FindBy(id="child_photo-error")
	WebElement cphoto_sizeError;

	//Duplicate Admission case
	@FindBy(xpath ="//*[@id='modal_duplicate']//div//div//div[2]")
	WebElement duplicateAdmissionMsg;

	//Form_Step2*******************************************************************************************
	@FindBy(xpath ="//*[@id='validation-step3']/div[1]/div[1]")
	WebElement capture_AdmissionID;

	@FindBy(xpath ="//*[@id='validation-step3']//div[2]//div[2]//div[1]//div[4]/button")
	WebElement choosePlan_LongTerm;
	@FindBy(id="full_payment_checkbox_V1")
	WebElement v1_FullInvoice;
	@FindBy(xpath ="//*[@id='validation-step3']//div[2]//div[2]//div[2]//div[4]/button")
	WebElement choosePlan_ShortTerm;
	@FindBy(id="full_payment_checkbox_V2")
	WebElement v2_FullInvoice;
	@FindBy(xpath="//*[@id='frm_step_2']/div[2]/div/div[1]//div")
	WebElement selectedplanMsg;
	@FindBy(xpath="//form//div[2]//div//div[3]//div//div//label[1]//strong//input[@id='chk_term_cond']")
	WebElement checkbox_TermCond;
	@FindBy(id="btn_reset_2")
	WebElement backBtn_step2;
	@FindBy(id="btn_step_3")
	WebElement acceptContinue_btn;
	@FindBy(xpath="//html//body//div[5]//p[contains(text(), 'Education')]")
	WebElement paymentJSON;
	@FindBy(xpath="//html//body//div[5]//div[7]//div//button[text()='OK']")
	WebElement okBtn;
	
	//Eveningprogram_Age_Restriction
	
	@FindBy(xpath="//*[@id='validation-step2']/div[1]/div")
	WebElement ageMsg_EveningProgram;







	//------------------------------------------------------------------------------------------------
	// Initializing the page Objects/webElement
	public static String downloadPath = "C:\\Users\\admin\\Downloads";
	String filePath = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Veer.jpeg";
	String filePath_father = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Cfather.jpeg";
	String filePath_mother = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Cmother.jpeg";
	String filePath_1MB = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\moreThan1MB.jpeg";
	String filePath_multiplesFaces = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\multiplesFace.jpeg";
	String filePath_format_PDF = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\invoice.pdf";



	WebDriver driver;
	WebDriverWait wait;


	public Admission_Form(WebDriver driver) {
		this.driver = driver;
		// Use Duration to specify the timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000)); // Adjust timeout as needed
		PageFactory.initElements(driver, this);
	}

	
	public void OpenAdmision_OnlineFormPage() throws InterruptedException {
		driver.get(Admission_URL);
	}

	//SC_001_TC_003

	public void Admission_ViaCenterSelection() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
	}

	//SC_001_TC_004
	public void Admission_viaChildID() {
		admisionID.sendKeys("45960");
		nextBtn1.click();
	}
	//SC_001_TC_005
	public void mandatoryFields_validationErorr() {
		nextBtn1.click();
		System.out.println("Validation message without filling any field of form:"+ centerError.getText());
		System.out.println("Validation message without filling any field of form:"+ admissionIDError.getText());
	}
	//SC_001_TC_006
	public void WrongAdmission_ChildID() {
		admisionID.sendKeys("4596098");
		nextBtn1.click();

		// Use JavaScript to find the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement messageElement = (WebElement) js.executeScript("return document.querySelector('.alert')");

		if (messageElement != null) {
			System.out.println("Message text: " + messageElement.getText());
		} else {
			System.out.println("Message element not found.");
		}

	}
	//SC_002_TC_002
	public void Admission_Step1_filledsuccessfully() throws InterruptedException {
		//Full Day program
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("Tom");
		lastName_Child.sendKeys("Gupta");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

		//call the father & mother section methods------------------------------------------
		fatherSection_form();
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(skipDetails_checkboxM));
		skipDetails_checkboxM.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is" + capture_AdmissionID.getText());

	}
	//****************************************************************************
	public void ChildSection_form() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("Manju");
		lastName_Child.sendKeys("Singh");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		monthSelect_dropdown.click();
		monthSelected.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

	}

	// Father Section form...............................................................................
	public void fatherSection_form() {
		//FatherPhoto upload process via robot
		Actions action = new Actions(driver);
		WebElement fatherPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span[1]"))
				);
		action.moveToElement(fatherPhoto).click().perform();

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		fatherName.sendKeys("Lalit Singh");
		fatherEmail.sendKeys("kvam@gmail.com");
		fatherPhone.sendKeys("9909001295");
		father_employer.sendKeys("FPQA2");

	}


	// mother Section form...............................................................................

	public void motherSection_Form() {
		//motherPhoto upload process via robot
		// Locate the mother photo upload element
		Actions actions1 = new Actions(driver);
		WebElement motherPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span[1]")));

		actions1.moveToElement(motherPhoto).click().perform();

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(filePath);
			clipboard.setContents(stringSelection, null);

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
			// You may want to handle the exception more gracefully here
		}

		motherName.sendKeys("Lmamta");
		motherEmail.sendKeys("mla@gmail.com");
		motherPhone.sendKeys("8069001230");
		mother_employer.sendKeys("FPQ");
	}

	//SC_002_TC_003
	public void mandatroryfieldsValidations_Step1() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		FWUtils.scrollDown();
		Thread.sleep(500);
		nextBtn_step1.click();
		List<WebElement> errorValidationMsg = driver.findElements(By.xpath("//*[text()='This field is required.']"));
		System.out.println("Number of error validation messages on screen: " + errorValidationMsg.size());

		for (WebElement element : errorValidationMsg) {
			System.out.println(element.getText());
		}

	}
	//SC_002_TC_004
	public void ChildPhoto_SizeMore1MB_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_1MB);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement cphoto_sizeError1MB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("child_photo-error"))); // Update with correct locator
			System.out.println(cphoto_sizeError1MB.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	//SC_002_TC_004
	public void ChildPhoto_format_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_format_PDF);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("child_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	//SC_002_TC_004
	public void ChildPhoto_multiplesFaces_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_multiplesFaces);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("child_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	//-----------------------------------------------------------------------------------------
	//SC_002_TC_004
	public void fatherPhoto_SizeMore1MB_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span[1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_1MB);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("father_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	//SC_002_TC_004
	public void fatherPhoto_format_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span[1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_format_PDF);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("father_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	//SC_002_TC_004
	public void FatherPhoto_multiplesFaces_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='validation-step2']//div[2]//div[1]//div[2]/label/span[1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_multiplesFaces);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("father_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	//*************************************************************************
	//SC_002_TC_004
	public void motherPhoto_SizeMore1MB_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement motherPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span[1]"))
				);
		actions.moveToElement(motherPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_1MB);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mother_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	//SC_002_TC_004
	public void motherPhoto_format_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement motherPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span[1]"))
				);
		actions.moveToElement(motherPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_format_PDF);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mother_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	//SC_002_TC_004
	public void MotherPhoto_multiplesFaces_Validation() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement motherPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html//body//div[3]//div//div[1]//div//form//fieldset[3]//div[4]//div[1]//div[2]//label//span[1]"))
				);
		actions.moveToElement(motherPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath_multiplesFaces);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Validate file upload size error message
			WebElement photoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mother_photo-error"))); // Update with correct locator
			System.out.println(photoError.getText());

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	// SC_002_TC_006	
	public void program_DropdownList() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(program_dropdown));
		// Create a Select object to interact with the dropdown
		Select dropdown = new Select(program_dropdown);

		// Get all options from the dropdown
		List<WebElement> options = dropdown.getOptions();

		// Print each option
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

	// SC_002_TC_007
	public void Discount_DropdownList() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();

		wait.until(ExpectedConditions.visibilityOf(discount_dropdown));
		// Create a Select object to interact with the dropdown
		Select dropdown = new Select(discount_dropdown);

		// Get all options from the dropdown
		List<WebElement> options = dropdown.getOptions();

		// Print each option
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}
	//SC_002_TC_008
	public void Discount_SiblingDiscount() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		//  wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("jonny");
		lastName_Child.sendKeys("Gupta");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		discount_dropdown.click();
		discount_sibling.click();
		reference_AdmissionID.sendKeys("45973");
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

		//call the father & mother section methods------------------------------------------
		fatherSection_form();
		FWUtils.scrollDown();
		motherSection_Form();
		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is" + capture_AdmissionID.getText());
	}
	// SC_002_TC_009

	public void Discount_SingleParent() throws InterruptedException {
		//Single Parent Discount & Full Day program
		selectCenter_dropdown.click();
		centerSelected.click();
		nextBtn1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("Tarun");
		lastName_Child.sendKeys("Gupta");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		discount_dropdown.click();
		discount_singleParent.click();
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

		//call the father & mother section methods------------------------------------------
		fatherSection_form();
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(skipDetails_checkboxM));
		skipDetails_checkboxM.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is" + capture_AdmissionID.getText());

	}

	//SC_002_TC_010
	public void Discount_StaffDiscount() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("Sushil");
		lastName_Child.sendKeys("Gautam");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		discount_dropdown.click();
		discount_staff.click();
		employee_ReferenceID_dropdown.click();
		selectEmployee5.click();      
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

		//call the father & mother section methods------------------------------------------
		fatherSection_form();
		FWUtils.scrollDown();
		motherSection_Form();
		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is" + capture_AdmissionID.getText());
	}
	//SC_002_TC_011 (Inauguration Discount)------------------------------------


	// SC_002_TC_012
	public void validations_FatherMotherSection() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherName.sendKeys("Rahul1");
		fatherEmail.sendKeys("rahul@");
		fatherPhone.sendKeys("9379001");
		father_employer.sendKeys("CompTest");
		checkbox_WorkingF.click();

		motherName.sendKeys("gaii");
		motherEmail.sendKeys("gari@");
		motherPhone.sendKeys("88701239");
		mother_employer.sendKeys("QB Comp");
		checkbox_WorkingM.click();


		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn_step1));
		nextBtn_step1.click();
		System.out.println("Father Section Validation Msg is: " +fname_ErrorMsg.getText());
		System.out.println("Father Section Validation Msg is: " +femail_ErrorMsg.getText());
		System.out.println("Father Section Validation Msg is: "+ fphone_ErrorMsg.getText());

		System.out.println("Mother Section Validation Msg is: " +mname_ErrorMsg.getText());
		System.out.println("Mother section Validation Msg is: " +memail_ErrorMsg.getText());
		System.out.println("Mother section Validation Msg is: "+ mphone_ErrorMsg.getText());


	}
	// SC_002_TC_013
	public void checkboxIFNotWorking_FatherMotherSection() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherName.sendKeys("mohiy");
		fatherEmail.sendKeys("rahul@gmail.com");
		fatherPhone.sendKeys("9876543210");
		checkbox_WorkingF.click();

		motherName.sendKeys("NGarimm");
		motherEmail.sendKeys("gari@gmail.com");
		motherPhone.sendKeys("8870123990");
		checkbox_WorkingM.click();


		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn_step1));
		nextBtn_step1.click();
		System.out.println("employer Name should be empty");


	}
	// SC_002_TC_014
	public void BackButton_functionality_step1() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(backBtn_step1));
		backBtn_step1.click();
	}


	// SC_002_TC_015
	public void Duplicate_AdmissionForm() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("SiblingOne");
		lastName_Child.sendKeys("Gupta");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_fullDay.click();
		discount_dropdown.click();
		discount_sibling.click();
		reference_AdmissionID.sendKeys("45973");
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");

		//call the father & mother section methods------------------------------------------
		fatherSection_form();
		FWUtils.scrollDown();
		motherSection_Form();
		//wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(duplicateAdmissionMsg));
		System.out.println("Duplicate child Info Message is" + duplicateAdmissionMsg.getText());
	}
	//Step2___________________SC_003_TC_004__________

	public void choosePlan_shortTerm() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is  " + capture_AdmissionID.getText());
		choosePlan_ShortTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_TermCond));
		checkbox_TermCond.click();
		acceptContinue_btn.click();
		wait.until(ExpectedConditions.visibilityOf(paymentJSON));
		System.out.println("Print the Payment JSON "+ paymentJSON.getText());
		okBtn.click();
	}

	//SC_003_TC_005
	public void choosePlan_LongTerm() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.visibilityOf(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("AdmissionID Message is" + capture_AdmissionID.getText());
		choosePlan_LongTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_TermCond));
		checkbox_TermCond.click();
		acceptContinue_btn.click();
		wait.until(ExpectedConditions.visibilityOf(paymentJSON));
		System.out.println("Print the Payment JSON "+ paymentJSON.getText());
		okBtn.click();
	}
	//SC_003_TC_006
	public void generateFullInvoice_longTerm() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("Admission ID Message is  " + capture_AdmissionID.getText());
		v1_FullInvoice.click();
		choosePlan_LongTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_TermCond));
		checkbox_TermCond.click();
		acceptContinue_btn.click();
		wait.until(ExpectedConditions.visibilityOf(paymentJSON));
		System.out.println("Print the Payment JSON "+ paymentJSON.getText());
		okBtn.click();
	}
	//SC_003_TC_006 & SC_003_TC_007
	public void generateFullInvoice_shortTerm() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("Admission ID Message is  " + capture_AdmissionID.getText());
		v2_FullInvoice.click();
		choosePlan_ShortTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_TermCond));
		checkbox_TermCond.click();
		acceptContinue_btn.click();
		wait.until(ExpectedConditions.visibilityOf(paymentJSON));
		System.out.println("Print the Payment JSON "+ paymentJSON.getText());
		okBtn.click();
	}
	//SC_003_TC_008
	public void Step2_BackBtn_functionality() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("Admission ID Message is  " + capture_AdmissionID.getText());
		v2_FullInvoice.click();
		choosePlan_ShortTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		backBtn_step2.click();
	}
	//SC_004_TC_001 & SC_004_TC_002
	public void admission_orderSummary() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		//call child section method
		ChildSection_form();
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();					
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
		System.out.println("Admission ID Message is  " + capture_AdmissionID.getText());
		v2_FullInvoice.click();
		choosePlan_ShortTerm.click();
		wait.until(ExpectedConditions.visibilityOf(selectedplanMsg));
		System.out.println("display message after selected plan successfully.  "+selectedplanMsg.getText());
		FWUtils.scrollDown();
		wait.until(ExpectedConditions.elementToBeClickable(checkbox_TermCond));
		checkbox_TermCond.click();
		acceptContinue_btn.click();
		List<WebElement> tRows = driver.findElements(By.tagName("tr"));
		int countRows = tRows.size();
		System.out.println("Total no of Rows: " + countRows);

		List<WebElement> tColumns = driver.findElements(By.tagName("th"));
		int countColumns = tColumns.size();
		System.out.println("Total no of Columns: " + countColumns);

		for (int i = 0; i < tRows.size(); i++) {
			List<WebElement> tData = driver.findElements(By.tagName("td"));
			for (int j = 0; j < tData.size(); j++) {
				System.out.println(tData.get(j).getText());
			}
		wait.until(ExpectedConditions.visibilityOf(paymentJSON));
		System.out.println("Print the Payment JSON "+ paymentJSON.getText());
		 okBtn.click();
	}
	}
	//SC_011_TC_006
	public void Eveningprogram_Age_Restrictions() throws InterruptedException {
		selectCenter_dropdown.click();
		centerSelected.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn1));
		nextBtn1.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
		Select select = new Select(adSource);
		select.selectByVisibleText("Facebook");
		//childPhoto upload process via robot..................................................................................
		Actions actions = new Actions(driver);
		WebElement childPhoto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='btn btn-primary'][1]"))
				);
		actions.moveToElement(childPhoto).click().perform();
		//childPhoto.sendKeys(filePath);

		// Use Robot to handle the file upload dialog
		try {
			Robot robot = new Robot();

			// Pause to ensure the file dialog has opened
			Thread.sleep(2000);

			// Type the file path into the file dialog
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// Simulate keypresses to paste the file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Press Enter to confirm the file upload
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}

		childName.sendKeys("Ritik");
		lastName_Child.sendKeys("Singh");
		gender_dropdown.click();
		gender_boy.click();
		blood_dropdown.click();
		blood_A.click();
		allgergies.sendKeys("capsiucum");
		dOB.click();
		select_year.click();
		year_2022.click();
		select_DOB.click();
		joiningDate_Calendar.click();
		monthSelect_dropdown.click();
		monthSelected.click();
		joiningDate.click();
		Thread.sleep(500);
		program_dropdown.click();
		program_EveningProgram.click();
		flatNo.sendKeys("Amarpali ZOdaic");
		landmark.sendKeys("melliunium school");
		state_dropdown.click();
		state_UP.click();
		cityName.sendKeys("Noida");
		pincode.sendKeys("201301");
		FWUtils.scrollDown();
		fatherSection_form();
		motherSection_Form();
		wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
		nextBtn_step1.click();
		wait.until(ExpectedConditions.visibilityOf(ageMsg_EveningProgram));
		String messageText = ageMsg_EveningProgram.getText();
		System.out.println("Age Restriction Message: " + messageText);
	}
	

	
}
	


