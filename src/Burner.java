
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
	
	public void plusButton() {
		if (mySetting.equals(Setting.HIGH)) {
			return;
		}
		else if (mySetting.equals(Setting.OFF)) {
			mySetting = Setting.LOW;
		}
		else if (mySetting.equals(Setting.LOW)) {
			mySetting = Setting.MEDIUM;
		}
		else if (mySetting.equals(Setting.MEDIUM)) {
			mySetting = Setting.HIGH;
		}
	}
	
	public void minusButton() {
		if (mySetting.equals(Setting.LOW)) {
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
