package admission_onlineFormTestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admission_onlineForm.AdmissionForm_ViaExcel;
import generics.BaseTest;
import generics.FWUtils;

public class ExcelData_SiblingDiscount extends BaseTest{
	
	 @BeforeMethod
	    public void OpenAdmisisonForm_Page() throws InterruptedException {
	        String pageURL = driver.getCurrentUrl();
	        System.out.println("URL of the page is:" + pageURL);    
	        String pageTitle = driver.getTitle();
	        System.out.println("title of the page is:" + pageTitle);    
	        // Other WebDriver setup code
	    }

	    @DataProvider(name = "admissionFormData_Sibling")
	    public Object[][] getAdmissionFormData() throws IOException {
	        int rowcount = FWUtils.read_XL_RowCount(READ_XL_DATA, "AdmissionForm_Sibling");
	        if (rowcount == 0) {
	            System.out.println("No data found for AdmissionForm_Sibling.");
	        }
	        Object[][] data = new Object[rowcount][23]; // Adjust size according to your data columns
	        for (int i = 1; i <= rowcount; i++) {
	            for (int j = 0; j < 23; j++) {
	                String cellData = FWUtils.read_XL_Data(READ_XL_DATA, "AdmissionForm_Sibling", i, j);
	                data[i - 1][j] = cellData;
	            }
	        }
	        return data;
	    }

	    @Test( dataProvider = "admissionFormData_Sibling")
	    public void InputSelection(String centers, String socialMedia, String gender, String bloodGp, String program,
	                               String dis_type, String state, String referenceAdmissionID, String firstName, String lastName,
	                               String allergies, String flat, String landMark, String city, String pcode, String fName,
	                               String fEmailID, String fMobile, String fEmployerName, String mName, String mEmailID,
	                               String mMobile, String mEmployerName) throws InterruptedException, IOException {
	        System.out.println("name of child: " + firstName); // Debug statement
	        AdmissionForm_ViaExcel ad_form = new AdmissionForm_ViaExcel(driver);
	        ad_form.setSiblingChild_form(centers, socialMedia, gender, bloodGp, program, dis_type, state, referenceAdmissionID,
	                firstName, lastName, allergies, flat, landMark, city, pcode, fName, fEmailID, fMobile, fEmployerName,
	                mName, mEmailID, mMobile, mEmployerName);
	    }


}
