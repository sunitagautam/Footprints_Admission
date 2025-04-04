package admission_onlineFormTestScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admission_onlineForm.AdmissionForm_ViaExcel;
import generics.BaseTest;
import generics.FWUtils;

public class ExcelData_NoDiscountAdmission extends BaseTest {

	@BeforeMethod
    public void OpenAdmisisonForm_Page() throws InterruptedException {
        String pageURL = driver.getCurrentUrl();
        System.out.println("URL of the page is:" + pageURL);    
        String pageTitle = driver.getTitle();
        System.out.println("title of the page is:" + pageTitle);    
        // Other WebDriver setup code
    }
    
    @DataProvider(name = "admissionFormData_NoDiscountApplied")
    public Object[][] getAdmissionFormData_NoDiscountApplied() throws IOException {
        int rowcount = FWUtils.read_XL_RowCount(READ_XL_DATA, "AdmissionForm_NoDiscount");
        if (rowcount == 0) {
            System.out.println("No data found");
        }
        Object[][] data = new Object[rowcount][21]; // Adjust size according to your data columns
        for (int i = 1; i <= rowcount; i++) {
            for (int j = 0; j < 21; j++) {
                String cellData = FWUtils.read_XL_Data(READ_XL_DATA, "AdmissionForm_NoDiscount", i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }

    @Test( dataProvider = "admissionFormData_NoDiscountApplied")
    public void InputAdmissionForm(String centers, String socialMedia, String gender, String bloodGp, String program,
                                String state,String firstName, String lastName,
                               String allergies, String flat, String landMark, String city, String pcode, String fName,
                               String fEmailID, String fMobile, String fEmployerName, String mName, String mEmailID,
                               String mMobile, String mEmployerName) throws InterruptedException, IOException {
       
    	System.out.println("name of child: " + firstName); // Debug statement
        
        AdmissionForm_ViaExcel ad_form = new AdmissionForm_ViaExcel(driver);
        ad_form.setChild_NoDiscountApplied(centers, socialMedia, gender, bloodGp, program,state,
                firstName, lastName, allergies, flat, landMark, city, pcode, fName, fEmailID, fMobile, fEmployerName,
                mName, mEmailID, mMobile, mEmployerName);
    }

}


