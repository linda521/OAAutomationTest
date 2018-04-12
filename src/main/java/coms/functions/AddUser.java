package coms.functions;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import bean.UserBean;
import coms.util.StringVerify;
import functions.LoginFunction;

public class AddUser {
	private static Logger LOGGER = LogManager.getLogger(AddUser.class);
	private WebDriver driver;
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public AddUser(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public void input(UserBean user){
		LOGGER.info("add user:" + user.toString());
		//填写姓名
		driver.findElement(By.id("edit-realname")).sendKeys(user.getUserName());
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.name("simplename")));
		WebElement simplenameElement = driver.findElement(By.name("simplename"));
		String simpleName=simplenameElement.getAttribute("value").trim();
		StringVerify.verifyNull(simpleName);
		simplenameElement.click();
		
		//获取account
		String account = driver.findElement(By.id("edit-account")).getAttribute("value").trim();
		StringVerify.verifyNull(account);
		user.setAccount(account);
		
		this.userBean = user;
		
		//获取搜索简码，不为空
		String u_name_py = driver.findElement(By.name("u_name_py")).getAttribute("value").trim();
		StringVerify.verifyNull(u_name_py);
		
		//获取邮箱
		String editEmail = driver.findElement(By.id("edit-email")).getAttribute("value").trim();
		StringVerify.verifyNull(editEmail);
		
		//选择部门
		driver.findElement(By.className("choice-btn")).click();
		
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.className("bootstrap-dialog-title")));
		String title = driver.findElement(By.className("bootstrap-dialog-title")).getText();
		StringVerify.verifyEqual( "选择部门",title);
		//js脚本，通过公司名称选择公司名称
		String form = "珠三角公司";
		String js = "$(\"span[title=\'"+form+"\']\").prev().click();";
		System.out.println(js);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;		
		jsExecutor.executeScript(js);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.id("dialogSure")).click();
		
		String partCode = driver.findElement(By.className("choice-placeholder")).getText();
		StringVerify.verifyEqual(form,partCode);
		
	    //职务
		driver.findElement(By.name("duty")).sendKeys("testor");
		
		//员工编号
		driver.findElement(By.name("u_code")).sendKeys("10002021");
		
		//手机
		driver.findElement(By.name("u_phone")).sendKeys("13722343223");
		
		//保存
		driver.findElement(By.id("info-submit")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	

}
