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
	}

}
