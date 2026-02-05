package main;
import java.util.*;
import color.*;
class Main
{
	
	public static void main(String[]args)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println(ConsoleStyle.getCYAN() + ConsoleStyle.getBOLD() +"===================================================="+ ConsoleStyle.RESET);
		System.out.println(ConsoleStyle.getCYAN() + ConsoleStyle.getBOLD() +"======   AIR TRAFFIC CONTROL SYSTEM - LOGIN   ======"+ConsoleStyle.RESET);
		System.out.println(ConsoleStyle.getCYAN() + ConsoleStyle.getBOLD()+"===================================================="+ ConsoleStyle.RESET);
		
		if(LoginSystem.login(sc))
		{
			Menu.showMenu(sc);
			System.out.println(ConsoleStyle.getBRIGHT_GREEN() + ConsoleStyle.getBOLD() +"Thanks for Visiting!"+ ConsoleStyle.RESET);
		}
		else
		{
			System.out.println(ConsoleStyle.getRED() +"Maximum attempts exceed Exiting the System" + ConsoleStyle.RESET);
		}
	}
}
			