package admission_onlineFormTestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admission_onlineForm.SummerCamp_Admission;
import generics.BaseTest;
import generics.FWUtils;

public class SummerCamp_Admission_TestScripts extends BaseTest{

	@BeforeMethod
	public void Open_SummerCamp_AdmisisonForm() throws InterruptedException {
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
		// other WebDriver setup code
	}

		@DataProvider(name = "admissionFormData")
	public Object[][] getAdmissionFormData() throws IOException {
	    int rowcount = FWUtils.read_XL_RowCount(READ_XL_DATA_SummerCamp, "AdmissionFormData");
	    Object[][] data = new Object[rowcount][21]; // Adjust size according to your data columns

	    for (int i = 1; i <= rowcount; i++) {
	        for (int j = 0; j < 21; j++) {
	            String cellData = FWUtils.read_XL_Data(READ_XL_DATA_SummerCamp, "AdmissionFormData", i, j);
	            data[i-1][j] = cellData;
	           // System.out.println("Row " + (i-1) + ", Column " + j + ": " + cellData); // Debug statement
	        }
	    }
	    return data;
	}


	@Test(priority=1, dataProvider = "admissionFormData")
	public void Input_SummerAdmission(String centers, String socialMedia, String gender, String bloodGp, String program,
            String state,String firstName, String lastName,
           String allergies, String flat, String landMark, String city, String pcode, String fName,
           String fEmailID, String fMobile, String fEmployerName, String mName, String mEmailID,
           String mMobile, String mEmployerName) throws InterruptedException, IOException {
	    System.out.println("name of child: " + firstName); // Debug statement
	  
	    SummerCamp_Admission ad_sform = new SummerCamp_Admission(driver);
	    ad_sform.setSummerCamp_Childform(centers, socialMedia, gender, bloodGp, program, state, firstName, lastName, allergies, flat, landMark, city, pcode, fName, fEmailID, fMobile, fEmployerName, mName, mEmailID, mMobile, mEmployerName);
	}

}

