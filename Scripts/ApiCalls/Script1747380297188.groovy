import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.assertj.core.api.Assertions

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType


def requestObject = new RequestObject("RequestObject")

requestObject.setRestUrl("https://reqres.in/api/users/1")
requestObject.setRestRequestMethod("GET")
requestObject.setHttpHeaderProperties([
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])
def responseRequest=WS.sendRequest(requestObject)
Assertions.assertThat(responseRequest.getStatusCode()).isEqualTo(200)


