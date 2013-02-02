package junit.tutorial;

public class Calculator2 {
	/**
	 * 引数で与えられた２つの値を掛け合わせた値を返す
	 * @param x　１つ目の引数
	 * @param y　２つ目の引数
	 * @return　xとyを掛け合わせた値
	 */
	public int multiply(int x,int y){
		return x * y;
	}
	public float divide(int x, int y){
		if(y==0) throw new IllegalArgumentException("devide by zero.");
		return (float)x / (float)y;
	}
}
