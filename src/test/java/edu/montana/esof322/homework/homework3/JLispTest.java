package edu.montana.esof322.homework.homework3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class JLispTest {

 	  /*====================================================================
    // Homework 3
    //
    // Included in this directory is a simple lisp implementation.  This
    // lisp implementation supports basic math, akin to what our reverse
    // polish notation calculator did.
    //
    // The intention with this lisp is to support simple, binary addition
    // in the form:
    //
    //  (+ 1 2)
    //
    //  or
    //
    //  (+ 1 (+ 2 3))
    //
    //
    // The `+` operator can take two and only two arguments, and must be
    // enclosed in parenthesis to be valid.
    //
    // This implementation is buggy. Your assignment is to create four (4)
    // tests showing *different* bugs within the simple language.
    //
    //====================================================================*/

	JLisp lisp = new JLisp();

	@Test
	// This is a sample test to help you get started
	public void exampleTest() {
		assertEquals(1, 2);
		fail("test didn't pass");
		assertEquals("Foo", "Bar");
	}

	@Test
	public void simpleInputTest() {

		Integer expected = new Integer(2);
		assertEquals(expected, lisp.eval("+ 1 1"));  	   	
	}

	@Test // Test with imbalanced parenthesis 
	public void testWithImbalancedClosingParanthesis() {

		try {
		Integer expected = new Integer(87);
		assertEquals(expected, lisp.eval("(+ 1 ( + 1 (+ 3 ( + 2 ( + 4  + 2  + 9  + 15  + 10  + 20 20 ) ) ) ) ) ) ) )"));
		fail("did not throw exception");
		}catch (Exception e) {
			//passed
		}
		
	}
	@Test //Null string Test 
	public void throwsIllegalArgumentExceptionWhenPassedNull(){

		try{ 
			lisp.eval(null); 
			fail("did not throw");
		}
		catch(IllegalArgumentException illegalArgumentException){
			//passes 
		}
		catch (Exception e) {
			fail("did not throw illegalArgumentException");
		}
	}
	
	
	@Test //Null string Test 
	public void shouldReturnZeroWhenPassedBlankString(){

		try{ 
			assertEquals(new Integer(0), lisp.eval("")); 
			
		}
		catch(Exception exception){
			//passes 
			fail("throwing exception");
		} 
	}
	
	
	@Test //value Test 
	public void shouldReturnValueWhenPassedDecimalString(){

		Random random = new Random();
		float floatValue = random.nextFloat();
		int expectedTotal = (int)(floatValue+floatValue);
		try{ 
			assertEquals(new Integer(expectedTotal), lisp.eval("+ "+floatValue+" "+floatValue)); 
			
		}
		catch(Exception exception){
			//passes 
			fail("throwing exception");
		} 
	}
	
	
	@Test //Negative number string Test 
	public void shouldReturnTotalWhenPassedNegativeIntegerValueString(){
		
		Random random = new Random();
		int firstValue = random.nextInt(10) -30;
		int secondValue = random.nextInt(10) -30;
		
		try{ 
			assertEquals(new Integer(firstValue+secondValue), lisp.eval("+ "+firstValue+" "+secondValue)); 
			
		}
		catch(Exception exception){
			//failed
			fail("throwing exception");
		} 
	}
	
}


