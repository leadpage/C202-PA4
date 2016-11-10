/** Leah Belleville
	C202 Dr. H Tuesday Thursday
	10/25/16
	Program 4 - Implement a spell checker
	*/



import java.util.*;
import java.io.*;
import java.lang.*;



public class Program4{

static MyLinkedList[] list = new MyLinkedList[26];// list contains 26 null 

static long Compsfound = 0;
static long Wdfound = 0;
static long Compsnotfound = 0;
static long Wdnotfound = 0;







/** In the Main method is where we call the use of the other methods.*/


public static void main(String[] args){

	for(int i = 0; i < list.length; i++)
		list[i] = new MyLinkedList<String>();// each array element contains a new MyLinkedList


	readDictionary();
	System.out.println("...");

 	//System.out.println(list[1]);
 	comparingBookToDictionary();

 	double avgCompsfound = (double)(Compsfound / Wdfound);
 	System.out.println("The average is:" + avgCompsfound);

 	double avgNotFound =(double) (Compsnotfound / Wdnotfound);
 	System.out.println("The average of Compsnotfound and Wdnotfound is" + avgNotFound);


}// main
	
// In the readDictionary method we had to read in the file of dictionary words. I used the to.LowerCase to make sure all words were lowercase. 
public static void readDictionary(){
	try{
		File f = new File("random_dictionary.txt");
		Scanner input = new Scanner(f);
			while(input.hasNext()){
				String W2 = input.next();// takes the next word and puts it in to W2
				if(W2.charAt(0) < 97)
					W2 = W2.toLowerCase();// Java API Converts all letters to lowercase Saving the new lowercase string to W2

				list[W2.charAt(0) - 97].add(W2);




			}//while
			input.close();


	}//try

	catch(IOException e){
		System.out.println("The File is Unable to read");




	}//catch
	


	
}// readDictionary
// In this comparingBook method we are looking at the book and comparing the words to the dictionary. I used a string builder approach. I also made sure that any special characters were ignored and that we split the letters from those special characters. I made sure that all the letters were changed to lowercase.

public static void comparingBookToDictionary(){
	int [] counter = {0};
	
	try{

	File f = new File("oliver.txt");
	//System.out.println("here");

		Scanner input = new Scanner(f);
			String W2 = "";

			while(input.hasNext()){

				String line = input.nextLine().toLowerCase();
				String [] lineA = line.split(" ");


				StringBuilder sb = new StringBuilder();



				for(int i = 0; i < lineA.length; i++){
					for(int j = 0; j < lineA[i].length(); j++){

						if(Character.isLetter(lineA[i].charAt(j))){

							sb.append(lineA[i].charAt(j));

						}// if


					}//for
							String cleanWord = sb.toString();
						//list[cleanWord.charAt(0) - 97].contains(cleanWord);
							//System.out.println(cleanWord + " ");
						if(!cleanWord.isEmpty())
						
						if(list[cleanWord.charAt(0) - 97].contains(cleanWord, counter)){
							//System.out.println("The word " +cleanWord+" is correct");
								Wdfound++;
								Compsfound += counter[0];


						}// if
						else{
							//System.out.println("The word "+cleanWord+" is not correct");
							 Wdnotfound++;
							 Compsnotfound += counter[0];

						}//else

						sb.setLength(0);
						counter[0] = 0;

				}// for
				
		





			}//while
			 input.close();
			 System.out.println("The file was read Successfully");





	}//try

	catch(IOException e){
		System.out.println("Unable to read file");


	}// catch


}// comparingBook


}//class