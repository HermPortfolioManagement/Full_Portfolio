#pragma once
#include <iostream> // for io
#include <cstdlib> // for exit function
#include "class.h" // for running classes
#include "runtime.h" // for starting fuction processes
#include "SEC.h" // for safe return and input validation

int closeProgram() { // start close function
	
	std::cout << "Goodbye!" << std::endl;
	exit(EXIT_SUCCESS); 
	return safeExit;
	
} // end function

int displayGuide() { // start ASCII guide function
	
	std::cout << "Guide:\n"
		 << "========================================================================\n"
		 << "	Sometimes +		Common *	NO -\n"
		 << "========================================================================\n"
		 << "symptoms	 \t\t\tCovid	     Flu    	   Cold \n"
		 << "========================================================================\n"
		 << "Fever				|	*	|	*	|	+	|\n"
		 << "Cough				|	*	|	*	|	+	|\n"
		 << "Shortness of Breath\t\t|	*	|	-	|	-	|\n"
		 << "Runny Nose			|	+	|	+	|	*	|\n"
		 << "Headaches			|	+	|	*	|	+	|\n"
		 << "Sneezing			|	-	|	-	|	*	|\n"
		 << "Fatigue\t			|	+	|	*	|	+	|\n"
		 << "========================================================================\n"
		 << std::endl;
		 
		 
	return safeExit;
	
} // end function

int menu() { // start menu function
	
	int choice = 0;
	int totalPatients = 0;
	bool isValid = false;
	
	
	while (!isValid) { // start validation loop
	
		std::cout << "welcome to the symptom checker! Do you want to run some tests?"
		<< "\n\n1. Yes\n2. View Guide\n3. No\n\n" << std::endl;
		std::cin >> choice;
	
		switch (choice) { // begin switch case
			
			case 1: { // on yes
				
				std::cout << "how many patients do you want to check?\n" << std::endl;
				std::cin >> totalPatients;
				
				if (totalPatients > 0) { // begin input validation
					
					isValid = true;
					construct(totalPatients);
					
				} else { // on input less than zero
				
					invalidInput();
				
				} // end if else
				
				break;
				
			} // end case 1
			
			case 2: { // on view guide
				
				displayGuide();
				// to stay on menu, do not set to isValid
				break;
			}
			
			case 3: { // on no
				
				isValid = true;
				closeProgram();
				break;
				
			} // end case 3
			
			default: { // on invalid input
				
				invalidInput();
				break;
			}
			
		} // end switch-case statement
		
		
	} // end validation loop
	
	return safeExit;
	
} // end function
