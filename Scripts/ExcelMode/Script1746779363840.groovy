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



def orangeLogin = findTestData('Data Files/OrangeExcel')

String url = orangeLogin.getValue('Url', 1)

String username = orangeLogin.getValue('Username', 1)

String password = orangeLogin.getValue('Password', 1)

WebUI.openBrowser(url)

WebUI.maximizeWindow()

WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Username'), username)

WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Password'), password)

WebUI.click(findTestObject('Object Repository/OrangeLocator/LoginButton'))

WebUI.verifyElementPresent(findTestObject('Object Repository/OrangeLocator/Dashboard'), 5)

WebUI.click(findTestObject('Object Repository/OrangeLocator/Admin'))

WebUI.click(findTestObject('Object Repository/AdminAdd/AddBtn'))



def admin = findTestData('Data Files/Admin')

String userrole = admin.getValue('UserRole', 1)
String employeename = admin.getValue('EmployeeName', 1)
String status = admin.getValue('Status', 1)
String adminUserName = admin.getValue('adminUsername', 1)
String adminPassword = admin.getValue('adminPassword', 1)
String confirm = admin.getValue('confirm', 1)



WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/AdminAdd/userRole'))

WebUI.click(findTestObject('Object Repository/AdminAdd/Role',[('role'): userrole]))

WebUI.setText(findTestObject('Object Repository/AdminAdd/employeeName'), employeename)

WebUI.click(findTestObject('Object Repository/AdminAdd/statusSelect'))

WebUI.click(findTestObject('Object Repository/AdminAdd/statusDropdown',[('status'): status]))

WebUI.setText(findTestObject('Object Repository/AdminAdd/adminUsername'),adminUserName)

WebUI.setText(findTestObject('Object Repository/AdminAdd/adminPassword'),adminPassword)

WebUI.setText(findTestObject('Object Repository/AdminAdd/adminConfirmPassword'),confirm)

WebUI.delay(3)

WebUI.closeBrowser()





		






//WebUI.closeBrowser()



