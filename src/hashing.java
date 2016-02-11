/** Copyright (c) 2016, Valentino Constantinou <vc@valentino.io>
 Copyright (c) 2016, Elie Harik <elie.hharik@gmail.com>
 Permission to use, copy, modify, and/or distribute this software for any
 purpose with or without fee is hereby granted, provided that the above
 copyright notice and this permission notice appear in all copies.
 THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

// ToDo
// include the two hashing functions
// write the results of the hashing functions to the specified output directory
// create a console menu

import java.util.Scanner; // import the scanner
import java.io.BufferedReader; // for reading the file
import java.io.BufferedWriter; // for writing the file
import java.io.FileReader; // for reading the file
import java.io.FileWriter; // for writing the file
import java.util.ArrayList; // for storing the input file contents

public class hashing {

    // globally available variables
    public static int arraySize; // array size
    public static String inputFilePath; // input file path
    public static String outputFilePath1; // output file path
    public static String outputFilePath2; // output file path

    public static int lines; // line count
    private static ArrayList<String> names = new ArrayList<String>(); // array for names
    private static ArrayList<Integer> namesOut1 = new ArrayList<Integer>(); // array for hashed names 1
    private static ArrayList<Integer> namesOut2 = new ArrayList<Integer>(); // array for hashed names 2


    public static void main(String args[]) {

        // print welcome message
        System.out.println("Welcome and Go Wildcats!\n");

        // enter some sort of cool console art here just because
        System.out.println("|||    |||||   ||||     ||||");
        System.out.println("||||   |||||   ||||     ||||");
        System.out.println("|||||   ||||   ||||     ||||");
        System.out.println("|| |||   |||   ||||     ||||");
        System.out.println("||  |||   ||   ||||     ||||");
        System.out.println("||   |||  ||   ||||     ||||");
        System.out.println("|||   ||| ||   ||||     ||||");
        System.out.println("||||   |||||   ||||     ||||");
        System.out.println("|||||   ||||   |||||||||||||");
        System.out.println("|||||    |||   |||||||||||||\n");

        specifications(); // ask for the user input
        readFile(); // read the input file into an array list
        hashTheFile(); // import the file and do the hashing
        writeFile(); // write the file

    }

    /**
     * This function is used for user specification.
     */
    public static void specifications() {

        try {

            // create a Scanner that's going to read from system input on console
            Scanner scan = new Scanner(System.in);

            // ask the user to specify the array size, integer only
            System.out.println("Enter the desired array size: ");
            arraySize = scan.nextInt();

            // ask the user to specify the input file path
            System.out.println("Enter the input file path: ");
            inputFilePath = scan.next();

            // ask the user to specify the output file path
            System.out.println("Enter the output file path (1): ");
            outputFilePath1 = scan.next();

            // ask the user to specify the output file path
            System.out.println("Enter the output file path (2): ");
            outputFilePath2 = scan.next();

        }

        catch (Exception ex) {

            printError("a fatal error occurred");
            ex.printStackTrace(); // error catching

        }

    }

    /**
     * This function is used for reading the file contents into an ArrayList.
     */
    public static void readFile() {

        try {

            System.out.println("Working with file: " + inputFilePath); // print the file path we are working with

            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath)); // initialize the reader

            while (reader.readLine() != null) { // while there is a line in the file

                lines++; // add one to the line count
                names.add(reader.readLine()); // add name to names array

            }

            System.out.println("There are " + lines + " lines in the file."); // print the line count
            System.out.println("The input file contents have been saved to the array."); // print the line count

            reader.close(); // close the reader

        }

        catch (Exception ex) {

            printError("a fatal error occurred");
            ex.printStackTrace(); // error catching

        }

    }

    /**
     * This function is used for hashing.
     */
    public static void hashTheFile() {

        /* could be for each loop */
        /* not sure if this is correct */

        for (int i = 0; i < names.size(); i++) { // needs to be changed to array size

            String toHash = names.get(i);
            System.out.println(toHash.hashCode());
            namesOut2.add(toHash.hashCode());

        }

    }

    /**
     * This function is used for writing to a file.
     */
    public static void writeFile() {

        try {

            /* there's probably a nice way to print out the array list instead of converting to array */

            BufferedWriter br = new BufferedWriter(new FileWriter(outputFilePath2));
            StringBuilder sb = new StringBuilder();

            Integer[] namesOut = new Integer[names.size()]; // create array for hashed names

            // copy the content into the new array
            for (int i = 0; i < names.size(); i++ ) {

                namesOut[i] = namesOut2.get(i);

            }

            for (int i = 0; i < lines; i++) {

                sb.append(namesOut[i]); // append the name
                sb.append("\n"); // start a new line

            }

            br.write(sb.toString()); // write the contents of the loop to csv
            br.close(); // close the writer */

            // print message
            System.out.println("A file has been written to " + outputFilePath2);


        }

        catch (Exception ex) {

            printError("a fatal error occurred");
            ex.printStackTrace(); // error catching

        }

    }

    /**
     * This function is used for printing errors.
     */
    public static void printError(String s) {

        System.out.println("\nError: " + s);

    }

}
