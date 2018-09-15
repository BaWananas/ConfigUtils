package managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import rawElements.Setting;
import rawElements.SettingBlock;

public class Writer {
	
	public void write (SettingBlock settings, File fileText) throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(fileText));
		String str = new String();
		for (int i=0; i < settings.getSettings().length; i++)
		{
			Setting set = settings.getSettings()[i];
			str += set.getSettingName() + " = " + set.getSettingValues() + "\r";
		}
		out.write(str);
		out.close();
	}

}
