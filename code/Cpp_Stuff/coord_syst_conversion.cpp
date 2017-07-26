// Program to convert from cartesian to polar

#include <iostream>
#include <cmath>
using namespace std;

double polar(double x, double y){ 
	// Converts 2D Cartesian (x,y) to 2D Polar (r, theta) coordinates
	double r, theta;
	theta = atan(y/x); // Calculating angle w/r to cartesian coord.
	r=sqrt(x*x + y*y); // 2D Pythagoras theorem
	cout << "(" << r << ", " << theta*180/M_PI << ")"; // Prints in format (r,theta)
	return 0;
}

double polar(double x, double y, double z){
	// Converts 3D Cartesian (x,y,z) to 3D Spherical Polar (x, theta, phi) coordinates
	double r, theta, phi;
	r = sqrt(x*x + y*y + z*z); // 3D Pythagoras theorem
	theta = acos(z/r);
	phi = atan(y/x);
	cout << "(" << r << ", " << theta*180/M_PI << ", " << phi*180/M_PI <<")"; // Prints in format (r,theta,phi)
	return 0;
}

double cartesian(double r, double theta){
	// Converts 2D Polar (r, theta) to 2D Cartesian (x, y) coordinates
	double x, y;
	x = r * cos(theta);
	y = r * sin(theta);
	cout << "(" << x << ", " << y << ")"; // Prints in format (x,y)
	return 0;
}

double cartesian(double r, double theta, double phi){ // SPHERICAL 
	// Converts 3D Spherical Polar (r, theta, phi) to 3D Cartesian (x, y, z) coordinates
	double x, y, z;
	x = r * sin(theta) * cos(phi);
	y = r * sin(theta) * sin(phi);
	z = r * cos(theta);
	cout << "(" << x << ", " << y << ", " << z <<")"; // Prints in format (x,y,z)
	return 0;
}

int main(){
	float vector[3], element;
	char choice_conversion; // Polar or Cartesian
	int choice_dimension; // 2D or 3D

	do { // error handling of Dimension choice
		cout << "2D or 3D vector? [type '2' or '3']: ";
		cin >> choice_dimension;
		if ((choice_dimension != 2 and choice_dimension != 3) || cin.fail()){ // if neither 2 nor 3 are written, then write errormessage
			cout << "Dimension not valid. Try again." << endl;
			cin.clear();
			cin.ignore();
		}
	} while ((choice_dimension != 2 and choice_dimension != 3) || cin.fail());
	
	do { // error handling of Coordinate system choice
		cout << "Convert to (p)olar or (c)artesian? [type 'p' or 'c']: ";
		cin >> choice_conversion; // add another choice_cylindrical_or_spherical if time allows
		if ((choice_conversion != 'p' and choice_conversion != 'c') || cin.fail()){
			cout << "Not a valid input. Try again." << endl;
			cin.clear(); // clears the error i.e. returns a goodbit = 0 
			cin.ignore(); // discarding characters from the input
		}
	} while ((choice_conversion != 'p' and choice_conversion != 'c') || cin.fail());
	
	for (int i=1; i<=choice_dimension; i++){ // reads each element of the 2D Vector the user inputs
		if (choice_conversion == 'c' and (i==2 or i==3) ){ // To remind input of angles is in degrees
			cout << "Remember ANGLE in DEGREES" << endl;
		}
		
		cout << "Enter element " << i << ": "; 
		cin >> element;
		while (cin.fail()) { // Error handling
			cout << cin.fail() << "Error: Input a floating point number, please. Try again: ";
			cin.clear(); 
			cin.ignore();
			cin >> element;
		}
		
		vector[i-1] = element;  // store each element in array
	}
	// checks for whether you input certesian coordinates or polar
	if (choice_conversion == 'p'){ // OVERLOADING FUNCTIONS
		// checking 2D or 3D
		if (choice_dimension == 2){
			polar(vector[0], vector[1]); // call function inserting each array element
		}
		else if (choice_dimension == 3){
			polar(vector[0], vector[1], vector[2]);
		}
	}
	else if (choice_conversion == 'c'){ // OVERLOADING FUNCTIONS
		// checking 2D or 3D
		if (choice_dimension == 2){
			cartesian(vector[0], vector[1]*M_PI/180); // convert vector[1] back to radians
		}
		else if (choice_dimension == 3){
			cartesian(vector[0], vector[1]*M_PI/180, vector[2]*M_PI/180);
		}
	}
}
