package generics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import admission_onlineForm.AdmissionForm_ViaExcel;

public class ExcelDataProvider {
	
	@Test(dataProvider = "test1Data")
	public void test1(String firstName, String lastName, String allergies) {
		System.out.println(firstName + "|" + lastName + "|" + allergies);
		//AdmissionForm_ViaExcel ad_form = new AdmissionForm_ViaExcel(driver);
	//	ad_form.childForm(firstName, lastName, allergies);

		
	}
	
	@DataProvider(name = "test1Data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\SunitaGautam\\Desktop\\Automation\\Admission_onlineForm\\testData\\input.xlsx";
		return testData(excelPath, "Admission_Step1");
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object[][] data = new Object[rowCount - 1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i - 1][j] = cellData;
			}
		}
		return data;
	}
	
	
}
