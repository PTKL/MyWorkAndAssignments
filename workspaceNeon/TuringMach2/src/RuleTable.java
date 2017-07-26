/**
 *  <B>TuringRuleTable</B> is a class which holds a list of rules for a 
 *  TuringMachine.  This class develops a Vector of "Rule" objects.
 *  TuringRule objects are defined as 5-tuples of
 *  <UL>
 *  <LI>Current state
 *  <LI>Character which must be read at tape head
 *  <LI>Character which will be written at the tape head
 *  <LI>Direction to move the tape head
 *  <LI>Next state to enter
 *  </UL>
 *  <P>
 *  TuringRuleTable supports concepts such as adding rules, deleting rules,
 *  iterating rules, and searching rules.  
 *  <P>
 *  Import note: The first two tuples must be unique across the set of all
 *  rules.  For example, if there is a rule such as 1,a,..., there cannot
 *  be another rule of 1,a,...,.  Adding a rule with the same first two tuples
 *  will replace that rule in the rule table.
 *  <P>
 *  TuringRuleTable makes use of a privately defined Vector variable,
 *  Rules which implements the dynamically allocated linked-list to hold
 *  the rules.
 *
 *  @version       %I%, %G%
 *  @author        Tom Briggs
 *  @since         JDK1.1.5
 *  @see           Vector
 *  @see           TuringMachine
 *  @see           TuringRule
*/

import java.util.*;
import java.lang.*;
import Rule;

public class RuleTable {
  Vector RuleTable;
    
  
  /**
   * Construct the RuleTable vector
   *
   */
  public RuleTable()
    {
      RuleTable = new Vector();
    }

  /**
   * Add or modify a TuringRule in the TuringRuleTable depending on wether it 
   * was found or not.
   *
   * @param reqCurrentRule               requested current rule
   * @param reqCharacterRead             requested character to read
   * @param reqCharacterToWrite          requested character to write
   * @param reqDirection                 direction to move the tape head
   * @param reqNextRule                  requested next rule to enter
   * @exception TuringRuleException   rule is inconsistent with validation rules
   */

   public void AddRule(int reqCurrentRule, char reqCharacterRead,
		     char reqCharacterToWrite, char reqDirection,
		       int reqNextRule) //throws TuringRuleException
    {

      Rule theRule;
      int theRow;

      // look for requested rule 
      theRow = FindRule(reqCurrentRule, reqCharacterRead);

      // if theRow < 0, rule not found, so add new rule
      if (theRow < 0) {
	theRule = new Rule(reqCurrentRule, reqCharacterRead,
				   reqCharacterToWrite, reqDirection,
				   reqNextRule);
	RuleTable.addElement(theRule);
      }
      else {  // rule is found, update
	theRule = (Rule) RuleTable.elementAt(theRow);
	theRule.SetRequestedValues(reqCurrentRule, reqCharacterRead,
				   reqCharacterToWrite, reqDirection,
				   reqNextRule);
	RuleTable.setElementAt(theRule, theRow);

      }  
    }



  /**
   * Find a rule in the tape, and return its row number in the table.  Find uses
   * the a rule number and a read character to determine a match (a key value)
   *
   * @param reqRule                   current rule number
   * @param reqCharacter                   read character 
   * @return Integer                      row number of rule, <code>-1</code> if not found
   */
  public int FindRule (int reqRule, int reqCharacter )
    {
      Rule theRule;
      int theRow, theSize;
      boolean found, done;

      // cannot search if there are no rules
      if (RuleTable.isEmpty()) return -1;

      // set some default, sane values
      theRow = 0;
      theSize = RuleTable.size();
      found = false;
      done = false;
      
      while (!done)
	{
	  theRule = (Rule) RuleTable.elementAt(theRow);
	  
	  if ((theRule.theCurrentRule == reqRule) &&
	      (theRule.theCharacterRead == reqCharacter)) 
	    {
	      found = true;
	      done = true;
	    }
	  else 
	    theRow++;

	  if (theRow >= theSize) 
	    done = true;
	}

      if (found) return theRow;
      else return -1;

    }  

  /**
   * Convert the entire rule table to a string 
   *
   * @return String               representation of rule table
   */
  
  public String  toString()
    {
      Rule theRule;
      int  theSize, theRow;
      boolean done;
      StringBuffer theString;

      theString = new StringBuffer("\n      ----| The Rule Table |----\n");

      if ((RuleTable == null) ||(RuleTable.isEmpty())) {
	theString.append("The RuleTable is empty or not initialized.\n");
      }
      else {
	theSize = RuleTable.size();
	theString.append("Number of rules: " + theSize + "\n");	

	theRow = 0;
	done = false;

	while (!done) {
	  theRule = (Rule) RuleTable.elementAt(theRow);
	  theString.append(theRule.toString());
	  theRow++;
	  if (theRow >= theSize) done=true;
	} // end while
	theString.append("\n\n");
      } // end else

      return theString.toString();
    } // end ShowRules


  /**
   *   dispose
  */
  public void Clear()
    {
      if (!RuleTable.isEmpty()) 
	RuleTable.removeAllElements();
      
    }

  /**
   * getWriteChar
   *
   * @param row
   */
  public char getWriteChar( int Row )
    {
      Rule Rule;

      Rule = (Rule)RuleTable.elementAt(Row);
      return Rule.theCharacterToWrite;
    }

/**
   * getDirection
   *
   * @param row
   */
  public char getDirection( int Row )
    {
      Rule Rule;

      Rule = (Rule)RuleTable.elementAt(Row);
      return Rule.theTapeHeadDirection;
    }

/**
   * getNextRule
   *
   * @param row
   */
  public int getNextRule( int Row )
    {
      Rule Rule;

      Rule = (Rule)RuleTable.elementAt(Row);
      return Rule.theNextRule;
    }


}




