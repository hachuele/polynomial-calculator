# Polynomial Calculator

In this assignment, I implemented a polynomial class called Polynomial along with an interactive command-based program that uses the class. The program allows the user to create and manipulate several polynomials. The internal representation used for a polynomial is an `ArrayList` object. 

Some of the requirements for the program relate to efficiency, testing, and style/design, as well as functionality. 

## Program Details 

The polynomial class, Polynomial, will have floating point coefficients, and non-negative integer exponents. The class definition is in `Polinomial.java`. There is also a helper Term class defined in `Term.java`. A Term is used to hold the *(coefficient,exponent)* pair that makes up one term in a polynomial. 

The interface for Polynomial is described below using example calls and results: 

```java
//Create the zero polynomial. That is one all of whose coefficients have the value zero.
Polynomial poly1 = new Polynomial(); 

//Create a polynomial with a single term. For example, the above expression creates the polynomial 3x^5. 
Polynomial poly2 = new Polynomial(new Term(3,5));

//Add two polynomials, resulting in a new one that is the sum of the first two. The two original polynomials are unchanged.
Polynomial sum = poly1.add(poly2); 
//poly1: 3x^3 + 2x + 7
//poly2: x^5 -3x^3 + 5
//sum:   x^5 + 2x + 12

//Evaluate a polynomial for a specific floating point value of x. 
double result = poly1.eval(x); 
//poly1: 3x^3 + 2x + 7
//x: 2
//result: 35
```



