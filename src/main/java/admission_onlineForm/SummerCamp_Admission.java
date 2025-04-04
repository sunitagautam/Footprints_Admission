package admission_onlineForm;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class SummerCamp_Admission extends BaseTest{
	
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
			@FindBy(css = "#admission_source")
			WebElement adSource;
			@FindBy(xpath="//*[@id='admission_source']/option[2]")
			WebElement optionFB;
			@FindBy(xpath="//span[@class='btn btn-primary'][1]")
			WebElement childPhoto;
			//span[@class='btn btn-primary'][1]
			@FindBy(xpath="//*[@id='name']")
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
			@FindBy(xpath="//*[@id='enrollment_date_root']//div//div//div//div//div[1]//div[2]")
			WebElement nextMonth_arrow;
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
			WebElement rSibling_AdmissionID;
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
			@FindBy(xpath="//input[@id='chk_term_cond']")
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
			String filePath_child = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Veer.jpeg";
			String filePath_father = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Cfather.jpeg";
			String filePath_mother = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\Cmother.jpeg";
			String filePath_1MB = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\moreThan1MB.jpeg";
			String filePath_multiplesFaces = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\multiplesFace.jpeg";
			String filePath_format_PDF = "C:\\Users\\SunitaGautam\\Desktop\\Documents\\Photo_admission\\invoice.pdf";
			//AutoIT exe files
			String childExe_File = "C:\\Users\\SunitaGautam\\Desktop\\childImage.exe";
			String fatherExe_exe = "C:\\Users\\SunitaGautam\\Desktop\\fatherImage.exe";
			String motherExe_exe = "C:\\Users\\SunitaGautam\\Desktop\\motherImage.exe";


			WebDriver driver;
			WebDriverWait wait;


			public SummerCamp_Admission(WebDriver driver) {
			    this.driver = driver;
			    this.wait = new WebDriverWait(driver, Duration.ofSeconds(2000)); // Adjust timeout as needed
			    PageFactory.initElements(driver, this);
			}



			public void OpenSummerCamp_Admision_OnlineForm() throws InterruptedException {
				driver.get(Summer_Camp_Admission);
			}
			
			
			public void setSummerCamp_Childform(String centers,String socialMedia,String gender,String bloodGp,String program,String state,
					String firstName,String lastName,String allergies,String flat, String landMark,String city,
					String pcode,String fName,String fEmailID,String fMobile,String fEmployerName,String mName,String mEmailID,
					String mMobile, String mEmployerName) throws InterruptedException, IOException {
				Select select0 =new Select(selectCenter_dropdown);
				selectCenter_dropdown.sendKeys(centers);
				wait.until(ExpectedConditions.visibilityOf(nextBtn1));
				nextBtn1.click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#admission_source")));
				Select select = new Select(adSource);
				adSource.sendKeys(socialMedia);

				Select select1 = new Select(gender_dropdown);
				gender_dropdown.sendKeys(gender);
				Select select2 = new Select(blood_dropdown);
				blood_dropdown.sendKeys(bloodGp);
				Select select3 = new Select(program_dropdown);
				program_dropdown.sendKeys(program);

				wait.until(ExpectedConditions.visibilityOf(state_dropdown));
				Select select5 = new Select(state_dropdown);
				state_dropdown.sendKeys(state);

				dOB.click();
				select_year.click();
				year_2022.click();
				select_DOB.click();
				joiningDate_Calendar.click();
				nextMonth_arrow.click();
				joiningDate.click();

				wait.until(ExpectedConditions.visibilityOf(childName));
				childName.sendKeys(firstName);
				lastName_Child.sendKeys(lastName);
				allgergies.sendKeys(allergies);
				flatNo.sendKeys(flat);
				landmark.sendKeys(landMark);
				cityName.sendKeys(city);
				wait.until(ExpectedConditions.visibilityOf(pincode));
				pincode.sendKeys(pcode);
				//Father details:
				wait.until(ExpectedConditions.visibilityOf(fatherName));
				fatherName.sendKeys(fName);
				fatherEmail.sendKeys(fEmailID);
				fatherPhone.sendKeys(fMobile);
				father_employer.sendKeys(fEmployerName);

				//Mother details
				wait.until(ExpectedConditions.visibilityOf(motherName));
				motherName.sendKeys(mName);
				motherEmail.sendKeys(mEmailID);
				motherPhone.sendKeys(mMobile);
				mother_employer.sendKeys(mEmployerName);
		        Images(); // photo upload method
		        
				wait.until(ExpectedConditions.visibilityOf(nextBtn_step1));
				nextBtn_step1.click();

				wait.until(ExpectedConditions.visibilityOf(capture_AdmissionID));
				System.out.println("Admission ID Message is  " + capture_AdmissionID.getText());

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
			//******************************Upload Images****************************************************************
			public void Images() throws IOException, InterruptedException {
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
