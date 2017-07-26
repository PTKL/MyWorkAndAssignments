//package TuringMachine;

import java.applet.*;  // Imports the applet class widgets, required
import java.awt.*;     // Imports the Graphics AWT widgets
import java.util.*;    // Imports the Java UTIL widgets
import java.lang.*;
import java.net.*;
import java.io.*;
import Environment;
import RuleTable;

public class Machine implements Runnable
{
  boolean Running;
  String InputTape;
  Environment theParent;
  RuleTable RuleTable;

  public Machine(Environment reqParent, 
		       RuleTable reqRuleTable,
		       String reqInputTape)
    {
      Running = false;
      theParent = reqParent;
      InputTape = reqInputTape;
      RuleTable = reqRuleTable;
    }

  public void run( )
    {
      int CurrentRule = 1;
      int TapeHead = 0;
      int LoopIndex;
      int Row;
      StringBuffer WorkSpace;
      char TapeChar;
      StringBuffer ConsoleText;

      WorkSpace = new StringBuffer(InputTape.toString());

      Running = true;

      ConsoleText = new StringBuffer(" Start \n");

      while (Running) 
	{

	  if (TapeHead < 0) {
	    theParent.sendConsole("CRASH! at Rule " + CurrentRule + "tape head cannot move past beginning\n");
	    Running = false;
	    continue;
	  }

	  while (TapeHead >= WorkSpace.length())
	      WorkSpace.append("        ");


	  /* Get the input character */
	  TapeChar = WorkSpace.charAt(TapeHead);

	  
	  /* Get the rule */
	  Row = RuleTable.FindRule( CurrentRule, TapeChar);

	  if (Row < 0) {
	    theParent.sendConsole("CRASH! at Rule " + CurrentRule + " tape head at: " + 
			TapeHead + "char: " + TapeChar + "\n");
	    Running = false;
	  }

	  /* Write the character */

	  TapeChar = RuleTable.getWriteChar( Row );
	  WorkSpace.setCharAt(TapeHead, TapeChar);
	  
	  /* move the tape head */
	  if (RuleTable.getDirection(Row) == 'R') TapeHead++;
	  else TapeHead--;
	  
	  /* go to the rule */
	  CurrentRule = RuleTable.getNextRule( Row );

	  if (CurrentRule <= 0) {
	    Running = false;
	    continue;
	  }
	  

	  /* Ouput the Running of the machine */
	  {

	    StringBuffer OutputSpace = new StringBuffer(WorkSpace.toString());
	    String RuleText;

	    RuleText = new String("rule(" + CurrentRule + ") ");
	    OutputSpace.append("\n");
	    OutputSpace.setLength(WorkSpace.length() + RuleText.length() + 3);

	    OutputSpace.insert(0, RuleText);
	    OutputSpace.insert(TapeHead + RuleText.length(),'<');
	    OutputSpace.insert(TapeHead + RuleText.length() + 2,'>');
	    
	    theParent.sendConsole(OutputSpace.toString());

	  }

	} // end While 

      if (CurrentRule == 0) theParent.sendConsole("ACCEPT!!\n");
      else theParent.sendConsole("CRASH! STATE ENTERED!\n");


    }



} // End Turing Machine
