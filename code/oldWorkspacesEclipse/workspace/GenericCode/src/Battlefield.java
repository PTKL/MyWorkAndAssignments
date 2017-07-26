/**
* @author Emil Zahariev <Emil.Zahariev2013@live.rhul.ac.uk>
* @since  2013-03-18
* @param 	battlefieldArray creating the 3D array to be used
*/
public class Battlefield {
	int[][][] battlefieldArray;
	/* Constructor that initializes the value of the 3D array. 
	* <p>
	* The objective of this constructor is to initialize a 3D array with pre-assigned  	
	* values. It assigns the values to the X axis, Y axis and Z axis.
	* <p>
	* @param battlefieldArray creating and initializing the array with values that are predetermened. 
	* @param yCoord this expresess the Y axis of the battlefield.
	* @param xCoord this expresess the X axis of the battlefield.
	* @param zCoord this expresess the Z axis of the battlefield.
	*/
	public Battlefield() {
		battlefieldArray = new int[5][5][5];
		int yCoord, xCoord, zCoord;
		for (yCoord = 0; yCoord < battlefieldArray.length; yCoord++) {
			battlefieldArray[yCoord] = new int[5][5];
			for (zCoord = 0; zCoord < battlefieldArray.length; zCoord++) {
				battlefieldArray[yCoord][zCoord] = new int[5];
				for (xCoord = 0; xCoord < battlefieldArray.length; xCoord++) {
					battlefieldArray[yCoord][zCoord][xCoord] = 0;
				}
			}
		}
	}
	/*
	* The goal of this method is to display the battlefield in the terminal when the application is executed.
	*/ 
	public void printBattlefield() {
		int yCoord, xCoord, zCoord;
		System.out.print("     ");
		for (zCoord = 0; zCoord < battlefieldArray.length; zCoord++)
			System.out.print("Z=" + zCoord + "        ");
		System.out.print("\n\n");
		for (yCoord = 0; yCoord < battlefieldArray.length; yCoord++) {
			System.out.print("Y=" + yCoord + " ");
			for (zCoord = 0; zCoord < battlefieldArray.length; zCoord++) {
				System.out.print(" ");
				for (xCoord = 0; xCoord < battlefieldArray.length; xCoord++)
					System.out.print(battlefieldArray[yCoord][zCoord][xCoord] + " ");
			}
			System.out.println();
		}
		System.out.print("\n");
		for (xCoord = 0; xCoord < battlefieldArray.length; xCoord++) {
			System.out.print(" " + "xCoord=0");
			for (int count = 1; count < battlefieldArray.length; count++) {
				System.out.print(" ");
				System.out.print(count);
			}

		}
	}
	/*
	* Useing this method we can create the battlefield with all the parameters and arguments that were used in the constructor.
	*/
	public static void main(String[] args) {
		Battlefield battlefield = new Battlefield();
		battlefield.printBattlefield();
	}

}
