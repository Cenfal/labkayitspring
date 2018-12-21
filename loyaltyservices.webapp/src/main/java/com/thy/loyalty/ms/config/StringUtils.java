package com.thy.loyalty.ms.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author E_KIRBAS
 */

public class StringUtils {

    /**
     * using String.replace functions for a string containing $ char,
     * you get exception below; 
     * java.lang.IllegalArgumentException: Illegal group reference
     * 
     * This function replaces $ with S char.
     * 
     * Before using replace, use this function.
     * 
     * 
     * @param str
     * @return
     */

	private static final String StringDontUpdate = "[---]";
	private static final String StringIgnore = null;
	public  static final String StringClear = "[CLR]";
	public  static final String StringClearReplace = "\\[CLR\\]";
	private static final int IntegerDontUpdate = -999999;

	public static String clearInvalidCharForReplace(String str){

        StringBuffer buf = new StringBuffer();
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '$')
                buf.append('S');
            else
                buf.append(str.charAt(i));
        }

        return buf.toString();        
        
    }
    
	public static boolean isAlpha(String str)
	{
		if (str == null)
			return false;
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isLetter(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i)))
				return false;
		}
		return true;
	}    
	
	public static boolean isNumber(String str)
	{
		if ( (str == null) || (str.trim().length()==0) )
			return false;
		str = str.trim();
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}    

	/**
	 * 
	 * @param str format ddMMyyyy
	 * @return
	 */
	public static boolean isValidDate(String str) {
		Object convertedValue = null;
		DateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");
		dateFormatter.setLenient(false);
		try {
			convertedValue = dateFormatter.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param str raw string contains date info
	 * @param format date format like ddMMyyyy, dd.MM.yyyy
	 * @return
	 */
	public static java.util.Date parseDate(String str,String format) {
		Date date = null;
		DateFormat dateFormatter = new SimpleDateFormat(format);
		dateFormatter.setLenient(false);
		try {
			date = dateFormatter.parse(str);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	

	/**
	 * 
	 * @param str format ddMMyyyy
	 * @return
	 */
	public static boolean isValidDateForSQL(String str) {
		
		try {
			
			//Must be 8 digits long
			if ((str == null) || (str.length()!=8))
				return false;
			
			//day month year values must be set
			String dayStr 	= str.substring(0, 2);
			String monthStr	= str.substring(2, 4);
			String yearStr 	= str.substring(4, 8);
			
			//day month year values must be digits
			int day 	= Integer.parseInt(str.substring(0, 2));
			int month 	= Integer.parseInt(str.substring(2, 4));
			int year 	= Integer.parseInt(str.substring(4, 8));
			
			//must be an existing date
			return isValidDate(dayStr+monthStr+yearStr);
		}
		
		catch (Exception e) {
			return false;
		}
	}	
	
	/**
	 * Returns difference (today - given date) in days.
	 * @param year
	 * @param month
	 * @param day
	 * @return difference (today - given date) in days.
	 */
	public static long getDayDifferenceFromToday(String year, String month, String day) {
		Calendar today = new GregorianCalendar();
		Calendar fDate = null;
		
		today = new GregorianCalendar(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
		fDate = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
		
		return ((today.getTimeInMillis() - fDate.getTimeInMillis())/(24*60*60*1000));
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		if(str == null)
			return true;
		if(str.trim().equals(""))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNonUpdatedString(String str) {

//		if(str.trim().equals(StringDontUpdate))
//			return true;
//		else
//			return false;

		if (str == StringIgnore || str.length()==0)
		{
			return true;
		}
		else
			return false;
		
//
//		if(str.trim().equals(StringDontUpdate))
//			return true;
//		else
//			return false;
//

	}
	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNonUpdatedInteger(String value) {

		if(value== null || value.trim().length()==0)
			return true;
		else
			return false;
	}


	/**
	 * Changes the case of the string to ttle case (First letter of each word is capital and the other letters are lower)
	 * @param str
	 * @return
	 */
    public static String toTitleCase(String input, String language) {
		java.util.Locale loc = new java.util.Locale(language, "");
		try
		{
			if (input.length() > 0)
			{
				char[] temp = input.trim().toCharArray();
				temp[0] = temp[0] = String.valueOf(temp[0]).toUpperCase(loc).charAt(0);
				for (int i = 0; i < temp.length; i++)
				{
					try
					{
						if(String.valueOf(temp[i]).equals(" "))
							temp[i + 1] = String.valueOf(temp[i + 1]).toUpperCase(loc).charAt(0);
						else 
							temp[i + 1] = String.valueOf(temp[i + 1]).toLowerCase(loc).charAt(0);
					}
					catch (ArrayIndexOutOfBoundsException a)
					{
					}						
				}
				input = new String(temp);
			}
		}
		catch (NullPointerException e)
		{
		}
		return input;    	
    }
    
	//input olarak gelen karakter db nin desteklemedigi anlamsiz bir karakter ise false, aksi halde true doner 
	public static boolean isValidCharacter(char c) {
		int val = (int)c;
		if( (val == 32) || //turkish chars 
			(val == 199) || 
			(val == 231) ||
			(val == 304) ||
			(val == 305) ||
			(val == 286) ||
			(val == 287) ||
			(val == 246) ||
			(val == 214) ||
			(val == 220) ||
			(val == 252) ||
			(val == 350) ||
			(val == 351) ) {
			return true;
		}else if((val >= 40) && (val <= 93)) { //capitals & digits & punctuation
			return true;
		}else if((val >= 97) && (val <= 125)) { //small cases & punctuation
			return true;
		}else if((val >= 148) && (val <= 157)) { //digits
			return true;
		}else {
			return false;
		}
	}
	//input olarak gelen stringde dbnin desteklemedigi anlamsiz bir karakter varsa;
	//true doner. (Cince, Rusca, Kiril...v.s. alfabe karakterlerinin kontrolu icin eklenmistir.)
	public static boolean hasInvalidCharacter(String input) {
		if((input==null) || (input.trim().length() == 0))
			return false;
		else {
			for(int i = 0; i < input.trim().length(); i++) {
				if(!isValidCharacter(input.charAt(i)))
					return true;
			}
			return false;
		}
	}
	
	/**
	 * Replaces substring of a given string.
	 * Example :
	 * replaceSubstring("Your ticketed name is {0}.", "{0}", "ANTONIO VIVALDI")
	 * returns :  Your ticketed name is ANTONIO VIVALDI.
	 * @param str
	 * @param pattern
	 * @param replace
	 * @return
	 */

	public static String replaceSubstring(String str, String pattern, String replace) {
	    int s = 0;
	    int e = 0;
	    StringBuffer result = new StringBuffer();

	    while ((e = str.indexOf(pattern, s)) >= 0) {
	        result.append(str.substring(s, e));
	        result.append(replace);
	        s = e+pattern.length();
	    }
	    result.append(str.substring(s));
	    return result.toString();
	}
	
	public static String stack2string(Exception e) {
		  try {
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
		    return "---\r\n" + sw.toString() + "---\r\n";
		  }
		  catch(Exception e2) {
		    return "bad stack2string";
		  }
		 }
	public static String now() {
		String DateFormat = "yyyy_MM_dd";
		
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
	    
	    return sdf.format(cal.getTime());

	  }
	public static String now(String DateFormat) {
		
	    Calendar cal=null;
		SimpleDateFormat sdf=null;
		try {
			cal = Calendar.getInstance();
			sdf = new SimpleDateFormat(DateFormat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return sdf.format(cal.getTime());

	  }
	
	// input null ise ya da bos ise, preferential parametreyi geri doner.
	public static String nvl(String input,String preferential) {
		
		if (input == null|| input.trim().length() == 0)
		{
			return preferential;
		}
		return input;
	}

	public static boolean isTrue(String value)
	{
		if (value != null && (value.toLowerCase().equals("true") || value.toLowerCase().equals("t") || value.toLowerCase().equals("1")))
		{
			return true;
		}

		return false;
	}
	
	public static String replaceTurkishWithEnglish(String in) {
		String out = new String(in);
		out = out.replace('i', 'I');
		out = out.replace((char)305, 'I'); //kucuk I
		out = out.replace((char)304, 'I'); //buyuk i
		out = out.replace((char)351, 'S'); //kucuk s
		out = out.replace((char)350, 'S'); //buyuk s
		out = out.replace((char)231, 'C'); //kucuk c
		out = out.replace((char)199, 'C'); //kucuk C
		out = out.replace((char)117, 'U'); //kucuk u
		out = out.replace((char)85, 'U'); //buyuk u
		out = out.replace((char)287, 'G'); //kucuk g
		out = out.replace((char)286, 'G'); //buyuk g
		out = out.replace((char)246, 'O'); //kucuk o
		out = out.replace((char)214, 'O'); //buyuk o
		out = out.replaceAll(" ", "");
		return out;
	}
	
	public static String rightPad(String str, int length, char car) {
		
		if(length - str.length() > 0)
			return str + String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car));
		else
			return str;
	}  
	
	public static String leftPad(String str, int length, char car) {  
		
		if(length - str.length() > 0)
			return String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car)) + str;
		else
			return str;
	}
	
	public static String handleNullString(String myString) {
		
		if (myString == null)
			return "";
		else
			return myString.trim();
	}

}
