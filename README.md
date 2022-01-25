<div id="top"></div>


<br />
<div align="center">
  <h3 align="center">CashRegister</h3>
  <p align="center">
    Cash register is able to keep your change exact. It can accept $20, $10, $5, $2 and $1 bills. If there are sufficient 
bills of the correct denomination, it should be able to return exact change in each denomination from the cash register. If there are insufficient bills for exact change, it should say so. 
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

![Screen Shot 2022-01-22 at 6 19 05 PM](https://user-images.githubusercontent.com/57274530/150703629-a7774a64-32f7-4363-82cf-6d40c2054da8.png)

There are many great cashiers we don't have to correct our transaction change; however, I wanted to make sure it was accessible if needed.

<p align="right">(<a href="#top">back to top</a>)</p>


### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [Spring.io](https://spring.io/projects/spring-framework)
* [Junit5](https://junit.org/junit5/)

<p align="right">(<a href="#top">back to top</a>)</p>

### Features
        
* SHOW - Output the current number of each denomination in the register in format $<total> <# of 20’s> <# of 10’s> <# of 5’s> <# of 2’s> <# of 1’s> 
* PUT - Adds some number of each denomination from the register, then print the current state. Same output format as show command. 
* TAKE - Removes some number of each denomination from the register, then print the current state. Same output format as show command. 
* CHANGE - Returns change for some amount of money. Output should be denominations of change for the value asked in format <# of 20’s> <# of 
          10’s> <# of 5’s> <# of 2’s> <# of 1’s>, e.g. 0 0 4 0 0. This should also deduct the resulting denominations from the register. 
* QUIT Exit the program 

### Endpoints
Allows a cashregister initialize with default $20's, $10's, $5's, $2's, and $1's values to 0. It returns a response code 200 successful.
<details>
<summary>http://localhost:5000/cashdrawers/cashdrawer</summary>

```JSON
{
1
}
```

</details>
Allows a user to get the cashregister json object. The json object contains the current values and id.
<details>
<summary>http://localhost:5000/cashdrawers/cashdrawer/1</summary>

```JSON
        {
            "id": 1,
            "twenty": 0,
            "ten": 0,
            "five": 0,
            "two": 0,
            "one": 0,
            "total": 0
        }
```

</details>
Allows a user to add values to the cashdrawer. Returns string.
<details>
<summary>http://localhost:5000/cashdrawers/cashdrawer/1/transactions/put</summary>

```JSON
        $68 1 2 3 4 5
```

</details>
Allows a user to take values from the cashdrawer if there are sufficient funds. Returns string.
<summary>http://localhost:5000/cashdrawers/cashdrawer/1/transactions/take</summary>

```JSON
        $0 0 0 0 0 0
```

</details>
        
