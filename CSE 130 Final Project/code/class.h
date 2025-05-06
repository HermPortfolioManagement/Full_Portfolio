#pragma once

#include <iostream>
#include "menu.h"
#include "SEC.h"
		
		
class Patient { // begin class def
			
	// attributes
				
	bool fever = false;
	bool cough = false;
	bool shortBreath = false;
	bool runnyNose = false;
	bool headAche = false;
	bool sneezing = false;
	bool fatigue = false;

	bool hasCovid = false;
	bool hasFlu = false;
	bool hasCold = false;
	bool hasOther = false;

	int covidTotal = 0;
	int fluTotal = 0;
	int coldTotal = 0;
	int otherTotal = 0;
	
	int patientTotal = 0;
	 
				

	
	protected:
			
	// Methods
				
	int report(int covidTotal, int fluTotal, int coldTotal, int otherTotal, int patientTotal) { // start report method
					
	
	/*	std::cout << "Covid total is: " << covidTotal << "\nPatient total is: "
				  << patientTotal << "\ncovidTotal / patientTotal is: "  // DEBUG LINES
				  << (float)covidTotal / (float)patientTotal << std::endl;*/ 
	
		float covidPercent = (float)covidTotal / patientTotal * 100;
		float fluPercent = (float)fluTotal / patientTotal * 100;
		float coldPercent = (float)coldTotal / patientTotal * 100;
		float otherPercent = (float)otherTotal / patientTotal * 100;
					
		std::cout << "\nTotals\n" << std::endl;
					
		std::cout << "Total patients: " << patientTotal << std::endl;
		std::cout << "Patients with covid: " << covidTotal << std::endl;
		std::cout << "Patients with the flu: " << fluTotal << std::endl;
		std::cout << "Patients with a cold: " << coldTotal << std::endl;
		std::cout << "Patients with an other illness: " << otherTotal
				  << std::endl;
						 
		std::cout << "\nPercentages\n" << std::endl;
					
		std::cout << "Patients with covid: " << covidPercent << "%"
			      << std::endl;
		std::cout << "Patients with the flu: " << fluPercent << "%"
				  << std::endl;
		std::cout << "Patients with a cold: " << coldPercent << "%"
				  << std::endl;
		std::cout << "Patients with an other illness: " << otherPercent
				  << "%" << std::endl;
		
		return safeExit;
					
	} // end class method
				
	int generateSymptom(int symptom) { // start symptom gen method
						
	//input will be modulo 2 from generateIllness();
						
		bool hasSymptom = false;
	//	std::cout << "Symptom generation is: " << symptom; // DEBUG LINE
						
		switch (symptom) { // start symptom checker
							
			case 0: { // on don't gen symptom
								
				/* hasSymptom set to false at call, and doesn't
				  need additional code. Case added to avoid default
				  case.*/
				break;
								
			} // end case 0
							
			case 1: { // on generate symptom
							
				hasSymptom = true;
				break;
								
			} // end case 1
							
			default: { // on generation error
								
				generationError();
				break;
								
			} // end default case
							
		} // end switch-case statement
						
		return hasSymptom;
						
	} // end class method
				
				
	int generateIllness(int patientTotal, int covidTotal = 0, int fluTotal = 0, int coldTotal = 0, int otherTotal = 0) { // start generation method -- ENTRY POINT
		
		for (int patient = 0; patient < patientTotal; patient++) { // start patient for loop
						
			for (int symptom = 0; symptom < 7; symptom++) { // start symptom for loop
						
				int hasSymptom = (std::rand()) % 2;
						
				switch (symptom) { // start symptom switch case statement
						
					case 0: { // first symptom - fever
							
						fever =  generateSymptom(hasSymptom);
						break;
								
					} // end case 0
							
					case 1: { // second symptom - cough
							
						cough = generateSymptom(hasSymptom);
						break;
								
					} // end case 1
							
					case 2: { // third symptom - short breath
								
						shortBreath = generateSymptom(hasSymptom);
						break;
								
					} // end case 2
							
					case 3: { // forth symptom - runny nose
							
						runnyNose = generateSymptom(hasSymptom);	
						break;
								
					} // end case 3
							
					case 4: { // fifth symptom - headache
							
						headAche = generateSymptom(hasSymptom);
						break;
								
					} // end case 4
							
					case 5: { // sixth symptom -- sneezing
								
						sneezing = generateSymptom(hasSymptom);
						break;
								
					} // end case 5
							
					case 6: { // seventh symptom - fatigue
							
						fatigue = generateSymptom(hasSymptom);
						break;
								
					} // end case 6
							
					default: { // on generation out of range
								
						generationError();
						break;
								
					} // end default case
					
				} // end switch case statement
					
			} // end symptom loop

				// Begin illeness generation
				
				if ((fever) && (cough) && (shortBreath) && (!sneezing)) { // covid check
						
					hasCovid = true;
					covidTotal++;
						
				} else if ((fever) && (cough) && (headAche) && (fatigue) && (!shortBreath) && (!sneezing)) {
						
					hasFlu = true;
					fluTotal++;
						
				} else if ((sneezing) && (runnyNose) && (!shortBreath)) {
						
					hasCold = true;
					coldTotal++;
						
				} else {
						
					hasOther = true;
					otherTotal++;
						
				} // end if-else branch
				
					// end illness generation
					
		} // end patient loop
					
		report(covidTotal, fluTotal, coldTotal, otherTotal, patientTotal);
					
		return safeExit;
	} // end class method

	// Constructor
	
	public:
				
	Patient(int patientsChecked) { // start constructor method
				
		patientTotal = patientsChecked;
		generateIllness(patientTotal);
				
	} // end constructor method
	
	~Patient() {} // destructor
						
}; // end class Patient def
