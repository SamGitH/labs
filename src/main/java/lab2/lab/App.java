package lab2.lab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

class Move{
	Move() {
		System.out.println("Enter name of file!");
		Scanner in =new Scanner(System.in);
		String name_of_old_File = in.nextLine();       
		File oldFile=new File(name_of_old_File);       	
		System.out.println("Enter new name of file!");
		String name_of_new_File = in.nextLine();
		File newFile=new File(name_of_new_File);
		try {
			FileUtils.moveDirectory(oldFile, newFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}
	
}


public class App 
{
	public static void main( String[] args )
	{
		Move mv=new Move();
	}
}

