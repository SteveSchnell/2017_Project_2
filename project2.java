/******************************************************************************************************************************
*Program Name: project2.java                                                                                        *
*Programmer: Steve Schnell                                                                                                    *
*Assignment: Project 2                                                                                                        *
*Purpose:The purpose of this program is to uses a stack data structure to check for palindromes in each line of a text file.  *
*Date: November 30, 2017                                                                                                      *
******************************************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;


public class project2 
{
	static Scanner scanner; //Static Scanner and File Objects
	static File file;	

   public static void main(String[] args) 
    {
    
		ArrayList <String> TextFile;//Initialise new ArrayList
		
		TextFile = readFromText(scanner,file);//Assign returned arraylist with TextFile		
      writeToText("palindromes.txt",TextFile);//saves the results to a text document 	 
     
      for(int i = 0; i < TextFile.size(); i++)//loops through the arraylist
      {   
         if(palindromesCheck(TextFile.get(i)))//check if the line is a palindrome
         {
            String Temp = TextFile.get(i);
            TextFile.set(i, "\"" + Temp + "\" is a palindrome. ");//if true, adds "is a palindrome."
         }
         else
         {
            //TextFile.set(i, "");//if false, it deletes the line
         }
      }

      //writeToText("palindromes.txt",TextFile);//saves the results to a text document  
    }
    
//-----------------------------------------------------------------------------------------------------------    
    
static ArrayList<String> readFromText (Scanner scanner, File file)// Static method that returns an ArrayList
   {		
		file = new File("INPUT.txt");//Instantiate File with file name within parameters	
		
		try //surround with try and catch to see whether the file was read or not
      {
			scanner = new Scanner(file);
		} 
      catch (FileNotFoundException e) 
      {

			e.printStackTrace();
		}
		
		ArrayList <String> theWord = new ArrayList <String>();//Instantiate a new ArrayList of String type
		
		while(scanner.hasNext())//while it has next ..
      {
			
			String str = scanner.nextLine();//Initialise str with word read		
			theWord.add(str);//add to ArrayList
		}	
		return theWord;//return ArrayList
	}
    
//-----------------------------------------------------------------------------------------------------------

   static void writeToText(String fileName, ArrayList<String> output) // Static method
   {
		try ( BufferedWriter writer = new BufferedWriter (new FileWriter (fileName))) //surround with try and catch to see whether the file was written or not
		{			
			for (int i = 0; i < output.size(); i++) //loops through the arraylist
         {
            if(!output.get(i).equals(""))//if the line is not empty
            {
				   writer.write (output.get(i));//writes the line to the document
               writer.newLine();
            }
			}
			
			writer.close ();//closes the document
		} 
      catch (IOException e) 
      {
			e.printStackTrace ();
		}
	}
   
//-----------------------------------------------------------------------------------------------------------

    static Boolean palindromesCheck(String Line )// Static method that returns an Boolean
    {   
      Line = Line.replaceAll("[^a-zA-Z]+", "");//remove all symbols and spaces from the string
      Line = Line.toLowerCase();//sets all characters to lowercase
    
      ArrayList <Character> theLine = new ArrayList <Character>();//Instantiate a new ArrayList of Character type
    
      for (char c : Line.toCharArray()) //adds the string to the arraylist
      {
         theLine.add(c);
      }
    
    
      Stack StackOne = new Stack(theLine.size()); //creates two new stacks
      Stack StackTwo = new Stack(theLine.size()); 
    
      int e =  theLine.size()-1;
    
      for(int i = 0; i < theLine.size(); i++)//adds the arraylist to the stacks
      {   
         StackOne.push(theLine.get(i));
         StackTwo.push(theLine.get(e));
         
         e--;
      }
    
    
      while (!StackOne.isEmpty()) //compairs the stacks
      {
        if(StackOne.pop() != StackTwo.pop())
         return false;
               
      }
     
      return true;

    }  
  
}
//-----------------------------------------------------------------------------------------------------------

class Stack //standard stack class
{
   private int maxSize;
   private long[] stackArray;
   private int top;
   
   public Stack(int s) 
   {
      maxSize = s;
      stackArray = new long[maxSize];
      top = -1;
   }
   
   public void push(long j) 
   {
      stackArray[++top] = j;
   }
   
   public long pop() 
   {
      return stackArray[top--];
   }
   
   public long peek() 
   {
      return stackArray[top];
   }
   
   public boolean isEmpty() 
   {
      return (top == -1);
   }
   
   public boolean isFull() 
   {
      return (top == maxSize - 1);
   }
}