// Name: Eric J. Hachuel
// USC loginid: hachuelb
// CS 455 PA2
// Fall 2016

//Import Statements

import java.util.Scanner;
import java.util.ArrayList;

public class PolynomialCalculator {
    
    /**
       Adds input terms to Polynomial object located at specified index of array.
     * @param commandIn The Scanner input command.
    */
    public static void runCreate(Scanner commandIn, Polynomial[] inputArray){
            
            if(!commandIn.hasNextInt()){System.out.println("Please enter a value for the Polynomial you wish to create.");}
            else{
                int polyIndex = commandIn.nextInt();
                if(polyIndex <0 || polyIndex >= inputArray.length){
                    System.out.println("Illegal index for a poly. must be between 0 and 9, inclusive");
                }

                else{
                    System.out.println("Enter a space-separated sequence of coeff-pwer pairs terminated by <nl>");

                    Scanner inputScanner = new Scanner(System.in);

                    //Create polynomial at provided input index and add terms to.
                    Polynomial firstPoly = new Polynomial();

                    //Create new ArrayList to store integers
                    ArrayList<Integer> arrayListInput = new ArrayList<>();

                    //Store line of integers as a String
                    String lineInput = inputScanner.nextLine();

                    //Create new Scanner object to read line of ints as String
                    Scanner InputlineScanner = new Scanner(lineInput);

                    //While loop to read input string and add integers it to the ArrayList
                    while (InputlineScanner.hasNextInt()) {
                        arrayListInput.add(InputlineScanner.nextInt());
                    }

                    if(arrayListInput.size() % 2 == 0){
                        for(int i = 0; i < arrayListInput.size(); i = i+2){
                        Polynomial secondPoly = new Polynomial(new Term(arrayListInput.get(i),arrayListInput.get(i+1)));
                        firstPoly = firstPoly.add(secondPoly);
                        }
                    }

                    else{
                        //WARNING
                        for(int i = 0; i < arrayListInput.size()-1; i = i+2){
                        Polynomial secondPoly = new Polynomial(new Term(arrayListInput.get(i),arrayListInput.get(i+1)));
                        firstPoly = firstPoly.add(secondPoly);
                        }
                        
                    }
                    inputArray[polyIndex] = firstPoly;
                    
                }
            }
    }

    
    
    /**
       Prints a specified Polynomial, providing index of Array (location of Polynomial).
     * @param commandIn The Scanner input command.
    */
    public static void runPrint(Scanner commandIn, Polynomial[] inputArray){
        
        
    }
    
    
    /**
    Adds specified Polynomials into provided index of Array (location of resulting Polynomial).
    @param commandIn The Scanner input command.
    */
    public static void runAdd(Scanner commandIn, Polynomial[] inputArray){
        
        System.out.println("Add Worked!");
    }
    
    
    /**
    Evaluates provided Polynomial (index) with given floating-point x value.
    @param commandIn The Scanner input command.
    */
    public static void runEval(Scanner commandIn, Polynomial[] inputArray){
        
        
    }
    
    
    /**
    Guides user through list of potential commands for the program.
    */
    public static void runHelp(){
        System.out.println("Welcome to the Polynomial Program! Please use any of the following commands:");
        System.out.println("-'create':Adds input terms to Polynomial object located at specified index of array. ");
        System.out.println("-'print':Prints a specified Polynomial, providing index of Array (location of Polynomial).");
        System.out.println("-'add':Adds specified Polynomials into provided index of Array (location of resulting Polynomial). ");
        System.out.println("-'eval':Evaluates provided Polynomial (index) with given floating-point x value. ");
        System.out.println("-'quit':End the program. ");
        System.out.println("-'help': The 'help' command prints the current list of commands.");
        System.out.println();
    }
    
    
    
    public static void main(String[] args) {
        
        //Initialize array of Polynomials
        int ARRAY_LENGTH = 10;
        Polynomial[] polyArray = new Polynomial[ARRAY_LENGTH];
        
        //Initialize array of 10 polynomials to the zero polynomial
        for (int i = 0; i<polyArray.length; i++){
            polyArray[i] = new Polynomial(new Term(0,0));
        }
        
        //Intro message directing users to the help command
        System.out.println("-----------------------------------------------------");
        System.out.println("Please enter the 'help' command for more information.");
        System.out.println("-----------------------------------------------------");
        System.out.println();        
        
        System.out.print("cmd> ");
        Scanner in = new Scanner(System.in);
            
            while(in.hasNextLine()){
                
                //Store input line as a String
                String inputLine = in.nextLine();

                //Create new Scanner object to read String
                Scanner commandShell = new Scanner(inputLine);
                
                while(commandShell.hasNext()){
                    
                    String commandInput = commandShell.next();
                    
                    if(commandInput.equalsIgnoreCase("create")){runCreate(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("print")){runPrint(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("add")){runAdd(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("eval")){runEval(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("help")){runHelp();} 
                    else if(commandInput.equalsIgnoreCase("quit")){return;}
                    else{System.out.println("ERROR: Illegal command. Type 'help' for command options.");}

                    System.out.print("cmd> ");
                }
          
            }
    }
}
