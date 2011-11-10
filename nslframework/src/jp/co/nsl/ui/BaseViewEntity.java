package jp.co.nsl.ui;

import android.graphics.Color;

public class BaseViewEntity {
	/**
	 * 背景色
	 */
	private int backgroundColor = Color.BLACK;
	/**
	 * パディング
	 */
	private int paddingLeft = 0;
	private int paddingTop=0;
	private int paddingRight=0;
	private int paddingBottom=0;
	/**
	 * マージン
	 * @return
	 */
	private int marginLeft = 0;
	private int marginTop=0;
	private int marginRight=0;
	private int marginBottom=0;


	private int width = -2;
	private int hight = -2;

	/**
	 * TextViewの幅を設定します。
	 * @param TextViewの幅
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * TextViewの幅を返します。
	 * @return　TextViewの幅
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * TextViewの高さを設定します。
	 * @param TextViewの高さ
	 */
	public void setHight(int hight) {
		this.hight = hight;
	}

	/**
	 * TextViewの高さを返します、
	 * @return　TextViewの高さ
	 */
	public int getHight() {
		return hight;
	}

	public void setMargin(int left,int top,int right,int bottom){
		marginLeft = left;
		marginTop=top;
		marginRight=right;
		marginBottom=bottom;
	}

	public int getMarginLeft(){
		return marginLeft;
	}
	public int getMarginTop(){
		return marginTop;
	}
	public int getMarginRight(){
		return marginRight;
	}
	public int getMarginBottom(){
		return marginBottom;
	}

	public void setPadding(int left,int top,int right,int bottom){
		paddingLeft = left;
		paddingTop=top;
		paddingRight=right;
		paddingBottom=bottom;
	}
	public int getPaddingLeft(){
		return paddingLeft;
	}
	public int getPaddingTop(){
		return paddingTop;
	}
	public int getPaddingRight(){
		return paddingRight;
	}
	public int getPaddingBottom(){
		return paddingBottom;
	}

	/**
	 * 背景色
	 * @param backgroundColor the 背景色 to set
	 */
	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * 背景色
	 * @return the 背景色
	 */
	public int getBackgroundColor() {
		return backgroundColor;
	}


}
