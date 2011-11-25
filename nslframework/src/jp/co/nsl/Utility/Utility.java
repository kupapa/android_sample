package jp.co.nsl.Utility;

import java.text.DecimalFormat;

public class Utility {
    /**
     * Zero Padding
     * @param paddingNum
     * @param num
     * @return
     */
    public static String zeroPadding(int paddingNum, String num) {
   	StringBuffer sb = new StringBuffer();
   	String zero = "0";

   	for(int count=0; count < paddingNum;count++){
   		sb.append(zero);
    	}
   	DecimalFormat df = new DecimalFormat(sb.toString());
   	return df.format(Integer.parseInt(num));
	}
	
	public static boolean isNullEmpty(String value){
	
		if(value == null || value.trim().equals("")){
			return true;
		}else{
			return false;
		}	
	}
	public static String isNullStr(String value){
		
		if(value == null){
			return "";
		}else{
			return value;
		}
	}
	public static String inputConvZero(String value){
		String result = "";
		if (value==null){
			result = "0";
		}else{
			if (value.trim().length()==0){
				result = "0";
			}else{
				result = value.trim();
			}
		}
		return result;
	}	
}
