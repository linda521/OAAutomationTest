package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.framework.BaseTest;

import functions.LoginFunction;

public class LoginTest implements BaseTest {

	
	HashMap<String,Object> paramMap;
	@Override
	public void run(HashMap<String,Object> map) {
		this.paramMap = map;
		WebDriver driver = (WebDriver)map.get("driver");
		LoginFunction login = new LoginFunction(driver);
		login.testLogin();
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
