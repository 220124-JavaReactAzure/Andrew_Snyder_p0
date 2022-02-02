package com.revature.bankDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.revature.bankDriver.models.Customer;
import com.revature.bankDriver.util.AppState;

public class bankDriver {
	
	public static void main(String[] args) {
	AppState app = new AppState();
	app.startup();
		
		
		/*File customerPersistance = new File("resources/data.txt");
		
		try(FileWriter fileWriter = new FileWriter(customerPersistance, true); ){//include true to append the data
	    fileWriter.write(customer.toFileString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	    // fileWriter.close();
	    
	    String[] customerArr = customer.toFileString().split(":");
	    
	    customer.printFromFile(customerArr);*/
	
	} 
}
	

