/** 
 * TuringMachineConsole handles all of the user interface operations.  
 * The console maps various AWT components onto the screen, and manages
 * the buttons.	 The user can click on the buttons and fill out dialog 
 * boxes to send information back to the TuringMachine.	 The information
 * gathered from the Console is used to modify rules, retrieve rules from 
 * a URL, start the machine, and cause the machine to show its rules.  
 *
 * @author	  Tom Briggs
 * @version	  %I%, %G%
 * @see		  TuringMachine
 * @see		  TuringMachineEnvironment
 * @since	  JDK1.1
 */
import java.awt.*;
import java.util.*;
import Environment;

public class Console extends Environment
{
  
  Button      okay, show, input, rules, url,inputtape;	  // buttons
  TextArea    textarea;		   // text window
  Panel	      panel, button;
  Environment     theParent;
  GridBagLayout gridbag = new GridBagLayout();	
  Vector ConsoleBuffer = new Vector();
  int StartRow;

  /**
   * Constructs the Turing machine console.  Creates two panels, one 
   * to hold the text area, and another to hold the various buttons.
   * The overal panel holds only these two panels.
   * The layout manager for the console is GridBag.  This gives greater
   * control over the placement of the widgets on the screen.  Further,
   * the layout manager controls resize events.
   * <P>
   * The console uses AWT 1.1's ActionListener, which is new for AWT.
   * A more versatile version would use the older, deprecated event handler.
   * <P>
   * This event needs to pass strings back and forth other other TM
   * objects.  This is actually the job of the TMEnvironment.  To facilitate
   * this message passing, the TMEnvironment registers itself when it
   * instantiates the TMConsole.
   *
   * @param TuringMachineEnvironment	Pass strings back and forth
   * @see TuringMachineEnvironment
   * @see java.awt.*
   * @see GridBagLayout
   * @see Panel
   * @see Button
   * @see TextArea
   * @see Label
   * @see ActionListener
   * @see constrain
   */

  public Console( Environment E) // Environment parent )
  {

    theParent = E;

    StartRow = 0;

    // setup the gui environment. Since this is applet, 
    // the TMEnvironment is a child of the default display panel.  
    setLayout(gridbag);	 // set the layout manager to be gridbag.
    
    // create a panel to hold a label and text area, and make it a gridbag
    panel = new Panel();
    panel.setLayout(gridbag);

    // create another panel to hold buttons, and make it a gridbag.
    button = new Panel();
    button.setLayout(gridbag);
    
    // create a series of buttons.
    okay = new Button("Start");
    input = new Button("Input Language");
    rules = new Button("Add / Edit Rules");
    url = new Button("Load Rule from URL");
    show = new Button("Show");
    inputtape = new Button("Input Tape");
    
    // create a textarea, which cannot be edited
    // the text area does not send any pertient information,
    //	 so there is no action listener on this item.
    textarea = new TextArea (20,70);
    textarea.setEditable(false);
    
    // constrain setups the information with the layout manager.
    // every object that is going to be controlled as a gridbag
    // needs to be constrained.	 Constrain also adds the item 
    // which makes it visible.	
    // constrain is not part of AWT, but is from 'java in a nutshell'
    // which presented several methods of constrain (all implemented here)
    // which make it very easy to use.
    constrain(panel, new Label("Console Messages"), 0,0,5,1);
    constrain(panel, textarea, 0,1,1,1, GridBagConstraints.BOTH,
	      GridBagConstraints.NORTHWEST, 0.0, 0.0, 10, 10,5,5);
    constrain(button, okay, 0,2,1,1, 
	      GridBagConstraints.NONE, GridBagConstraints.WEST, 
	      0.3, 0.0, 10, 10,5,5);
    constrain(button, show, 1,2,1,1, GridBagConstraints.NONE, 
	      GridBagConstraints.CENTER, 0.3, 0.0, 10, 10,5,5);
    constrain(button, input, 2,2,1,1, GridBagConstraints.NONE, 
	      GridBagConstraints.EAST, 0.3, 0.0, 10, 10,5,5);	
    constrain(button, rules, 3,2,1,1, GridBagConstraints.NONE, 
	      GridBagConstraints.EAST, 0.3, 0.0, 10, 10,5,5);	
    constrain(button, url, 4,2,1,1, GridBagConstraints.NONE, 
	      GridBagConstraints.EAST, 0.3, 0.0, 10, 10,5,5);	
    constrain(button, inputtape, 5,2,1,1, GridBagConstraints.NONE, 
	      GridBagConstraints.EAST, 0.3, 0.0, 10, 10,5,5);	
    
    constrain(this, panel, 0,0,1,1,GridBagConstraints.VERTICAL,
	      GridBagConstraints.NORTHWEST, 0.0,1.0,10,10,5,5);
    constrain(this, button, 0,1,2,1,GridBagConstraints.HORIZONTAL,
	      GridBagConstraints.CENTER,1.0, 0.0, 5,0,0,0);

    

  }

  /**
   * Set the contents of the console buffer, and then set the contents of
   * the text area to the console buffer.
   *
   * @param text	   text to display on the window
   * @see TextArea
   */
  public void SetText(String text)
    {

      //      ConsoleBuffer.removeAllElements();
      ConsoleBuffer.addElement(text);
      
      StartRow++;
      textarea.setText(text);
    }

  /**
   * Append a message to the ConsoleBuffer.  If the buffer is over a set
   * limit, truncate it.  If the buffer is truncated, set the text of the 
   * text area to the contents of the buffer, otherwise, append the text
   * onto the text area.  Note, there is a stepped truncation / overflow
   * in place here, that is, if the buffer goes over a certain size, it 
   * is not truncated back to maximum size, but 1k less.
   *
   * @param text	  text to add to the display
   * @see TextArea
   * @see StringBuffer
   */
  public void SendText(String text)
    {

      if (ConsoleBuffer.size() - StartRow > 150 )
	TrimConsoleBuffer( );

      textarea.appendText(text);
      ConsoleBuffer.addElement(text);

    }
  
  void TrimConsoleBuffer( )
    {
      int loop, start, end;

      String NewConsoleText = new String("");

      end = ConsoleBuffer.size();
      start = StartRow+100;

      for (loop = start; loop < end; loop++)
	{
	  NewConsoleText.concat( (String) ConsoleBuffer.elementAt(loop));
	}
      StartRow = start;
      SetText( NewConsoleText );

    }
      

  /**
   * This is the full version of constrain.  The general idea of this
   * constrain is to create a new GridBag constraint object for the
   * object to be constrained.	Constrains specify information for the
   * layout manager, such as what directions to grow or shrink the item
   * when the window itself is resized, where to place the item, what margin
   * to use around the item, what row and column within the grid to place the
   * item (relative to its size).
   * <P>
   * In addition to creating this meta-information about a container, also
   * create an inset if it is required.	 Finally, constrain the object with
   * the layout manager, and add the item to the display.  This makes the
   * item visible.  
   * <P>
   * NOTE:  the other constrain which are overloaded in this object all
   * eventually call this version of constrain.
   *
   * @param container		  where to add the object
   * @param component		  object to add
   * @param grid_x		  horizontal location in grid
   * @param grid_y		  vertical location in grid
   * @param grid_width		  width of object in grid cells 
   * @param grid_height		  height of object in grid cells
   * @param fill		  directions which object can be resized
   * @param anchor		  where to anchor the component in its cells
   * @param weight_x		  weight given to object on horizontal resize
   *				  <code>0</code>no resize,
   *				  <code>1.0</code>max weight resize,
   *				  all other values in ratio.
   * @param weight_y		  weight given to object on vertical resize
   * @param top			  top margin
   * @param left		  left margin
   * @param bottom		  bottom margin
   * @param right		  right margin
   * @see GridBagConstraints
   */

  public void constrain(Container container, Component component,
			int grid_x, int grid_y, int grid_width, 
			int grid_height, int fill, int anchor, 
			double weight_x, double weight_y,
			int top, int left, int bottom, int right)
    {
      // Create a new constraint object
      GridBagConstraints c = new GridBagConstraints();
      
      // Copy variables from call into new constraint object
      c.gridx = grid_x;
      c.gridy = grid_y;
      c.gridwidth = grid_width;
      c.gridheight = grid_height;
      c.fill = fill;
      c.anchor = anchor;
      c.weightx = weight_x;
      c.weighty = weight_y;
      
      // Determine if an insent needs to be created.  
      // Insets determine the top, bottom, left, and right margins
      // of an object.	Value is in pixels.
      if (top + bottom + left + right > 0)
	c.insets = new Insets(top, left, bottom, right);
      
      // The following expression is:
      // method: get the layout manager instanciated with the given container,
      // typecast: typecast it as a GridBagLayout(compile/abort if cannot)
      // method: GridBagLayout.setContraints to associate layout info with
      //	      a given component.
      // Add the component to the container with new layouts
      
      ((GridBagLayout)container.getLayout()).setConstraints(component,c);
      container.add(component);
      
    }
  
  /**
   * overloaded constrain which only gives x,y,width,and height options 
   *
   * @param container		  where to add the object
   * @param component		  object to add
   * @param grid_x		  horizontal location in grid
   * @param grid_y		  vertical location in grid
   * @param grid_width		  width of object in grid cells 
   * @param grid_height		  height of object in grid cells
   * @see constrain
   * @see GridBagConstraints
   */

  public void constrain (Container container, Component component,
			 int grid_x, int grid_y, int grid_width, 
			 int grid_height)
    {
      constrain(container, component, grid_x, grid_y, grid_width, grid_height,
		GridBagConstraints.NONE,
		GridBagConstraints.NORTHWEST,
		0.0, 0.0, 0,0,0,0);
      
    }

  /**
   * constrain a component that doesn't grow.
   *
   * @param container		  where to add the object
   * @param component		  object to add
   * @param grid_x		  horizontal location in grid
   * @param grid_y		  vertical location in grid
   * @param grid_width		  width of object in grid cells 
   * @param grid_height		  height of object in grid cells
   * @param fill		  directions which object can be resized
   * @param anchor		  where to anchor the component in its cells
   * @param weight_x		  weight given to object on horizontal resize
   */

  public void constrain (Container container, Component component,
			 int grid_x, int grid_y, int grid_width, 
			 int grid_height,
			 int top, int left, int bottom, int right) 
    {
      constrain(container,component, grid_x, grid_y,
		grid_width, grid_height, GridBagConstraints.NONE,
		GridBagConstraints.NORTHWEST,
		0.0, 0.0, top, left, bottom, right);
    }
  
  /**
   * handle an action event (button click, etc)
   *
   * @param event
   * @deprecated
   * @see actionEvent
   */

 public boolean action (Event event, Object arg)
    {

      if (event.target == show) {
	  theParent.Show();
      }
      else if (event.target == okay) {
	  theParent.Run();  // start the TM running
      }
      else if (event.target == input) {
	  createDialog("Tape Language: ",  
		       "Enter the Tape Languaage: ", 0);
      }
      else if (event.target == url) {
	  createDialog("Load Rule Table through URL",
		     "Enter a URL to the rule table: ", 3);
	  theParent.LoadRuleURL();
      }
      else if (event.target == rules)
	{
	  Frame f = new Frame("Add Rules Dialog");
	  AddRuleDialog addDialog =
	    new AddRuleDialog(theParent, f,"Add New TM Rules", true,
			      theParent.getString(0), theParent.getString(0));
	  addDialog.show();
	}
      else if (event.target == inputtape)
	{
	  createDialog("Input Tape", "Enter the Input Tape: ", 2);
	}
      else {
	  return false;
      }
      return true;
    }

  /**
   * Create a diloag box with a title, a prompt, and which TM string to 
   * modify;  0 = input language, 1 = not used, 2 = input tape, 3 = URL
   *
   * @param Title	   title of the dialog box
   * @param Prompt	   prompt to give users
   * @param which	   which string to get and send back to TM
   */

  public void createDialog(String Title, String Prompt, int Which)
    {
      Frame f = new Frame(Title);

      System.out.println("createDialog\n");

      AddLanguageDialog d = 
	new AddLanguageDialog(theParent, f, Title, true, 
			      theParent.getString(Which), 
			      Prompt, Which);
      d.show();
    }

} // End Console Task


/**
 * create a dialog box to accept rules from the user.
 * the rule editor will replace an existing rule or add a new one
 * using the criteria described for TMRuleTable.FindRule.
 * AddRuleDialog creates a modal pop-up dialog box, which have
 * several buttons, labels, and choice fields.
 * The rule dialog sends the rule to be added to the Environment,
 * which in turn sends it to the Rule table.
 *
 * @author	 Tom Briggs
 */

class AddRuleDialog extends Dialog
{
  Environment E;
  TextField ruleField, nextField;     // Text entry fields
  Choice readChoice, writeChoice, directionChoice; // Choice fields
  Button okay, cancel, exit;   // some nice buttons
  Label label, ruleP, readP,writeP,nextP,directP;  // some prompts
  Panel Top, Middle, Bottom;  // panels to hold everything together
  GridBagLayout G;   // GridBag Layout Manager 
  GridBagConstraints GC;  // GridBag Constraints
  int LoopIndex;   // a loop index
  char ch;   // hold a misc. character
  String str = new String();   // Misc. string 
  
  /** 
   * construct and instantiate an AddRuleDialog box
   *
   * @param f		  parent frame to map itself into
   * @param title	  title of dialog
   * @param modal	  modality of this box
   * @param InputLanguage Input alphabet
   * @param TapeLanguage  Tape alphabet
   */
  
  AddRuleDialog(Environment Env , Frame f, String title, 
		boolean modal, String InputLanguage, 
		String TapeLanguage )
    {
      // send the frame constructor messsage
      super(f,title,modal);

      E = Env;
      
      G = new GridBagLayout();	// create a new gridbag
      
      this.setLayout(G);  // make it the layoutmanager
      
      Top = new Panel();  // create 3 panels
      Middle = new Panel();
      Bottom = new Panel();
      
      Top.setLayout(new GridLayout(1,1,15,15));	  // set their layouts
      Middle.setLayout(new GridLayout(6,2,15,15));
      Bottom.setLayout(new GridLayout(1,5,15,15));
      
      // make the labels and inputs
      label = new Label("Enter new rules");
      Top.add(label);
      
      ruleP = new Label("Rule number: ");
      ruleField = new TextField(2);
      Middle.add(ruleP);
      Middle.add(ruleField);
      
      readP = new Label("Input Character: ");
      readChoice = new Choice();
      
      // because Read Choice is a string, and the ChoiceField wants an
      // an array, loop across the string, pick out the chars, and 
      // build the choice field
      readChoice.addItem(" ");
      for (LoopIndex = 0; LoopIndex < InputLanguage.length(); LoopIndex++)
	{
	  ch = InputLanguage.charAt(LoopIndex);
	  str = "";
	  str = str + ch;
	  readChoice.addItem(str);
	}
      
      Middle.add(readP);
      Middle.add(readChoice);
      
      writeP = new Label("Write Character: ");
      writeChoice = new Choice();
      writeChoice.addItem(" ");
      for (LoopIndex = 0; LoopIndex < TapeLanguage.length(); LoopIndex++)
	{
	  ch = TapeLanguage.charAt(LoopIndex);
	  str = ""; 
	  str = str + ch;
	  writeChoice.addItem(str);
	}
      
      Middle.add(writeP);
      Middle.add(writeChoice);
      
      nextP = new Label("Next Rule: ");
      nextField = new TextField(2);
      Middle.add(nextP);
      Middle.add(nextField);
      
      directP = new Label("Direction: ");
      
      directionChoice = new Choice();
      directionChoice.addItem("Right");
      directionChoice.addItem("Left");
      directionChoice.select("Right");
      Middle.add(directP);
      Middle.add(directionChoice);
      
      
      // Add some buttons
      okay = new Button("Okay");
      Bottom.add( okay);
      
      cancel = new Button("Cancel");
      Bottom.add( cancel);
      
      exit = new Button("Exit");
      Bottom.add(exit);
      
      // Create constraint information
      GC = new GridBagConstraints();
      GC.gridx = 1;
      GC.gridy = 1;
      GC.gridwidth=100;
      GC.gridheight=1;
      GC.fill=GridBagConstraints.NONE;
      GC.ipadx = 10;
      GC.ipady = 10;
      GC.anchor= GridBagConstraints.NORTHWEST;
      GC.weightx = 0.0;
      GC.weighty = 0.0;
      
      G.setConstraints(Top,GC);
      this.add(Top);
      
      GC.gridy = 2;
      GC.gridheight= 6;
      GC.gridwidth = 100;
      GC.anchor = GridBagConstraints.CENTER;
      G.setConstraints(Middle,GC);
      this.add(Middle);
      
      GC.gridy = 9;
      GC.gridwidth = 100;
      GC.gridheight = 1;
      GC.anchor = GridBagConstraints.SOUTH;
      G.setConstraints(Bottom,GC);
      
      // Add and pack the manager 
      this.add(Bottom);
      this.pack();
      
    }
  
  public boolean action(Event event, Object arg)
    {
      String Rule, Read, Write, Next, Direction;
      
      if (event.target == exit) 
	{
	  this.hide();
	  this.dispose();
	}
      else if (event.target == okay)
	{ 
	  Rule = new String();
	  Read = new String();
	  Write = new String();
	  Next = new String();
	  Direction = new String();
	  
	  Rule = ruleField.getText();
	  Read = readChoice.getSelectedItem();
	  Write = writeChoice.getSelectedItem();
	  Next = nextField.getText();
	  Direction = directionChoice.getSelectedItem();
	  
	  
	  ruleField.setText("");
	  nextField.setText("");
	  
	  if (Direction == "Right") Direction = "R";
	  else if (Direction == "Left") Direction = "L";
	  else Direction = "-";
	  
	  E.SendRule(Rule, Read, Write, Direction, Next);
	  
	} // end if okay
      else {
	return false;
      }

      return true;

    } // end Action event 
  
} // end Class AddRuleDialog

class AddLanguageDialog extends Dialog
{
  Environment E;
  TextField LangField;
  Button okay, cancel, exit;
  Label label, langP;
  Panel Top, Middle, Bottom;
  GridBagLayout G;
  GridBagConstraints GC;
  String Language;
  int Which;
  
  AddLanguageDialog(Environment Env, Frame f, String title, 
		    boolean modal, String theLanguage, 
		    String LabelText, int which )
    {
      
      super(f,title,modal);

      System.out.println("AddLanguagedialog");

      E = Env;

      Language = theLanguage;
      Which = which;
      
      G = new GridBagLayout();
      
      this.setLayout(G);
      
      Top = new Panel();
      Middle = new Panel();
      Bottom = new Panel();
      
      Top.setLayout(new GridLayout(1,1,15,15));
      Middle.setLayout(new GridLayout(1,8,10,10));
      Bottom.setLayout(new GridLayout(1,5,15,15));
      
      label = new Label(LabelText);
      Top.add(label);
      
      // langP - P = Prompt //
      langP = new Label("Enter Language: ");
      if (which == 3)
	LangField = new TextField(40);
      else 
	LangField = new TextField(10);
      LangField.setText(Language);
      
      
      Middle.add(langP);
      Middle.add(LangField);
      
      okay = new Button("Okay");
      Bottom.add( okay);
      
      cancel = new Button("Cancel");
      Bottom.add( cancel);
      
      exit = new Button("Exit");
      Bottom.add(exit);
      
      GC = new GridBagConstraints();
      GC.gridx = 1;
      GC.gridy = 1;
      GC.gridwidth=1;
      GC.gridheight=1;
      GC.fill=GridBagConstraints.NONE;
      GC.ipadx = 10;
      GC.ipady = 10;
      GC.anchor= GridBagConstraints.NORTHWEST;
      GC.weightx = 0.0;
      GC.weighty = 0.0;
      
      G.setConstraints(Top,GC);
      this.add(Top);
      
      GC.gridy = 1;
      GC.gridheight= 1;
      GC.gridwidth = 2;
      GC.anchor = GridBagConstraints.CENTER;
      G.setConstraints(Middle,GC);
      this.add(Middle);
      
      GC.gridy = 6;
      GC.gridwidth = 1;
      GC.gridheight = 1;
      GC.anchor = GridBagConstraints.SOUTH;
      G.setConstraints(Bottom,GC);
      this.add(Bottom);
      
      this.pack();
      
    }
  
  public boolean action (Event event, Object arg)
    {

      if (event.target == exit) 
	{
	  this.hide();
	  this.dispose();
	}
      else if (event.target == cancel)
	{
	  LangField.setText(Language);
	}
      else if (event.target == okay)
	{ 
	  E.sendString( LangField.getText(), Which );
	  
	  this.hide();
	  this.dispose();
	  
	} // end if 
      else {
	return false;
      }

      return true;

    } // end ActionPerformed
  
} // end Language Dialog







