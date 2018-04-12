package coms.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.AMSException;

import coms.util.StringVerify;
import functions.LoginFunction;

public class Pages {
	private static Logger LOGGER = LogManager.getLogger(LoginFunction.class);
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void verifyPageTitle(String pageTitle){
		
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("top-dropNav-button")));
		String title = driver.findElement(By.id("top-dropNav-button")).getText();
		StringVerify.verifyNull(title);
		if(title.trim().equals(pageTitle)){
			LOGGER.info("进入"+pageTitle+"页面");
		}else{
			LOGGER.error("进入"+title+"页面，与期望"+pageTitle+"不符");
			throw new AMSException("");
		}
	}
	

}
