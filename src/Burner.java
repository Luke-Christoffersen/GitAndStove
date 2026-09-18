
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
		mySetting = Setting.OFF;
		timer = 0;
	}
	
	// Plus button function. Increases the current setting by one. Ignores if on highest setting
	public void plusButton() {
		switch (mySetting) {
		case HIGH:
			timer = TIME_DURATION;
			break;
		case OFF:
			mySetting = Setting.LOW;
			timer = TIME_DURATION;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			timer = TIME_DURATION;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			timer = TIME_DURATION;
			break;
		}
	}
	
	// Minus button function. Decreases the current setting by one. Ignores if on lowest setting
	public void minusButton() {
		switch (mySetting) {
		case OFF:
			timer = TIME_DURATION;
			break;
		case LOW:
			mySetting = Setting.OFF;
			timer = TIME_DURATION;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			timer = TIME_DURATION;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			timer = TIME_DURATION;
			break;
		}
	}
	
	public void updateTemperature() {
		// Check if timer is greater than 0
		if (timer > 0) {
			// Decrement the timer by 1
			timer--;
			if (timer == 0) {
				Temperature targetTemp;
				// Set target temp to matching temperature setting
				switch (mySetting) {
				case LOW:
					targetTemp = Temperature.WARM;
				case MEDIUM:
					targetTemp = Temperature.HOT;
				case HIGH:
					targetTemp = Temperature.BLAZING;
				default:
					targetTemp = Temperature.COLD;
					
				// Check if the current temperature is not equal to the target temp
				if (myTemperature != targetTemp) {
					// enum order is BLAZING(0), HOT(1), WARM(2), and COLD(#)
					// Check to see if the value of myTemperature is higher than the target temperature
					if (myTemperature.ordinal() > targetTemp.ordinal()) {
						// Decrease myTemperature's enum value by 1
						myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
					}
					else {
						// Increase my Temperature's enum value by 1
						myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
					}
					
					// If myTemperature doesn't match the target, reset the timer
					if (myTemperature != targetTemp) {
						timer = TIME_DURATION;
					}
				}
				}
			}
		}
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
