
public class Burner {
	private enum Temperature {
		BLAZING, HOT, WARM, COLD
	}

	private Temperature myTemperature;
	
	public String getTemperature() {
		return this.myTemperature.toString();
	}
	
	private Setting mySetting;
	
	private int timer;
	
	public final static int TIME_DURATION = 2;
	
	Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.LOW;
		timer = 2;
	}
	
	// Plus button function. Increases the current setting by one. Ignores if on highest setting
	public void plusButton() {
		switch (mySetting) {
		case HIGH:
			break;
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		}
	}
	
	// Minus button function. Decreases the current setting by one. Ignores if on lowest setting
	public void minusButton() {
		if (mySetting.equals(Setting.OFF)) {
			return;
		}
		else if (mySetting.equals(Setting.LOW)) {
			mySetting = Setting.OFF;
			return;
		}
		else if (mySetting.equals(Setting.MEDIUM)) {
			mySetting = Setting.LOW;
			return;
		}
		else if (mySetting.equals(Setting.HIGH)) {
			mySetting = Setting.MEDIUM;
			return;
		}
	}
	
	public void updateTemperature() {
		
	}
	
	void display() {
		String printMessage = "";
		switch (myTemperature) {
		case COLD:
			printMessage = "cooool";
			break;
		case WARM:
			printMessage = "warm";
			break;
		case HOT:
			printMessage = "CAREFUL";
			break;
		case BLAZING:
			printMessage = "VERY HOT! DON'T TOUCH";
			break;
		}
		
		System.out.println(this.myTemperature + "....." + printMessage);
	}
	
}
