package jp.co.nsl.Manifest;

import android.content.Context;
/**
 * Android Manifestから情報取得
 * @author oguri
 *
 */
public class Manifest {
    /**
     * AndroidManifestからVersionNameを取得する
     * @param context
     * @return
     */
    public static String getVersionName(Context context){
   	 String result="";
   	 try{
   		 result = context.getPackageManager().getPackageInfo( context.getPackageName(), 1 ).versionName;
   	 }catch(Exception e){
   		 
   	 }
   	 return result;    	 
    }
    /**
     * AndroidManifestからVersion　Codeを取得する
     * @param context
     * @return
     */
    public static String getVersion(Context context){
   	 int result=-1;
   	 try{
   		 result = context.getPackageManager().getPackageInfo( context.getPackageName(), 1 ).versionCode;
   	 }catch(Exception e){
   		 
   	 }
   	 return String.valueOf(result);
    }

}
