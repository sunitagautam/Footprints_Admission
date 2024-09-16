package admission_onlineFormTestScripts;

import org.testng.annotations.Test;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import admission_onlineForm.Admission_Form;
import generics.BaseTest;

@Test (groups = {"AllClasstests"})
public class Admission_FormTestScripts extends BaseTest{
	@BeforeMethod
	public void OpenAdmisisonForm_Page() throws InterruptedException {
		String pageURL = driver.getCurrentUrl();
		System.out.println("URL of the page is:" +pageURL);	
		String pageTitle = driver.getTitle();
		System.out.println("title of the page is:" +pageTitle);	
	}

	@Test (priority=1,groups ="Sanity Testing")
	@Ignore
	public void AdmisionViaCenterSelection_SC_001_TC_003() throws InterruptedException 
	{	
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_001_TC_003");
		ad_form.Admission_ViaCenterSelection();
	}	
	
	@Test (priority=2,groups ={"Sanity Testing, Smoke Testing"})
	@Ignore
	public void AdmisionViaAdmissionID_SC_001_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_001_TC_004");
		ad_form.Admission_viaChildID();
	}	
	@Test (priority=3,groups="Regression Testing")
	@Ignore
	public void MandatoryFields_Validations_SC_001_TC_005() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_001_TC_005");
		ad_form.mandatoryFields_validationErorr();
	}	
	@Test (priority=4,groups ="Smoke testing, window.Regression", enabled = false)
	@Ignore
	public void ValidationsAdmissionID_SC_001_TC_006() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_001_TC_006");
		ad_form.WrongAdmission_ChildID();
	}	
	@Test (priority=5, groups ={"Sanity Testing,Regression Tetsing"})
	@Ignore
	public void AdmissionStep1_success_SC_002_TC_002() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_002");
		ad_form.Admission_Step1_filledsuccessfully();
	}	

	@Test (priority=6,groups ="Sanity Testing")
	@Ignore
	public void AdmissionStep1_MandatoryFieldsValidations_SC_002_TC_003() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_003");
		ad_form.mandatroryfieldsValidations_Step1();
	}	
	@Test (priority=7,enabled=false)
	@Ignore
	public void Child_photoSize1MB_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_childPhoto size validation msg");
		ad_form.ChildPhoto_SizeMore1MB_Validation();
	}	

	@Test (retryAnalyzer= listeners.RetryAnalyzer.class)
	@Ignore
	public void Child_photoFormat_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_childPhoto format Validation Message");
		ad_form.ChildPhoto_format_Validation();
	}	
	@Test (priority=9,groups = "Regression Testing")
	@Ignore
	public void Child_photoMultiplesFaces_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_childPhoto_MultiplesFaces validation Message");
		ad_form.ChildPhoto_multiplesFaces_Validation();
	}	
	@Test (priority= 10,retryAnalyzer= listeners.RetryAnalyzer.class)
	@Ignore
	public void father_photoSize1MB_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_Father Photo size validation msg");
		ad_form.fatherPhoto_SizeMore1MB_Validation();
	}	

	@Test (priority=11)
	@Ignore
	public void father_photoFormat_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_father Photo format Validation Message");
		ad_form.fatherPhoto_format_Validation();
	}	
	@Test (priority=12)
	@Ignore
	public void father_photoMultiplesFaces_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_father Photo_MultiplesFaces validation Message");
		ad_form.FatherPhoto_multiplesFaces_Validation();
	}	
	
	@Test (priority= 13)
	@Ignore
	public void mother_photoSize1MB_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004 mother Photo size validation msg");
		ad_form.motherPhoto_SizeMore1MB_Validation();
	}	

	@Test (priority=14)
	@Ignore
	public void mother_photoFormat_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_mother Photo format Validation Message");
		ad_form.motherPhoto_format_Validation();
	}	
	@Test (priority=15)
	@Ignore
	public void mother_photoMultiplesFaces_SC_002_TC_004() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_004_mother Photo_MultiplesFaces validation Message");
		ad_form.MotherPhoto_multiplesFaces_Validation();
	}	
	@Test (priority=16)
	@Ignore
	public void programListValidation_SC_002_TC_006() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_006 Program list as per center configuration");
		ad_form.program_DropdownList();
	}	
	@Test (priority=17)
	@Ignore
	public void discountListValidation_SC_002_TC_007() throws InterruptedException 
	{
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_006 dropdown list as per center configuration");
		ad_form.Discount_DropdownList();
	}	
	
	@Test(priority = 18,groups = "{Sanity Testing,Regression Testing}")
	@Ignore
	public void discountType_siblingApplied_SC_002_TC_008() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_008");
		ad_form.Discount_SiblingDiscount();
	}
	@Test(priority = 19,retryAnalyzer= listeners.RetryAnalyzer.class)
	@Ignore
	public void discountType_singleParentApplied_SC_002_TC_009() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_009");
		ad_form.Discount_SingleParent();
	}
	@Test(priority = 20,groups = "Regression Testing")
	@Ignore
	public void discountType_staffApplied_SC_002_TC_010() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_010");
		ad_form.Discount_StaffDiscount();
	}
	@Test(priority = 21 ,groups = "Regression Testing")
	@Ignore
	public void FatherMotherSection_Validations_SC_002_TC_012() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_012");
		ad_form.validations_FatherMotherSection();
	}
	@Test(priority = 22 , groups = "Regression Testing")
	@Ignore
	public void CheckBox_IFNotWorking_Validations_SC_002_TC_013() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_013");
		ad_form.checkboxIFNotWorking_FatherMotherSection();
	}
	@Test(priority = 23,groups = "Regression Testing")
	@Ignore
	public void BackBtnFunctionality_SC_002_TC_014() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_014");
		ad_form.BackButton_functionality_step1();
	}
	@Test(priority = 24,groups = "Sanity Testing")
	@Ignore
	public void DuplicateChild_SC_002_TC_015() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_002_TC_015");
		ad_form.Duplicate_AdmissionForm();
	}
	@Test(priority = 25,groups = "Sanity Testing")
	@Ignore
	public void ShortTermPlan_SC_003_TC_004() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_003_TC_004");
		ad_form.choosePlan_shortTerm();
	}
	@Test(priority = 26,groups = "Regression Testing")
	@Ignore
	public void LongTermPlan_SC_003_TC_005() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_003_TC_005");
		ad_form.choosePlan_LongTerm();
	}
	@Test(priority = 27,groups = "Regression Testing")
	@Ignore
	public void generatefullInvoice_longTermPlan_SC_003_TC_006() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_003_TC_006");
		ad_form.generateFullInvoice_longTerm();
	}
	@Test(priority = 28,groups = "Testing")
	@Ignore
	public void generatefullInvoice_shortTermPlanSC_003_TC_006() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_003_TC_007");
		ad_form.generateFullInvoice_shortTerm();
	}
	@Test(priority = 29,groups ="Sanity Testing")
	@Ignore
	public void back_functionality_Step2_SC_003_TC_006() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_003_TC_008");
		ad_form.Step2_BackBtn_functionality();
	}
	@Test(priority = 30,groups ="Sanity Testing")
	
	public void Amdission_summary_PaymentJSON_Step2_SC_003_TC_006() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_004_TC_001 & SC_004_TC_002");
		ad_form.admission_orderSummary();
	}

	@Test(priority = 31)
	public void eveningprogram_Age_Restriction_SC_011_TC_006() throws InterruptedException {
		Admission_Form ad_form = new Admission_Form(driver);
		System.out.println("SC_011_TC_006");
		ad_form.Eveningprogram_Age_Restrictions();
	}
}
