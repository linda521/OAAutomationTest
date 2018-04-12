package coms.functions;

import java.io.IOException;

public class SendShenpi {
	
	public void upFile(String file){
		try {
			Runtime.getRuntime().exec("upfile.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
