# Aggregator Program

The program you’ll have to create needs to be able compute aggregates from a file containing data. 
Take a look at the data below.

	"PRODUCT_NAME","PRODUCT_CATEGORY","SALES_PRICE"
	"Hair Gel","Beauty",6.99
	"Scotch tape","Office Supply",2.99
	"Office Chair","Office Supply",134.99
	"Eraser","Office Supply",0.99
	"Lipstick","Beauty",9.99
	"Nail Polish","Beauty",8.99
	"Note Book","Office Supply",2.99
	"Flower Pot","Home & Gardening",22.76
	"Garden Hose","Home & Gardening",12.87

This format is referred to as a CSV (Comma Separated Values). 
Review this and understand what kind of data it is. 

- The first line is called the header. 
- The lines following the header is the actual data in the respective order. 
- Each attribute is separated with a comma hence the name.

###Requirements:
- First you need to create a file called products.csv in your workspace and paste the above data in that file.

- Your program should read through the file and compute the following calculations.

	1) The average price for each product_category.
	2) The total sales value for each product_category.	
	3) The number of products in each product_category.
	4) The most expensive item in each product_category.

- Your program should print to the screen the information. Here is an example of how it should be printed out:


	Beauty
	----------------------------------
	average_price = 8.66
	total_sales_value = 25.97
	number_of_products = 3
	most_expensive = 9.99
	
	Office Supply
	----------------------------------
	average_price = xxxx
	etc etc...

- You’ll need to use a file reader in Java to parse files. Check out this tutorial if you need help in that: http://www.mkyong.com/java/how-to-read-file-from-j...

- Keep in mind the OOP design principles you learned about in the “Master Object Oriented Design” course. Especially the single responsibility principle! 
- Don’t dump everything in one class file. 
- Separate the responsibilities so that your code is well organized. 
- Be creative and experiment. 
- There are many ways to solve this problem.

## Solution

### Project implementation specification

- I have used the Observer Pattern
- I have slightly modified the original UML Diagram Class, including the farewell (removeObserver) method.
- I have create a Maven Project with autoexecution of CoffeeShop class.

- I have also created an UML Class Diagram (folder uml) to understand the classes, packages, responsibilities, abstractions and interactions

 To build and auto exec the CoffeeShop class

	mvn clean install exec:java

### Environment
- Maven3
- JDK 1.8
- Eclipse Neon (With Markdown Text Editor and ObjectAID UML plugins)
- OS: MacOS
