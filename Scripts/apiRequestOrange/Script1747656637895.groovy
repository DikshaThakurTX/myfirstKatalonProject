import api.CustomizableKeywords as CS
import groovy.json.JsonSlurper
import groovy.json.JsonOutput



JsonSlurper jsonSlurper = new JsonSlurper()

String  baseUrl = "https://opensource-demo.orangehrmlive.com/"
String pathUrl = "web/index.php/auth/login"
String endPoint= baseUrl+pathUrl
Map<String,Object> pathParams= [:]
Map<String,Object> queryParams= [:]
Map<String,Object> requestBody=[:]
Map<String,String> header= [:]
int expectedStatusCode=200
def getResponse=CS.handleRequest('GET', endPoint, queryParams,pathParams, requestBody, header, expectedStatusCode)
def responseText=getResponse.getResponseText()
println(responseText)
String tokenPattern =':token="&quot;(.+?)&quot;"'
def token=null
def matches= responseText=~tokenPattern
if(matches.find()) {
	token =matches.group(1)
	println("Extracted Token : "+ token)
}
else {
	println("token not found")
}

