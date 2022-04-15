///////////////////////////////////////////////////////////////////////////////
//
// Title:            (Log4J2- Add logging to an existing, working program)
// Files:            (Exercise 12_03.java)
// Semester:         (Secure Software Development) Spring 2022
//
// Author:           (Arielle Collins)
// Email:            (acollins214@student.cccs.edu)
// Lecturer's Name:  (Doug Lundin)
//
/////////////////////////////////////////////////////////////////////////////
//
// Online sources:   a. Baseline code: https://github.com/douglundin/CSC245-Project4-Log4J2
//                   b. Logging best practices: https://www.papertrail.com/solution/tips/logging-in-java-best-practices-and-tips/
//                   b. Project file details: https://mkyong.com/logging/apache-log4j-2-tutorials/
//
////////////////////////////////////////////////////////////////////////////
package edu.arapahoe.csc245;
import java.util.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * This class creates an array with 100 randomly chosen integers
 * prompts the user to enter the index of the array, and then displays the corresponding value.
 * Logging was added to this program following the logging best practices.
 * @author (Arielle Collins)
 */
public class Exercise12_03 {
    //Initialize logger
    private static final Logger logger = LogManager.getLogger(Exercise12_03.class);

    /**
     * This is the entrypoint for the program.
     * @param args - Unused: This program does not take arguments.
     */
    public static void main(String[] args) {
        int[] data = new int[100];

        // Initialize array
        for (int i = 0; i < 100; i++) {
            data[i] = (int) (Math.random() * 10000);
        }
        // Initialize scanner
        Scanner input = new Scanner(System.in);
        // User is asked for input
        System.out.print("Enter an index: ");
        int index = input.nextInt();

        try {
            System.out.println("The element is " + data[index]);
        }
        //Catch block is used to handle and error with user input
        catch (Exception ex) {
            //Logger logs the relevant error message, and provides relevant info to the developer.
            logger.error("Out of Bounds", ex);
        }
    }

}
