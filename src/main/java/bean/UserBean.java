package bean;

public class UserBean {
	
	private String account;
	private String passWord;
	private String userName;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	public UserBean(String account, String passWord,String userName) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserBean [account=" + account + ", passWord=" + passWord + ", userName=" + userName + "]";
	}

}
