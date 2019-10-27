package study.java.code;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class test005 {
    public static void main(String[] args) {
	try {
	    OutputStream output = new FileOutputStream("D:/Output.txt");
	    String str ="파일은 이렇게 저장하면 됩니다.";
	    byte[] by=str.getBytes();
	    output.write(by);
			
	} catch (Exception e) {
            e.getStackTrace();
	}
    }
}


