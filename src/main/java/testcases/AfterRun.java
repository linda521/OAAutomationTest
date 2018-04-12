package testcases;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.framework.BaseTest;
import com.framework.FrameWork;

public class AfterRun implements BaseTest{

	public static WebDriver driver;
	
	
	public void close(){
		
		driver.quit();
		//driver.close();
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run(HashMap<String, Object> Map) {
		// TODO Auto-generated method stub
		driver = (WebDriver) Map.get("driver");
		close();
	}
}
