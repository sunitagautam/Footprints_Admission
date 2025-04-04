package admission_onlineFormTestScripts;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import admission_onlineForm.AdmissionForm_ViaExcel;
import generics.BaseTest;
import generics.FWUtils;

public class ExcelDataProvider_SingleParentDiscount extends BaseTest {
    
    @BeforeMethod
    public void OpenAdmisisonForm_Page() throws InterruptedException {
        String pageURL = driver.getCurrentUrl();
        System.out.println("URL of the page is:" + pageURL);    
        String pageTitle = driver.getTitle();
        System.out.println("title of the page is:" + pageTitle);    
        // Other WebDriver setup code
    }

    @DataProvider(name = "admissionForm_SingleParent")
    public Object[][] getAdmissionForm_Singleparent() throws IOException {
        int rowcount = FWUtils.read_XL_RowCount(READ_XL_DATA, "AdmissionForm_SingleParent");
        if (rowcount == 0) {
            System.out.println("No data found for AdmissionForm_SingleParent.");
        }
        
        Object[][] data = new Object[rowcount][18]; // Adjust size according to your data columns
        for (int i = 1; i <= rowcount; i++) {
            for (int j = 0; j < 18; j++) {
                String cellData = FWUtils.read_XL_Data(READ_XL_DATA, "AdmissionForm_SingleParent", i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }

    @Test(dataProvider = "admissionForm_SingleParent")
   public void ValuesSelection(String centers, String socialMedia, String gender, String bloodGp, String program,
                               String dis_type, String state, String firstName, String lastName, String allergies, String flat,
                                String landMark, String city, String pcode, String mName, String mEmailID, String mMobile,
                                String mEmployerName) throws InterruptedException, IOException {
        System.out.println("name of child: " + firstName); // Debug statement
        
       AdmissionForm_ViaExcel ad_form = new AdmissionForm_ViaExcel(driver);
        ad_form.setSingleChild_form(centers, socialMedia, gender, bloodGp, program, dis_type, state, firstName, lastName,
               allergies, flat, landMark, city, pcode, mName, mEmailID, mMobile, mEmployerName);
    }
    
    
}
