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

}
