"# Auto1testing" 

Test description:

Search is a crucial part of all Auto1 platforms and Automation testing is essential
part of software development in Auto Group. Please create automation test which will do the
following. Upload solution to github.com or send it as zip file: (You are free to use any
programming language or any framework for this task. Please do not use any record-pay tools)

● Open https://www.autohero.com/de/search/

● Filter for First registration ( Erstzulassung ). Filter for FROM 2015

● Apply Filter

● Sort cars by Price Descending ( Höchster Preis )

● Verify all cars are filtered by first registration ( 2015+ )

● Verify all cars are sorted by price descending

Project structure:

3 classes: 

BaseClass - environment setup;

SearchClass - POM class, locators and methods used for searching page;

TestClass - test;

Tech stack:

Java programming language with TestNG framework;

Test running:  

mvn clean test


