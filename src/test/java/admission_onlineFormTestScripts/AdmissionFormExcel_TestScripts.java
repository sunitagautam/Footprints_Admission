package admission_onlineFormTestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admission_onlineForm.AdmissionForm_ViaExcel;
import generics.BaseTest;
import generics.ExcelUtils;
import generics.FWUtils;

public class AdmissionFormExcel_TestScripts extends BaseTest{
	
	@BeforeMethod
	public void OpenAdmisisonForm_Page() throws InterruptedException {
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
		// other WebDriver setup code
	}

	
	@Test(priority=1)
	public void Admission()throws InterruptedException, IOException 
	{	int rowcount = FWUtils.read_XL_RowCount(READ_XL_DATA,"AdmissionFormData");
	   
	for(int i=1; i<=rowcount;i++)
	{
		String centers = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,0);
		String socialMedia = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,1);
		String gender = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,2);
		String bloodGp = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,3);
		String program= FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,4);
		String dis_Type = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,5);
		String state = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,6);
		String referenceAdmissionID = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,7);
		String firstName = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,8);
		String lastName = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,9);
		String allergies = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,10);
		String flat = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,11);
		String landMark = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,12);
		String city = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,13);
		String  pcode= FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,14);
		String  fName= FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,15);
		String fEmailID = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,16);
		String  fMobile= FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,17);
		String fEmployerName = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,18);
		String mName = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,19);
		String mEmailID = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,20);
		String mMobile = FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,21);
		String mEmployerName= FWUtils.read_XL_Data(READ_XL_DATA,"AdmissionFormData",i,22);
		
		AdmissionForm_ViaExcel ad_form = new AdmissionForm_ViaExcel(driver);
		ad_form.setSiblingChild_form(centers,socialMedia,gender,bloodGp,program,dis_Type,state ,referenceAdmissionID,
				firstName, lastName,allergies,flat,landMark,city,pcode,fName,fEmailID,fMobile,fEmployerName,mName,mEmailID,mMobile,mEmployerName);

	}
}
}