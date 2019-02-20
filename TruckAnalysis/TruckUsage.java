package ex9;

import java.util.Date;

public class TruckUsage {

	private int miles;
	private int gas;
	private String observationTime;
	
	public TruckUsage(int miles, int gas, String observationTime) {
		super();
		this.miles = miles;
		this.gas = gas;
		this.observationTime = observationTime;
	}
	
	@Override
	public String toString() {
		return  miles +"," +gas +","+ observationTime;
	}
	
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public String getObservationTime() {
		return observationTime;
	}
	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}
	
}
