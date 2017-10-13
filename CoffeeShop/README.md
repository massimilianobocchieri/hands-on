## OOP Coding Assignment – Coffee Shop

Imagine a typical coffee shop scenario in which you have an attendant that takes customer orders at the counter and prepares their drinks. The customers sit in the shop and listen for their order to be called up. 

When their particular order is called up, they grab the drink and leave the store. 

If their order is not called they do not leave the store and continue to just sit there and listen for their order. 

### UML Class Diagram to code up this scenario. 

 ![picture](https://d2vvqscadf4c1f.cloudfront.net/TTXldMkZQ6exCxyFkCNM_2015-04-29_22-09-28__CoffeeShop.png)
 
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
