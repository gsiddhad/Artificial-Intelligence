/*
 *	Cookies.java / Cookies
 *	15 - Nov - 2016
 * 	Author : Gourav Siddhad
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

@SuppressWarnings("serial")
public class Cookies extends Agent{

	@Override
	protected void setup() {
		try {
			addBehaviour(new mybehaviour(this));
		} catch(Exception e) {
			System.out.println(e.toString());
		}
//	    doDelete();
	}

	class mybehaviour extends SimpleBehaviour {

		Object args[] = getArguments();
		private String STRARG = args[0].toString();
		private boolean finished = false;

		public mybehaviour(Agent a) {
			super(a);
		}

		@SuppressWarnings("resource")
		public void action() {
			System.out.println("Enter the path to folder to search for files");
			Scanner scanner = new Scanner(System.in);
			String folderPath = scanner.next();
			File folder = new File(folderPath);
			File searchfolder = new File(STRARG.toString());
			System.out.println("Searching for folder : "+ STRARG);
			try {
				scandir(folder, searchfolder);
			} catch(Exception e) {
				System.out.println("Exception : Directory does not exist.");
			}
			finished = true;
		}

		public boolean done() {
			return finished;
		}
	}

	public void scandir(File folder, File searchfolder) {
		boolean flag = true;
		if (folder.isDirectory()) {
			if(folder.getName().toString().equalsIgnoreCase(searchfolder.toString())) {
				System.out.println("Folder Found : Deleting");
				flag = false;
				try {
					deletefiles(folder);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length < 1)
				System.out.println("There is no File inside Folder");
			else
				System.out.println("List of Files & Folder");

			if(flag)
				for (File file : listOfFiles) {
					if(!file.isDirectory()) {
						try {
							System.out.println(file.getCanonicalPath().toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else
					scandir(file, searchfolder);
				}
			}
		} else
			System.out.println("There is no Folder @ given path :" + folder.getPath());
	}

	public void deletefiles(File file) throws IOException{
		if(file.isDirectory()) {
			if(file.list().length == 0) {
				file.delete();
				System.out.println("Directory is deleted : "
									+ file.getAbsolutePath());
			} else {
				String files[] = file.list();
				for (String temp : files) {
					File fileDelete = new File(file, temp);
					deletefiles(fileDelete);
				}
				if(file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : "
										+ file.getAbsolutePath());
				}
	    	}
	    } else {
	    	file.delete();
	    	System.out.println("File is deleted : " + file.getAbsolutePath());
	    }
	}
}
