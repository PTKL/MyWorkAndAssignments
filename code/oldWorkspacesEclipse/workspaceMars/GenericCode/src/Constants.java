/*
  A program to demonstrate constant variables
*\



class Constants
{
 public static void main(String[]args)
 {

  //Constant score values.

  final int TOUCHDOWN = 6;
  final int CONVERSION = 1;
  final int FIELDGOAL = 3;

  //Calculate points scored.  

  int td, pat, fg, total;

  td = 4* TOUCHDOWN;
  pat = 3* CONVERSION;
  fg = 2* FIELDGOAL;
  total = (td + pat + fg);


  //Output calculated total.
  System.out.println("Score: " + total);

 }

}