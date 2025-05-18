package api
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class CustomizableKeywords {

	private static final KeywordLogger logger = new KeywordLogger()

	@Keyword
	static ResponseObject handleRequest(String method,

			String endpoint,

			Map<String, Object> pathParams = [:],

			Map<String, Object> queryParams = [:],


			Object requestBody = null,

			Map<String, String> headers = [:],

			int expectedStatusCode = 200) {

		ResponseObject response = null

		try {

			// Replace path parameters

			pathParams.each { key, value ->

				endpoint = endpoint.replace("{$key}", value.toString())
			}

			// Add query parameters

			if (!queryParams.isEmpty()) {

				String queryString = queryParams.collect { k, v -> "$k=$v" }.join("&")

				endpoint = "${endpoint}?${queryString}"
			}

			logger.logInfo("${method.toUpperCase()} Request URL: ${endpoint}")

			// Create request object

			RequestObject request = new RequestObject()

			request.setRestRequestMethod(method.toUpperCase())

			request.setRestUrl(endpoint)

			// Attach headers

			List<TestObjectProperty> headerList = headers.collect { k, v ->

				new TestObjectProperty(k, ConditionType.EQUALS, v)
			}

			request.setHttpHeaderProperties(headerList)

			logger.logInfo("Request Headers: ${headers}")

			// Add request body only if applicable

			if (["POST", "PUT", "PATCH"].contains(method.toUpperCase()) && requestBody != null) {

				String bodyJson = (requestBody instanceof String) ? requestBody : JsonOutput.toJson(requestBody)

				request.setBodyContent(new com.kms.katalon.core.testobject.impl.HttpTextBodyContent(

						bodyJson, "UTF-8", "application/json"))

				logger.logInfo("Request Body: ${bodyJson}")
			}

			// Send request

			response = WS.sendRequest(request)

			int statusCode = response.getStatusCode()

			String responseText = response.getResponseText()

			WS.verifyResponseStatusCode(response, expectedStatusCode, FailureHandling.CONTINUE_ON_FAILURE)

			KeywordUtil.logInfo("Status Code: ${statusCode}")

			if (statusCode != expectedStatusCode) {

				KeywordUtil.markFailedAndStop("Expected ${expectedStatusCode} but got ${statusCode}")
			} else {

				logger.logInfo("Status Code Validation PASSED: ${statusCode}")
			}

			// Log response body if any

			if (responseText?.trim()) {

				logger.logInfo("Response Text: ${responseText}")

				// Compare response to requestBody only if both are Maps

				if (requestBody instanceof Map) {

					def jsonResponse = new JsonSlurper().parseText(responseText)

					def jsonRequest = requestBody

					if (jsonResponse instanceof Map) {

						jsonRequest.each { key, val ->

							if (jsonResponse.containsKey(key)) {

								if (jsonResponse[key] != val) {

									logger.logWarning("Mismatch key '${key}': expected '${val}', got '${jsonResponse[key]}'")
								}
							} else {

								logger.logWarning("Key '${key}' missing in response")
							}
						}

						jsonResponse.each { key, val ->

							if (!jsonRequest.containsKey(key)) {

								logger.logWarning("Extra key in response: '${key}' with value '${val}'")
							}
						}
					} else {
						// raising an exception if the Response is not matched
						throw new IllegalStateException("Response is not a JSON object (Map), skipping key comparison")
					}
				}
			} else {

				logger.logInfo("Response is EMPTY")
			}
		} catch (Exception e) {

			logger.logError("${method.toUpperCase()} request failed: ${e.message}")

			if (response != null) {

				logger.logWarning("Failed Response Text: ${response.getResponseText()}")
			}

			throw e
		}

		return response
	}
}
