import org.assertj.core.api.Assertions

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

JsonSlurper jsonSlurper = new JsonSlurper()
def requestObject = new RequestObject("RequestObject")

requestObject.setRestUrl("https://reqres.in/api/users/${id}")
requestObject.setRestRequestMethod("GET")
requestObject.setHttpHeaderProperties([
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])
def responseRequest=WS.sendRequest(requestObject)
Assertions.assertThat(responseRequest.getStatusCode()).isEqualTo(200)
def getResponseForGet=jsonSlurper.parseText(responseRequest.getResponseText())
assert getResponseForGet.data.id == 2 : ' page number is not matched'

assert getResponseForGet.data.first_name=="Janet" : 'id is notmatched '
println(JsonOutput.prettyPrint(JsonOutput.toJson(getResponseForGet)))


//=====================Post================================================================
def requestObject1 = new RequestObject("RequestObject")

requestObject1.setRestUrl("https://reqres.in//api/users")
requestObject1.setRestRequestMethod("POST")
requestObject1.setHttpHeaderProperties([
	new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json"),
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])

def requestBodyForPost = JsonOutput.toJson([
	"name": "morpheus",
	"job" : "leader"
])
requestObject1.setBodyContent(new HttpTextBodyContent(requestBodyForPost, "UTF-8", "application/json"))
def responseRequestForPost=WS.sendRequest(requestObject1)
Assertions.assertThat(responseRequestForPost.getStatusCode()).isEqualTo(201)
def getResponseForPost=jsonSlurper.parseText(responseRequestForPost.getResponseText())
println(JsonOutput.prettyPrint(JsonOutput.toJson(getResponseForPost)))


//=======================================PUT=======================================================================================
def requestObjectForPut = new RequestObject("RequestObject")

requestObjectForPut.setRestUrl("https://reqres.in/api/users/2")
requestObjectForPut.setRestRequestMethod("PUT")
requestObjectForPut.setHttpHeaderProperties([
	new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json"),
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])

def requestBodyForPut = JsonOutput.toJson([
	"name": "Diksha",
	"job": "Tes tEngineer"
])

requestObjectForPut.setBodyContent(new HttpTextBodyContent(requestBodyForPut, "UTF-8", "application/json"))
def responseRequestForPut = WS.sendRequest(requestObjectForPut)
Assertions.assertThat(responseRequestForPut.getStatusCode()).isEqualTo(200)
def getResponseForPut=jsonSlurper.parseText(responseRequestForPut.getResponseText())
println(JsonOutput.prettyPrint(JsonOutput.toJson(getResponseForPut)))

//====================================PATCH-==============================================================

def requestObjectForPatch = new RequestObject("RequestObject")

requestObjectForPatch.setRestUrl("https://reqres.in/api/users/2")
requestObjectForPatch.setRestRequestMethod("PATCH")
requestObjectForPatch.setHttpHeaderProperties([
	new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json"),
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])

def requestBodyForPatch = JsonOutput.toJson([
	"name": "Diksha thakur",
	
])

requestObjectForPatch.setBodyContent(new HttpTextBodyContent(requestBodyForPatch, "UTF-8", "application/json"))
def responseRequestForPatch = WS.sendRequest(requestObjectForPatch)
Assertions.assertThat(responseRequestForPatch.getStatusCode()).isEqualTo(200)
def getResponseForPatch=jsonSlurper.parseText(responseRequestForPatch.getResponseText())
println(JsonOutput.prettyPrint(JsonOutput.toJson(getResponseForPatch)))

//=============================================DELETE===================================================

def requestObjectForDelete = new RequestObject("RequestObject")

requestObjectForDelete.setRestUrl("https://reqres.in/api/users/2")
requestObjectForDelete.setRestRequestMethod("DELETE")
requestObjectForDelete.setHttpHeaderProperties([
	new TestObjectProperty("x-api-key",ConditionType.EQUALS,"reqres-free-v1")])

def responseRequestForDelete = WS.sendRequest(requestObjectForDelete)
Assertions.assertThat(responseRequestForDelete.getStatusCode()).isEqualTo(204)
