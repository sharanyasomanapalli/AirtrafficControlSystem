package aircraft;
public class PassengerAircraft extends Aircraft
{
	private int passengercount;
	public PassengerAircraft(String callsign,int altitude,int speed,int passengercount)
	{
		super(callsign,altitude,speed);
		this.passengercount=passengercount;
	}
	
	public void setPassengerCount(int pcount)
	{
		this.passengercount=pcount;
	}
	
	public String gettype()
	{
		return "Passenger";
	}
	public String getinfo()
	{
		return "passengercount: "+passengercount;
	}
	
}