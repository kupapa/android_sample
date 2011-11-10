package jp.co.nsl.ui;

public class EditTextEntity extends TextViewEntity {

	/**
	 * 入力タイプ
	 */
	private int inputType =0;

	/**
	 * 入力タイプを設定します。
	 * @param inputType　入力タイプ
	 */
	public void setInputType(int inputType) {
		this.inputType = inputType;
	}

	/**
	 * 入力タイプを返します。
	 * @return　入力タイプ
	 */
	public int getInputType() {
		return inputType;
	}
	
	
}
