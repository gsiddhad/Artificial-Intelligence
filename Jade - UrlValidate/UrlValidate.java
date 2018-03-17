/*
 *	UrlValidate.java / UrlValidate
 *  15 - Nov - 2016
 * 	Author : Gourav Siddhad
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import jade.core.Agent;

@SuppressWarnings("serial")
public class UrlValidate extends Agent{
	@Override
	protected void setup() {
		Object args[] = getArguments();
		String STR_ARG = args[0].toString();
		System.out.println(STR_ARG);

		try {
		    URL url = new URL(STR_ARG);
		    URLConnection conn = url.openConnection();
		    conn.connect();
		    System.out.println("Connection to " + STR_ARG + " is set");
		    System.out.println("URL is valid");
		} catch (MalformedURLException e) {
		    System.out.println("URL not in valid form");
		} catch (IOException e) {
			System.out.println("The connection couldn't be established");
		}
	}
}
