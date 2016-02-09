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
// ask the user to specify the location of the working file
// ask the user to specify the output location
// include the two hashing functions
// try/catch blocks and error handling, with print error function
// write the results of the hashing functions to the specified output directory
// create a console menu

import java.util.Scanner; // import the scanner

public class hashing {

    // globally available variables
    public static int arraySize;

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
        System.out.println("|||||    |||   |||||||||||||");

        // create a Scanner that's going to read from system input on console
        Scanner scan = new Scanner(System.in);

        // ask the user to specify the array size, integer only
        System.out.println("Enter the desired array size: ");
        arraySize = scan.nextInt();

    }

    /**
     * This function is used for printing errors.
     */
    public static void printError(String s) {

        System.out.println("\nError: " + s);

    }

}
