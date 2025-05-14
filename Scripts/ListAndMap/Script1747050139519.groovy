import org.openqa.selenium.By

import org.openqa.selenium.By

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XPath
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


def loginCredential = [:]
loginCredential.put("username", "Admin")
loginCredential.put("password", "admin123")

String username = loginCredential.get("username")
String password = loginCredential.get("password")

WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Username'),username)
WebUI.sendKeys(findTestObject('Object Repository/OrangeLocator/Password'), password)
WebUI.click(findTestObject('Object Repository/OrangeLocator/LoginButton'))

WebUI.click(findTestObject('Object Repository/Leave/Leave'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Leave/verifyLeaveList'))
WebUI.click(findTestObject('Object Repository/Leave/showLeaveWithStatusDropDown'))

WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> dropdownShowLeave= driver.findElements(By.xpath("//div[@role='listbox']/child::div[@class='oxd-select-option']"))

for(WebElement showLeave : dropdownShowLeave) {
//	println showLeave.getText()
	if (showLeave.getText().equals("Scheduled")) {
		showLeave.click() 
		break  
	}
}





