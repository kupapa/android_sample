package jp.co.nsl.Date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jp.co.nsl.Utility.Utility;
/**
 * 日付
 * @author oguri
 *
 */
public class NslDate {
	//**********************************************************************************************
	/** 
	* 指定した２つの日付間隔を返します。 
	* @param format 引数date1、date2の書式を指定します。yyyymmddまたはyyyy/mm/ddです。 
	* @param date1 算出対象日を指定します。 
	* @param date2 基準日を指定します。 
	* @return date1とdate2の間隔を日数で返します。 
	*/ 
	//**********************************************************************************************
	public static long getDateDiff(String format, String date1, String date2) { 
		String strDate1 = ""; 
		String strDate2 = ""; 
		Date dtDate1 = null; 
		Date dtDate2 = null; 
		long days = 0; 
		long time1 = 0; 
		long time2 = 0; 
	
	
		if (format.equals("yyyy/mm/dd")) { 
		strDate1 = date1 + " 00:00:00"; 
		 strDate2 = date2 + " 00:00:00"; 
		} else { 
		strDate1 = date1.substring( 0, 4) 
		+ "/" + date1.substring( 4, 6) 
		+ "/" + date1.substring( 6, 8) 
		+ " 00:00:00"; 
		strDate2 = date2.substring( 0, 4) 
		+ "/" + date2.substring( 4, 6) 
		+ "/" + date2.substring( 6, 8) 
		+ " 00:00:00"; 
		}
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
	
		try {
			dtDate1 = formatter.parse(strDate1);// 文字列 → 日付 
			dtDate2 = formatter.parse(strDate2);// 文字列 → 日付 
		} catch (ParseException e) { // 書式エラー 
			return days; 
		} catch (Exception e) { 
			return days; 
		} 
	
		time1 = dtDate1.getTime();// 1970 年 1 月 1 日 00:00:00 GMT からのミリ秒数を取得。 
		time2 = dtDate2.getTime();// 1970 年 1 月 1 日 00:00:00 GMT からのミリ秒数を取得。 
	
		// 差分計算 注：1日の秒数 = 1000 * 60 * 60 * 24 = 86400000) 
		days = (time2 - time1) / 86400000; 
	
		return days;
	}
	/**
	 * 指定した日付文字列（yyyy/MM/dd or yyyy-MM-dd）
	 * における月末日付を返します。
	 * 
	 * @param strDate 対象の日付文字列
	 * @return 月末日付
	 */
	public static int getLastDay(String strDate) {
	    if (strDate == null || strDate.length() != 10) {
	        throw new IllegalArgumentException(
	                "引数の文字列["+ strDate +"]" +
	                "は不正です。");
	    }
	    int yyyy = Integer.parseInt(strDate.substring(0,4));
	    int MM = Integer.parseInt(strDate.substring(5,7));
	    int dd = Integer.parseInt(strDate.substring(8,10));
	    Calendar cal = Calendar.getInstance();
	    cal.set(yyyy,MM-1,dd);
	    int last = cal.getActualMaximum(Calendar.DATE);
	    return last;
	}
	/**
	 * 月末を取得
	 * @param thisDate　指定日
	 * @param nextMonth　日付が月末と同じなら次月の月末を取得する
	 * @return 月末日(yyyy/MM/dd)
	 * @throws Exception
	 */
	public static String getLastDate(String thisDate,
							  boolean nextMonth) throws Exception{
		try{
			String result = "";
		    int yyyy = Integer.parseInt(thisDate.substring(0,4));
		    int MM = Integer.parseInt(thisDate.substring(5,7));
		    int dd = Integer.parseInt(thisDate.substring(8,10));
		    Calendar cal = Calendar.getInstance();
		    cal.set(yyyy,MM-1,dd);
			int lastdd = cal.getActualMaximum(Calendar.DATE);
			
			String lastDate = String.valueOf(yyyy) 
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(MM) )
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(lastdd));
			
			if (thisDate.equals(lastDate)){
				if (nextMonth){
					Calendar nextDate = add(cal, 0, 1, 0, 0, 0, 0, 0);
					result = String.valueOf(nextDate.YEAR)
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(nextDate.MONTH+1))
							+ "/"
							+ Utility.zeroPadding(2, String.valueOf(nextDate.DATE));
				}else{
					result = lastDate;
				}
			}else{
				result = lastDate;
			}
			return result;
		}catch(Exception e){
			throw e;
		}
		
	}
	/**
	 * 締め日を取得
	 * @param thisDate　指定日付
	 * @param shimebi　締め日
	 * @param nextMonth　日付が締め日と同じなら次月の締め日を取得する
	 * @return　締め日(yyyy/MM/dd)
	 * @throws Exception
	 */
	public static String getShimeDate(String thisDate,
								int shimebi,
								boolean nextMonth) throws Exception{
		String tDate = thisDate;
		String shimeDate = ""; 

		try{
			String result = "";
		    int yyyy = Integer.parseInt(thisDate.substring(0,4));
		    int MM = Integer.parseInt(thisDate.substring(5,7));
		    int dd = Integer.parseInt(thisDate.substring(8,10));
		    Calendar cal = Calendar.getInstance();
		    cal.set(yyyy,MM-1,dd);
			
		    shimeDate = String.valueOf(yyyy) 
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(MM)) 
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(shimebi));
			
			if (thisDate.equals(shimeDate)){
				if (nextMonth){
					Calendar nextDate = add(cal, 0, 1, 0, 0, 0, 0, 0);
					result = String.valueOf(nextDate.YEAR)
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(nextDate.MONTH+1))
							+ "/"
							+ Utility.zeroPadding(2, String.valueOf(nextDate.DATE));
				}else{
					result = shimeDate;
				}
			}else{
				int thisDt = Integer.parseInt(thisDate.replace("/", ""));
				int shimeDt = Integer.parseInt(shimeDate.replace("/", ""));
				if (thisDt >= shimeDt){
					Calendar nextDate = add(cal, 0, 1, 0, 0, 0, 0, 0);
					result = String.valueOf(nextDate.YEAR)
							+ "/" 
							+ Utility.zeroPadding(2,String.valueOf(nextDate.MONTH+1))
							+ "/"
							+ Utility.zeroPadding(2, String.valueOf(nextDate.DATE));
				}else{
					result = shimeDate;
				}
			}
			return result;
		}catch(Exception e){
			throw e;
		}
		
	}
	/**
	 * 日付の加減算
	 * @param thisDate
	 * @param addYyyy
	 * @param addMM
	 * @param addDd
	 * @return
	 */
	public static String getAddDate(String thisDate,int addYyyy,int addMM,int addDd){
		String result = "";
		try{
			Calendar cal = Calendar.getInstance();
		    int yyyy = Integer.parseInt(thisDate.substring(0,4));
		    int MM = Integer.parseInt(thisDate.substring(5,7));
		    int dd = Integer.parseInt(thisDate.substring(8,10));
		    cal.set(yyyy,MM-1,dd);
		    
		    Calendar nextDate = add(cal, addYyyy, addMM, addDd, 0, 0, 0, 0);
		    
			result = String.valueOf(nextDate.YEAR)
					+ "/" 
					+ Utility.zeroPadding(2,String.valueOf(nextDate.MONTH+1))
					+ "/"
					+ Utility.zeroPadding(2, String.valueOf(nextDate.DATE));

		}catch(Exception e){
			result = thisDate;
		}finally{
			
		}
		return result;
	}
	/**
	 * 締め日の日付を返す
	 * @param matsuShime
	 * @param shiteibiShime
	 * @param shimeShiteibi
	 * @return
	 */
	public static String getShimeHiduke(boolean matsuShime,
									 boolean shiteibiShime,
									 String shimeShiteibi){
		String result = "";
		try{
			String thisDate = getNowYear() 
							+ "/"
							+ Utility.zeroPadding(2,getNowMonth())
							+"/"
							+ Utility.zeroPadding(2,getNowDate());
			String shimebi = "";
			if (matsuShime){
				//末締め
				shimebi = getLastDate(thisDate, true);
				//日付取得
				result = shimebi;
			}else{
				//末締め以外
	        	if (shiteibiShime){
	        		if (!shimeShiteibi.equals("0")){
	        			try {
							shimebi = NslDate.getShimeDate(thisDate, Integer.parseInt(shimeShiteibi), true);
							//日付取得
							result = shimebi;
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		}else{
	        			shimebi = getLastDate(thisDate, true);
						//日付取得
						result = shimebi;
	        			
	        		}
	        	}else{
	        		shimebi = getLastDate(thisDate, true);
					//日付取得
					result = shimebi;
	        	}

			}
		}catch(Exception e){
			
		}
		return result;
		
	}

	public static String getShimeHiduke(String ym,
										boolean matsuShime,
										boolean shiteibiShime,
										String shimeShiteibi){
		String result = "";
		try{
		String thisDate = getNowYear() 
			+ "/"
			+ Utility.zeroPadding(2,getNowMonth())
			+"/"
			+ Utility.zeroPadding(2,getNowDate());
		String shimebi = "";
		if (matsuShime){
		//末締め
		shimebi = getLastDate(thisDate, true);
		//日付取得
		result = shimebi;
		}else{
		//末締め以外
		if (shiteibiShime){
		if (!shimeShiteibi.equals("0")){
		try {
			shimebi = NslDate.getShimeDate(thisDate, Integer.parseInt(shimeShiteibi), true);
			//日付取得
			result = shimebi;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
		shimebi = getLastDate(thisDate, true);
		//日付取得
		result = shimebi;
		
		}
		}else{
		shimebi = getLastDate(thisDate, true);
		//日付取得
		result = shimebi;
		}
		
		}
		}catch(Exception e){
		
		}
		return result;
	
	}
	/**
	 * 日付文字列をタイムスタッンプに変換する
	 * @param dateVal　日付（yyyy/MM/dd）
	 * @return
	 */
	public static String cnvStrToTimestamp(String dateVal){
		Timestamp object = null;
		try {
			object = new Timestamp(new SimpleDateFormat("yyyy/MM/dd").parse(dateVal).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(object.getTime());
	}
	/**
	 * timestampを日付文字列に変換する
	 * @param time
	 * @return
	 */
	public static String cnvTimestampToStr(String time){
		try{
			String formatStr = "yyyy/MM/dd";
			Timestamp ts = null;
			ts = new Timestamp(Long.parseLong(time));
			Date dt = null;
			dt = new Date(ts.getTime());
			
			SimpleDateFormat sdf1 = new SimpleDateFormat(formatStr);
			return sdf1.format(dt);
			
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 指定月の最初の日を返す
	 * @param ym
	 * @return 指定月の最初の日のタイムスタンプ
	 */
	public static String getMonthFirst(String ym){
		String result = "";
		try{
			result = ym.substring(0,4) + "/" + ym.substring(4,6) + "/01";
			return cnvStrToTimestamp(result);
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 指定月の最終日を返す
	 * @param ym
	 * @return　指定月の最終日のタイムスタンプ
	 */
	public static String getMonthLast(String ym){
		String result = "";
		try{
			Date dt ;
			int y = 0; 
			int m = 0;
			int d = 0;
			String wkDate = "";

			result = ym.substring(0,4) + "/" + ym.substring(4,6) + "/01";
			dt = _string2date(result);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);

			cal.add(Calendar.MONTH, 1);
			cal.add(Calendar.DAY_OF_MONTH, -1);

			y = cal.get(cal.YEAR);
			m = cal.get(cal.MONTH)+1;
			d = cal.get(cal.DATE);
			
			wkDate = y + "/" + m + "/" + d;
			
			return cnvStrToTimestamp(wkDate);
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 現在日付をタイムスタンプで返す
	 * @return　タイムスタンプ
	 */
	public static String getNowTimestamp(){
		String result = "";
		try{
	        final Calendar cal = Calendar.getInstance();
	        int mYear = cal.get(Calendar.YEAR);
	        int mMonth = cal.get(Calendar.MONTH);
	        int mDay = cal.get(Calendar.DAY_OF_MONTH);
	        String sDate = String.valueOf(mYear) + 
			            "/" + Utility.zeroPadding(2, String.valueOf(mMonth + 1)) + 
			            "/" + Utility.zeroPadding(2,String.valueOf(mDay));
            return cnvStrToTimestamp(sDate);
		}catch(Exception e){
			
		}
		return result;
	}
	/**
	 * 現在年を返す
	 * @return 現在年を返す
	 */
	public static String getNowYear(){
		try{
			final Calendar cal = Calendar.getInstance();
			int y = cal.get(Calendar.YEAR);
			
			return String.valueOf(y);
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 現在月を返す
	 * @return　現在月を返す
	 */
	public static String getNowMonth(){
		try{
			final Calendar cal = Calendar.getInstance();
			int m = cal.get(Calendar.MONTH) +1;
			
			return String.valueOf(m);
			
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 現在日を返す
	 * @return　現在日を返す
	 */
	public static String getNowDate(){
		try{
			final Calendar cal = Calendar.getInstance();
			int d = cal.get(Calendar.DATE);
			
			return String.valueOf(d);
			
		}catch(Exception e){
			return "";
		}
	}
	/**
	 * 日付文字列を日付型へ
	 * @param value
	 * @return
	 */
     private static Date _string2date(String value) {  
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
        try {  
        	return (Date) sdf.parse(value);       
       } catch (ParseException e) {  
            return null;  
        }  
     }  
     /**
      * 現在の日付・時刻から指定の【年数】を加算・減算した結果を返します。
      * @param addYera 加算・減算する年数
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addYera(int addYera){
         return add(null,addYera,0,0,0,0,0,0);
     }
     /**
      * 現在の日付・時刻から指定の【月数】を加算・減算した結果を返します。
      * @param addMonth 加算・減算する月数
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addMonth(int addMonth){
         return add(null,0,addMonth,0,0,0,0,0);
     }
     /**
      * 現在の日付・時刻から指定の【日数】を加算・減算した結果を返します。
      * @param addDate 加算・減算する日数
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addDate(int addDate){
         return add(null,0,0,addDate,0,0,0,0);
     }
     /**
      * 現在の日付・時刻から指定の【時間】を加算・減算した結果を返します。
      * @param addHour 加算・減算する時間
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addHour(int addHour){
         return add(null,0,0,0,addHour,0,0,0);
     }
     /**
      * 現在の日付・時刻から指定の【分】を加算・減算した結果を返します。
      * @param addMinute 加算・減算する分
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addMinute(int addMinute){
         return add(null,0,0,0,0,addMinute,0,0);
     }
     /**
      * 現在の日付・時刻から指定の【秒】を加算・減算した結果を返します。
      * @param addSecond 加算・減算する秒
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar addSecond(int addSecond){
         return add(null,0,0,0,0,0,addSecond,0);
     }
     /**
      * 現在の日付・時刻から指定の時間量を加算・減算した結果を返します。
      * 年、月、日、時間、分、秒、ミリ秒の各時間フィールドに対し、
      * 任意の時間量を設定できます。
      * たとえば、現在の日付時刻から 10 日前を計算する場合は以下となります。
      * Calendar cal = add(null,0,0,-10,0,0,0,0);
      * 
      * 各時間フィールドの値がその範囲を超えた場合、次の大きい時間フィールドが
      * 増分または減分されます。
      * たとえば、以下では1時間と5分進めることになります。
      * Calendar cal = add(null,0,0,0,0,65,0,0);
      * 
      * 各時間フィールドに設定する数量が0の場合は、現在の値が設定されます。
      * java.util.GregorianCalendarの内部処理では以下の分岐を行っている。
      *     if (amount == 0) {
      *         return;
      *     }
      *     
      * @param cal 日付時刻の指定があればセットする。
      *     nullの場合、現在の日付時刻で新しいCalendarインスタンスを生成する。
      * @param addYera 加算・減算する年数
      * @param addMonth 加算・減算する月数
      * @param addDate 加算・減算する日数
      * @param addHour 加算・減算する時間
      * @param addMinute 加算・減算する分
      * @param addSecond 加算・減算する秒
      * @param addMillisecond 加算・減算するミリ秒
      * @return    計算後の Calendar インスタンス。
      */
     public static Calendar add(Calendar cal,
                                int addYera,int addMonth,int addDate,
                                int addHour,int addMinute,int addSecond,
                                int addMillisecond){
         if (cal == null) {
             cal = Calendar.getInstance();
         }
         cal.add(Calendar.YEAR, addYera);
         cal.add(Calendar.MONTH, addMonth);
         cal.add(Calendar.DATE, addDate);
         cal.add(Calendar.HOUR_OF_DAY, addHour);
         cal.add(Calendar.MINUTE, addMinute);
         cal.add(Calendar.SECOND, addSecond);
         cal.add(Calendar.MILLISECOND, addMillisecond);
         return cal;
     }

}
