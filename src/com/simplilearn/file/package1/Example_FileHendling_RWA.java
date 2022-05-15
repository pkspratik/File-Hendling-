package com.simplilearn.file.package1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Example_FileHendling_RWA { // RWA (read , Write and append) 

	public static void main(String[] args) throws IOException {
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any Operation like R or W or A or E");
		
		
		String user_i=sc.next();
		
		if(user_i.equalsIgnoreCase("w")) {
			System.out.println("You Enter W for Writing"); 
			
				write_infile();
			}
	
		else if(user_i.equalsIgnoreCase("r")) {
			System.out.println("You Enter R for Reading");
			 List l =read_file("F://Files//test1.txt"); 
			
			 Iterator<String> itr = l.iterator(); 
			    while (itr.hasNext()) {
			      System.out.println(itr.next()); 
			    }
		}
		
		else if(user_i.equalsIgnoreCase("a")) {
			System.out.println("You Enter A for Append");
			append_infile();
		}
		else if(user_i.equalsIgnoreCase("e")) {
			System.out.println("You Enter E for Exit");
			break;
		}
		else {
			System.out.println("Please Enter Valid Charector");
		}
		
		
		}
		
	}
	
	 private static List<String> read_file(String fileName) {   // this method for reading text from file
	  
	    List<String> lines = Collections.emptyList(); //creates an empty list
	    try
	    { 
	      lines = 
	       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	    } 
	  
	    catch (IOException e) 
	    { 
	      //e.printStackTrace();
	    	System.out.println("Enter a valid File mane . ERROR! ");
	    } 
	    return lines; 
	  } 
	
	
	private static void write_infile()  throws IOException {  // this method used for writing in file
	
	   Scanner sc = new Scanner (System.in);
	   System.out.println("Enter Text for File ");
	   String data = sc.nextLine();
	   
	    Files.write(Paths.get("F://Files//test1.txt"), data.getBytes()); 

	    System.out.println(" Writing Successful ");
	}
	
	
	private static void append_infile() throws IOException {        // this is use for append 
		  Scanner sc = new Scanner (System.in);
		 System.out.println("Enter Text for append ");
		   String appenddata  = sc.nextLine();
		
		List<String> lines = Arrays.asList(" ",appenddata);
		
		Files.write(Paths.get("f://Files//test1.txt"), lines,StandardCharsets.UTF_8 ,StandardOpenOption.APPEND);
		
		System.out.println("Append Successful");
	}
	
}
