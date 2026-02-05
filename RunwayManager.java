package runway;
import java.util.*;
import aircraft.*;
import color.*;
public class RunwayManager
{
	private static ArrayList<Runway> runwaysList=new ArrayList<>();
	static{
		runwaysList.add(new Runway("RWY-01"));
		runwaysList.add(new Runway("RWY-02"));
		runwaysList.add(new Runway("RWY-03"));

	}
	public static void manageRunways(Scanner sc,ArrayList<Aircraft> aircraftList)
	{
		System.out.println();
		System.out.println(ConsoleStyle.getCYAN()+ConsoleStyle.getBOLD()+"--- Runway Manager ---"+ConsoleStyle.RESET);
		for(Runway r : runwaysList)
		{
			System.out.println(r.statusString());
		}
		System.out.println();
		
		System.out.println(ConsoleStyle.getRED()+"1."+ConsoleStyle.RESET+"Assign Aircraft to Runway");
		System.out.println(ConsoleStyle.getRED()+"2."+ConsoleStyle.RESET+"Free Runway");
		System.out.println("Press Enter or any option from above to Exit Runway Manager");
		System.out.println();
		System.out.print(ConsoleStyle.getCYAN()+"Choose an option: "+ConsoleStyle.RESET);
		String option=sc.nextLine().trim();
		
		
		
		if("1".equals(option))
		{
			System.out.println();
			System.out.print("Enter Runway Name: ");
			String rname=sc.nextLine().trim();
			rname=rname.trim().toUpperCase();
			
			int count=0;
			for(Runway r : runwaysList)
			{
				if(r.getName().equalsIgnoreCase(rname))
				{
					count++;
					break;
				}
			}
			
			if(count==0)
			{
				System.out.println(ConsoleStyle.getRED()+"Runway name is Not Found"+ConsoleStyle.RESET);
				return;
			}




			System.out.print("Enter callsign: ");
			String cs = sc.nextLine().trim();
			cs=cs.trim().toUpperCase();
			boolean aircraftExists = false;
			Aircraft selectedAircraft = null;
			for (Aircraft a : aircraftList) 
			{
    				if (a.getCallSign().equalsIgnoreCase(cs)) 
				{
        				aircraftExists = true;
					selectedAircraft = a;
        				break;
    				}
			}

			if (!aircraftExists) 
			{
    				System.out.println(ConsoleStyle.getRED()+"Aircraft " + cs + " does not exist in the system."+ConsoleStyle.RESET);
				System.out.println();
    				return;
			}

			if (!selectedAircraft.haslandingclearence()) 
			{
    				System.out.println(ConsoleStyle.getRED()+"Aircraft " + cs + " must have landing clearance before runway assignment."+ConsoleStyle.RESET);
    				return;
			}
			
			
			Runway rselect=null;
			for(Runway r : runwaysList)
			{
				if(r.getName().equalsIgnoreCase(rname))
				{
					rselect=r;
					break;
				}
			}

			if(rselect==null)
			{
				System.out.println(ConsoleStyle.RED+"Runway Not Found"+ConsoleStyle.RESET);
				return;
			}
			
			if(rselect.isOccupied())
			{
				System.out.println(ConsoleStyle.RED+"Runway is already occupied by " + rselect.getOccupyingcallsign()+ConsoleStyle.RESET);
			}

			rselect.occupy(cs);



			selectedAircraft.setAssignedRunway(rselect.getName());
			selectedAircraft.revokelandingclearence();

			System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD+"Aircraft "+cs+" is assigned to "+rname+" successfully"+ConsoleStyle.RESET);
			
			selectedAircraft.setAssignedRunway(rselect.getName());
			selectedAircraft.revokelandingclearence();
		}

		else if("2".equals(option))
		{
			System.out.println();
			System.out.print("Enter Runway Name: ");
			String rname = sc.nextLine().trim();
			
			Runway selectedRunway=null;
			for(Runway r: runwaysList)
			{
				if(r.getName().equalsIgnoreCase(rname))
				{
					
					selectedRunway=r;
					break;
				}
			}
			
			if(selectedRunway==null)
			{
				System.out.println(ConsoleStyle.RED+"Runway Not Found"+ConsoleStyle.RESET);
				return;
			}
			if(!selectedRunway.isOccupied())
			{
				System.out.println(ConsoleStyle.RED+"Runway is already Free"+ConsoleStyle.RESET);
				return;
			}
			

			String occupyingCallSign = selectedRunway.getOccupyingcallsign();
			Aircraft selectedAircraft = null;	
			for (Aircraft a : aircraftList)
			{
    				if (a.getCallSign().equalsIgnoreCase(occupyingCallSign)) 
				{
        				selectedAircraft = a;
        				break;
    				}
			}

			if (selectedAircraft == null) 
			{
    				System.out.println(ConsoleStyle.RED+"Occupying aircraft not found"+ConsoleStyle.RESET);
    				return;
			}

			if (!selectedAircraft.hastakeoffclearence()) 
			{
    				System.out.println(ConsoleStyle.RED+"Cannot free runway. Aircraft " + occupyingCallSign + " must have takeoff clearance"+ConsoleStyle.RESET);
    				return;
			}
			






			selectedRunway.free();
			
			selectedAircraft.setAssignedRunway(null);
			selectedAircraft.revoketakeoffclearence();



			System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD+"Runway " + selectedRunway.getName() + " is now free"+ConsoleStyle.RESET);
		}
		else
		{
			if(option==null || option.isEmpty())
			{
				return;
			}
			System.out.println(ConsoleStyle.RED+"Invalid option"+ConsoleStyle.RESET);
			System.out.println();
		}
	}
	
}