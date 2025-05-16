import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After
import org.w3c.dom.DOMImplementationSource

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class BaseListenerForOrange   {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	public void beforeTestcase(TestCaseContext testCaseContext) {
	
		WebUI.openBrowser(GlobalVariable.UrlOrange)
		WebUI.maximizeWindow()
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
@AfterTestCase
	public void afterTestCase(TestCaseContext testCaseContext) {
		
		WebUI.click(findTestObject('Object Repository/organgreHrmLoginModule/userDropDown'))
		WebUI.click(findTestObject('Object Repository/organgreHrmLoginModule/Logout'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/organgreHrmLoginModule/LogoutVerify'), 5)
		
		WebUI.delay(3)
		WebUI.closeBrowser()
		
}
}