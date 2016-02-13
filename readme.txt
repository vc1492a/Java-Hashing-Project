Names: Valentino Constantinou, Elie Harik, Ashley Felber, Terry Neuman

The package asks for user input, then executes three separate hashing algorithms on a set of text data while also assessing performance.
The output is then printed in the console and written to separate txt files. We have hard-coded the user input areas for ease of use
when in development and testing. Input validation was thus not included for the file paths (must be string), but could easily be included
similar to the input validation for the array size (must be int).

The hashing algorithms use for loops to construct the lists, but it would be better to use a foreach loop. We elected
not to do this because it would require a rewrite of the sortAndSolveCollisions function but this would be syntactically
ideal.

Our hashing function outperforms the first hashing function, but is a marginally worse performer than the built-in
Java hashCode function.