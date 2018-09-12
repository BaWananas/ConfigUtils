import java.io.File;
import java.io.IOException;

import rawElements.Setting;
import reader.Reader;

public class test {
	
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Nathan Beer\\git\\ConfigUtils\\ConfigUtils\\src\\sampleText\\sample1");
		Reader reader = new Reader(file);
		try {
			Setting[] settings = reader.read(file).getSettings();
			for (int i = 0; i < settings.length; i++)
			{
				System.out.println(settings[i].getSettingName() + " = " + settings[i].getSettingValues());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
