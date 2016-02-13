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
import java.util.Collections;

public class hashing {

	// globally available variables
	public static int arraySize; // array size
	public static String inputFilePath; // input file path
	public static String outputFilePath1; // output file path
	public static String outputFilePath2; // output file path

	public static int lines; // line count
	private static ArrayList<String> names = new ArrayList<String>(); // array for names
	private static ArrayList<Integer> namesOut1 = new ArrayList<Integer>(); // array for hashed names 1
	private static ArrayList<String> namesOutString1 = new ArrayList<String>(); // final array used to output strings of names 1
	private static ArrayList<Integer> namesOut2 = new ArrayList<Integer>(); // array for hashed names 2
	private static ArrayList<String> namesOutString2 = new ArrayList<String>(); //Final array used to output strings of names 2
	private static ArrayList<Integer> namesOut3 = new ArrayList<Integer>(); // array for hashed names 2
	private static ArrayList<String> namesOutString3 = new ArrayList<String>(); //Final array used to output strings of names 2


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
			//
			//            // ask the user to specify the input file path
			//            System.out.println("Enter the input file path: ");
			//            inputFilePath = scan.next();
			//
			//            // ask the user to specify the output file path
			//            System.out.println("Enter the output file path (1): ");
			//            outputFilePath1 = scan.next();
			//
			//            // ask the user to specify the output file path
			//            System.out.println("Enter the output file path (2): ");
			//            outputFilePath2 = scan.next();
			
			
//			//@NOTE HARD CODED.
//            inputFilePath = "assets/input.txt";
//            outputFilePath1 = "assets/output1.txt";
//            outputFilePath2 = "assets/output2.txt";
			inputFilePath = "/Users/elieharik/Desktop/WORK/NORTHWESTERN/Winter Quarter/MSiA490 - Python Java/Project/Project1/Project/assets/input.txt";
			outputFilePath1 = "/Users/elieharik/Desktop/WORK/NORTHWESTERN/Winter Quarter/MSiA490 - Python Java/Project/Project1/Project/assets/output1.txt";
			outputFilePath2 = "/Users/elieharik/Desktop/WORK/NORTHWESTERN/Winter Quarter/MSiA490 - Python Java/Project/Project1/Project/assets/output2.txt";


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

		//Hash method 1. 
		for (int i = 0; i < names.size(); i++) {

			String currentString = names.get(i);
			int lengthOfName = currentString.length();
			int sumAscii = 0; //Use to sum values of char asciis in string

			for (int j = 0; j < lengthOfName; j++ ) {
				char currentChar = currentString.charAt(j);

				//Convert char to ascii code by just casting to int
				int currentCharAscii = (int) currentChar;
				sumAscii += currentCharAscii;
			}

			// @Note: namesOut1 will be our temp output of Ints
			int hashValue = sumAscii % arraySize;
			namesOut1.add(hashValue); //Output

		}



		//Java's own hashcode
		for (int i = 0; i < names.size(); i++) { // needs to be changed to array size

			String toHash = names.get(i);
			System.out.println(toHash.hashCode());
			namesOut2.add(toHash.hashCode() % arraySize);
		}
		
		
		//Our own hash
		for (int i = 0; i < names.size(); i++) {
			int hash = 7; 
			String currentString = names.get(i); //get the name
			
			int lengthOfName = currentString.length();
			int sumAscii = 0; //Use to sum values of char asciis in string

			for (int j = 0; j < lengthOfName; j++ ) {
				int currentChar = (int) currentString.charAt(j);
				hash = hash*31 + currentChar; 
			}
			int hashValue = hash % arraySize; 
			namesOut3.add(hashValue); 
		}
		
		

		namesOutString1 = sortAndSolveCollisions(namesOut1);
		namesOutString2 = sortAndSolveCollisions(namesOut2);
		namesOutString3 = sortAndSolveCollisions(namesOut3);

		//@NOTE @TEST
		System.out.println("\n\n\nNAMEOUTSTRING1");
		for (String s : namesOutString1) {

			System.out.println(s);

		}
		
		System.out.println("\n\n\n\nNAMEOUTSTRING2");
		for (String s : namesOutString2) {

			System.out.println(s);

		}
		
		System.out.println("\n\n\n\nNAMEOUTSTRING3");
		for (String s : namesOutString3) {

			System.out.println(s);

		}

	}


	/*
	 * @Note: IMPORTANT NOTE
	 * In hints (2), says that one should use linked list where
	 *  each node contains a string, for which "head" will be corresponding 
	 *  element in array. 
	 *  
	 *  So instead of adding Integers to String array with commas and space,
	 * should also have an array of LINKED LISTS (Will do it tomorrow) 
	 */

	/**
	 *
	 * @param intArray (which is your names array that you got from the two hash methods
	 *
	 * Order the ArrayList of Integers, and check if there are collisions in array
	 * In the sorted array, collisions will occur when you have consecutives entries that are equal
	 *
	 * Copy into an array of strings (that will be your output) accordingly
	 *                 If no collision:just copy new val to new array
	 *                 if collision: copy to corresponding index (where 
	 */


	public static ArrayList<String> sortAndSolveCollisions(ArrayList<Integer> intArray) {

		ArrayList<String> stringList = new ArrayList<String>();

		int indexFirstOccurence = 0; //The index of the first occurence of a specific int in your list.
		int numberDuplicates = 0; //TOTAL number of duplicates in your input array.
		
		/* 
		 * part 3)d) of performance requirements:
		 * If no string from the input has been mapped to a particular line,
		 * line should contain "EMPTY LINE".
		 * 
		 * To do this, add a counter that goes from your min value to your max value (in hash map)
		 * BUT only increases in increments of 1. Therefore, if hash codes go from 2 to 4, the counter
		 * will help us add two EMPTY LINES.
		 */
		int emptyCounter = 0;

		//Sort the input array. 
		Collections.sort(intArray);

		//Check if the array size is greater than 0 
		if (intArray.size() > 0) { //Add the first element to your new STRING array 
			stringList.add(String.valueOf(intArray.get(0)));

			for (int i = 1; i < intArray.size(); i++) {

				//Check if current val is equal to the first occurence of a value.
				if (intArray.get(indexFirstOccurence).equals(intArray.get(i))) {

					//We do not need to increment our counter here since we have cons. equal values. 
					//Increment number of collisions that you have
					numberDuplicates++;

					//Create a temporary String that will contain what is already in the index where you want to add 
					//value that collided.
					String tempString = stringList.get(i-numberDuplicates+emptyCounter);

					//Now add value to the proper index in the string array with space and comma.
					stringList.set(i-numberDuplicates+emptyCounter,
							tempString + ", " + String.valueOf(intArray.get(i)));

				}

                else {

					//Need to check if the value that we have is equal to the value before +1
					if (intArray.get(i) == intArray.get(i-1) + 1) {//No need to change increment our counter
						//Change index first occurence
						indexFirstOccurence = i;

						//Add that value to your string array (in correct position of course!)
						//@Note: explain how decided to place values where. 
						stringList.add(i-numberDuplicates+emptyCounter, String.valueOf(intArray.get(i)));

					}

                    else {
						 //Just add an empty line here and increment counter while array(i+1) != array(i)+1
						for (int lastValue = intArray.get(i-1)+1; lastValue < intArray.get(i); lastValue++) {

							stringList.add(i-numberDuplicates+emptyCounter, "LINE EMPTY");
							emptyCounter++;

						}
					
						//Now add the specific entry 
						indexFirstOccurence = i;
						stringList.add(i-numberDuplicates+emptyCounter, String.valueOf(intArray.get(i)));
					}

				}

			}
			/*
			 *  @NOTE Might need to add for loop here to check if max 
			 *  value in your intArray is equal to maxModulo (arraysize - 1)
			 *  If not, fill the last portion of array with EMPTY LINES 
			 *  e.g. if last hash value is 97 and array size is 99
			 *  we need to add two EMPTY LINES (fro 98 and 99). 
			 */
			
			/*
			 * @NOTE: HOW TO TEST THIS???
			 * WILL COMMENT OUT FOR NOW TO MAKE SURE NOT MESSING ANYTHING UP 
			 * 
			 * Works with current hash method #3. Adds lines for 97 98 99 
			 * 
			 * 
			 * Let's do this here: 
			 * Get the last value in the array.
			 * Can do this here, because the way things were done above 
			 * we cannot get a "LINE EMPTY" as the last element of our array.
			 * We will actually fetch value from our integer array
			 */
			int lastValue = intArray.get(intArray.size()-1); //Get the last element
			
			//Max value of hash code is, for ex, 99 (99%100 = 99, while 100%100 = 0)
			if (lastValue < intArray.size()-1) {
				//Get the difference between our max hash code value and max possible value
				int difference = intArray.size()-1-lastValue;
				for (int i = 0; i < difference; i++) {
					//Add a new EMPTY LINE 
					stringList.add("EMPTY LINE");
					emptyCounter++;
				}
			}
			
			
			
			
			/*
			 * PERFORMANCE METRIC 
			 * REQUIREMENTS PART 4
			 * Just calculate total number of collisions, collisions / size of original array and numb of emtpy lines
			 * @Note: For now just add this as last string in array
			 */
			stringList.add("Total number of collisions is equal to: " + numberDuplicates);
			float proportionOfDuplicates = (float) numberDuplicates / intArray.size();
			stringList.add("Total # of collisions divided by total number of elements: " + proportionOfDuplicates);
			stringList.add("Total number of empty lines is equal to: " + emptyCounter);

				
		}
		
		
		return stringList; 
	}

	/**
	 * This function is used for writing to a file.
	 */
	public static void writeFile() {

		try {

            // import the file writer
            FileWriter writer = new FileWriter(outputFilePath1);

            // write the output1.txt file
            for(String str: namesOutString1) {

                writer.write(str);
                writer.write('\n');

            }

            // write the output2.txt file
            for(String str: namesOutString2) {

                writer.write(str);
                writer.write('\n');

            }

            writer.close(); // close the writer

            // print message
            System.out.println("A file has been written to " + outputFilePath1 + " and " + outputFilePath2);

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
