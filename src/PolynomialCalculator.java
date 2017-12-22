// Name: Eric J. Hachuel
// CS 455 PA2
// Fall 2016

//Import Statements

import java.util.Scanner;
import java.util.ArrayList;

/**
   A polynomial Calculator. 
   Serves as the command-based user interface for Polynomials that can be created, 
   added together, evaluated, and converted to a string form for printing.
*/
public class PolynomialCalculator {
    
    /**
    Adds input terms to Polynomial object located at specified index of array.
    @param commandIn The Scanner input command.
    @param inputArray The array of Polynomials.
    */
    public static void runCreate(Scanner commandIn, Polynomial[] inputArray){
        
        //boolean variable for negative exponent error checking
        boolean isNegativeExponent = false;
        
        //Integer to count amount of negative exponents submitted, if any.
        int negativeExpCount = 0;
        
        //Error check for no value entered after command
        if(!commandIn.hasNextInt()){System.out.println("Please enter a value for the Polynomial you wish to create.");}
        else{
            int polyIndex = commandIn.nextInt();

            //Error check for no invalid polynomail index.
            if(polyIndex <0 || polyIndex >= inputArray.length){
                System.out.println("Illegal index for a poly. must be between 0 and 9, inclusive");
            }

            else{
                System.out.println("Enter a space-separated sequence of coeff-pwer pairs terminated by <nl>");

                Scanner inputScanner = new Scanner(System.in);

                //Create polynomial to add terms to.
                Polynomial firstPoly = new Polynomial();

                //Create new ArrayList to store numbers
                ArrayList<Integer> arrayListInput = new ArrayList<>();

                //Store line of numbers as a String
                String lineInput = inputScanner.nextLine();

                //Create new Scanner object to read line of numbers as String
                Scanner InputlineScanner = new Scanner(lineInput);

                //While loop to read input string and add integers it to the ArrayList
                while (InputlineScanner.hasNextInt()) {arrayListInput.add(InputlineScanner.nextInt());}
                
                //Uses modulus for Error-checking too many arguments (ignores last argument if odd number).
                if(arrayListInput.size() % 2 == 0){
                    for(int i = 0; i < arrayListInput.size(); i = i+2){
                    Polynomial secondPoly = new Polynomial(new Term(arrayListInput.get(i),Math.abs(arrayListInput.get(i+1))));
                    
                    //Will count how many exponents have been submitted as negative values.
                    if(arrayListInput.get(i+1)<0){negativeExpCount++;isNegativeExponent = true;}

                    //Save the final Polynomial to the polynomial variable.
                    firstPoly = firstPoly.add(secondPoly);
                    }
                }

                else{
                    System.out.println("WARNING: You were missing the last exponent. Last value has been ignored.");
                    for(int i = 0; i < arrayListInput.size()-1; i = i+2){
                    Polynomial secondPoly = new Polynomial(new Term(arrayListInput.get(i),Math.abs(arrayListInput.get(i+1))));
                    
                    //Will count how many exponents have been submitted as negative values.
                    if(arrayListInput.get(i+1)<0){negativeExpCount++; isNegativeExponent = true;}
                    
                    //Save the final Polynomial to the polynomial variable.
                    firstPoly = firstPoly.add(secondPoly);
                    }
                }
                
                //Check if negative exponents were entered. If so, prompt WARNING message.
                if(isNegativeExponent){
                    System.out.println("WARNING: You have enterned " + negativeExpCount+ " negative exponent(s), the absolute value will be used.");
                }
                //Add the final Polynomial to the specified index.
                inputArray[polyIndex] = firstPoly;
            }
        }
    }

    /**
    Prints a specified Polynomial, providing index of Array (location of Polynomial).
    @param commandIn The Scanner input command.
    @param inputArray The array of Polynomials.
    */
    public static void runPrint(Scanner commandIn, Polynomial[] inputArray){
        
        //Error check for no value entered after command
        if(!commandIn.hasNextInt()){System.out.println("Please enter a value for the Polynomial you wish to print.");}
            else{
                int polyIndex = commandIn.nextInt();
                
                //Error check for no invalid polynomail index.
                if(polyIndex <0 || polyIndex >= inputArray.length){
                    System.out.println("Illegal index for a poly. must be between 0 and 9, inclusive");
                }
                else{
                    //Prints Polynomial at specified index.
                    System.out.println(inputArray[polyIndex].toFormattedString());
                }
            }
    }
    
    /**
    Adds specified Polynomials into provided index of Array (location of resulting Polynomial).
    @param commandIn The Scanner input command.
    @param inputArray The array of Polynomials.
    */
    public static void runAdd(Scanner commandIn, Polynomial[] inputArray){
        
        //Error check for no value entered after command
        if(!commandIn.hasNextInt()){System.out.println("Please enter a value for the Polynomial you wish to create or add to.");}
        else{
            //Create new ArrayList to store integers
            ArrayList<Integer> arrayListInputs = new ArrayList<>();

            //Store line of integers as a String
            String lineInput = commandIn.nextLine();

            //Create new Scanner object to read line of ints as String
            Scanner InputlineScanner = new Scanner(lineInput);

            //While loop to read input string and add integers it to the ArrayList
            while (InputlineScanner.hasNextInt()) {arrayListInputs.add(InputlineScanner.nextInt());}
            
            //Error Checking for index values
            //Error check for no invalid polynomail index.
            if(arrayListInputs.get(0) <0 || arrayListInputs.get(0) >= inputArray.length){
                System.out.println("Illegal index for main poly. must be between 0 and 9, inclusive");
            }
            else if(arrayListInputs.get(1) <0 || arrayListInputs.get(1) >= inputArray.length){
                System.out.println("Illegal index for first poly of addition. must be between 0 and 9, inclusive");
            }
            else if(arrayListInputs.get(2) <0 || arrayListInputs.get(2) >= inputArray.length){
                System.out.println("Illegal index for second poly of addition. must be between 0 and 9, inclusive");
            }
            
            else{
                //Run add method and store in index specified.
                inputArray[arrayListInputs.get(0)]= inputArray[arrayListInputs.get(1)].add(inputArray[arrayListInputs.get(2)]);
            }
        }
    }
    
    
    /**
    Evaluates provided Polynomial (index) with given floating-point x value.
    @param commandIn The Scanner input command.
    @param inputArray The array of Polynomials.
    */
    public static void runEval(Scanner commandIn, Polynomial[] inputArray){
        
        //Error check for no value entered after command
        if(!commandIn.hasNextInt()){System.out.println("Please enter a value for the Polynomial you wish to create.");}
        else{
            int polyIndex = commandIn.nextInt();

            //Error check for no invalid polynomail index.
            if(polyIndex <0 || polyIndex >= inputArray.length){
                System.out.println("Illegal index for a poly. must be between 0 and 9, inclusive");
            }
            
            else{
            //Prompt for a value of x to be used in the evaluation
            System.out.print("Enter a floating point value for x:");
            Scanner evalInputScanner = new Scanner(System.in);
            int evalInput = evalInputScanner.nextInt();

            //Print out the evaluated Polynomial at the specified index.
            System.out.println(inputArray[polyIndex].eval(evalInput));
            }
        }
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
        int POLY_ARRAY_LENGTH = 10;
        Polynomial[] polyArray = new Polynomial[POLY_ARRAY_LENGTH];
        
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
                    
                    //Reads input command and runs appropriate method.
                    if(commandInput.equalsIgnoreCase("create")){runCreate(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("print")){runPrint(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("add")){runAdd(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("eval")){runEval(commandShell, polyArray);}
                    else if(commandInput.equalsIgnoreCase("help")){runHelp();} 
                    else if(commandInput.equalsIgnoreCase("quit")){return;}
                    else{System.out.println("ERROR: Illegal command. Type 'help' for command options.");}
                    
                    //Print for next command.
                    System.out.print("cmd> ");
                }
            }
    }
}
