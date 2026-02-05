package aircraft;
import color.*;
public abstract class Aircraft
{
	private String callsign;
	private int altitude;
	private int speed;
	private boolean landingclearence;
	private boolean takeoffclearence;
	private String assignedRunway = null;

	public Aircraft(String callsign,int altitude,int speed)
	{
		this.callsign  = callsign;
		this.altitude  = altitude;
		this.speed     = speed;
	}

	public void setAltitude(int altitude)
	{
		this.altitude=altitude;
	}
	public void setSpeed(int speed)
	{
		this.speed=speed;
	}
	
	public abstract String gettype();
	public abstract String getinfo();
	

	public String getCallSign()
	{
		return callsign;
	}
	public int getAltitude()
	{
		return altitude;
	}
	public int getSpeed()
	{
		return speed;
	}

	public String getFormat()
	{
		return String.format(ConsoleStyle.getGRAY()+ConsoleStyle.getBOLD()+"%-10s %-10s %-9d %-8d %s",gettype(),getCallSign(),getAltitude(),getSpeed(),getinfo()+ConsoleStyle.RESET);
	}
	

	public boolean haslandingclearence()
	{
		return landingclearence;
	}
	public void grantlandingclearence()
	{
		this.landingclearence=true;
	}
	public void revokelandingclearence()
	{
		this.landingclearence=false;
	}

	public boolean hastakeoffclearence()
	{
		return takeoffclearence;
	}
	public void granttakeoffclearence()
	{
		this.takeoffclearence=true;
	}
	public void revoketakeoffclearence()
	{
		this.takeoffclearence=false;
	}
	

	public String getAssignedRunway()
	{
		 return assignedRunway; 
	}
	public void setAssignedRunway(String runwayName) 
	{
		 assignedRunway = runwayName;
	}


	
}