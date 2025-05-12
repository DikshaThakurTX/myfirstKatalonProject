import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


fromToLeave()



public void fromToLeave() {
	def leave =findTestData('Data Files/leave')
	String fromDate=leave.getValue("fromDate", 1)
	String toDate=leave.getValue("toDate", 1)
	
	WebUI.click(findTestObject('Object Repository/Leave/Leave'))
	WebUI.click(findTestObject('Object Repository/Leave/fromDateDropDown'))
	TestObject dateField = findTestObject('Object Repository/Leave/fromDateDropDown')
	WebUI.executeJavaScript("arguments[0].removeAttribute('readonly')", Arrays.asList(WebUI.findWebElement(dateField, 10)))
	WebUI.setText(dateField, '')

//	WebUI.setText(findTestObject('Object Repository/Leave/fromDate'),[('FromDate'): fromDate])
//	WebUI.clearText(findTestObject('Object Repository/Leave/fromDateDropDown'))

//	WebUI.setText(findTestObject('Object Repository/Leave/fromDateDropDown',[('toDate'): toDate]))
//	WebUI.delay(3)
}
