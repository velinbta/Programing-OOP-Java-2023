3. Shopping Spree 
Create two classes: class Person and class Product.
Each person should have a name, money, and a bag of products.
Each product should have a name and cost. The name cannot be an empty string.
Be careful about white space in the name. Money and cost cannot be a negative number.

Product 
- name: String
- cost: double
+ Product (String,  double)
- setCost (double): void
- setName (String): void
+ getName(): String
+ getCost(): double

Person
- name: String
- money: double
- products: List<Product>
+ Person (String,  double)
- setName (String): void
- setMoney (double): void
+ buyProduct (Product): void
+ getName(): String

Create a program in which each command corresponds to a person buying a product.
If the person can afford a product add it to his bag.
If a person doesn't have enough money, print an appropriate exception message: "{Person name} can't afford {Product name}"

In the first two lines, you are given all people and all products.
After all, purchases print every person in the order of appearance and all products that he has bought also in order of appearance.

If nothing is bought, print: 
"{Person name} - Nothing bought".

Read commands till you find the line with the "END" command.
In case of invalid input (negative money exception message: "Money cannot be negative") or empty name: (empty name exception message "Name cannot be empty") break the program with an appropriate message.
See the examples below: 

Examples:

Input 1:
Peter=11;George=4
Bread=10;Milk=2
Peter Bread
George Milk
George Milk
Peter Milk
END

Output 1:
Peter bought Bread
George bought Milk
George bought Milk
Peter can't afford Milk
Peter - Bread
George - Milk, Milk

Input 2:
Maria=0
Coffee=2
Maria Coffee
END

Output 2:
Maria can't afford Coffee
Maria - Nothing bought

Input 3:
John=-3
Peppers=1
John Peppers
END

Output 3:
Money cannot be negative