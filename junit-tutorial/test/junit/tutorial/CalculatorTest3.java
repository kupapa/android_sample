package junit.tutorial;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CalculatorTest3 {
	//テスト対象クラス(TargetClass.java)
	public class TargetClass{
		
	}
	//テストクラス(TargetClassTest.java)
	public class TargetClaTest{
		
	}
//	@Test
//	public void isValidはuserNameとpawordが空でない場合にtrueを返す() throws Exception{
//		UserForm sut = new UserForm();
//		assertThat(sut.isValid(),is(true));
//	}
//	@Test
//	public void userNameが空のときにエラーメッセージが取得出来る()
//										throws Exception{
//		//期待値と実測値
//		UserForm sut = new UserForm("","1234");
//		String expected = "ユーザIDは必須項目です。";
//		String actual = sut.getErrorMessage();
//		assertThat(actual,is(expected));
//	}
	@Test
	public void addで要素を追加うるとサイズが１となりgetで取得出来る() throws Exception{
		//ArrayListdのaddメソッドのテスト
		ArrayList<String> sut = new ArrayList<String>();
		sut.add("Hello");
		assertThat(sut.size(),is(1));
		assertThat(sut.get(0),is("Hello"));
	}
	@Test
	public void 要素が２つ追加された状態で要素をremoveするとsizeが１となる() throws Exception{
		//Setup
		ArrayList<String> sut = new ArrayList<String>();
		sut.add("Hello");
		sut.add("World");
		//Exercise
		sut.remove(0);
		//Verify
		assertThat(sut.size(),is(1));
		assertThat(sut.get(0),is("World"));
		
	}
}
