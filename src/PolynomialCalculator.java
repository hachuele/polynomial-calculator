// Name: Eric J. Hachuel
// USC loginid: hachuelb
// CS 455 PA2
// Fall 2016

//Import Statements

import java.util.Scanner;

public class PolynomialCalculator {
    
    
    /**
       Adds input terms to Polynomial object located at specified index of array.
     * @param commandIn The Scanner input command.
    */
    public static void runCreate(Scanner commandIn){
        
        System.out.println("Run Worked!");
        
        
    }
    
    
    /**
       Prints a specified Polynomial, providing index of Array (location of Polynomial).
     * @param commandIn The Scanner input command.
    */
    public static void runPrint(Scanner commandIn){
        
        
    }
    
    
    /**
    Adds specified Polynomials into provided index of Array (location of resulting Polynomial).
    @param commandIn The Scanner input command.
    */
    public static void runAdd(Scanner commandIn){
        
        System.out.println("Add Worked!");
    }
    
    
    /**
    Evaluates provided Polynomial (index) with given floating-point x value.
    @param commandIn The Scanner input command.
    */
    public static void runEval(Scanner commandIn){
        
        
    }
    
    
    /**
    Guides user through list of potential commands for the program.
    @param commandIn The Scanner input command.
    */
    public static void runHelp(Scanner commandIn){
        
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        //Initialize/Create array of Polynomials  
        Polynomial[] PolyArray = new Polynomial[10];
        
        
        //Initialize array of 10 polynomials to the zero polynomial
        for (int i = 0; i<PolyArray.length; i++){
            PolyArray[i] = new Polynomial(new Term(0,0));
        }
        
        //boolean variable quitProgram to exit program when command "quit" is entered
        boolean quitProgram = false;
        
        //Intro message directing users to the help command
        System.out.println("-----------------------------------------------------");
        System.out.println("Please enter the 'help' command for more information.");
        System.out.println("-----------------------------------------------------");
        System.out.println();        
        
        
        System.out.print("cmd> ");
        Scanner in = new Scanner(System.in);
        
        while(!quitProgram){
            
            while(in.hasNextLine()){
                
                //Store input line as a String
                String inputLine = in.nextLine();

                //Create new Scanner object to read String
                Scanner commandShell = new Scanner(inputLine);
                
                while(commandShell.hasNextLine()){

                    if(commandShell.next().equalsIgnoreCase("create")){runCreate(commandShell);}
                    else if(commandShell.next().equalsIgnoreCase("print")){runPrint(commandShell);}
                    else if(commandShell.next().equalsIgnoreCase("add")){runAdd(commandShell);}
                    else if(commandShell.next().equalsIgnoreCase("eval")){runEval(commandShell);}
                    else if(commandShell.next().equalsIgnoreCase("help")){runHelp(commandShell);}
                    else if(commandShell.next().equalsIgnoreCase("quit")){quitProgram = false;}
                    else{System.out.println("ERROR: Illegal command. Type 'help' for command options.");}

                    System.out.print("cmd> ");
                
                }
          
            }
        }
    }
}
