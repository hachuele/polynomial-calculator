// Name: Eric J. Hachuel
// USC loginid: hachuelb
// CS 455 PA2
// Fall 2016

//Import Statement(s)
import java.util.ArrayList;

/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Polynomial {

    /**
       Default Polynomial Constructor.
       Creates the 0 polynomial. Creating ArrayList and adding the zero term.
    */
    public Polynomial() {
        
        termArr = new ArrayList<>();
        assert this.isValidPolynomial();
    }

    /**
       Creates polynomial with single term given. 
       Instantiates new ArrayList of Term objects and adds input terms into ArrayList.
       @param term the term to add to the Polynomial function.
     */
    public Polynomial(Term term) {
        
        termArr = new ArrayList<>();
        
        //Check if coefficient is zero. If so, do not add term to ArrayList.
        if(term.getCoeff()!=0){
            termArr.add(term);
        }
        
        //Assert statement for representation invariant validation. 
        assert this.isValidPolynomial();
    }


    /**
       Returns the Polynomial that is the sum of this polynomial and b
       (neither poly is modified)
     * @param b The polynomial to be added to the current (this) Polynomial instance.
     * @return Returns the sum of the two Polynomials added.
     */
    public Polynomial add(Polynomial b) {
        
        //Local variables
        
        int firstArrayLoc = 0; //Next element in this Polynomial
        int secondArrayLoc = 0; //Next element in b Polynomial
        Polynomial sumPoly = new Polynomial(); //Create Polynomial to add other two arrays
        
        //Loop until either array has been completely checked
        while (firstArrayLoc < this.termArr.size() && secondArrayLoc < b.termArr.size()){
        
        //Variables to shorten subsequent code
        Term firstpolyArr = this.termArr.get(firstArrayLoc);
        Term secondpolyArr = b.termArr.get(secondArrayLoc);
        
            //Checks if exponents are equal. If equal, check if coefficients cancel eachother.
            if(firstpolyArr.getExpon() == secondpolyArr.getExpon()){
                if(firstpolyArr.getCoeff() + secondpolyArr.getCoeff() == 0){firstArrayLoc++; secondArrayLoc++;}
                
                //If coefficients don't cancel eachother, add term with added coefficients to Polynomial.
                else{
                    sumPoly.termArr.add(new Term(firstpolyArr.getCoeff() + secondpolyArr.getCoeff(),secondpolyArr.getExpon()));
                    firstArrayLoc++;
                    secondArrayLoc++;
                }
            }
            
            //If exponents are not equal, add terms in decreasing order.
            else{
                if(firstpolyArr.getExpon() < secondpolyArr.getExpon()){
                    sumPoly.termArr.add(secondpolyArr); 
                    secondArrayLoc++;
                }
                
                else{ 
                    sumPoly.termArr.add(firstpolyArr);
                    firstArrayLoc++;
                }
            }
        }
        
        //Append remaining elements from either array at end of resulting Polynomial.
        while(firstArrayLoc < this.termArr.size()){
            sumPoly.termArr.add(this.termArr.get(firstArrayLoc));
            firstArrayLoc++;
        }
        
        while(secondArrayLoc < b.termArr.size()){
            sumPoly.termArr.add(b.termArr.get(secondArrayLoc));
            secondArrayLoc++;
        }
              
        //Assert statements testing representation invariants for Polynomial.
        assert this.isValidPolynomial();
        assert b.isValidPolynomial();
        assert sumPoly.isValidPolynomial();
        
	return sumPoly;  // returns resulting Polynomial.
    }


    /**
       Returns the value of the poly at a given value of x. 
     * @param x Given value of x to evaluate specific Polynomial.
     * @return Returns the total/calculated value of the Polynomial with the given x.
     */
    public double eval(double x) {
        
        double total = 0;
        
        for (int i=0; i<termArr.size(); i++){
            total += (termArr.get(i).getCoeff())*Math.pow(x,termArr.get(i).getExpon());
        }
	return total;         
    }


    /**
       Return a String version of the polynomial with the 
       following format, shown by example:
       zero poly:   "0.0"
       1-term poly: "3.2x^2"
       4-term poly: "3.0x^5 + -x^2 + x + -7.9"

       Polynomial is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
     * @return Returns a string version of the polynomial with proper formatting.
    */
    public String toFormattedString() {
        
        String output ="";
        if(!termArr.isEmpty()){
            for (int i = 0; i < termArr.size(); i++){
                
                 if(termArr.get(i).getExpon() == 0){output+= termArr.get(i).getCoeff();}
                 
                 else{
                     if(termArr.size() == 1 || (i == (termArr.size()-1)) ){
                     output+= (termArr.get(i).getCoeff() + "x^" + termArr.get(i).getExpon());
                    }
                     
                    else{output+= (termArr.get(i).getCoeff() + "x^" + termArr.get(i).getExpon()+ " + ");}
                }
            }
        }
        else {output+= "0.0";}
        
        return output;
    }

    
    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
       * @ return Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPolynomial() {
        
        //Checks for terms with zero-coefficient.
        for(int i = 0; i < termArr.size(); i++){
            if(termArr.get(i).getCoeff() == 0){return false;}
        }
        
        //Checks if exponents are in decreasing order. Also checks for exponents of equal value.
        for(int j = 0; j < termArr.size()-1; j++){
            if(termArr.get(j).getExpon() >= termArr.get(j+1).getExpon()){return false;}
        }
	return true;     
    }


    // **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)
    /*
        REPRESENTATION INVARIANTS:
        -For a non-zero Polynomial, all terms must be in decreasing order by exponent.
        -Polynomial must only store non-zero coefficient terms.
        -Polynomial must not have two or more terms with same exponent.
    */
    private ArrayList<Term> termArr;
    
}
