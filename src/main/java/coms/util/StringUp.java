package coms.util;

public class StringUp {

	
	public static String upFirstChar(String str){
		char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
	}
}
