package runway;
import color.*;
public class Runway
{
	private String name;
	private boolean occupied;
	private String occupyingcallsign;
	public Runway(String name)
	{
		this.name=name;
		this.occupied=false;
		this.occupyingcallsign=null;
	
	}
	
	public String getName()
	{
		return name;
	}
	public boolean isOccupied()
	{
		return occupied;
	}
	public String getOccupyingcallsign()
	{
		return occupyingcallsign;
	}
		

	public void occupy(String callsign)
	{
		this.occupied=true;
		this.occupyingcallsign=callsign;
	}
		
	public void free()
	{
		this.occupied =false;
		this.occupyingcallsign=null;
	}
	
	public String statusString()
	{
		if(occupied)
		{
			return (name+" : "+ConsoleStyle.getRED()+"Occupied ("+occupyingcallsign+")"+ConsoleStyle.RESET);
		}
		else
		{
			return (name+" : "+ConsoleStyle.getBRIGHT_GREEN()+"Free"+ConsoleStyle.RESET);
		}
	}
}
	