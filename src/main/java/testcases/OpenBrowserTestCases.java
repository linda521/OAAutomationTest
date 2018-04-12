package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.BaseTest;



import coms.util.PropertiesUtil;
import coms.util.StringVerify;


public class OpenBrowserTestCases implements BaseTest {

	private String browser_name;
	public static WebDriver driver;
	private static Logger LOGGER = LogManager.getLogger(OpenBrowserTestCases.class);
	public PropertiesUtil proUtil;
	
	
	public String getBrowser_name() {
		return browser_name;
	}


	public void setBrowser_name(String browser_name) {
		this.browser_name = browser_name;
	}


	public static WebDriver getDriver() {
		return driver;
	}


	public static void setDriver(WebDriver driver) {
		OpenBrowserTestCases.driver = driver;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	 public void openBrowser(){
		 if(proUtil == null){
			 proUtil = new PropertiesUtil();
		 }
		 String path = this.getClass().getResource(".").getPath();
		 path = path.substring(1, path.length()-1);
		 path = path.replace("testcases", "");
		 System.out.println(path);
		 path += "lib/geckodriver.exe";
		 browser_name = proUtil.getValue("browser");
		 StringVerify.verifyNull(browser_name);
		 browser_name = browser_name.trim().toUpperCase();
		 LOGGER.info(browser_name);
		 if(browser_name.equals("FIREFOX")){
			// System.setProperty("webdriver.firefox.bin", path);
			 System.setProperty("webdriver.gecko.driver", path);
		     
		      System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
					driver = new FirefoxDriver();
		 }
	 }

	 
	 public void openUrl(){
		 if(proUtil == null){
			 proUtil = new PropertiesUtil();
		 }
		 String url = proUtil.getValue("url");
		 StringVerify.verifyNull(url);
		 if(url.contains("http")){
			 
		 }else{
			 url = "http://"+url;
		 }
		 driver.get(url);
	 }
	 
	 
	 
	 public void run(){
		 
		 
	 }


	@Override
	public void run(java.util.HashMap<String, Object> Map) {
		OpenBrowserTestCases browser = new OpenBrowserTestCases();			 
		 browser.openBrowser();
		 browser.openUrl();
	     Map.put("driver", driver);		
	}
	 
	
}
