package coms.util;

import com.framework.AMSException;

public  class StringVerify {

	
	
	public static void verifyNull(String arg){
		if(arg ==null ){
			throw new AMSException( "arg  is null");
		}
		
	}
	
	
	public static void verifyEqual(String expected,String actual){
		verifyNull(expected);
		verifyNull(actual);
		if(expected.trim().equals(actual.trim())){
			
		}else{
			throw new AMSException("������" + expected +"��ʵ�ʵģ�"+actual+"����");
		}
	}
	

}
