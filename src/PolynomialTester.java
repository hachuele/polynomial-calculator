// Name: Eric J. Hachuel
// CS 455 PA2
// Fall 2016

//Import statement(s)
import java.util.ArrayList;


public class PolynomialTester {
   
    
    public static void main(String[] args) {
        
   
        //Test empty polynomial
        Polynomial p1 = new Polynomial();
        
        //Test polynomial with 0 term
        Polynomial p2 = new Polynomial(new Term());
        
        //Test polynomial with 0 term input
        Polynomial p3 = new Polynomial(new Term(0,0));
        
        //Test polynomial with 1 term input - 0 exponent
        Polynomial p4 = new Polynomial(new Term(7,0)); //Expected 7.0
        
        //Test polynomial with 1 term input - 0 coeff
        Polynomial p5 = new Polynomial(new Term(0,3));
        
        //Test polynomial with 1 term input -correct
        Polynomial p6 = new Polynomial(new Term(2,3)); //2x^3
        
        //Test polynomial with 2 term input -correct
        Polynomial p7 = new Polynomial(new Term(2,3)).add(new Polynomial(new Term(6,8))); //6x^8 + 2x^3
        
        //Test add with polynomials that cancel eachother
        Polynomial p8 = new Polynomial(new Term(2,3)).add(new Polynomial(new Term(-2,3))); //0.0
        
        //Test sam exponent diff coeff
        Polynomial p9 = new Polynomial(new Term(2,3)).add(new Polynomial(new Term(-5,3))); //-3x^3
        
        //Test polynomial with 1 negative term input - 0 exponent
        Polynomial p10 = new Polynomial(new Term(-87,0)); //Expected -87.0
        
        //Test polynomial with 2 term input -correct
        Polynomial p11 = new Polynomial(new Term(6,8)).add(new Polynomial(new Term(7,1))); //7x^9 + 6x^8
        
        //Test 3 term polynomial
        Polynomial p12 = p11.add(new Polynomial(new Term(6,7)));
        
        //Test 3 term polynomial
        Polynomial p13 = p7.add(new Polynomial(new Term(-1,1)).add(new Polynomial(new Term(8,0))));
        
        //Test 3 term polynomial
        Polynomial p14 = (new Polynomial(new Term(-6,1)).add(new Polynomial(new Term(-1,9))).add(new Polynomial(new Term(1,5))));
        
        //Test polynomial with coeff = 1
        Polynomial p15 = new Polynomial(new Term(1,1));
        
        //Test polynomial with coeff = -1
        Polynomial p16 = new Polynomial(new Term(-1,1));
        
        //Eval tests
        double resultp7 = p7.eval(2); //Expected 1552
        double resultp9 = p9.eval(50); //Expected -24
        double resultp13 = p13.eval(1); //Expected 13
        
        //Print Statements
        System.out.println("p1:" + p1.toFormattedString());
        System.out.println("p2:" +p2.toFormattedString());
        System.out.println("p3:" +p3.toFormattedString());
        System.out.println("p4:" +p4.toFormattedString());
        System.out.println("p5:" +p5.toFormattedString());
        System.out.println("p6:" +p6.toFormattedString());
        System.out.println("p7:" +p7.toFormattedString());
        System.out.println("p8:" +p8.toFormattedString());
        System.out.println("p9:" +p9.toFormattedString()); 
        System.out.println("p10:" +p10.toFormattedString());
        System.out.println("p11:" +p11.toFormattedString());
        System.out.println("p12:" +p12.toFormattedString());
        System.out.println("p13:" +p13.toFormattedString());
        System.out.println("p14:" +p14.toFormattedString());
        System.out.println("p15:" +p15.toFormattedString());
        System.out.println("p16:" +p16.toFormattedString());
        System.out.println(resultp7);
        System.out.println(resultp9);
        System.out.println(resultp13);
    }
    
}
