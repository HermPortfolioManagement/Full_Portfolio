#include "menu.h"
#include "SEC.h"

/*
	Opening screen should ask if you want to run tests, or see the guide
	
		GUIDE SCREEN SHOULD LOOK LIKE
		
	Guide:
	=============================================
				Sometimes +		Common *	NO -|
	=============================================
	symptoms			  Covid	   Flu	   Cold |
	=============================================
	Fever				|	*	|	*	|	+	|
	Cough				|	*	|	*	|	+	|
	Shortness of Breath |	*	|	-	|	-	|
	Runny Nose			|	+	|	+	|	*	|
	Headaches			|	+	|	*	|	+	|
	Sneezing			|	-	|	-	|	*	|
	Fatigue				|	+	|	*	|	+	|
	=============================================
	
	guide should cycle back into menu
*/

int main() {
	forceChange();
	menu();
	return safeExit;
}
