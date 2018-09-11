package rawElements;

public class Setting {
	
	private String settingName;
	private String settingValues;
	
	public Setting(String name, String value)
	{
		this.settingName = name;
		this.settingValues = value;
	}

	public String getSettingName() {
		return settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getSettingValues() {
		return settingValues;
	}

	public void setSettingValues(String settingValues) {
		this.settingValues = settingValues;
	}
	
}
