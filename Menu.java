package main;
import java.util.*;
import aircraft.*;
import runway.*;
import color.*;
public class Menu
{
	public static void showMenu(Scanner sc)
	{
		
	

		boolean b =true;
		while(b)
		{
			System.out.println(ConsoleStyle.getCYAN() + ConsoleStyle.getBOLD() +"====================================================");
			System.out.println("====== AIR TRAFFIC CONTROL SYSTEM - MAIN MENU ======");
			System.out.println("===================================================="+ConsoleStyle.RESET);

			System.out.println(ConsoleStyle.getRED()+"1."+ConsoleStyle.RESET+"Add Aircraft");
			System.out.println(ConsoleStyle.getRED()+"2."+ConsoleStyle.RESET+"View All Aircrafts");
			System.out.println(ConsoleStyle.getRED()+"3."+ConsoleStyle.RESET+"Control Specific Aircraft");
			System.out.println(ConsoleStyle.getRED()+"4."+ConsoleStyle.RESET+"Manage Runways");
			System.out.println(ConsoleStyle.getRED()+"5."+ConsoleStyle.RESET+"Delete Aircraft");
			System.out.println(ConsoleStyle.getRED()+"6."+ConsoleStyle.RESET+"Exit");
			System.out.println();
			System.out.print(ConsoleStyle.getCYAN() +"Enter any option: "+ConsoleStyle.RESET);
			String choice=sc.nextLine().trim();
			
			switch(choice)
			{
				case"1":
					AircraftManager.addAircraftMethod(sc);
					break;
				case"2":
					AircraftManager.viewAllAircrafts();
					break;
				case"3":
					AircraftControl.controlSpecificAircraft(sc, AircraftManager.getAircraftList());
					break;
				case"4":
					RunwayManager.manageRunways(sc, AircraftManager.getAircraftList());
					break;
				case"5":
					System.out.println(ConsoleStyle.getRED() +"-----Delete Aircraft-----"+ ConsoleStyle.RESET);
					System.out.print("Enter Callsign: ");
					String callsign=sc.nextLine().trim();
					callsign=callsign.trim().toUpperCase();
					if(AircraftManager.deleteAircraft(sc,callsign))
					{
						
						System.out.println(ConsoleStyle.getGREEN() +"Aircraft "+callsign+" deleted successfully" + ConsoleStyle.RESET);
						System.out.println();
					}
					else
					{
						System.out.println();
						System.out.println(ConsoleStyle.getRED()+ "No callsign Found"+ ConsoleStyle.RESET);
					}
					break;
				case"6":
					b=false;
					break;
				default:
					System.out.println(ConsoleStyle.getRED()+"Invalid Input" + ConsoleStyle.RESET);
					break;
			}
		}
	}
}
		
