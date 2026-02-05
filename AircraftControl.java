package aircraft;
import java.util.*;
import color.*;
public class AircraftControl
{
	public static void controlSpecificAircraft(Scanner sc, ArrayList<Aircraft> aircraftList)
	{
		System.out.println();
		System.out.println(ConsoleStyle.getCYAN()+ ConsoleStyle.getBOLD()+"--- Control Specific Aircraft ---"+ConsoleStyle.RESET);
		System.out.print("Enter Aircraft Callsign: ");
		String cs=sc.nextLine().trim().toUpperCase();
		
		Aircraft selectedAircraft=null;
		for(Aircraft a : aircraftList)
		{
			if(a.getCallSign().equalsIgnoreCase(cs))
			{
				selectedAircraft=a;
				break;
			}
		}
		if(selectedAircraft==null)
		{
			System.out.println(ConsoleStyle.getRED()+"Aircraft "+cs+" Not Found"+ConsoleStyle.RESET);
			return;
		}
		
		
		while(true)
		{
			System.out.println();
			System.out.println(ConsoleStyle.getRED()+"1."+ConsoleStyle.RESET+"View Status");
			System.out.println(ConsoleStyle.getRED()+"2."+ConsoleStyle.RESET+"Update Altitude");
			System.out.println(ConsoleStyle.getRED()+"3."+ConsoleStyle.RESET+"Update Speed");
			System.out.println(ConsoleStyle.getRED()+"4."+ConsoleStyle.RESET+"Grant Landing Clearance");
        		System.out.println(ConsoleStyle.getRED()+"5."+ConsoleStyle.RESET+"Grant Takeoff Clearance");
        		System.out.println(ConsoleStyle.getRED()+"6."+ConsoleStyle.RESET+"Exit Control Panel");
			System.out.println();
        		System.out.print(ConsoleStyle.getCYAN() +"Choose an option: "+ConsoleStyle.RESET);
        		String option = sc.nextLine().trim();
			
			
			switch(option)
			{
				case"1":
					System.out.println();
					System.out.println("CallSign         "+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET + selectedAircraft.getCallSign());
                			System.out.println("Type             "+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET + selectedAircraft.gettype());
                			System.out.println("Altitude         "+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET  + selectedAircraft.getAltitude() + " ft");
                			System.out.println("Speed            "+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET  + selectedAircraft.getSpeed() + " knots");
                			System.out.println("Runway           "+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET  + (selectedAircraft.getAssignedRunway() == null ? "None" : selectedAircraft.getAssignedRunway()));
                			System.out.println("Landing Clearance"+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ConsoleStyle.RESET  + (selectedAircraft.haslandingclearence() ? "Granted" : "Not Granted"));
                			System.out.println("Takeoff Clearance"+ConsoleStyle.getYELLOW()+ConsoleStyle.BOLD+" : "+ ConsoleStyle.RESET + (selectedAircraft.hastakeoffclearence() ? "Granted" : "Not Granted"));
                			break;
				case "2":
    					 while (true) 
					{
        					System.out.print("Enter new altitude (0 - 45000 ft): ");
        					String altInput = sc.nextLine().trim();

        					if (altInput == null || altInput.isEmpty()) 
						{
            						System.out.println(ConsoleStyle.YELLOW + "Altitude must be numeric" + ConsoleStyle.RESET);
            						continue;
        					}

        					boolean isValidAltitude = true;
        					for (int i = 0; i < altInput.length(); i++) 
						{
            						if (!Character.isDigit(altInput.charAt(i))) 
							{
                						isValidAltitude = false;
                						break;
            						}
        					}

        					if (!isValidAltitude) 
						{
            						System.out.println(ConsoleStyle.YELLOW + "Altitude must be numeric" + ConsoleStyle.RESET);
            						continue;
        					} 
						else 
						{
            						int newAlt = Integer.parseInt(altInput);
            						if (newAlt < 0 || newAlt > 45000) 
							{
                						System.out.println(ConsoleStyle.YELLOW + "Altitude must be between 0 and 45000 ft." + ConsoleStyle.RESET);
                						continue;
            						}
					 		else 
							{
                						selectedAircraft.setAltitude(newAlt);
                						System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD + "Altitude updated" + ConsoleStyle.RESET);
                						break;
            						}
        					}
    					}
    					break;
				case "3":
    					while (true) 
					{
        					System.out.print("Enter new speed (0 - 1000 knots): ");
        					String spdInput = sc.nextLine().trim();

	        				if (spdInput == null || spdInput.isEmpty()) 
						{
            						System.out.println(ConsoleStyle.YELLOW + "Speed must be numeric" + ConsoleStyle.RESET);
            						continue;
        					}

        					boolean isValidSpeed = true;
        					for (int i = 0; i < spdInput.length(); i++) 
						{
            						if (!Character.isDigit(spdInput.charAt(i))) 
							{
                						isValidSpeed = false;
                						break;
            						}
        					}

        					if (!isValidSpeed) 
						{
            						System.out.println(ConsoleStyle.YELLOW + "Speed must be numeric" + ConsoleStyle.RESET);
            						continue;
        					} 
						else
						{
            						int newSpd = Integer.parseInt(spdInput);
            						if (newSpd < 0 || newSpd > 1000) 
							{
                						System.out.println(ConsoleStyle.YELLOW + "Speed must be between 0 and 1000 knots" + ConsoleStyle.RESET);
                						continue;
            						}
	 						else 
							{
                						selectedAircraft.setSpeed(newSpd);
                						System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD + "Speed updated" + ConsoleStyle.RESET);
                						break;
            						}
        					}
    					}
    					break;
				case "4":
               				if (selectedAircraft.getAssignedRunway() != null)
					{
                    				System.out.println(ConsoleStyle.RED+"Cannot grant landing clearance. Aircraft is already on a runway"+ConsoleStyle.RESET);
                				} 
					else if (selectedAircraft.haslandingclearence())
					{
                    				System.out.println(ConsoleStyle.RED+"Aircraft already has landing clearance"+ConsoleStyle.RESET);
               				}
					else
					{
                    				selectedAircraft.grantlandingclearence();
                    				System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD+"Landing clearance granted"+ConsoleStyle.RESET);
                			}
               				break;

				case "5":
                				if (selectedAircraft.getAssignedRunway() == null)
	 				{
                    				System.out.println(ConsoleStyle.RED+"Cannot grant takeoff clearance. Aircraft is not on a runway"+ConsoleStyle.RESET);
               			 	}
					else if (selectedAircraft.hastakeoffclearence()) 
					{
                    				System.out.println(ConsoleStyle.RED+"Aircraft already has takeoff clearance"+ConsoleStyle.RESET);
               				}
					else
					{
                    				selectedAircraft.granttakeoffclearence();
                    				System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD+"Takeoff clearance granted"+ConsoleStyle.RESET);
                				}
               				break;
				case "6":
                				System.out.println(ConsoleStyle.GREEN+ConsoleStyle.BOLD+"Exiting Aircraft Control Panel..."+ConsoleStyle.RESET);
                				return;

            			default:
               	 			System.out.println(ConsoleStyle.RED+"Invalid option"+ConsoleStyle.RESET);
                				break;
        		}

        		System.out.println();
    		}
	}
}


					
			


