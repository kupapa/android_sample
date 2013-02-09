package junit.tutorial4;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AssertionTest {
	
	AssertionFail sut;
	
	@Before
	public void setup() throws Exception {
		sut = new AssertionFail();
	}
	
	/**
	 * リスト4.1
	 * assertThat---汎用的な値の比較検証
	 */
	@Test
	public void assertion(){
		String actual = "Hello" + " " + "World";
		assertThat(actual,is("Hello World"));
	}
	/**
	 * リスト4.2
	 * failメソッドによるテストの失敗
	 */
	@Test
	public void なにか難しいけど重要なテストケース(){
		fail("TODO テストコードを実装する");
	}
	/**
	 * リスト4.3
	 * 特定のステップが呼び出されると失敗となるテスト
	 */
	@Test(expected = IllegalStateException.class)
	public void timeoutがtrueのときにロジックが実行されないこと(){
		// Setup
		Runnable logic = new Runnable(){
			public void run(){
				fail("run が呼ばれてしまった");
			}
		};
		sut.timeOut = true;
		// Exerise
		sut.invoke(logic);
	}
}
