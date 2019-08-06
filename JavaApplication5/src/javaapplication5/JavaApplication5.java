
package javaapplication5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// @author Anar Alaskarzade

public class JavaApplication5 {

        private Scanner scanner = null;
        private String data;
    
    // Initial Main method
    public static void main(String[] args) {

        // Create an instance of this class and start it
        JavaApplication5 test = new JavaApplication5();
        test.start();
   
    }
    
    // Actual Main method
    public void start() {
        
        // Load data from file to a string
        loadData();
        // First exercise
        countBEE();
        // Second exercise
        count4CharString();
        // Third exercise
        count8CharString();
    }
    
    public void loadData() {
        
        // Load the data from file with FileReader
        try {
            scanner = new Scanner(new FileReader("exercise_data.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Read everything into one string
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next());
        }
        
        // Close the scanner and build the string
        scanner.close();
        data = stringBuilder.toString();    
    }
    
    // Count and print number of strings "BEE" present in data
    public void countBEE() {
        
        String bee = "bee";     
        int searchFrom = 0;   
        boolean contains = true;
        int beeCounter = 0;

        // While data contains "BEE" keep searching 
        while (data.substring(searchFrom).contains(bee)) {
            // Find index of first "BEE", starting from 0
            int a = data.indexOf(bee, searchFrom);
            System.out.println("BEE at " + a);
            // Record a "BEE"
            beeCounter++;
            System.out.println("BEE Count " + beeCounter);
            // Increate counter to start next search after the last "BEE"
            searchFrom = a + 1;
        }
        System.out.println("Total BEE Count " + beeCounter);
    }
    
    // Count and print number of 4 character strings which start with A and end with G
    public void count4CharString() {
        
        char g = 'g';
        int searchFrom = 0;   
        boolean containsA = true;
        int stringCounter = 0; 
        
        // While data contains A keep searching
        while (data.substring(searchFrom).contains("a")) {
            // Find index of first "A", starting from 0
            int a = data.indexOf("a", searchFrom);
            // Check if the third character after this A is a G 
            if (data.charAt(a+3) == g) {
                System.out.println("A**G at " + a);
                // Record the string 
                stringCounter++;
                System.out.println("A**G Count " + stringCounter); 
            }
            // Move the counter forward to next A 
            searchFrom = a + 1;
        }
        System.out.println("Total A**G Count " + stringCounter);
    }
        
    // Count and print number of 8 character strings which start with D and end with B, and Contain CC
    public void count8CharString() {
        
        char b = 'b';
        int searchFrom = 0;   
        boolean containsD = true;
        int stringCounter = 0; 
        
        // While data contains D keep searching
        while (data.substring(searchFrom).contains("d")) {
            // Find index of first "D", starting from 0
            int a = data.indexOf("d", searchFrom);
            // Check if the seventh character after this D is a B, also procees only if the seventh character is lower that string length 
            if (a + 7 < data.length() && data.charAt(a + 7) == b) {
                // If it is, create a substring from D to B 
                String maybe = data.substring(a, a + 7);
                // Check if substring contains CC
                if (maybe.contains("cc")) {
                    System.out.println("D**CC**B at " + a);
                    // Record the string 
                    stringCounter++;
                    System.out.println("D**CC**B Count " + stringCounter);
                }
            }
            // Move the counter forward to next D
            searchFrom = a + 1;
        }
        System.out.println("Total D**CC**B Count " + stringCounter);
    }
}
   

