package jp.co.nsl.ui;

public class ButtonEntity extends BaseViewEntity {

	private String text="";

	/**
	 * テキストを設定します。
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * テキストを返します。
	 * @return
	 */
	public String getText() {
		return text;
	}
	
}
