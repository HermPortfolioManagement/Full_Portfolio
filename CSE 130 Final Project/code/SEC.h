#pragma once

int safeExit = 0; // standardized return code

int forceChange() { // to add to main to force compile
	
	std::cout << std::endl;
	
	return safeExit;
	
} // end function

int invalidInput() { // run when input is invalid
	
	std::cout << "I'm sorry, I don't understand. Let's try again." << std::endl;
	
	return safeExit;
	
} // end function

int generationError() { // generation out of switch-case range
	
	std::cout << "Error - generation out of range" << std::endl;
	
	return safeExit;
	
} // end function
