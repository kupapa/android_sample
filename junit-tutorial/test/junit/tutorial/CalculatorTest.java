package junit.tutorial;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


public class CalculatorTest {

	@Test
	public void multiplyで３と４の乗算結果が取得できる(){
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3,4);
		assertThat(actual, is(expected));
	}
	 @Test
	 public void multiplyで５と７の乗算結果が取得出来る(){
		 Calculator calc = new Calculator();
		 int expected = 35;
		 int actual = calc.multiply(5, 7);
		 assertThat(actual, is(expected));
	 }
	
	 @Test
	 public void divideで３と２の除算結果が取得出来る(){
		 Calculator calc = new Calculator();
		 float expected = 1.5f;
		 float actual = calc.divide(3, 2);
		 assertThat(actual, is(expected));
	 }
	 @Test(expected = IllegalArgumentException.class)
	 public void divideで５と０のときIllegalArgumentExceptionを送出する(){
		 Calculator calc = new Calculator();
		 calc.divide(5, 0);
	 }
	 
}
