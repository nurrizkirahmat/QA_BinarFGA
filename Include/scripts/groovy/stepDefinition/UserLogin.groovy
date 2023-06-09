package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class UserLogin {
	@Given("User open the browser")
	public void user_open_the_browser() {
		WebUI.openBrowser('https://secondhand.binaracademy.org/')
		WebUI.maximizeWindow()
	}

	@When("User click masuk in homepage")
	public void user_click_masuk_in_homepage() {
		WebUI.click(findTestObject('Page_Home/button_Masuk'))
	}

	@When("User fill column email {string}")
	public void user_fill_column_email(String email) {
		WebUI.setText(findTestObject('Page_Login/field_email'), email)
	}

	@When("User fill column password {string}")
	public void user_fill_column_password(String password) {
		WebUI.setText(findTestObject('Page_Login/field_password'), password)
	}

	@When("User click button masuk")
	public void user_click_button_masuk() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.callTestCase(findTestCase('Pages/User Login/Click Login'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User verify in homepage")
	public void user_verify_in_homepage() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.waitForElementPresent(findTestObject('Page_Home/navbar_Produk saya'), 0)
	}

	@Then("User verify login error")
	public void user_verify_login_error() {
		// Write code here that turns the phrase above into concrete actions
		WebUI.callTestCase(findTestCase('Pages/User Login/verify Login Failed'), [:], FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User close browser")
	public void user_close_browser() {
		WebUI.closeBrowser()
	}
}