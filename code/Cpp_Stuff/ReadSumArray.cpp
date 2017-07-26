#include <iostream>
#include <fstream>
#include <string>
#include <sstream> // stringstream for conversion str to float
using namespace std;

double sum(double number){ // sums all elements
	double sum;
	sum += number;
	return sum;
}

double mean(double total, int lines){ // calculates mean
	double mean;
	mean = total/lines;
	cout << mean << endl;
	return mean;
}

double stdev(double number, double avg){ // calculates standard deviation
	double stdev = 0; 
	stdev = (number - avg)*(number - avg); // pow didn't work, idk why
	cout << stdev << endl;
	return stdev;
}

int neg(double number, int negs){ // calculates how many negative values
	if (number<0){
		negs += 1;
	}	
	return negs;
}

int main(){
	double array [37] = {}, bigger, smaller;
	float sum_tot=0, avg=0;
	int line_counter = 0, negs = 0;
	// OPENING FILE
	string filecontents;
	ifstream myFile("/home/emil/Cpp_Stuffsimpledata.txt");
	if (myFile.is_open()){
		// READING FILE
		while (getline(myFile,filecontents)){
			stringstream convert(filecontents); // String to Float
			double data;
			while(convert >> data){ // Storing into an array
				array [line_counter] = data;
				line_counter += 1;
			}
		}
		myFile.close(); // Closing file
	}
	else{
		cout << "Unable to open file" << endl;
	}
	// Sending each array element to the function
	for (int i=0; i<line_counter; i++){
		sum_tot = sum(array[i]);
	}
	
	cout << "SUM: " << sum_tot << endl;
	cout << "MEAN: ";
	avg = mean(sum_tot, line_counter);
	
	cout << "\nSTANDARD DEVIATION\n" << endl;
	for (int i=0; i<line_counter; i++){
		stdev(array[i], avg);
	}
	
	for (int i=0; i<line_counter; i++){
		negs = neg(array[i], negs);
	}
	cout << "\nTotal negative numbers: " << negs << endl;
	
	bigger = max(array[0],array[1]); // Initiating comparison
	smaller = min(array[0],array[1]);
	for (int i=0; i<line_counter; i++){ // after that compares next term
		bigger = max(bigger, array[i+1]);
		smaller = min(smaller,array[i+1]);
	}
	cout << "MAX value: " << bigger << endl;
	cout << "MIN value: " << smaller << endl;
}
