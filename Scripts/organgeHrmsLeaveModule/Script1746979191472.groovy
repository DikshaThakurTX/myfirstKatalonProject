import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XPath
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement





    def leave = findTestData('Data Files/leave')

    String fromDate = leave.getValue('fromDate', 1)

    String toDate = leave.getValue('toDate', 1)

    WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/leave'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/organgeHrmsLeaveModule/verifyLeaveList'))
    WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/fromDate'))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/fromDate'), Keys.chord(Keys.CONTROL, 'a'))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/fromDate'), Keys.chord(Keys.DELETE))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/fromDate'), fromDate)
    WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/toDate'))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/toDate'), Keys.chord(Keys.CONTROL, 'a'))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/toDate'), Keys.chord(Keys.DELETE))
    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/toDate'), toDate)
	WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/dropDownForShowLeaveWithStatus'))
    WebUI.delay(1)

    
	WebDriver driver = DriverFactory.getWebDriver()
    List<WebElement> dropdownShowLeave = driver.findElements(By.xpath('//div[@role=\'listbox\']/child::div[@class=\'oxd-select-option\']'))

    for (WebElement showLeave : dropdownShowLeave) {
        if (showLeave.getText().equals('Scheduled')) {
            showLeave.click()
            break
        }else {
		println("Could not able to select any option from Shoe LeaveWith Staus dropdown")
    }
	}


    String fileName = 'C:\\Users\\Diksha Thakur\\Katalon Studio\\katalondemo\\myfirstKatalonProject\\Data Files\\excel.xlsx'

    String sheetName = 'leave'

    WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/dropDownLeaveType'))

    String leaveType = CustomKeywords.'com.utility.readFromExcel.getCellDate'(fileName, sheetName, 1, 3)

    TestObject leaveTypeOption = WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/optionsForLeaveType', 
            [('optionForLeaveType') : leaveType]))

    WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/employeeNameTextBox'))

    String employeeName = CustomKeywords.'com.utility.readFromExcel.getCellDate'(fileName, sheetName, 1, 4)

    WebUI.sendKeys(findTestObject('Object Repository/organgeHrmsLeaveModule/employeeNameTextBox'), employeeName)
	
	String pathLocation = System.getProperty("user.dir")

    String path = pathLocation+'\\Data Files\\excelWrite.xlsx'

    String newSheet = 'write'

    CustomKeywords.'com.utility.writeInExcel.setCellData'(path, newSheet, 1, 0, employeeName)


 	

