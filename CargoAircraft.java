package aircraft;
public class CargoAircraft extends Aircraft
{
	private int cargoweight;
	public CargoAircraft(String callsign,int altitude,int speed,int cargoweight)
	{
		super(callsign,altitude,speed);
		this.cargoweight=cargoweight;
	}
	
	public void setCargoWeight(int cweight)
	{
		this.cargoweight=cweight;
	}
	
	public String gettype()
	{
		return "Cargo";
	}
	public String getinfo()
	{
		return "Cargoweight: "+cargoweight;
	}
	
}