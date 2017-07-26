/* Program to calculate the inverse of a 3x3 matrix. Not completed yet. I only have the first step
 * which consists of taking the adjoint of each element in the matrix. This returns a 2x2 matrix, which I decided to 
 * display on terminal element by element in the order 00, 01, 10, 11, where 	00 01
 * 																				10 11

TERMINAL OUTPUT:
8
4
7
6
______
1
4
2
6
______
1
8
2
7
______
7
3
7
6
______
5
3
2
6
______
5
7
2
7
______
7
3
8
4
______
5
3
1
4
______
5
7
1
8
______

*/


#include <iostream>
using namespace std;

// IMP: improve all by using references and/or pointers and passing by ref or by pointers

int det(int matrix[3][3]){ // Need to make an algorithm for this 
	// http://www.cplusplus.com/forum/beginner/143538/
	// http://stackoverflow.com/questions/8767166/passing-a-2d-array-to-a-c-function
	// divide and conquer: http://stackoverflow.com/questions/21220504/matrix-determinant-algorithm-c
	int determinant;
	determinant = matrix[0][0]*matrix[1][1]*matrix[2][2] + matrix[1][0]*matrix[2][1]*matrix[0][2] + matrix[0][1]*matrix[1][2]*matrix[2][0] - (matrix[0][2]*matrix[1][1]*matrix[2][0] + matrix[0][0]*matrix[2][1]*matrix[1][2] + matrix[1][0]*matrix[0][1]*matrix[2][2]);
	return determinant;
}

void inv(int matrix[3][3], int det_matrix){
	// To calculate the inverse you need to go over all x* and y* 
	//    x1 x2 x3
	// y1 00 01 02 
	// y2 10 11 12
	// y3 20 21 22
	// Take 00 for example: split zeros and name each 'column' and 'row'.
	// The x and y's are needed to switch from one adjoint to the other.
	int adjoint[3][3];
	for (int y_coord = 0; y_coord <= 2 ; y_coord++){ // Switching to next y coordinate (see above representation of a 3d matrix)
		for (int x_coord = 0; x_coord <= 2 ; x_coord++){ // Switching to next x coordinate (see above rep. of a 3d matrix)
			for (int column = 0; column <= 2 ; column++){ // Now we select each 'column' and 'row' in order to check whether the next element is 
				for (int row = 0; row <= 2; row++){ 	  // in the same row or the same column. In which case we don't add it to 'adjoint' matrix.
					if (row != x_coord and column != y_coord){ // Only when the coordinates are different than the column or the row we add to 'adjoint' 
						adjoint[column][row] = matrix[column][row]; // We transfer elements to the adjoint matrix.
						cout << adjoint[column][row] << endl;
					} // If you got lost at some point and you don't understand, go to line 79.
				}
			}cout << "______" << endl;
		}	
	}
} // Keep trying: go to line 1.


int main(){
	int det_matrix;
	int matrix[3][3] = 
	{
	{5, 7, 3},
	{1, 8, 4},
	{2, 7, 6}	
	};
	
	det_matrix = det(matrix); // = 87
	inv(matrix, det_matrix);
}
