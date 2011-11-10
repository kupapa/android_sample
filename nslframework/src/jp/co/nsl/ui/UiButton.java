package jp.co.nsl.ui;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

public class UiButton extends Button{

	ButtonEntity _be = null;
	
	public void setButtonEntity(ButtonEntity be){
		_be = be;
	}
	/**
	 * コンストラクタ
	 * @param context
	 */
	public UiButton(Context context){
		super(context);
	}
	/**
	 * コンストラクタ
	 * @param context
	 * @param be
	 */
	public UiButton(Context context,ButtonEntity be){
		super(context);
		_be = be;
		setButtonSetting();
	}
	
	private void setButtonSetting(){
//		//幅
//		this.setWidth(_be.getWidth());
//		//高さ
//		this.setHeight(_be.getHight());
		//テキスト
		this.setText(_be.getText());
		//マージン
//		this.setPadding(_be.getMarginLeft(), 
//						_be.getMarginTop(), 
//						_be.getMarginRight(), 
//						_be.getMarginBottom());
		//パディング
		this.setPadding(_be.getPaddingLeft(), 
						_be.getPaddingTop(), 
						_be.getPaddingRight(), 
						_be.getPaddingBottom());
        //幅、高さ
        LinearLayout.LayoutParams layoutParams = 
					            new LinearLayout.LayoutParams(
					            		_be.getWidth(), 
					            		_be.getHight());
        //マージン
        layoutParams.setMargins(_be.getMarginLeft(), 
        						_be.getMarginTop(), 
        						_be.getMarginRight(), 
        						_be.getMarginBottom());
        
        this.setLayoutParams(layoutParams);

		
	}
	public void setButtonSetting(ButtonEntity be){
		_be = be;
		setButtonSetting();
	}
}
