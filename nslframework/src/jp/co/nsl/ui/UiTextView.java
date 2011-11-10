package jp.co.nsl.ui;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UiTextView extends TextView{

	//TextViewのエンティティ
	private TextViewEntity tve = null;
	
	public void setTextViewEntity(TextViewEntity tv){
		tve = tv;
	}
	/**
	 * コンストラクタ
	 */
	public UiTextView(Context context){
		super(context);
		tve = null;
	}
	/**
	 * コンストラクタ
	 * @param tv
	 */
	public UiTextView(Context context,TextViewEntity tv){
		super(context);
		tve = tv;
		setTextViewSetting();
	}
	
//	/**
//	 * 
//	 * @param context
//	 * @return
//	 */
//	public TextView getTextView(Context context){
//		TextView tv = new TextView(context);
//		//TextViewの詳細設定
//		setTextViewSetting(tv);
//		return tv;
//	}

//	public TextView getTextView(Context context,TextViewEntity tve){
//		TextView tv = new TextView(context);
//		this.tve = tve;
//		//TextViewの詳細設定
//		setTextViewSetting(tv);
//		return tv;
//	}

	public void setTextViewSetting(TextViewEntity tv){
		this.tve = tv;
	}
	/**
	 * 
	 */
	private void setTextViewSetting(){
		//テキストサイズ
		if (tve.getTextSize() > 0.0f){
			//サイズ指定があれば
			this.setTextSize(tve.getTextSize());
		}
		//背景色
		this.setBackgroundColor(tve.getBackgroundColor());

		//文字位置
		this.setGravity(tve.getGravity());
		//文字
		this.setText(tve.getText());
		//文字色
		this.setTextColor(tve.getTextColor());
        //幅、高さ
        LinearLayout.LayoutParams layoutParams = 
            new LinearLayout.LayoutParams(
            		tve.getWidth(), 
            		tve.getHight());
        //マージン
        layoutParams.setMargins(tve.getMarginLeft(), 
        						tve.getMarginTop(), 
        						tve.getMarginRight(), 
        						tve.getMarginBottom());
        this.setLayoutParams(layoutParams);
        
        //パディング
        this.setPadding(tve.getPaddingLeft(), 
        			  tve.getPaddingTop(), 
        			  tve.getPaddingRight(), 
        			  tve.getPaddingBottom());

        this.setBackgroundColor(tve.getBackgroundColor());
	}
}
