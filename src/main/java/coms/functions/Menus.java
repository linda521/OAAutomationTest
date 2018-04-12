package coms.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Menus {
	private static Logger LOGGER = LogManager.getLogger(Menus.class);
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public Menus(WebDriver driver){
		this.driver = driver;
	}
	
	public void click(String menuName){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String js="var q=document.documentElement.scrollTop=100";
		jsExecutor.executeScript(js);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(menuName.trim().equals("用户管理")){
			js = "$(\"a[href=\'/view/employee/list.html\']\").children().filter(\"i\").click();";
			
			jsExecutor.executeScript(js);
		}else{
			driver.findElement(By.linkText("添加用户")).click();
		}
		
	}
}
