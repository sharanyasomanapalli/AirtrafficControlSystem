package aircraft;
import java.util.*;
import color.*;
public class AircraftManager
{
	private static ArrayList<Aircraft> aircraftList = new ArrayList<>();
	static{
		aircraftList.add(new PassengerAircraft("AIB432",25000,270,150));
		aircraftList.add(new CargoAircraft("HBU236",27000,300,25000));
	}
	public static void addAircraftMethod(Scanner sc)
	{
		System.out.println();
		System.out.println(ConsoleStyle.getCYAN()+ ConsoleStyle.getBOLD()+"---Add Aircraft---"+ConsoleStyle.RESET);
	
		System.out.println(ConsoleStyle.getRED()+"1."+ConsoleStyle.RESET+"Passenger Aircraft");
		System.out.println(ConsoleStyle.getRED()+"2."+ConsoleStyle.RESET+"Cargo Aircraft"+ConsoleStyle.RESET);
		System.out.println();
		System.out.print(ConsoleStyle.getCYAN()+"select option: "+ConsoleStyle.RESET);
		String choice =sc.nextLine().trim();
		if("1".equals(choice))
		{
			System.out.println();
			
			String cs=validCallSign(sc);
			
			int alt = -1;
			while (true) 
			{
    				System.out.print("Enter Altitude ( 0 - 45000 ft): ");
    				String altInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(altInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter a numeric altitude."+ConsoleStyle.RESET);
        				continue;
   			 	}
    				alt = Integer.parseInt(altInput);
    				if (!InputValidator.isValidAltitude(alt)) {
        			System.out.println(ConsoleStyle.getYELLOW()+"Altitude must be between 0 and 45000 ft."+ConsoleStyle.RESET);
    				} 
				else 
				{
       			 		break;
    				}
			}
			int spd = -1;	
			while (true) 
			{
    				System.out.print("Enter Speed (0 - 1000 knots): ");
    				String spdInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(spdInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter a numeric speed."+ConsoleStyle.RESET);
        				continue;
    				}
    				spd = Integer.parseInt(spdInput);
    				if (!InputValidator.isValidSpeed(spd)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Speed must be between 0 and 1000 knots."+ConsoleStyle.RESET);
    				} 
				else 
				{
        				break;
    				}
			}	


				
			int pcount = -1;
			while (true) 
			{
    				System.out.print("Enter Passenger Count: ");
    				String pcInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(pcInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter a Positive numeric passenger count"+ConsoleStyle.RESET);
        				continue;
   			 	}
    				pcount = Integer.parseInt(pcInput);
    				if (!InputValidator.isValidCount(pcount)) {
        			System.out.println(ConsoleStyle.getYELLOW()+"Passenger count must be greater than or equals to zero"+ConsoleStyle.RESET);
    				} 
				else 
				{
       			 		break;
    				}
			}
					
						
				
				aircraftList.add(new PassengerAircraft(cs,alt,spd,pcount));
			
				System.out.println(ConsoleStyle.getBRIGHT_GREEN() + ConsoleStyle.getBOLD() +"Passenger Aircraft "+cs+" Added Successfully"+ConsoleStyle.RESET);
				System.out.println();
			
		}
		else if("2".equals(choice))
		{
			System.out.println();
			
			String cs=validCallSign(sc);
			
			int alt = -1;
			while (true) 
			{
    				System.out.print("Enter Altitude (0 - 45000 ft): ");
    				String altInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(altInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter a numeric altitude."+ConsoleStyle.RESET);
        				continue;
   			 	}
    				alt = Integer.parseInt(altInput);
    				if (!InputValidator.isValidAltitude(alt)) {
        			System.out.println(ConsoleStyle.getYELLOW()+"Altitude must be between 0 and 45000 ft."+ConsoleStyle.RESET);
    				} 
				else 
				{
       			 		break;
    				}
			}
			 int spd = -1;	
			while (true) 
			{
    				System.out.print("Enter Speed (0 - 1000 knots): ");
    				String spdInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(spdInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter a numeric speed."+ConsoleStyle.RESET);
        				continue;
    				}
    				spd = Integer.parseInt(spdInput);
    				if (!InputValidator.isValidSpeed(spd)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Speed must be between 0 and 1000 knots."+ConsoleStyle.RESET);
    				} 
				else 
				{
        				break;
    				}
			}	

			

    		int cweight = -1;
			while (true) 
			{
    				System.out.print("Enter CargoWeight: ");
    				String cwInput = sc.nextLine().trim();
    				if (!InputValidator.isValidNumber(cwInput)) 
				{
        				System.out.println(ConsoleStyle.getYELLOW()+"Invalid input. Please enter Postive numeric Cargoweight"+ConsoleStyle.RESET);
        				continue;
   			 	}
    				cweight = Integer.parseInt(cwInput);
    				if (!InputValidator.isValidWeight(cweight)) {
        			System.out.println(ConsoleStyle.getYELLOW()+"Cargoweight must be greater than zero"+ConsoleStyle.RESET);
    				} 
				else 
				{
       			 		break;
    				}
			}




			aircraftList.add(new CargoAircraft(cs,alt,spd,cweight));
			
			System.out.println(ConsoleStyle.getBRIGHT_GREEN() + ConsoleStyle.getBOLD() +"Cargo Aircraft "+cs+" Added Successfully"+ConsoleStyle.RESET);
			System.out.println();
		}
		else
		{
			System.out.println(ConsoleStyle.getRED()+"Invalid input redirecting to menu page"+ConsoleStyle.RESET);
		}
	}
	public static void viewAllAircrafts()
	{
			System.out.println();
			System.out.println("=============================================================");
			System.out.println("Type       CallSign   Altitude  Speed    Info");
			System.out.println("=============================================================");
			for(Aircraft a : aircraftList)
			{
				System.out.println(a.getFormat());
			}
			System.out.println("=============================================================");
			System.out.println();
	}
		
	public static boolean deleteAircraft(Scanner sc,String callsign)
	{
		
		for(Aircraft a : aircraftList)	
		{
			
			if(a.getCallSign().equals(callsign))
			{
				
				aircraftList.remove(a);
				return true;
			}
		
		}
		return false;
	}




		
	public static String validCallSign(Scanner sc)
	{
		while(true)
		{
			System.out.print("Enter CallSign: ");
			String callsign=sc.nextLine().trim();
			callsign = callsign.trim().toUpperCase();
			if(callsign==null || callsign.trim().isEmpty())
			{
				System.out.println(ConsoleStyle.getYELLOW()+"CallSign can not be empty"+ConsoleStyle.RESET);
				continue;
			}
			if(callsign.length()<5)
			{
				System.out.println(ConsoleStyle.getYELLOW()+"Callsign contain atleast 5 characters"+ConsoleStyle.RESET);
				continue;
			}
			if(iscallsigntaken(callsign))
			{
				System.out.println(ConsoleStyle.getYELLOW()+"Callsign Already Exists Enter a unique one"+ConsoleStyle.RESET);
				continue;
			}
			if (!callsign.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$"))
		        {
    				System.out.println(ConsoleStyle.getYELLOW()+"CallSign must contain only letters and numbers (no special characters)."+ConsoleStyle.RESET);
    				continue;
			}
			return callsign;
		}
	}
	public static boolean iscallsigntaken(String callsign)
	{
		for(Aircraft a : aircraftList)
		{
			if(callsign.equals(a.getCallSign()))
			{
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Aircraft> getAircraftList()
	{
        	return aircraftList;
    	}
}






		
		
	
		