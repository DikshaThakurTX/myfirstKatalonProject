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

WebUI.sendKeys(findTestObject('Object Repository/organgreHrmLoginModule/Username'),username)
WebUI.sendKeys(findTestObject('Object Repository/organgreHrmLoginModule/Password'), password)
WebUI.click(findTestObject('Object Repository/organgreHrmLoginModule/LoginButton'))

WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/leave'))
WebUI.verifyElementVisible(findTestObject('Object Repository/organgeHrmsLeaveModule/verifyLeaveList'))
WebUI.click(findTestObject('Object Repository/organgeHrmsLeaveModule/dropDownForShowLeaveWithStatus'))






