package com.revature.bankofandrew.menus;

import java.io.BufferedReader;

import com.revature.bankofandrew.util.MenuRouter;
import static com.revature.bankofandrew.util.AppState.shutdown;

public class WelcomeMenu extends Menu {

	
	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		System.out.println("Welcome to the Bank of Andrew\n" +
			      "1) Login\n" +
				  "2) Register\n" +
				  "3) Exit\n" + 
				  ">" 
				  );
			

		String userSelection = consoleReader.readLine();
		switch(userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("The input was not 1-3, try again");
			break;
		}
		
		
	}

}