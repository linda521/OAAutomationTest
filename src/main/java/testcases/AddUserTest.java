package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.BaseTest;

import bean.UserBean;
import coms.functions.AddUser;
import coms.functions.Menus;
import coms.functions.Pages;
import coms.functions.SearchUser;
import coms.util.StringUp;

public class AddUserTest implements BaseTest{

	private WebDriver driver;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(HashMap<String, Object> Map) {
		
		UserBean user =(UserBean) Map.get("userBean");
		driver = (WebDriver)Map.get("driver");
		Menus menu = new Menus(driver);
		menu.click("用户管理");
		Pages page = new Pages(driver);
		page.verifyPageTitle("用户列表");
		menu.click("添加用户");
		page.verifyPageTitle("添加账号");
		AddUser addUser = new AddUser(driver);
		addUser.input(user);
		user = addUser.getUserBean();
		user.setPassWord(StringUp.upFirstChar(user.getAccount())+"123");
		
		Map.put("userBean", user);
		
		driver.findElement(By.linkText("返回")).click();
		page.verifyPageTitle("用户列表");
		
		SearchUser search = new SearchUser(driver);
		search.search(user.getAccount());
	}

}
