Cash Register

Expected Features:

Provide implementation for hte following features:
Show - Output the current number of each denomination in the register in format of
        $<total> <# of 20's> <# of 10's> <# of 5's> <# of 2's> <# of 1's> 
Put - Adds some number of denomination from the register, then print the current state. Same output format as above
Take - Removes some number of each denomination from the register, then print the current state. Same output format.
Change - Returns change for some amount of money, and deducts the result denominations from the register.
        Output should be denominations of change for the value asked in format
        <# of 20's> <# of 10's> <# of 5's> <# of 2's> <# of 1's>, eg 0 0 4 0 0
Quit - Exit the program

Key Points:
- Run from the command line
- Includes junit and hamcrest for testing.
- Include tests that exercise functionality.
- Include Test case: How to make $8 change if you have $13 in the cash register
