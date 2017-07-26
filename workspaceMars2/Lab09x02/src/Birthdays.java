/*************************************************************************
 *  Compilation:  javac Birthdays.java
 *  Execution:    java Birthdays dayNum trials
 *  
 *  Computes the number of people (by simulation) that must enter a room
 *  until two of them share a birthday. Assumes birthdays a uniform
 *  and independent from 0 to dayNum-1. Repeats the experiment trials times and
 *  prints the average
 *  
 *  % java Birthdays 365 100000
 *  Average = 24.65394
 *
 *  Remark: the expected number of people for dayNum = 365 is about 24.61658.
 *  (The median number is about 23, but the average is higher.)
 *
 *************************************************************************/


public class Birthdays { 

    public static void main(String[] args) { 
        int dayNum = Integer.parseInt(args[0]);     // number of days
        int trials = Integer.parseInt(args[1]);     // number of trials
        int people = 0;                        // total number of people over all T trials

        // repeat T times
        for (int t = 0; t < trials; t++) {

            //  days[d] = true if someone born on day d; false otherwise
            boolean[] days = new boolean[dayNum];

            while (true) {
                people++;                             // one more person enters the room
                int d = (int) (dayNum * Math.random());    // integer between 0 and dayNum-1
                if (days[d]) break;                   // two people with the same birthday, so break out of loop
                days[d] = true;                       // update days[d]
            }
        }

        int average = people / trials;
        System.out.println("Average = " + average);
    }
}
