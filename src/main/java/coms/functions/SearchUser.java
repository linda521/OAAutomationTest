package coms.functions;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.AMSException;

import functions.LoginFunction;

public class SearchUser {
	private static Logger LOGGER = LogManager.getLogger(SearchUser.class);
	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public SearchUser(WebDriver driver) {
		this.driver = driver;
	}

	public void search(String account){
		LOGGER.info("通过account账号:"+account+"搜索");
		driver.findElement(By.id("list-title")).sendKeys(account);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
			try{
				driver.findElement(By.cssSelector("div[title='"+account+"']"));
				LOGGER.info("通过account账号:"+account+"存在");
			}catch(NoSuchElementException e1){
				LOGGER.error("通过account账号:"+account+"搜索不到结果，添加用户失败");
				throw new AMSException(account + "用户添加失败");
			}catch(Exception e){
				throw new AMSException(account + "用户添加失败");
			}
		
	}
	
}
