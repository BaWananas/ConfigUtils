package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import rawElements.Setting;
import rawElements.SettingBlock;

public class Reader {
	
	private File textFile;
	
	public Reader(File textFile)
	{
		this.textFile = textFile;
	}
	
	public SettingBlock read(File file) throws IOException
	{
		ArrayList<Setting> settings = new ArrayList<Setting>();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		
		while ((str=reader.readLine()) != null)
		{
			settings.add(this.rowToSetting(str));
		}
		
		if (settings.isEmpty())
		{
			return null;
		}
		else 
		{
			Setting[] tmp = new Setting[settings.size()];
			settings.toArray(tmp);
			return new SettingBlock(tmp);
		}
	}
	
	private Setting rowToSetting(String row)
	{
		String str[];
		str = row.split("=");

		if (str.length >= 2)
		{
			if (!str[0].isEmpty() && !str[1].isEmpty())
			{
				return new Setting(str[0], str[1]);
			}
			else if (!str[0].isEmpty() && str[1].isEmpty())
			{
				return new Setting(str[0], "null");
			}
		}
		else if (str.length == 1) 
		{
			if (str[0] != null)
			{
				return new Setting(str[0], "null");
			}
		}
		
		return new Setting("null", "null");
	}
	
	
	

}
