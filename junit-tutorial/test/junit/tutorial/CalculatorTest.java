package junit.tutorial;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


public class CalculatorTest {

	@Test
	public void multiplyで乗算結果が取得できる(){
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3,4);
		assertThat(actual, is(expected));
	}
}
