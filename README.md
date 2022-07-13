Program Name: project2.java
Programmer: Steve Schnell
Assignment: Project 2
Date: November 30, 2017

Problem:
A palindrome is a phrase that reads the same forwards as it does backwards. For example, “a man, a plan, a canal, Panama,” is a palindrome. Write a program that uses a stack data structure to check for palindromes in each line of a text file

Analysis of Algorithm Complexity:
The readFromText method has a Big O of O(n) because it only contains a single while loop that copy the arrayList from the text document. The writeToText method has a Big O of O(n) because it only contains a single for loop to write the arrayList to the text document. The palindromesCheck method has a Big O of O(n) it has multiple for and while loops but none are nested so it stays O(n).

Analysis of Algorithm Design:
The programs consist of three parts. The first part is inputting the text document line by line into an arraylist. The next part is to process each line, first turning it into single string, removing spaces and symbols, then capitalization, and finely writing it into two stacks, and comparing them. The final part is to modify the list by removing non-palindromes and modifying the rest and then finally outputting the arraylist into a text document.
Program Input/Output:
The main inputs of the program are a text document of sentences and a text document of palindromes. The readFromText takes a scanner and a file as an input and returns an arraylist of string. The writeToText takes a string filename and an arraylist and has no return. The palindromesCheck takes a string line and returns a bool for the string being a palindrome.
