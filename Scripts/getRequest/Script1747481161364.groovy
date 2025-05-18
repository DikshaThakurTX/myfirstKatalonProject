import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


import internal.GlobalVariable
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import api.CustomizableKeywords as CS

JsonSlurper jsonSlurper = new JsonSlurper()

//String  baseUrl = GlobalVariable.BaseUrl
//String pathUrlFotListUser = "/api/users?page=2"
//String endPointFor_ListUser= baseUrl+pathUrlFotListUser
//Map<String,Object> pathParamsList_Users= [:]
//Map<String,Object> queryParamsList_Users= [:]
//Map<String,Object> requestBodyList_Users=[:]
//Map<String,String> headerList_Users= [
//"x-api-key" :  "reqres-free-v1" ]
//int expectedStatusCode_ListUsers=200
//def getResponseForListUser=CS.handleRequest('GET', endPointFor_ListUser, queryParamsList_Users,pathParamsList_Users, requestBodyList_Users, headerList_Users, expectedStatusCode_ListUsers)
//def jsonResponse_ListUser=jsonSluper.parseText( getResponseForListUser.getResponseText())
//assert jsonResponse_ListUser.page==2:" page number is not matched"
//assert jsonResponse_ListUser.data[1].id==8: "id is notmatched "
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponse_ListUser)))

//================================================================================================================

//String baseUrl =GlobalVariable.BaseUrl
//String  pathUrlFor_SpecficUser= "/api/users/{id}"
//String endPointFor_SpecificUser= baseUrl+pathUrlFor_SpecficUser
//Map<String,Object> pathParamsFor_SpecificUser=[
//	"id":2]
//Map<String,Object>queryParamsFor_SpecificUser=[:]
//Map<String,Object>requestBodyFor_SpecificUser=[:]
//Map<String,String>hearderFor_SpecificUser=[
//	"x-api-key" :  "reqres-free-v1"]
//int expectedStatusCode_ForSpecificUser=200
//def getResponseFor_SpecficUser= CS.handleRequest("GET", endPointFor_SpecificUser, pathParamsFor_SpecificUser, queryParamsFor_SpecificUser, requestBodyFor_SpecificUser, hearderFor_SpecificUser, expectedStatusCode_ForSpecificUser)
//def jsonResponseFor_SpecificUser= jsonSlurper.parseText(getResponseFor_SpecficUser.getResponseText())
//assert jsonResponseFor_SpecificUser.data.first_name.equals("Janet") : "name does not match"
//assert jsonResponseFor_SpecificUser.data.email.equals("janet.weaver@reqres.in"):"email does not match"
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_SpecificUser)))

//===========================================POST======================================================================


//String baseUrl =GlobalVariable.BaseUrl
//String  pathUrlFor_CreateUser= "/api/users"
//String endPointFor_CreateUser= baseUrl+pathUrlFor_CreateUser
//Map<String,Object> pathParamsFor_CreateUser=[:]
//Map<String,Object>queryParamsFor_CreateUser=[:]
//Map<String,Object>requestBodyFor_CreateUser=[
//	name : 'Diksha Thakur',
//	job : 'Test Engineer']
//
//Map<String,String>hearderFor_CreateUser=[
//	"x-api-key" :  'reqres-free-v1']
//
//int expectedStatusCodeFor_CreateUser=201
//def getResponseFor_CreateUser= CS.handleRequest("POST", endPointFor_CreateUser, pathParamsFor_CreateUser, queryParamsFor_CreateUser, requestBodyFor_CreateUser, hearderFor_CreateUser, expectedStatusCodeFor_CreateUser)
//def jsonResponseFor_CreateUser= jsonSlurper.parseText(getResponseFor_CreateUser.getResponseText())
////assert jsonResponseFor_CreateUser.id!=null: "name do not match"
////assert jsonResponseFor_CreateUser.createdAt!=null: "job do not match"
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_CreateUser)))


//============================================PUT===================================

//String baseUrl =GlobalVariable.BaseUrl
//String  pathUrlFor_PutMethod= "/api/users/{id}"
//String endPointFor_PutMethod= baseUrl+pathUrlFor_PutMethod
//Map<String,Object> pathParamsFor_PutMethod=[
//	id : 2]
//Map<String,Object>queryParamsFor_PutMethod=[:]
//Map<String,Object>requestBodyFor_PutMethod=[
//	name : namePut,
//	job : jobPut]
//Map<String,String>hearderFor_PutMethod=[
//	"x-api-key" :  'reqres-free-v1']
//int expectedStatusCodeFor_PutMethod=200
//def getResponseFor_PutMethod= CS.handleRequest("PUT", endPointFor_PutMethod, pathParamsFor_PutMethod, queryParamsFor_PutMethod, requestBodyFor_PutMethod, hearderFor_PutMethod, expectedStatusCodeFor_PutMethod)
//def jsonResponseFor_PutMethod= jsonSlurper.parseText(getResponseFor_PutMethod.getResponseText())
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_PutMethod)))