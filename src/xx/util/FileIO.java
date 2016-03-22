package xx.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.Format;
import java.util.Date;
import java.util.Locale;

import com.mysql.jdbc.Field;

public class FileIO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i;
	public static void main(String[] args) {
		String path = "index.txt";
		FileInputStream fileInputStream;
		byte[] buf = new byte[1024];
		StringBuilder stringBuilder = new StringBuilder();
		try {
			fileInputStream = new FileInputStream(new File(path));
			int re = fileInputStream.read(buf);
			while(re != -1) {
				stringBuilder.append(new String(buf));
				re = fileInputStream.read(buf);
			}
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(new File(path));
			fileWriter.write(stringBuilder.toString().replaceAll("abc", "bnm"));
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}