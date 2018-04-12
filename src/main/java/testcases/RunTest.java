package testcases;

import java.util.HashMap;

import bean.UserBean;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String,Object>();
		try{
			OpenBrowserTestCases browserTestCases = new OpenBrowserTestCases();		
			browserTestCases.run(map);
			LoginTest login = new LoginTest();
			login.run(map);
			UserBean user = new UserBean(null, null, "chl");
			map.put("userBean", user);
			AddUserTest add = new AddUserTest();
			add.run(map);
			AfterRun close = new AfterRun();
			close.run(map);
		}catch(Exception e){
			e.printStackTrace();
			AfterRun close = new AfterRun();
			close.run(map);
			
		}
	}

}
