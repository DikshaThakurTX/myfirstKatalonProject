import api.CustomizableKeywords as CS
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import internal.GlobalVariable

JsonSlurper jsonSlurper = new JsonSlurper()

String baseUrl = GlobalVariable.BaseUrl

String pathUrlFotListUser = '/api/users?page=2'

String endPointFor_ListUser = baseUrl + pathUrlFotListUser

Map<String, Object> pathParamsList_Users = [:]

Map<String, Object> queryParamsList_Users = [:]

Map<String, Object> requestBodyList_Users = [:]

Map<String, String> headerList_Users = [('x-api-key') : 'reqres-free-v1']

int expectedStatusCode_ListUsers = 200

def getResponseForListUser = CS.handleRequest('GET', endPointFor_ListUser, queryParamsList_Users, pathParamsList_Users, 
    requestBodyList_Users, headerList_Users, expectedStatusCode_ListUsers)

def jsonResponse_ListUser = jsonSlurper.parseText(getResponseForListUser.getResponseText())

assert jsonResponse_ListUser.page == 2 : ' page number is not matched'

assert jsonResponse_ListUser.data[1].id == 8 : 'id is notmatched '

println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponse_ListUser)))


//================================================================================================================


//String baseUrl = GlobalVariable.BaseUrl
//
//String pathUrlFor_SpecficUser = '/api/users/{id}'
//
//String endPointFor_SpecificUser = baseUrl + pathUrlFor_SpecficUser
//
//Map<String, Object> pathParamsFor_SpecificUser = [('id') : 2, ('name') : name]
//
//Map<String, Object> queryParamsFor_SpecificUser = [:]
//
//Map<String, Object> requestBodyFor_SpecificUser = [:]
//
//Map<String, String> hearderFor_SpecificUser = [('x-api-key') : 'reqres-free-v1']
//
//int expectedStatusCode_ForSpecificUser = 200
//
//def getResponseFor_SpecficUser = CS.handleRequest('GET', endPointFor_SpecificUser, pathParamsFor_SpecificUser, queryParamsFor_SpecificUser, 
//    requestBodyFor_SpecificUser, hearderFor_SpecificUser, expectedStatusCode_ForSpecificUser)
//
//def jsonResponseFor_SpecificUser = jsonSlurper.parseText(getResponseFor_SpecficUser.getResponseText())
//
//assert jsonResponseFor_SpecificUser.data.first_name.equals('Janet') : 'name does not match'
//
//assert jsonResponseFor_SpecificUser.data.email.equals('janet.weaver@reqres.in') : 'email does not match'
//
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_SpecificUser)))
//
//  
// //===========================================POST============================
//
//
// String baseUrl = GlobalVariable.BaseUrl
//
//String pathUrlFor_CreateUser = '/api/users'
//
//String endPointFor_CreateUser = baseUrl + pathUrlFor_CreateUser
//
//Map<String, Object> pathParamsFor_CreateUser = [:]
//
//Map<String, Object> queryParamsFor_CreateUser = [:]
//
//Map<String, Object> requestBodyFor_CreateUser = [('name') : 'Diksha Thakur', ('job') : 'Test Engineer']
//
//Map<String, String> hearderFor_CreateUser = [('x-api-key') : 'reqres-free-v1']
//
//int expectedStatusCodeFor_CreateUser = 201
//
//def getResponseFor_CreateUser = CS.handleRequest('POST', endPointFor_CreateUser, pathParamsFor_CreateUser, queryParamsFor_CreateUser, 
//    requestBodyFor_CreateUser, hearderFor_CreateUser, expectedStatusCodeFor_CreateUser)
//
//def jsonResponseFor_CreateUser = jsonSlurper.parseText(getResponseFor_CreateUser.getResponseText())
//
//assert jsonResponseFor_CreateUser.id != null : 'name do not match'
//
//assert jsonResponseFor_CreateUser.createdAt != null : 'job do not match'
//
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_CreateUser)))
//  
//  
//  //============================================PUT============================
//
//  
//String baseUrl = GlobalVariable.BaseUrl
//
//String pathUrlFor_PutMethod = '/api/users/{id}'
//
//String endPointFor_PutMethod = baseUrl + pathUrlFor_PutMethod
//
//Map<String, Object> pathParamsFor_PutMethod = [('id') : 2]
//
//Map<String, Object> queryParamsFor_PutMethod = [:]
//
//Map<String, Object> requestBodyFor_PutMethod = [('name') : namePut, ('job') : jobPut]
//
//Map<String, String> hearderFor_PutMethod = [('x-api-key') : 'reqres-free-v1']
//
//int expectedStatusCodeFor_PutMethod = 200
//
//def getResponseFor_PutMethod = CS.handleRequest('PUT', endPointFor_PutMethod, pathParamsFor_PutMethod, queryParamsFor_PutMethod, 
//    requestBodyFor_PutMethod, hearderFor_PutMethod, expectedStatusCodeFor_PutMethod)
//
//def jsonResponseFor_PutMethod = jsonSlurper.parseText(getResponseFor_PutMethod.getResponseText())
//
//println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_PutMethod)))
//  
//  
// //=========================================DELETE============================
//  
//
//String baseUrl = GlobalVariable.BaseUrl
//
//String pathUrlFor_Delete = '/api/users/{id}'
//
//String endpointFor_Delete = baseUrl + pathUrlFor_Delete
//
//Map<String, Object> pathParamsFor_Delete = [('id') : 3]
//
//Map<String, Object> queryParamsfOR_Delete = [:]
//
//Map<String, Object> requestBodyFor_Delete = [:]
//
//Map<String, String> headerFor_Delete = [('x-api-key') : 'reqres-free-v1']
//
//int expectedStatusCodeFor_Delete = 204
//
//def getResponseFor_Delete = CS.handleRequest('DELETE', endpointFor_Delete, pathParamsFor_Delete, queryParamsfOR_Delete, 
//    requestBodyFor_Delete, headerFor_Delete, expectedStatusCodeFor_Delete)
//
//String responseTextFor_Delete = getResponseFor_Delete.getResponseText()
//
//if (responseTextFor_Delete && responseTextFor_Delete.trim()) {
//    //we make sure the response is safe to parseas responseTextFor_Delete:-Checks if the response is not null or if it
//    //null, it shouldn't try to parse 
//    //responseTextFor_Delete.trim():- Removes spaces from the beginning and end of the text. //and Then checks if it’s not empty
//    Object getJonResponseFor_Delete = jsonSlurper.parseText(getResponseFor_Delete.getResponseText())
//
//    println(JsonOutput.prettyPrint(JsonOutput.toJson(getJonResponseFor_Delete)))
//} else {
//    println(' No content in response (204 No Content)')
//}
//  
//  
//  //============================================PATCH==========================
//
// String baseUrl = GlobalVariable.BaseUrl
//
//String pathUrlFor_Patch = '/api/users/{id}'
//
//String endPointFor_Patch = baseUrl + pathUrlFor_Patch
//
//Map<String, Object> pathParamsFor_Patch = [('id') : 2]
//
//Map<String, Object> queryParamsFor_Patch = [:]
//
//Map<String, Object> requestBodyFor_Patch = [('name') : 'Diksha']
//
//Map<String, String> hearderFor_Patch = [('x-api-key') : 'reqres-free-v1']
//
//int expectedStatusCodeFor_Patch = 200
//
//def getResponseFor_Patch = CS.handleRequest('PATCH', endPointFor_Patch, pathParamsFor_Patch, queryParamsFor_Patch, requestBodyFor_Patch, 
//    hearderFor_Patch, expectedStatusCodeFor_Patch)
//
//def jsonResponseFor_Patch = jsonSlurper.parseText(getResponseFor_Patch.getResponseText())
//
println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponseFor_Patch)))


//================================================================
String  baseUrl = GlobalVariable.BaseUrl
String pathUrlFotListUser = "/api/users?page=2"
String endPointFor_ListUser= baseUrl+pathUrlFotListUser
Map<String,Object> pathParamsList_Users= [:]
Map<String,Object> queryParamsList_Users= [:]
Map<String,Object> requestBodyList_Users=[:]
Map<String,String> headerList_Users= [
"x-api-key" :  "reqres-free-v1" ]
int expectedStatusCode_ListUsers=200
def getResponseForListUser=CS.handleRequest('GET', endPointFor_ListUser, queryParamsList_Users,pathParamsList_Users, requestBodyList_Users, headerList_Users, expectedStatusCode_ListUsers)
def jsonResponse_ListUser=jsonSlurper.parseText(getResponseForListUser.getResponseText())
def pageNumber=jsonResponse_ListUser.page 
// we are storing in variable so we can used this value in further 
def countItem=0
jsonResponse_ListUser.data.each{item->countItem++}
println countItem
assert jsonResponse_ListUser.page==pageNumber:" page number is not matched"
