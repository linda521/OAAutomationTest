package functions;


import org.apache.logging.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.AMSException;
import com.framework.FrameWork;
import org.openqa.selenium.support.ui.WebDriverWait;

import coms.util.PropertiesUtil;
import coms.util.StringVerify;

public class LoginFunction {
	
	public static WebDriver driver;
	private static Logger LOGGER = LogManager.getLogger(LoginFunction.class);
	public LoginFunction(WebDriver driver){
		this.driver = driver;
	}
	

	public void testLogin(){

		PropertiesUtil proUtil = new PropertiesUtil();
		String account = proUtil.getValue("account");
		String password = proUtil.getValue("password");
		String username= proUtil.getValue("username");
		StringVerify.verifyNull(account);
		StringVerify.verifyNull(password);
		StringVerify.verifyNull(username);

		LOGGER.info("[account: " +account+"],[password="+password+"],[username="+username+"]");
		driver.findElement(By.id("account")).sendKeys(account);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.className("home-header-user-name")));
		String text = driver.findElement(By.className("home-header-user-name")).getText();
		StringVerify.verifyNull(text);
		LOGGER.info(text);
		if(text.equals(username)){
			LOGGER.info(text +"µÇÂ¼³É¹¦");
		}else{
			LOGGER.error(text + "µÇÂ¼Ê§°Ü");
			throw new AMSException("µÇÂ¼Ê§°Ü");
		}
		
	}

}
