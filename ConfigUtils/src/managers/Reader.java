package managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import rawElements.Setting;
import rawElements.SettingBlock;

public class Reader {
	
	public SettingBlock read(File file) throws IOException
	{
		ArrayList<Setting> settings = new ArrayList<Setting>();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		boolean skipRow = false;
		
		while ((str=reader.readLine()) != null)
		{
			if (!skipRow)
			{
				str = str.trim();
				if (str.endsWith(";"))
				{
					String[] tmp = str.split(";");
					str = "";
					for (int i = 0; i < tmp.length; i++) 
					{
						if (i==0)
						{
							str += tmp[i]; 
						}
						else 
						{
							str += ";" + tmp[i];
						}
					}
				}
				
				if ((!str.startsWith("//")) && (!str.startsWith("/*")))
				{
					settings.add(this.rowToSetting(str));
				}
				if (str.startsWith("/*"))
				{
					skipRow = true;
				}
				
			}
			else
			{
				if (str.endsWith("*/"))
				{
					skipRow = false;
				}
			}
			
		}
		reader.close();
		
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
			str[0] = str[0].trim();
			str[1] = str[1].trim();
			if (!str[0].isEmpty() && !str[1].isEmpty())
			{
				return new Setting(str[0].trim(), str[1].trim());
			}
			else if (!str[0].isEmpty() && str[1].isEmpty())
			{
				return new Setting(str[0].trim(), "null");
			}
			else if (str[0].isEmpty() && !str[1].isEmpty())
			{
				return new Setting("null", str[1].trim());
			}
		}
		else if (str.length == 1)
		{
			str[0] = str[0].trim();
			if (!str[0].isEmpty())
			{
				return new Setting(str[0].trim(), "null");
			}

		}
		
		return new Setting("null", "null");
	}
	
	
	

}
