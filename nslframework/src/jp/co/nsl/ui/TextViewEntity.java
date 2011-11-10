package jp.co.nsl.ui;

import android.graphics.Color;

public class TextViewEntity extends BaseViewEntity{
	/**
	 * 文字
	 */
	private String text = "";
	/**
	 * 文字色
	 */
	private int textColor = Color.WHITE;
	/*
	 * 文字サイズ
	 */
	private float textSize = 12.0f;
	/*
	 * 文字位置
	 */
	private int gravity=0;



	/**
	 * 文字
	 * @param text the 文字 to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 文字
	 * @return the 文字
	 */
	public String getText() {
		return text;
	}

	/**
	 * 文字色
	 * @param textColor the 文字色 to set
	 */
	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	/**
	 * @return the 文字色
	 */
	public int getTextColor() {
		return textColor;
	}

	/**
	 * 文字サイズを設定します。
	 * @param 文字サイズ
	 */
	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	/**
	 * 文字サイズを返します。
	 * @return　文字サイズ
	 */
	public float getTextSize() {
		return textSize;
	}

	/**
	 * 文字位置を設定します。
	 * @param gravity 文字位置
	 */
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	/**
	 * 文字位置を返します。
	 * @return 文字位置
	 */
	public int getGravity() {
		return gravity;
	}


}
