package jp.co.nsl.ui;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

public class UIEditText extends EditText{
	//TextViewのエンティティ
	private EditTextEntity ete = null;

	public void setTextViewEntity(EditTextEntity et){
		ete = et;
	}
	/**
	 * コンストラクタ
	 */
	public UIEditText(Context context){
		super(context);
		ete = null;
	}
	/**
	 * コンストラクタ
	 * @param tv
	 */
	public UIEditText(Context context,EditTextEntity et){
		super(context);
		ete = et;
		setEditTextSetting();
	}
//	/**
//	 * EditTextを返します。
//	 * @param context
//	 * @return
//	 */
//	public EditText getEditText(Context context){
//		EditText et = new EditText(context);
//		//EditTextの詳細設定
//		setEditTextSetting(et);
//		return et;
//	}
//	public EditText getEditText(Context context,EditTextEntity ete){
//		EditText et = new EditText(context);
//		this.ete = ete;
//		//EditTextの詳細設定
//		setEditTextSetting(et);
//		return et;
//	}
	/**
	 * 
	 * @param ete
	 */
	public void setEditTextSetting(EditTextEntity ete){
		this.ete = ete;
		setEditTextSetting();
	}
	/**
	 * 
	 */
	private void setEditTextSetting(){
		//テキストサイズ
		if (ete.getTextSize() > 0.0f){
			//サイズ指定があれば
			this.setTextSize(ete.getTextSize());
		}
		//背景色
		this.setBackgroundColor(ete.getBackgroundColor());
		//文字位置
		this.setGravity(ete.getGravity());
		//文字
		this.setText(ete.getText());
		//文字色
		this.setTextColor(ete.getTextColor());
        //幅、高さ
        LinearLayout.LayoutParams layoutParams = 
            new LinearLayout.LayoutParams(
            		ete.getWidth(), 
            		ete.getHight());
        //マージン
        layoutParams.setMargins(ete.getMarginLeft(), 
        						ete.getMarginTop(), 
        						ete.getMarginRight(), 
        						ete.getMarginBottom());
        this.setLayoutParams(layoutParams);
        
        //パディング
        this.setPadding(ete.getPaddingLeft(), 
        			  ete.getPaddingTop(), 
        			  ete.getPaddingRight(), 
        			  ete.getPaddingBottom());

        this.setBackgroundColor(ete.getBackgroundColor());

        //入力タイプ
        this.setInputType(ete.getInputType());
	}
}
