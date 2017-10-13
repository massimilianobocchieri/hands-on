# Java API  for ElasticSearch JSON queries

## ------------------------------- ASSIGNMENT ----------------------------------
	
	Your task is to use the builder design pattern for creating a Java API (Application Programming Interface) that clients can use to create 
	a particular kind of JSON structure. 

###Business Requirement:

	You have been hired as a consultant to complete a 1 month project. Developers in our company need a handy java API they can use to interact with a searchengine. 	You'll need to use the builder pattern to create the below JSON structure. This json structure is actually a query that can be submitted to a searchengine called elasticsearch. 
	Elasticsearch is an opensource tool one can download and use but that's not important. 
	All your work will be in Java. 

 Developers in our company using your builder API should be able to create json requests like this.


	{
		"query": { 
			"bool": { 
	
				"must": [
							{ "match": { "item": "Milk" }}, 
							{ "match": { "item_type": "Dairy" }} 
						],
	
				"should": [
							{ "match": { "product_location": "New Mexico" }}, 
							{ "match": { "warehouse_number": 37 }} 
						]
					}
	   			}
	}

Here are the rules for the JSON structure. 

	You can have a single must or should section inside a bool section as shown. 
	But keep in mind that inside of each one of these musts or shoulds, you can have nested bool sections. 
	The match section is simple, you can have any attribute name and it's value. 
	For example, the above json query is filtering for ONLY those items that are "Milk". 
	And the "item_type" attribute has the value "Dairy". 
	The product_location should be "New Mexico" with warehouse_number: 37. 


You'll need to create a few java classes that will represent this JSON structure when they are converted to a JSON format.
Create the classes called Query, Bool, Must, Match and Test. 
You may also need a class called QueryBuilder, or whatever you want to name it. 
The Test class will contain the main method in which you will invoke the builder methods to create the instances of the Musts, Shoulds etc. and print out the composed objects json format to prove that the API works as expected. 

 Here is an example of how a developer expects to use the API:

	QueryBuilder builder = new QueryBuilder();
	builder.bool().mustMatch("item", "Milk").mustMatch("item_type", "Dairy");
	builder.bool().shouldMatch("product_location", "New Mexico").shouldMatch("warehouse_number", 37);

Remember the developers need to be able to nest bools inside of musts or shoulds if needed. So here's the case for a nested bool containing a must inside of an existing should section. 

 The developers expect to use the api like this:

	builder.bool().shouldMatch("lot_number", 307).bool().mustMatch("expiry_date", "Jan 2020");


To convert your classes into json you'll have to use an external java library called Jackson. You can learn more about it [here](http://www.mkyong.com/java/how-to-convert-java-obj...) 

## ------------------------------- IMPLEMENTATION ----------------------------------

###Assumptions

I didn't create Must and Should class due to constraint related to Jackson Json converter: as in the Json syntax of the ES query assignment they are considered to be  arrays ("must": [e1,e2,....,en] I decided to implement them as List<Object>.

The Object class choice is due to the fact that inside there can be either Match or Bool, so I stayed generic even if probably I could have "restricted" Match/Bool with some abstraction/interface.

Following your suggestion I watched carefully once again the "Builder Pattern" lesson and there I found a linear example of a single class construction; I tried to use some of the idea of builder demanding the object creation to QueryBuilder class, and to the Bool class, depending on the context of creation and return the proper object. Furthermore in Bool class (the trickiest and "recursive" one, I used an origin attribute in order to "contextualize" the object that requested the bool() building, to understand if I had to add an element either to must or should.

I tried to use SRP demanding the management of conversion to a JavaToJason Converter, using abstraction with interface and strategy pattern in the algorithm of conversion (imagining the possibility to use other json converters).
I used also Dependency inversion and Dependency injection in the main method of test class, injecting the jackson implementation of converter.

I created also a clean method in QueryBuilder to allow creating a new query using the same QueryBuilder object instance.


In Match class I had to use a Map to create pair {"name":"value"} instead of two fields to respect the requested json format required by ES.
And I used Object type for the name and value to stay generic and allow Letters, numbers, boolean as required in the assignment, following the ES syntax.


### Project implementation specification

I have create a Maven Project, as requested, including the Jackson Json dependency and with autoexecution of Test class.

I have also created an UML Class Diagram (folder uml) to understand the classes, packages, responsibilities, abstractions and interactions

 To build and auto exec the Test class

	mvn clean install exec:java

### Environment
- Maven3
- JDK 1.8
- Eclipse Neon (With Markdown Text Editor and ObjectAID UML plugins)
- OS: MacOS (Sorry if you find .DS_Store files...)


###Notes
I could have also used Spring Framework for injection but I think that for this example it would have been "overengineering".

####Possible improvements

 - Adding some JUnit Test to compare calls to the expected json output;
  - Build consistency State ( I have put only a check on QueryBuilder().bool().bool() but it can be extended to other syntax inconsistent scenarios;
 - Exception management
  	
	
 




