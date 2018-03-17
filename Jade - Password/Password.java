/*
 *	Password.java / Password
 *  15 - Nov - 2016
 * 	Author : Gourav Siddhad
 */

import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

@SuppressWarnings("serial")
public class Password extends Agent{
	@Override
	protected void setup() {
		addBehaviour(new mybehaviour(this));
	}

	public class mybehaviour extends SimpleBehaviour {

		private boolean finished = false;
		private String password = null;

		public mybehaviour(Agent a) {
			super(a);
		}

		@SuppressWarnings("resource")
		public void action() {
			System.out.println("Minimum 8 character long");
			System.out.println("Contains both Upper and Lower case");
			System.out.println("Minimum 1 digit");
			System.out.print("Enter password : ");
			Scanner scanner = new Scanner(System.in);
			password = scanner.next();
			try {
				checkstrength(password.toString());
			} catch(Exception e) {
				System.out.println("Exception");
			}
			finished = true;
		}

		public boolean done() {
			return finished;
		}
	}

	public void checkstrength(String password) {
		char ch;
		int length = password.length();
		int digit = 0, lowercase = 0, uppercase = 0, count = 0;

		if(length >= 8) {
			for(count=0; count<length; count++) {
				ch = password.charAt(count);
				if(Character.isDigit(ch))
					digit++;
				else if(Character.isLowerCase(ch))
					lowercase++;
				else if(Character.isUpperCase(ch))
					uppercase++;
			}
		}
		if(digit>=1 && lowercase>=1 && uppercase>=1)
			System.out.println("Password Strength : Strong");
		else
			System.out.println("Password Strength : Weak");
	}
}
