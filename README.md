Cash Register

Expected Features:

Provides implementation for hte following features:
Show - Output the current number of each denomination in the register in format of
        $<total> <# of 20's> <# of 10's> <# of 5's> <# of 2's> <# of 1's> 
Put - Adds some number of denomination from the register, then print the current state. Same output format as above
Take - Removes some number of each denomination from the register, then print the current state. Same output format.
Change - Returns change for some amount of money, and deducts the result denominations from the register.
        Output should be denominations of change for the value asked in format
        <# of 20's> <# of 10's> <# of 5's> <# of 2's> <# of 1's>, eg 0 0 4 0 0
Quit - Exit the program

Key Points:
- Run from the command line for user experience, and postman

        Endpoints

HTTP	Endpoint	Description
POST	/cashdrawers/cashdrawer Allows a cashregister with default $20's, $10's, $5's, $2's, and $1's values to 0. It returns a response code.
GET	/cashdrawers/cashdrawer/{cashdrawerid}	Allows a user to the cashregister json object. The json object contains the current values and id.
PUT	/cashdrawers/cashdrawer/{cashdrawerid}/transactions/{transactiontype} Allows a cashdrawer to take or add values to the cashdrawer. Returns string.

Successful Cashdrawer GET - SHOW - Input API: http://localhost:5000/cashdrawers/cashdrawer/1
{
    "id": 1,
    "twenty": 0,
    "ten": 0,
    "five": 0,
    "two": 0,
    "one": 0,
    "total": 0
}
        
Successful PUT API:http://localhost:5000/cashdrawers/cashdrawer/1/transactions/put 
 {
    "twenty": 1,
    "ten": 2,
    "five": 3,
    "two": 4,
    "one": 5
}
$68 1 2 3 4 5

Successful PUT - Take API:http://localhost:5000/cashdrawers/cashdrawer/1/transactions/take
 {
    "twenty": 1,
    "ten": 2,
    "five": 3,
    "two": 4,
    "one": 5
}
$0 0 0 0 0 0
