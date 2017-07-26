import java.util.Scanner;

enum DiskType {small, medium, large};

class TowerGame {
   
    // Initialization and set up   
    static DiskType[] arrPeg1 = new DiskType[]{DiskType.large, DiskType.medium, DiskType.small};
    static DiskType[] arrPeg2 = new DiskType[]{null, null, null};
    static DiskType[] arrPeg3 = new DiskType[]{null, null, null};  

public static void main(String [] args){   
    int playDisks = 0;        
    boolean move1 = true;
    Scanner  fromInput = new Scanner(System.in);    

    while(!isSolved())
    {
      printTower();

      int StartPeg = 1;

      if (move1)
     {
       move1 = false;
     } else
     {
      System.out.println("Please, pick a peg to move a disk from.");
      StartPeg = fromInput.nextInt();
     }
      
    System.out.println("Please, pick a peg to move the disk to.");
    int EndPeg = fromInput.nextInt();

    // Check if StartPeg and EndPeg are valid values (between 1 and 3)


    // Need to check that the start peg contains a disk that is SMALLER
    // than that on the destination peg

    DiskType d1 = getPegLastDisk(StartPeg);
    DiskType d2 = getPegLastDisk(EndPeg);

    if (IsDisc1Bigger(d1, d2))
    {
    // User can't make that move
        System.out.println("The peg has a smaller disk. Move invalid.");
    } else
    {
       moveDisk(StartPeg, EndPeg);
      
    }
    
    }

    
  }

  public static void moveDisk(int s, int e)
  {
     // Move last disk from start peg (s) to end destination peg (e)          
     
  }



  public static void  movingDisks(int disksMoving,int from,int to){
    if(disksMoving == 1){
      System.out.println("Moving the disks from " + from + " to " + to );
      printTower();

    }else{
      int other = (6-(from + to));
      movingDisks(disksMoving - 1, from, other);
      movingDisks(1, from, to);
      movingDisks(disksMoving -1, other, to);
    }   
  }

public static boolean isSolved()
  // Check PEG3 to see if it meets the criteria for a solved game
  {
    // To solve the problem, two conditions must be present
    // peg three has three discs
    // peg three disls are in the order of 1x large, 1x medium, 1x small
    boolean c1 = (arrPeg3.length == 3); // First essential condition
    boolean c2 =  (arrPeg3[0] == DiskType.large)
               && (arrPeg3[1] == DiskType.medium)
               && (arrPeg3[2] == DiskType.small); // Second essential condition
              
    return c1 && c2;
  }

  public static boolean IsDisc1Bigger(DiskType d1, DiskType d2)
{
  if (d1 == null) return false;
  if (d2 == null) return false;
  // Get ordinal (the position of the enum in it's enumeration)
  // Ordinal is the integer value of the enum member
  return (d1.ordinal() > d2.ordinal());
}

  public static DiskType getPegLastDisk(int pegNumber)
  // takes a peg as a parameter then checks the corrosponding array 
  // to return the last disk type otherwise returns null
  {
    DiskType r = null;
    switch (pegNumber)
    {
      case 1:
          r = arrPeg1[arrPeg1.length - 1];
      break;
      case 2:
          r = arrPeg2[arrPeg2.length - 1];
      break;
      case 3:
          r = arrPeg3[arrPeg3.length - 1];
      break;
    }

    return r;
  }

  public static String DiskToStr(DiskType aDisk)
  // Convert PEG enum type to String for stdout
  {
    String r = "";
    if (aDisk == null) return "";

    switch(aDisk)
    {
      case small: r= ".";
      break;
      case medium: r= ":";
      break;
      case large: r= "|";
      break;
    }
    return r;
  }

  public static void printTower()
  { // This method will print the Towers

   System.out.print("PEG1=");
   for (int i=0; i < arrPeg1.length;i++)
   {
      System.out.print(DiskToStr(arrPeg1[i]));
   }
   System.out.println("");

   System.out.print("PEG2=");   
   for (int i=0; i < arrPeg2.length;i++)
   {
      DiskToStr(arrPeg2[i]);
   }
   System.out.println("");

   System.out.print("PEG3=");   
   for (int i=0; i < arrPeg3.length;i++)
   {
      DiskToStr(arrPeg3[i]);
   }
   System.out.println("");

  }

}
