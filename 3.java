import javax.swing.JOptionPane;
//An interface used to compare two objects.
//Must implement method compareTo()
import java.lang.Comparable;

/**
 * SHOWS HOW TO PUT SEVERAL CLASSES IN ONE FILE. Ask user for numerator & denominator, output fraction
 * addition & subtraction using the Fraction class
 *
 * @author William McDaniel Albritton
 */

// when we put multiple classes in one file,
// the class with the main method is "public"
public class FractionCalculatorInOneFile {

  /**
   * main() method: begins program
   *
   * @param arguments is not used
   */
  public static void main(String[] arguments) {
    // Create two Default Fraction object
    // If A Class Implements an Interface,
    // Then We Can Use The Interface To Declare A Variable.
    // Syntax: InterfaceName variableName = new Constructor(parameters);
    FractionInterface fraction1 = new Fraction(0, 1);
    FractionInterface fraction2 = new Fraction(0, 1);
    FractionInterface fraction3 = new Fraction(0, 1);
    // get user input
    String number1 = JOptionPane.showInputDialog("Please enter the numerator");
    String number2 = JOptionPane.showInputDialog("Please enter the denominator");
    String number3 = JOptionPane.showInputDialog("Please enter the 2nd numerator");
    String number4 = JOptionPane.showInputDialog("Please enter the 2nd denominator");
    try {
      // Convert String To Integer.
      Integer numerator = Integer.parseInt(number1);
      Integer denominator = Integer.parseInt(number2);
      // Set first Fraction object
      fraction1.setNumerator(numerator);
      fraction1.setDenominator(denominator);
      // Convert String To Integer.
      numerator = Integer.parseInt(number3);
      denominator = Integer.parseInt(number4);
      // Set second Fraction object
      fraction2.setNumerator(numerator);
      fraction2.setDenominator(denominator);
      // calculate addition
      fraction3 = fraction1.add(fraction2);
      String message = fraction1.toString() + " + " + fraction2.toString() + " = "
          + fraction3.toString();
      // calculate subtraction
      fraction3 = fraction1.subtract(fraction2);
      message = message + "\n" + fraction1.toString() + " - " + fraction2.toString() + " = "
          + fraction3.toString();
      // multiply
      fraction3 = fraction1.multiply(fraction2);
      message = message + "\n" + fraction1.toString() + " * " + fraction2.toString() + " = "
          + fraction3.toString();
      // divide
      fraction3 = fraction1.divide(fraction2);
      message = message + "\n" + fraction1.toString() + " / " + fraction2.toString() + " = "
          + fraction3.toString();
      JOptionPane.showMessageDialog(null, message);
    }
    // if user does not enter an integer
    catch (NumberFormatException exception1) {
      JOptionPane.showMessageDialog(null, "Please enter a whole number.");
    }// end of catch
     // if user enters 0 for the denominator
    catch (IllegalFractionException exception2) {
      String message = exception2.toString();
      JOptionPane.showMessageDialog(null, message);
    }// end of catch

    // will not compile because method greatestCommonDivisor() is "private"
    // Fraction f = new Fraction(1,2);
    // f.greatestCommonDivisor(1,2);

  }// End of Main.

}// End of Class.

// *********************************************************************
/**
 * Interface is a list of method prototypes that other classes must implement (like a contract)
 *
 * @author William McDaniel Albritton
 */

// for multiple classes & interfaces in one file,
// interfaces MUST NOT have a "public" modifier
interface FractionInterface {

  /**
   * This Adds Two Fractions Together.
   *
   * @param fraction2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Result
   */
  public FractionInterface add(FractionInterface fraction2);

  /**
   * This Subtracts Two Fractions Together.
   *
   * @param fraction2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Result
   */
  public FractionInterface subtract(FractionInterface fraction2);

  /**
   * This Multiplies Two Fractions .
   *
   * @param fraction2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Product
   */
  public FractionInterface multiply(FractionInterface fraction2);

  /**
   * This Divides Two Fractions .
   *
   * @param fraction2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Quotient
   */
  public FractionInterface divide(FractionInterface fraction2);

  /** This method reduces a fraction to its lowest terms. */
  public void reduceToLowestTerms();

  /**
   * This Is An "Accessor" Method - Used To Get A Data Field.
   *
   * @return the numerator
   */
  public Integer getNumerator();

  /**
   * This Is An "Accessor" Method - Used To Get A Data Field.
   *
   * @return the denominator
   */
  public Integer getDenominator();

  /**
   * This Is A "Mutator" Method - Used To Set A Data Field.
   *
   * @param numeratorParameter is the first name.
   */
  public void setNumerator(Integer numeratorParameter);

  /**
   * This Is A "Mutator" Method - Used To Set A Data Field.
   *
   * @param lastNameParameter is the last name.
   * @exception IllegalFractionException if the denominator is zero
   */
  public void setDenominator(Integer denominatorParameter) throws IllegalFractionException;

}// End of interface.

// *********************************************************************

/**
 * Implements the "FractionInterface" Interface. Syntax: public class ClassName implements
 * InterfaceName{
 *
 * @author William McDaniel Albritton
 */
class Fraction implements FractionInterface, Comparable {

  // These Are The Data Fields.
  // Used to STore EACH Object's Data.
  // Syntax: private ClassName variableName;
  // Usually I go ahead and initialize the data field here.
  // This prevents a NullPointerException later on.
  private Integer numerator = new Integer(0);
  private Integer denominator = new Integer(1);

  /**
   * Constructor - Used To Create EAch Object & Initialize DAta Fields.
   *
   * @param numeratorParameter is the Fraction's Numerator.
   * @param denominatorParameter is the Fraction's Denominator.
   * @exception IllegalFractionException if the denominator is zero
   */
  public Fraction(Integer numeratorParameter, Integer denominatorParameter)
      throws IllegalFractionException {
    // This Code Initializes The Data Fields.
    // Syntax: dataField = parameter;
    numerator = numeratorParameter;
    denominator = denominatorParameter;
    if (denominator.equals(0)) {
      throw new IllegalFractionException("Cannot have 0 as the denominator!");
    }
  }

  /**
   * Used to Display The Data Stored In EAch Object's DAta Field.
   *
   * @return a Fraction in format: numerator / denominator
   */
  public String toString() {
    // Create a Local VAriable.
    String fractionString = numerator + " / " + denominator;
    // Return the Local Variable.
    return fractionString;
  }

  /**
   * This Adds Two Fractions.
   *
   * @param f2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Result
   */
  public FractionInterface add(FractionInterface f2) {
    // Get the Numbertor & Denominator Of f2.
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    // Cross Multiply & Add to Get Numerator.
    Integer numerator3 = numerator * denominator2 + numerator2 * denominator;
    // Multiply Both denominators.
    Integer denominator3 = denominator * denominator2;
    // Create (instantiate) new Fraction and reduce to lowest terms
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  /**
   * This Subtracts Two Fractions.
   *
   * @param f2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Result
   */
  public FractionInterface subtract(FractionInterface f2) {
    // Get the Numbertor & Denominator Of f2.
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    // Cross Multiply & Subtract to Get Numerator.
    Integer numerator3 = numerator * denominator2 - numerator2 * denominator;
    // Multiply Both denominators.
    Integer denominator3 = denominator * denominator2;
    // Create (instantiate) new Fraction and reduce to lowest terms
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  /**
   * This Multiplies Two Fractions.
   *
   * @param f2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Product
   */
  public FractionInterface multiply(FractionInterface f2) {
    // Get the Numbertor & Denominator Of f2.
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    // Multiply Numerators.
    Integer numerator3 = numerator * numerator2;
    // Multiply denominators.
    Integer denominator3 = denominator * denominator2;
    // Create (instantiate) new Fraction and reduce to lowest terms
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  /**
   * This Divides Two Fractions.
   *
   * @param f2 Is The 2nd Fraction.
   * @return a 3rd Fraction The Is The Quotient
   */
  public FractionInterface divide(FractionInterface f2) {
    // Get the Numbertor & Denominator Of f2.
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    // Multiply num1 * den2.
    Integer numerator3 = numerator * denominator2;
    // Multiply den1 * num2.
    Integer denominator3 = denominator * numerator2;
    // Create (instantiate) new Fraction and reduce to lowest terms
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  /** This method reduces a fraction to its lowest terms. */
  public void reduceToLowestTerms() {
    // determine the greatest common divisor
    Integer gcd = this.greatestCommonDivisor(numerator, denominator);
    // if GCD is negative, change to positive
    if (gcd < 0) {
      gcd = -gcd;
    }
    // divide gcd into both numerator and denominator
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

  /**
   * Euclid's algorithm from 200 BCE, which determines the greatest common divisior of two numbers.
   *
   * @param a is the first number.
   * @param b is the second number.
   * @return the gcd of the two numbers
   */
  private Integer greatestCommonDivisor(Integer a, Integer b) {
    // "private"
    // % is modulus which is the remainder of a division
    // base case
    if ((a % b) == 0) {
      return b;
    }
    // recursive case
    else {
      return greatestCommonDivisor(b, a % b);
    }
  }

  /**
   * This Is An "Accessor" Method - Used To Get A Data Field.
   *
   * @return the numerator
   */
  public Integer getNumerator() {
    // Return the Data Field.
    return numerator;
  }

  /**
   * This Is An "Accessor" Method - Used To Get A Data Field.
   *
   * @return the denominator
   */
  public Integer getDenominator() {
    // Return the Data Field.
    return denominator;
  }

  /**
   * This Is A "Mutator" Method - Used To Set A Data Field.
   *
   * @param numeratorParameter is the first name.
   */
  public void setNumerator(Integer numeratorParameter) {
    // SEt the Data Field.
    numerator = numeratorParameter;
  }

  /**
   * This Is A "Mutator" Method - Used To Set A Data Field.
   *
   * @param lastNameParameter is the last name.
   * @exception IllegalFractionException if the denominator is zero
   */
  public void setDenominator(Integer denominatorParameter) throws IllegalFractionException {
    // set the Data Field.
    denominator = denominatorParameter;
    if (denominator == 0) {
      throw new IllegalFractionException("Cannot have a denominator that is zero!");
    }
  }// end of setDenominator()

  /**
   * Compares this object with the specified object for order. Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified object.
   *
   * @param object2 The 2nd Object to be compared.
   * @return A negative integer, zero, or a positive integer as this object is less than, equal to,
   *         or greater than the specified object.
   * @exception ClassCastException If the specified object's type prevents it from being compared to
   *            this Object.
   */
  public int compareTo(Object object2) throws ClassCastException {
    // The parameter should be a Fraction, so we will cast it,
    // so that the compiler will let us call Fraction methods
    Fraction fraction2 = (Fraction) object2;
    // cross multiply the two fractions,
    // so that denominator will be the same for both
    int numerator1 = numerator * fraction2.getDenominator();
    int numerator2 = fraction2.getNumerator() * denominator;
    // subtract to get the result
    // if numerator1 > numerator2, then will have positive integer
    // if numerator1 == numerator2, then will have zero (0)
    // if numerator1 < numerator2, then will have negative integer
    int result = numerator1 - numerator2;
    return result;
  }

}// End of Class.

// ******************************************************************

/**
 * An Exception for use with the Fraction class
 *
 * @author William McDaniel Albritton
 */

// note that "public" is omitted, so that we can put many classes in one file
class IllegalFractionException extends RuntimeException {

  /**
   * Constructor
   *
   * @param message Describes the cause of the error
   */
  public IllegalFractionException(String message) {
    super(message);
  }
}// end of class
