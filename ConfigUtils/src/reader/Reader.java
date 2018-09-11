package reader;

import java.io.File;

import rawElements.Setting;
import rawElements.SettingBlock;

public class Reader {
	
	private File textFile;
	private SettingBlock settings;
	
	public Reader(File textFile)
	{
		this.textFile = textFile;
	}
	
	public SettingBlock read()
	{
		return null;
	}
	
	private Setting rowToSetting(String row)
	{
		String str[];
		str = row.split("=");
		if (str[0] != null && str[1] != null)
		{
			return new Setting(str[0], str[1]);
		}
		else if (str[0] != null && str[1] == null)
		{
			return new Setting(str[0], "null");
		}
		
		return new Setting("null", "null");
		
	}

}
