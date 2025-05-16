import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('organgeHrmsLoginModule'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('organgeHrmsLeaveModule'), [:], FailureHandling.STOP_ON_FAILURE)

