package junit.tutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class CalculatorTest2 {
	@Test
	public void multiplyで３と４の乗算結果が取得できる(){
		Calculator2 calc = new Calculator2();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		assertThat(actual,is(expected));
	}
	@Test
	public void multiplyで５と７の乗算結果が取得出来る(){
		Calculator2 calc = new Calculator2();
		int expected = 35;
		int actual = calc.multiply(5, 7);
		assertThat(actual,is(expected));
	}
}
