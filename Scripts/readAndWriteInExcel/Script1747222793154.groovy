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

//reading from excel

String fileName = 'C:\\Users\\Diksha Thakur\\Katalon Studio\\katalondemo\\myfirstKatalonProject\\Data Files\\excel.xlsx'
String sheetName = 'Sheet1'

WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Username'),
	CustomKeywords.'com.utility.readFromExcel.getCellDate'(fileName, sheetName, 1, 1))

WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Password'),
	CustomKeywords.'com.utility.readFromExcel.getCellDate'(fileName, sheetName, 1, 2))

WebUI.click(findTestObject('Object Repository/OrangeLocator/LoginButton'))



//write in excel

//String path ="C:\\Users\\Diksha Thakur\\Katalon Studio\\katalondemo\\myfirstKatalonProject\\Data Files\\excelWrite.xlsx"
//String sheetName = 'Sheet1'
//
//CustomKeywords.'com.utility.writeInExcel.setCellData'(path, sheetName, 0, 0,"username")
//CustomKeywords.'com.utility.writeInExcel.setCellData'(path, sheetName, 0, 1,"password")
//CustomKeywords.'com.utility.writeInExcel.setCellData'(path, sheetName, 0, 2,"id")