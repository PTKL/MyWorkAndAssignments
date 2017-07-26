/**
 * TuringRule implements one single TuringMachine rule.  This rule is
 * a 5-tuple described in detail in TuringRuleTable.  
 *
 *  @version       %I%, %G%
 *  @author        Tom Briggs
 *  @since         JDK1.1.5
 *  @see           TuringRuleTable
 *  @see           TuringMachine
 */

public class Rule
{
  int theCurrentRule;
  char theCharacterRead;   
  char theCharacterToWrite;  
  char theTapeHeadDirection;  
  int theNextRule;    
  
  
  /**
   * Constructs a rule, and uses SetRequestedValues to set the Rule 5-tuples 
   with the given requested values.  
   *
   * @param reqCurrentRule               the requested current rule
   * @param reqCharacterRead             the requested character to read
   * @param reqCharacterToWrite          the requested character to write
   * @param reqDirection                 the direction to move the tape head
   * @param reqNextRule                  the requested next rule to enter
   * @exception TuringRuleException   if a rule is inconsistent with validation rules
   * @see SetRequestedValues
   */
  
  public Rule(int reqCurrentRule, char reqCharacterRead,
	      char reqCharacterToWrite, char reqDirection, int reqNextRule) 
    {
      
      SetRequestedValues  ( reqCurrentRule, reqCharacterRead,
			    reqCharacterToWrite, reqDirection, reqNextRule);
      
    }
  
  /**
   * Sets the rule's values to the requested values, if and only if, the
   * requested values pass several sanity checks. This method is expected to be called
   * by other methods to set the values of the rule table.
   *
   * @param reqCurrentRule               requested current rule
   * @param reqCharacterRead             requested character to read
   * @param reqCharacterToWrite          requested character to write
   * @param reqDirection                 direction to move the tape head
   * @param reqNextRule                  requested next rule to enter
   * @exception TuringRuleException   rule is inconsistent with validation rules
   * @return                             <code>true</code>if the rule was added;
   *                                     <code>false</code>otherwise
   * @see boolean
   * @see Exception
   * @see TuringRuleException
   */
  
  public boolean SetRequestedValues(int reqCurrentRule, char reqCharacterRead,
				    char reqCharacterToWrite, char reqDirection,
				    int reqNextRule) {
    
    boolean ValuesPassSanityCheck;
    String ExceptionMessage;
    
    ValuesPassSanityCheck = true;
    ExceptionMessage = new String("TuringRule Validation Checks Failed: \n");
    // current rules must be greater than 0 
    if (reqCurrentRule <= 0) {
      ValuesPassSanityCheck = false;
      ExceptionMessage += "    1: Current rule less than 1\n";
    }
    
    // read and write chars can be any Java characters
    
    // requested direction must be 'R' or 'L' for Right or Left
    if ((reqDirection != 'R') && (reqDirection !='L')) {
      ValuesPassSanityCheck = false;
      ExceptionMessage += "    2: Direction must be R or L\n";
    }
    
    // requested next rule must be -1, 0, or positive. 
    if (reqNextRule < -1) {
      ValuesPassSanityCheck = false;
      ExceptionMessage += "    3: Next rule must be -1, 0, or positive integer\n";
    }
    
    if (ValuesPassSanityCheck){     
      theCurrentRule = reqCurrentRule;   // set the rule's values to requested
      theCharacterRead = reqCharacterRead;
      theCharacterToWrite = reqCharacterToWrite;
      theTapeHeadDirection = reqDirection;
      theNextRule = reqNextRule;
    }
    else {    // throw an exception!
      ExceptionMessage += "     NO Changes made to rule: " + 
	theCurrentRule + theCharacterRead + "\n";
      
      // throw new TuringRuleException ( ExceptionMessage );
    }
    
    return ValuesPassSanityCheck;
    
  } 
  
  
  /**
   * Convert the contents of the rule to a string.  Implements the toString standard 
   * method.
   *
   * @return              <code>String</code>String equivalent of rule.
   * @see String
   */
  public String toString()
    {
      String theRuleAsString, theDirectionAsString;
      
      if (theTapeHeadDirection == 'R')
	theDirectionAsString = new String("Right");
      if (theTapeHeadDirection == 'L')
	theDirectionAsString = new String("Left");
      else
	theDirectionAsString = new String("undef");
      
      theRuleAsString = new String 
	("When in state " + theCurrentRule + 
	 " reads " + theCharacterRead + " then writes " + theCharacterToWrite +
	 " and moves the tape " + theDirectionAsString + 
	 " and goes to rule " + theNextRule + "\n");
      
      return theRuleAsString;
    } 
  
  
} // End internal class rule declaration 


