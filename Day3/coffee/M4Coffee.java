package coffee;

abstract class Display {
	
}
abstract class Heater {

	public void startHeatingWater() throws InterruptedException {
		var cm = CoffeeMakerAPI.api;
		cm.setBoilerState(cm.BOILER_ON);
		while (cm.getBoilerStatus() != cm.BOILER_EMPTY)
			Thread.sleep(1000);
		tellWarmerToTurnOn();
	}

	protected abstract void tellWarmerToTurnOn();
	
}
abstract class Warmer {
	
}
class M4Display extends Display {
	Heater h;
	Warmer w;
	public void colleges(Heater h, Warmer w) {
		this.h = h;
		this.w = w;
	}
	public void startButtonPressed() {
		var cm = CoffeeMakerAPI.api;
		cm.setIndicatorState(cm.INDICATOR_ON);
		h.startHeatingWater();
	}
	
}
class M4Heater extends Heater {

	public void colleges(M4Display d, M4Warmer w) {
		// TODO Auto-generated method stub
		
	}
	
}
class M4Warmer extends Warmer {

	public void colleges(M4Display d, M4Heater h) {
		// TODO Auto-generated method stub
		
	}
	
}
public class M4Coffee {

	public static void main(String[] args) {
		var d = new M4Display();
		var h = new M4Heater();
		var w = new M4Warmer();
		d.colleges(h,w);
		h.colleges(d,w);
		w.colleges(d, h);
		d.startButtonPressed();
	}

}
