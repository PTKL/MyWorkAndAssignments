import java.applet.*;  // Imports the applet class widgets, required
import java.awt.*;     // Imports the Graphics AWT widgets
import java.util.*;    // Imports the Java UTIL widgets
import java.lang.*;
import java.net.*;
import java.io.*;
import Console;
import RuleTable;
import Machine;

/**
 * TuringMachineEnvironment is the super class for all of the Turing Machine objects.
 * The environment extends Applet, creates and maps a console onto the window,
 * creates a TuringMachine RuleTable, collects information from the user to begin
 * a TuringMachine, steps through the TuringMachine, and brokers information from all
 * of the objects.
 *
 * @author           Tom Briggs
 * @version          %I%, %G%
 * @since            JDK1.1
 */

public class Environment extends Applet
{

  Console theConsole;
  RuleTable theRuleTable;
  String theRuleURL;
  String InputLanguage, TapeLanguage, InputTape;

  public  void init()
  {
    
    // Initialize the global variables
    theRuleURL = new String("http://www.ship.edu/~thb/TuringMachine/tm-test.txt");
    InputLanguage = new String(" ");
    TapeLanguage = new String(" ");
    InputTape = new String("");

    // Create the rule table
    theRuleTable = new RuleTable(); 

    // Create the console
    theConsole = new Console(this);
    add(theConsole);	

    // Send a message to the console
    theConsole.SetText("\n\nTuring Machine version 1.0 \n\n");
    theConsole.SendText("  -- By: Tom Briggs, (c) 1998, all rights reserved\n");

  }

  /**
   * Accept a manually entered rule from the user interface and send it to the rule table.
   * 
   * @param reqRule          the current rule
   * @param reqReadChar      the character read
   * @param reqWritechar     the character to write
   * @param reqDirection     the direction to move the tape
   * @param reqNextRule      the next rule
   */

  public void SendRule(String reqRule, String reqReadChar,
		       String reqWriteChar, String reqDirection,
		       String reqNextRule)
    {
      int theRule;
      char theReadChar,theWriteChar,theDirection;
      int theNextRule;
      Integer x,y;

      x = new Integer(reqRule);
      theRule = x.intValue();
      theReadChar = reqReadChar.charAt(0);
      theWriteChar = reqWriteChar.charAt(0);
      theDirection = reqDirection.charAt(0);
      y = new Integer(reqNextRule);
      theNextRule = y.intValue();

      theRuleTable.AddRule(theRule,theReadChar,theWriteChar,theDirection,theNextRule);
      
    }


  /**
   * LoaddRuleURL reads a URL from a remote URL and loads the URL table with them.
   * Destroys the existing URL table!
   *
   * @param UR        URL to load
   */

  public void LoadRuleURL(  )
    {
      URL RuleFile;
      int c, state;
      boolean done;
      String text;
      int  current, next;
      char read, write, direction;

      theRuleTable.Clear();
      
      try {

	RuleFile = new URL (theRuleURL);

	Object content = RuleFile.getContent();

	InputStream in = RuleFile.openStream();
	StreamTokenizer tokenizer= new StreamTokenizer(in);
	

	/* setup tokenizer parameters */
	tokenizer.ordinaryChars(5,50);
	tokenizer.whitespaceChars(44,44);
	tokenizer.eolIsSignificant(false);
	tokenizer.slashSlashComments(true);
	tokenizer.parseNumbers();

	// Initialize some values
	current = 0;
	read = ' ';
	write = ' ';
	direction = ' ';
	next = 0;

	done = false;
	state = 0;
	while (!done)
	  {
	    c = tokenizer.nextToken();

	    if (c == StreamTokenizer.TT_EOL) {
	      ; 
	    }
	    else if (c == StreamTokenizer.TT_EOF) {
	      done = true;
	    }
	    else {
	      switch (state)
		{
		case 0:
		  current = (int) tokenizer.nval;
		  state = 1;
		  break;
		case 1:
		  text = tokenizer.sval;
		  if (text == null) read = ' ';
		  else read = text.charAt(0);
		  state = 2;
		  break;
		case 2:
		  text = tokenizer.sval;
		  if (text == null) write = ' ';
		  else write = text.charAt(0);
		  state = 3;
		  break;
		case 3:
		  text = tokenizer.sval;
		  if (text == null) direction = ' ';
		  else direction = text.charAt(0);
		  state = 4;
		  break;
		case 4:
		  next = (int)tokenizer.nval;
		  state = 0;
		  //try {
		    theRuleTable.AddRule( current, read, write, direction, next);
		    //}
		    //catch (TuringRuleException e) {
		    //Console.SendText("Rulefile has error on " + tokenizer.lineno() + ", ignoring.\n");
		    //Console.SendText("Error message is: " + e.getMessage() + "\n");
		    //}

		  current = 0; next = 0;
		  read = ' '; write = ' '; direction = ' ';
		  break;
		}

	    } // end if 
	  } // end while
      } // end try
      catch (MalformedURLException e)
	{
	  theConsole.SendText("URL is invalid: " + theRuleURL + "\n");
	  e.printStackTrace();

	}
      catch (IOException e)
	{
	  theConsole.SendText("IO Exception Caught!!\n");
	  e.printStackTrace();
	}

    } // end Load Rules file

  /**
   * Show the state of the machine.  This is normally invoked from the user interface. 
   *
   */
  public void Show()
    {
      String strRuleState;

      
      strRuleState = new String( theRuleTable.toString() );
      
      // send string back to console
      theConsole.SendText(strRuleState);

    }

  public void Run()
    {
      Machine TM = new Machine(this, theRuleTable, InputTape );
      new Thread(TM).start();
    }

  /**
   * user interface sends a string to update a global string
   *
   * @param value      value to set global variable to
   * @param WhichOne   which global variable to set
   */
  
   public void sendString( String value, int WhichOne )
    {

      switch (WhichOne)
	{
	case 0:
	  InputLanguage = value;
	  break;
	case 1:
	  TapeLanguage = value;
	  break;
	case 2:
	  InputTape = value;
	  break;
	case 3:
	  theRuleURL = value;
	  break;
	}
    }

    /**
     * user interface requests a global variables value
     *
     * @param WhichOne          which global variable to send
     * @return String
     */
 
  public String getString( int WhichOne )
    {
      String value;

      switch(WhichOne)
	{
	case 0:
	  value = InputLanguage;
	  break;
	case 1:
	  value = TapeLanguage;
	  break;
	case 2:
	  value = InputTape;
	  break;
	case 3:
	  value = theRuleURL;
	  break;
	default:
	  value = new String("error!");
	}
      return value;
    }

  public void sendConsole(String message)
    {
      theConsole.SendText(message);
    }



} // End Turing Machine Environment
