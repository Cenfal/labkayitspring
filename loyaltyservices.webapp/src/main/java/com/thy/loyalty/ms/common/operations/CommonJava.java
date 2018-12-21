package com.thy.loyalty.ms.common.operations;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thy.loyalty.ms.config.StringUtils;
import com.thy.ws.header.request.ParamType;
import com.thy.ws.header.request.RequestHeader;



public final class CommonJava {
	
	private static Log logger = LogFactory.getLog(CommonJava.class);
	
	private CommonJava() {
	}

	static int encoder = 347;
	static private NumberFormat nf = NumberFormat
			.getInstance(java.util.Locale.US);
	static private NumberFormat nf2 = NumberFormat
			.getInstance(java.util.Locale.US);
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat(
			"dd-MM-yyyy");
	private static SimpleDateFormat dateFormatter2 = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat dateFormatter3 = new SimpleDateFormat(
			"dd/MMM/yyyy");
	private static SimpleDateFormat dateFormatterDD = new SimpleDateFormat("dd");
	private static SimpleDateFormat dateFormatterMM = new SimpleDateFormat("MM");
	private static SimpleDateFormat dateFormatterYY = new SimpleDateFormat("yy");
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm");
	private static SimpleDateFormat timeFormatterDetail = new SimpleDateFormat(
			"HH:mm:ss");
	private static SimpleDateFormat timeFormatterPacked = new SimpleDateFormat(
			"yyMMdd:HHmm");
	private static SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static SimpleDateFormat dateFormatterDotsDDMMYYYY = new SimpleDateFormat(
			"dd.MM.yyyy");
	private static SimpleDateFormat timeFormatterHHMM = new SimpleDateFormat(
			"HH:mm");
	public static Vector vecUsers = new Vector();
	public static Vector vecUserLoginTime = new Vector();
	public static Vector vecUserTime = new Vector();
	public static Vector vecPerfLog = new Vector();
	
	public static SimpleDateFormat dateFormatterForEmailer = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	private static SimpleDateFormat dateFormatterYYYY = new SimpleDateFormat(
			"yyyy");
	public static final String [] months={"01","02","03","04","05","06","07","08","09","10","11","12"};

	/**
	 * Format timestamp into string as date
	 */
	public static String dateString(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatter.format(ts);
	}

	public static String dateStringWithSlash(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterDDMMYYYY.format(ts);
	}

	public static String timeStringHHMM(Timestamp ts) {
		if (ts == null)
			return "";
		return timeFormatterHHMM.format(ts);
	}

	public static String dateStringInverse(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatter2.format(ts);
	}

	public static String dateDD(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterDD.format(ts);
	}

	public static String dateDDmmmyyyy(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatter3.format(ts);
	}

	public static String dateDDMMYYYy(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterDDMMYYYY.format(ts);
	}

	public static String getFixLengthStr(String str, int len) {
		str = "000000000000000000" + str;
		return str.substring(str.length() - len);
	}

	public static String getFixLengthStr(String str, int len, String dummy) {
		str = str + "                         ";
		return str.substring(0, len);
	}

	public static String dateDotsDDMMYYYy(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterDotsDDMMYYYY.format(ts);
	}

	public static String dateMM(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterMM.format(ts);
	}

	public static String getSubString(String s, int startIndex, int endIndex) {
		if (s.length() < endIndex) {
			return s.substring(startIndex, s.length());
		} else {
			return s.substring(startIndex, endIndex);
		}
	}

	/*
	 * Returns the miliseconds in the given number of days
	 */
	public static long days(int day) {
		return day * 1000 * 60 * 60 * 24;
	}

	public static String dateYY(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterYY.format(ts);
	}

	public static String dateYYYY(Timestamp ts) {
		if (ts == null)
			return "";
		return dateFormatterYYYY.format(ts);
	}

	public static long now() {
		return System.currentTimeMillis();
	}

	public static Timestamp today() {
		Timestamp D = new Timestamp(System.currentTimeMillis());
		// return new Timestamp (D.getYear(), D.getMonth(), D.getDate(), 0, 0,
		// 0, 0);
		if (D.getYear() == 102 && D.getMonth() == 3 && D.getDate() == 26)
			D.setHours(1);
		else
			D.setHours(0);
		D.setMinutes(0);
		D.setSeconds(0);
		D.setNanos(0);
		return D;
	}

	public static Timestamp today(int plusDay) {
		Timestamp D = new Timestamp(System.currentTimeMillis()
				+ ((long) 1000 * 60 * 60 * 24 * plusDay));
		return new Timestamp(D.getYear(), D.getMonth(), D.getDate(), 0, 0, 0, 0);
	}

	public static boolean isToday(Timestamp t) {
		if (today().getTime() == (new Timestamp(t.getYear(), t.getMonth(),
				t.getDate(), 0, 0, 0, 0)).getTime())
			return true;
		return false;
	}

	public static Timestamp timeGMT() {
		Timestamp D = new Timestamp(System.currentTimeMillis()
				- ((long) 1000 * 60 * 60 * 2));
		return new Timestamp(D.getYear(), D.getMonth(), D.getDate(),
				D.getHours(), D.getMinutes(), 0, 0);
	}

	public static Timestamp timeDefault() {
		Timestamp D = new Timestamp(System.currentTimeMillis());
		return new Timestamp(D.getYear(), D.getMonth(), D.getDate(),
				D.getHours(), D.getMinutes(), 0, 0);
	}

	/**
	 * Format timestamp into string as date : time
	 */
	public static String timeString(Timestamp ts) {
		if (ts == null)
			return "";
		if (ts.getHours() == 0 && ts.getMinutes() == 0)
			return dateString(ts);
		return timeFormatter.format(ts);
	}

	public static String timeStringHHMMSS(Timestamp ts) {
		if (ts == null)
			return "";
		if (ts.getHours() == 0 && ts.getMinutes() == 0)
			return "00:00:00";
		return timeFormatterDetail.format(ts);
	}

	public static String timeStringPacked(Timestamp ts) {
		if (ts == null)
			return "";
		return timeFormatterPacked.format(ts);
	}

	public static String timedoubleToString(double d) {
		if (d == 8.5)
			return "8:30";
		if (d == 8.75)
			return "8:45";
		if (d == 9)
			return "9:00";
		if (d == 9.25)
			return "9:15";
		if (d == 9.5)
			return "9:30";
		if (d == 9.75)
			return "9:45";
		if (d == 10)
			return "10:00";
		if (d == 10.25)
			return "10:15";
		if (d == 10.5)
			return "10:30";
		if (d == 10.75)
			return "10:45";
		if (d == 11)
			return "11:00";
		if (d == 11.25)
			return "11:15";
		if (d == 11.5)
			return "11:30";
		if (d == 11.75)
			return "11:45";
		if (d == 12)
			return "12:00";
		if (d == 12.25)
			return "12:15";
		if (d == 12.5)
			return "12:30";
		if (d == 12.75)
			return "12:45";
		if (d == 13)
			return "13:00";
		if (d == 13.25)
			return "13:15";
		if (d == 13.5)
			return "13:30";
		if (d == 13.75)
			return "13:45";
		if (d == 14)
			return "14:00";
		if (d == 14.25)
			return "14:15";
		if (d == 14.5)
			return "14:30";
		if (d == 14.75)
			return "14:45";
		if (d == 15)
			return "15:00";
		if (d == 15.25)
			return "15:15";
		if (d == 15.5)
			return "15:30";
		if (d == 15.75)
			return "15:45";
		if (d == 16)
			return "16:00";
		if (d == 16.25)
			return "16:15";
		if (d == 16.5)
			return "16:30";
		if (d == 16.75)
			return "16:45";
		if (d == 17)
			return "17:00";
		if (d == 17.25)
			return "17:15";
		if (d == 17.5)
			return "17:30";
		if (d == 17.75)
			return "17:45";
		if (d == 18)
			return "18:00";
		if (d == 18.25)
			return "18:15";
		if (d == 18.5)
			return "18:30";
		if (d == 18.75)
			return "18:45";
		if (d == 19)
			return "19:00";
		if (d == 19.25)
			return "19:15";
		if (d == 19.5)
			return "19:30";
		if (d == 19.75)
			return "19:45";
		if (d == 20)
			return "20:00";
		if (d == 20.25)
			return "20:15";
		if (d == 20.5)
			return "20:30";
		if (d == 20.75)
			return "20:45";
		if (d == 21)
			return "21:00";
		if (d == 21.25)
			return "21:15";
		if (d == 21.5)
			return "21:30";
		if (d == 21.75)
			return "21:45";
		if (d == 22)
			return "22:00";
		if (d == 22.25)
			return "22:15";
		if (d == 22.5)
			return "22:30";
		if (d == 22.75)
			return "22:45";
		if (d == 23)
			return "23:00";
		if (d == 23.25)
			return "23:15";
		if (d == 23.5)
			return "23:30";
		if (d == 23.75)
			return "23:45";
		return "";
	}

	public static double timeStringTodouble(String s) {
		if (s.equals("8:30"))
			return (double) 8.5;
		if (s.equals("8:45"))
			return (double) 8.75;
		if (s.equals("9:00"))
			return (double) 9;
		if (s.equals("9:15"))
			return (double) 9.25;
		if (s.equals("9:30"))
			return (double) 9.5;
		if (s.equals("9:45"))
			return (double) 9.75;
		if (s.equals("10:00"))
			return (double) 10;
		if (s.equals("10:15"))
			return (double) 10.25;
		if (s.equals("10:30"))
			return (double) 10.5;
		if (s.equals("10:45"))
			return (double) 10.75;
		if (s.equals("11:00"))
			return (double) 11;
		if (s.equals("11:15"))
			return (double) 11.25;
		if (s.equals("11:30"))
			return (double) 11.5;
		if (s.equals("11:45"))
			return (double) 11.75;
		if (s.equals("12:00"))
			return (double) 12;
		if (s.equals("12:15"))
			return (double) 12.25;
		if (s.equals("12:30"))
			return (double) 12.5;
		if (s.equals("12:45"))
			return (double) 12.75;
		if (s.equals("13:00"))
			return (double) 13;
		if (s.equals("13:15"))
			return (double) 13.25;
		if (s.equals("13:30"))
			return (double) 13.5;
		if (s.equals("13:45"))
			return (double) 13.75;
		if (s.equals("14:00"))
			return (double) 14;
		if (s.equals("14:15"))
			return (double) 14.25;
		if (s.equals("14:30"))
			return (double) 14.5;
		if (s.equals("14:45"))
			return (double) 14.75;
		if (s.equals("15:00"))
			return (double) 15;
		if (s.equals("15:15"))
			return (double) 15.25;
		if (s.equals("15:30"))
			return (double) 15.5;
		if (s.equals("15:45"))
			return (double) 15.75;
		if (s.equals("16:00"))
			return (double) 16;
		if (s.equals("16:15"))
			return (double) 16.25;
		if (s.equals("16:30"))
			return (double) 16.5;
		if (s.equals("16:45"))
			return (double) 16.75;
		if (s.equals("17:00"))
			return (double) 17;
		if (s.equals("17:15"))
			return (double) 17.25;
		if (s.equals("17:30"))
			return (double) 17.5;
		if (s.equals("17:45"))
			return (double) 17.75;
		if (s.equals("18:00"))
			return (double) 18;
		if (s.equals("18:15"))
			return (double) 18.25;
		if (s.equals("18:30"))
			return (double) 18.5;
		if (s.equals("18:45"))
			return (double) 18.75;
		if (s.equals("19:00"))
			return (double) 19;
		if (s.equals("19:15"))
			return (double) 19.25;
		if (s.equals("19:30"))
			return (double) 19.5;
		if (s.equals("19:45"))
			return (double) 19.75;
		if (s.equals("20:00"))
			return (double) 20;
		if (s.equals("20:15"))
			return (double) 20.25;
		if (s.equals("20:30"))
			return (double) 20.5;
		if (s.equals("20:45"))
			return (double) 20.75;
		if (s.equals("21:00"))
			return (double) 21;
		if (s.equals("21:15"))
			return (double) 21.25;
		if (s.equals("21:30"))
			return (double) 21.5;
		if (s.equals("21:45"))
			return (double) 21.75;
		if (s.equals("22:00"))
			return (double) 22;
		if (s.equals("22:15"))
			return (double) 22.25;
		if (s.equals("22:30"))
			return (double) 22.5;
		if (s.equals("22:45"))
			return (double) 22.75;
		if (s.equals("23:00"))
			return (double) 23;
		if (s.equals("23:15"))
			return (double) 23.25;
		if (s.equals("23:30"))
			return (double) 23.5;
		if (s.equals("23:45"))
			return (double) 23.75;

		return (double) 0;
	}

	public static Timestamp convertStringToDate(String str) throws Exception {
		java.sql.Date D = new java.sql.Date(1990, 0, 1);
		str.trim();
		if (str.length() == 0) {
			return null;
		} else {
			D = D.valueOf(str);
			return new Timestamp(D.getYear(), D.getMonth(), D.getDate(), 0, 0,
					0, 0);
		}
	}

	public static Timestamp convertStringToDateDDMMYYYY(String str)
			throws Exception {
		java.sql.Date D = new java.sql.Date(1990, 0, 1);
		str.trim();
		if (str.length() == 0) {
			return null;
		} else {
			str = str.substring(6, 10) + "-" + str.substring(3, 5) + "-"
					+ str.substring(0, 2);
			D = D.valueOf(str);
			return new Timestamp(D.getYear(), D.getMonth(), D.getDate(), 0, 0,
					0, 0);
		}
	}

	public static Timestamp convertStringToDateDDMMYYYYHHMISS(String str)
			throws Exception {
		java.sql.Date D = new java.sql.Date(1990, 0, 1);
		java.sql.Time T = new java.sql.Time(0, 0, 0);
		str.trim();
		if (str.length() == 0) {
			return null;
		} else {
			String str2 = str.substring(6, 10) + "-" + str.substring(3, 5)
					+ "-" + str.substring(0, 2);
			D = D.valueOf(str2);
			str = str.substring(11, 13) + ":" + str.substring(14, 16) + ":"
					+ str.substring(17, 19);
			T = T.valueOf(str);
			return new Timestamp(D.getYear(), D.getMonth(), D.getDate(),
					T.getHours(), T.getMinutes(), T.getSeconds(), 0);
		}
	}

	/**
	 * Format a float number into a string.
	 */
	public static String nFormat(float d, String f) {
		return nFormat((double) d, f);
	}

	/**
	 * Format a double number into a string.
	 */
	public static String nFormat(double d, String f) {
		String s;

		DecimalFormat nf3 = (DecimalFormat) nf;
		nf3.applyPattern(f);
		nf3.setMinimumIntegerDigits(1);
		s = nf3.format(d + (double) 0.000001); // add 0.000001 to round up
												// floating point errors
		int a = f.length() - s.length();
		// BB Asprin : aslinda Javanin kendi formatlama rutinleri ile field boyu
		// verilebilmeli.
		// BB Simdilik leading blankleri supress ettigi icin ben elle ekledim.
		for (; a > 0; a--)
			s = " " + s;
		return s;
	}

	/**
	 * Format a long number into a string.
	 */
	public static String nFormat(long d, String f) {
		String s;

		DecimalFormat nf3 = (DecimalFormat) nf;
		nf3.applyPattern(f);
		nf3.setMinimumIntegerDigits(1);
		s = nf3.format(d);
		int a = f.length() - s.length();
		// BB Asprin : aslinda Javanin kendi formatlama rutilnelri ile field
		// boyu verilebilmeli.
		// BB Simdilik leading blankleri supress ettigi icin ben elle ekledim.
		for (; a > 0; a--)
			s = " " + s;
		return s;
	}

	/**
	 * Convert double to N7.2 format. 4 + . + 2
	 */
	public static String n7_2(double d) {
		return nFormat(d, "###0.00");
	}

	/**
	 * Convert float to N7.2 format. 4 + . + 2
	 */
	public static String n7_2(float d) {
		return n7_2((double) d);
	}

	/**
	 * Convert double to N7.2 format. 4 + . + 2
	 */
	public static String n7_1(double d) {
		return nFormat(d, "###0.0");
	}

	/**
	 * Convert float to N7.2 format. 4 + . + 2
	 */
	public static String n7_1(float d) {
		return n7_1((double) d);
	}

	/**
	 * Convert double to N15.2 format. 12 + . + 2
	 */
	public static String n15_2(double d) {
		return nFormat(d, "#############0.00");
	}

	/**
	 * Convert float to N15.2 format. 12 + . + 2
	 */
	public static String n15_2(float d) {
		return n15_2((double) d);
	}

	/**
	 * Convert double to N15.2 format. 12 + . + 2
	 */
	public static String n15_2c(double d) {
		return nFormat(d, "##,###,###,##0.00");
	}

	public static String n18_2c(double d) {
		return nFormat(d, "##,###,###,###,##0.00");
	}

	/**
	 * Convert float to N15.2 format. 12 + . + 2
	 */
	public static String n15_2c(float d) {
		return n15_2c((double) d);
	}

	public static String n15_4(double d) {
		return nFormat(d, "#############0.0000");
	}

	public static String n15_4(float d) {
		return n15_4((double) d);
	}

	public static String n15_4c(double d) {
		return nFormat(d, "##,###,###,##0.0000");
	}

	public static String n15_4c(float d) {
		return n15_4c((double) d);
	}

	/**
	 * Convert double to N15.0 format. 12 + . + 2
	 */
	public static String n15_0c(double d) {
		return nFormat(d, "##,###,###,###,###");
	}

	/**
	 * Convert float to N15.0 format. 12 + . + 2
	 */
	public static String n15_0c(float d) {
		return n15_0c((double) d);
	}

	/**
	 * Convert double to N7.0
	 */
	public static String n7_0(double d) {
		return nFormat(d, "######0");
	}

	/**
	 * Convert int to n7_0
	 */
	public static String n7_0(int d) {
		return n7_0((double) d);
	}

	/**
	 * Convert float to N7.0.
	 */
	public static String n7_0(float d) {
		return n7_0((double) d);
	}

	/**
	 * Convert double to N15_0
	 */
	public static String n15_0(double d) {
		return nFormat(d, "#############0");
	}

	/**
	 * Convert float to N15_0
	 */
	public static String n15_0(float d) {
		return n15_0((double) d);
	}

	/**
	 * Convert int to N15_0
	 */
	public static String n15_0(int d) {
		return n15_0((double) d);
	}

	/**
	 * Convert long to N15_0
	 */
	public static String n15_0(long d) {
		return n15_0((double) d);
	}

	/**
	 * Check equality of the float numbers. After arithmetic calculations often
	 * float numbers that should normally represent the same number has small
	 * differences. This function returns 'true' if two float numbers are
	 * roughly equal. (Equal enough for all practical purposes.) This means the
	 * difference between two numbers is less than 0.001
	 */
	public static boolean eq1_0(float v1, float v2) {
		float v = (v1 > v2 ? v1 - v2 : v2 - v1);
		return (v < 0.001);
	}

	public static boolean eq1_0(double v1, double v2) {
		double v = (v1 > v2 ? v1 - v2 : v2 - v1);
		return (v < 0.0001);
	}

	/**
	 * Compare two strings for equality. The difference from using the equal
	 * function of the string object is the correct handling of null objects.
	 * Either or both of the parameters can be null
	 * 
	 * @param str1
	 *            string to be compared
	 * @param str2
	 *            string to be compared
	 */
	public static boolean strEqual(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;
		else
			return str1.equals(str2);
	}

	public static boolean strEqualNull(String str1, String str2) {
		if (str1 == null)
			str1 = "";
		if (str2 == null)
			str2 = "";
		return str1.equals(str2);
	}

	public static boolean strEqualNullOrEmpty(String str) {
		if (str == null)
			return true;
		if (str.equals(""))
			return true;
		return false;
	}

//	public static void ilog(String logString) {
//		String fn = "N/A";
//		try {
//			String s = System.getProperty("thy.appdir");
//			String ts = new Timestamp(System.currentTimeMillis()).toString();
//			if (s.equals("C:\\")) {
//				fn = s + "contactcenter\\log\\ilog" + ts.substring(0, 10)
//						+ ".txt";
//			} else {
//				fn = s + "/contactcenter/log/ilog" + ts.substring(0, 10)
//						+ ".txt";
//			}
//
//			OutputStreamWriter p = new OutputStreamWriter(new FileOutputStream(
//					fn, true), "ISO-8859-9");
//			p.write(ts + " --> " + logString + "\r\n");
//			p.close();
//		} catch (Exception e) {
//			com.thy.milesandmiles.log.Log.getErrorInstance().error("Cannot write to ilogfile " + fn);
//		}
//	}

//	public static PrintStream getIlogStream() {
//		try {
//			String fn = "N/A";
//			String ts = new Timestamp(System.currentTimeMillis()).toString();
//			String s = System.getProperty("thy.appdir");
//			if (s.equals("C:\\")) {
//				fn = s + "contactcenter\\log\\ilog" + ts.substring(0, 10)
//						+ ".txt";
//			} else {
//				fn = s + "/contactcenter/log/ilog" + ts.substring(0, 10)
//						+ ".txt";
//			}
//			return new PrintStream(new FileOutputStream(fn, true));
//		} catch (Exception e) {
//			com.thy.milesandmiles.log.Log.getErrorInstance().error("Cannot write to ilogfile ");
//		}
//		return null;
//	}

//	public static void perfLog(String logString) {
//		String fn = "N/A";
//		try {
//			String ts = new Timestamp(System.currentTimeMillis()).toString();
//			if (vecPerfLog.size() > 999) {
//				String s = System.getProperty("thy.appdir");
//				fn = s + "/contactcenter/log/log" + ts.substring(0, 10)
//						+ ".txt";
//				OutputStreamWriter p = new OutputStreamWriter(
//						new FileOutputStream(fn, true), "ISO-8859-9");
//				for (int i = 0; i < vecPerfLog.size(); i++)
//					p.write("" + vecPerfLog.elementAt(i));
//				p.close();
//				vecPerfLog = new Vector();
//			}
//			vecPerfLog.add(ts + " ; " + logString + "\r\n");
//		} catch (Exception e) {
//			com.thy.milesandmiles.log.Log.getErrorInstance().error("Cannot write to ilogfile " + fn);
//		}
//
//	}

	/**
	 * Get the first line of a text string seperated by newline characters
	 * 
	 * @param Original
	 *            String
	 * @return The first line. If the paramater is null then a blank string
	 *         returns
	 */
	public static String firstLine(String s) {
		if (s == null)
			return "";
		int x = s.indexOf('\n');
		if (x < 0)
			return s;
		return s.substring(0, x);
	}

	/**
	 * Return printable string .i.e if the given parameter is null return ""
	 * else return the string
	 * 
	 * @param str1
	 *            string
	 */
	public static String strPrint(String str1) {
		if (str1 == null)
			return "";
		return str1;
	}

	public static String strPrintNA(String str1) {
		if (str1 == null)
			return "N/A";
		else if (str1.trim().equals(""))
			return "";
		return str1;
	}

	/**
	 * Return printable string .i.e if the given parameter is null return ""
	 * else return the string
	 * 
	 * @param str1
	 *            string
	 */
	public static String strPrint(String str1, boolean upperCase) {
		return strPrint(str1).replace('i', 'I').toUpperCase();
	}

	/**
	 * Round off given number.
	 * 
	 * @param in
	 *            number to be rounded.
	 * @param digits
	 *            number of digits after decimal point.
	 */
	public static double round(float in, int digits) {
		return (float) round((double) in, digits);
	}

	/**
	 * Round off given number.
	 * 
	 * @param in
	 *            number to be rounded.
	 * @param digits
	 *            number of digits after decimal point.
	 */
	public static double round(double in, int digits) {
		int a = 1;

		if (in == 0.00)
			return 0.00;
		BigDecimal bd = new BigDecimal(in);
		BigDecimal b2 = bd.setScale(digits, BigDecimal.ROUND_HALF_DOWN);
		return b2.doubleValue();
	}

	/**
	 * Increase a value by an amount or percent, whichever is greater
	 * 
	 * @param value
	 *            Value to be increased.
	 * @param pct
	 *            Percent (1 is %100). %100 increase means x2.
	 * @param plus
	 *            Amount
	 * @return Increased amount
	 */
	public static double pctOrPlus(double value, float pct, float plus) {
		BigDecimal valueBig = new BigDecimal(value);
		BigDecimal pctBig = new BigDecimal(pct);
		BigDecimal plusBig = new BigDecimal(plus);
		if (pct > 0.1 && pct < 0.1000001)
			pctBig = new BigDecimal("0.1");
		/*
		 * else if (pct<0.1 && pct>0.0999999) pctBig = new BigDecimal("0.1");
		 * else if (pct==0.1) pctBig = new BigDecimal("0.1");
		 */
		/*
		 * double v1 = value + plus; double v2 = value + (value * pct); if (v1 >
		 * v2) return v1; else return v2;
		 */
		double v1 = valueBig.add(plusBig).doubleValue();
		double v2 = valueBig.add(valueBig.multiply(pctBig)).doubleValue();
		if (v1 > v2)
			return v1;
		else
			return v2;
	}

	/*
	 * public static double pctOrPlus(BigDecimal value, BigDecimal pct,
	 * BigDecimal plus) { double v1 = value.add(plus).doubleValue(); double v2 =
	 * value.add( value.multiply(pct) ).doubleValue(); if (v1 > v2) return v1;
	 * else return v2; }
	 */

	/**
	 * Convert a string to Integer.
	 */
	public static int intVal(String s) throws Exception {
		int i = nf2.parse(s).intValue();
		return i;
	}

	// gets only numbers in the string
	public static String getNumbersOnly(String s) throws Exception {
		int i;
		String str = "";
		for (i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '0') || (s.charAt(i) == '1')
					|| (s.charAt(i) == '2') || (s.charAt(i) == '3')
					|| (s.charAt(i) == '4') || (s.charAt(i) == '5')
					|| (s.charAt(i) == '6') || (s.charAt(i) == '7')
					|| (s.charAt(i) == '8') || (s.charAt(i) == '9')) {
				str += s.charAt(i);
			}
		}
		return str;
	}

	/**
	 * Convert a string to long.
	 */
	public static long longVal(String s) throws Exception {
		long i = nf2.parse(s).longValue();
		return i;
	}

	/**
	 * Convert a string to double.
	 */
	public static double doubleVal(String s) throws Exception {
		double i = nf2.parse(s).doubleValue();
		return i;
	}

	/**
	 * Places a frame on the center of the screen
	 */
	public static void centerFrame(Component frame, boolean maximize) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (maximize) {
			screenSize.height -= 24;
			frame.setSize(screenSize);
			frame.setLocation(0, 0);
		} else {
			Dimension frameSize = frame.getSize();
			if (frameSize.height > screenSize.height)
				frameSize.height = screenSize.height;
			if (frameSize.width > screenSize.width)
				frameSize.width = screenSize.width;
			frame.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);
		}
	}

	/**
	 * returns current locale (hardcoded to US). Be very careful for the correct
	 * operation of numeric input fields before changing this.
	 */

	public static java.util.Locale currentLocale() {
		return java.util.Locale.US;
	}

	public static String writeNumberTR(double no) {
		String num = CommonJava.n15_2(no).trim();
		String blank = " ";
		String strnum = "";
		String cents = "";
		String arb = "";

		int len = num.length();
		if (!num.endsWith(".00"))
			cents = "/" + num.substring(len - 2) + "/";
		num = num.substring(0, len - 3);
		BigInteger temp = new BigInteger(num);
		String strval = num;
		BigInteger sender = temp;
		BigInteger cnst = new BigInteger("10");
		BigInteger cnst1000000 = new BigInteger("1000000");
		BigInteger cnst1000000000 = new BigInteger("1000000000");

		for (int i = 0; i <= strval.length() - 1; i++) {
			arb = String.valueOf(temp.mod(cnst));

			if ((!((i == 1) || (i == 4) || (i == 7) || (i == 10)))
					&& (!(arb.equals("0"))) && (!(arb.equals("1"))) && (i > 1)) {
				strnum = correspondsTR("1", i) + blank + strnum;
			}

			strnum = correspondsTR(arb, i) + blank + strnum;

			if (arb.equals("1")) {
				if (((i == 3) && (i + 2 <= strval.length()))
						|| ((i == 6) || (i == 9))) {
					strnum = "bir" + blank + strnum;
				}
			}
			if (arb.equals("0")) {
				if (((i == 3) && (i + 2 <= strval.length()))
						|| ((i == 6) && (i + 2 <= strval.length()))
						|| ((i == 9) && (i + 2 <= strval.length()))) {
					if (!((strval.charAt(strval.length() - i - 2) == '0') && (strval
							.charAt(strval.length() - i - 3) == '0')))
						strnum = correspondsTR("1", i) + blank + strnum;
				}
			}

			temp = temp.divide(cnst);
		}
		return strnum.trim();
	}

	public static String getCents(double no) {
		String num = CommonJava.n15_2(no).trim();
		String cents = "00";
		int len = num.length();
		if (!num.endsWith(".00"))
			cents = num.substring(len - 2);
		return cents;
	}

	public static String getCentsTR(double no) {
		String num = CommonJava.n15_2(no).trim();
		String cents = "00";
		int len = num.length();
		if (!num.endsWith(".00"))
			cents = num.substring(len - 2);
		return cents;
	}

	public static String writeNumberEN(double no) {
		String num = CommonJava.n15_2(no).trim();
		String blank = " ";
		String strnum = "";
		String cents = "";
		String arb = "";

		int len = num.length();
		if (!num.endsWith(".00"))
			cents = "/" + num.substring(len - 2) + "/";
		num = num.substring(0, len - 3);
		BigInteger temp = new BigInteger(num);
		String strval = num;
		BigInteger sender = temp;
		BigInteger cnst = new BigInteger("10");
		BigInteger cnst1000000 = new BigInteger("1000000");
		BigInteger cnst1000000000 = new BigInteger("1000000000");

		for (int i = 0; i <= strval.length() - 1; i++) {
			arb = String.valueOf(temp.mod(cnst));

			if ((!((i == 1) || (i == 4) || (i == 7) || (i == 10)))
					&& (!(arb.equals("0"))) && (!(arb.equals("1"))) && (i > 1)) {
				strnum = correspondsEN("1", i) + blank + strnum;
			}

			strnum = correspondsEN(arb, i) + blank + strnum;

			if (arb.equals("1")) {
				if (((i == 3) && (i + 2 <= strval.length()))
						|| ((i == 3) || (i == 6) || (i == 9))) {
					strnum = "one" + blank + strnum;
				}
			}
			if (arb.equals("0")) {
				if (((i == 3) && (i + 2 <= strval.length()))
						|| ((i == 6) && (i + 2 <= strval.length()))
						|| ((i == 9) && (i + 2 <= strval.length()))) {
					if (!((strval.charAt(strval.length() - i - 2) == '0') && (strval
							.charAt(strval.length() - i - 3) == '0')))
						strnum = correspondsEN("1", i) + blank + strnum;
				}
			}
			temp = temp.divide(cnst);
		}

		strnum = replaceString(strnum, "ten one ", "eleven ");
		strnum = replaceString(strnum, "ten two ", "twelve ");
		strnum = replaceString(strnum, "ten three ", "thirteen ");
		strnum = replaceString(strnum, "ten four ", "fourteen ");
		strnum = replaceString(strnum, "ten five ", "fifteen ");
		strnum = replaceString(strnum, "ten six ", "sixteen ");
		strnum = replaceString(strnum, "ten seven ", "seventeen ");
		strnum = replaceString(strnum, "ten eight ", "eighteen ");
		strnum = replaceString(strnum, "ten nine ", "nineteen ");

		return strnum.trim();
	}

	private static String correspondsTR(String s, int level) {
		if ((s.equals("0") && level == 0) || (s.equals("0") && level == 1))
			return "";
		if (s.equals("1") && level == 0)
			return "bir";
		if (s.equals("1") && level == 3)
			return "bin";
		if (s.equals("1") && level == 6)
			return "milyon";
		if (s.equals("1") && level == 9)
			return "milyar";

		if ((s.equals("1") && level == 1) || (s.equals("1") && level == 4)
				|| (s.equals("1") && level == 7)
				|| (s.equals("1") && level == 10)) {
			return "on";
		}

		if ((s.equals("1") && level == 2) || (s.equals("1") && level == 5)
				|| (s.equals("1") && level == 8)
				|| (s.equals("1") && level == 11)) {
			return "yüz";
		}

		if ((s.equals("2") && level == 0) || (s.equals("2") && level == 2)
				|| (s.equals("2") && level == 3)
				|| (s.equals("2") && level == 5)
				|| (s.equals("2") && level == 6)
				|| (s.equals("2") && level == 8)
				|| (s.equals("2") && level == 9)
				|| (s.equals("2") && level == 11)) {
			return "iki";
		}

		if ((s.equals("2") && level == 1) || (s.equals("2") && level == 4)
				|| (s.equals("2") && level == 7)
				|| (s.equals("2") && level == 10)) {
			return "yirmi";
		}

		if ((s.equals("3") && level == 0) || (s.equals("3") && level == 2)
				|| (s.equals("3") && level == 3)
				|| (s.equals("3") && level == 5)
				|| (s.equals("3") && level == 6)
				|| (s.equals("3") && level == 8)
				|| (s.equals("3") && level == 9)
				|| (s.equals("3") && level == 11)) {
			return "üç";
		}

		if ((s.equals("3") && level == 1) || (s.equals("3") && level == 4)
				|| (s.equals("3") && level == 7)
				|| (s.equals("3") && level == 10)) {
			return "otuz";
		}

		if ((s.equals("4") && level == 0) || (s.equals("4") && level == 2)
				|| (s.equals("4") && level == 3)
				|| (s.equals("4") && level == 5)
				|| (s.equals("4") && level == 6)
				|| (s.equals("4") && level == 8)
				|| (s.equals("4") && level == 9)
				|| (s.equals("4") && level == 11)) {
			return "dört";
		}

		if ((s.equals("4") && level == 1) || (s.equals("4") && level == 4)
				|| (s.equals("4") && level == 7)
				|| (s.equals("4") && level == 10)) {
			return "kýrk";
		}

		if ((s.equals("5") && level == 0) || (s.equals("5") && level == 2)
				|| (s.equals("5") && level == 3)
				|| (s.equals("5") && level == 5)
				|| (s.equals("5") && level == 6)
				|| (s.equals("5") && level == 8)
				|| (s.equals("5") && level == 9)
				|| (s.equals("5") && level == 11)) {
			return "beþ";
		}

		if ((s.equals("5") && level == 1) || (s.equals("5") && level == 4)
				|| (s.equals("5") && level == 7)
				|| (s.equals("5") && level == 10)) {
			return "elli";
		}

		if ((s.equals("6") && level == 0) || (s.equals("6") && level == 2)
				|| (s.equals("6") && level == 3)
				|| (s.equals("6") && level == 5)
				|| (s.equals("6") && level == 6)
				|| (s.equals("6") && level == 8)
				|| (s.equals("6") && level == 9)
				|| (s.equals("6") && level == 11)) {
			return "altý";
		}

		if ((s.equals("6") && level == 1) || (s.equals("6") && level == 4)
				|| (s.equals("6") && level == 7)
				|| (s.equals("6") && level == 10)) {
			return "altmýþ";
		}

		if ((s.equals("7") && level == 0) || (s.equals("7") && level == 2)
				|| (s.equals("7") && level == 3)
				|| (s.equals("7") && level == 5)
				|| (s.equals("7") && level == 6)
				|| (s.equals("7") && level == 8)
				|| (s.equals("7") && level == 9)
				|| (s.equals("7") && level == 11)) {
			return "yedi";
		}

		if ((s.equals("7") && level == 1) || (s.equals("7") && level == 4)
				|| (s.equals("7") && level == 7)
				|| (s.equals("7") && level == 10)) {
			return "yetmiþ";
		}

		if ((s.equals("8") && level == 0) || (s.equals("8") && level == 2)
				|| (s.equals("8") && level == 3)
				|| (s.equals("8") && level == 5)
				|| (s.equals("8") && level == 6)
				|| (s.equals("8") && level == 8)
				|| (s.equals("8") && level == 9)
				|| (s.equals("8") && level == 11)) {
			return "sekiz";
		}

		if ((s.equals("8") && level == 1) || (s.equals("8") && level == 4)
				|| (s.equals("8") && level == 7)
				|| (s.equals("8") && level == 10)) {
			return "seksen";
		}

		if ((s.equals("9") && level == 0) || (s.equals("9") && level == 2)
				|| (s.equals("9") && level == 3)
				|| (s.equals("9") && level == 5)
				|| (s.equals("9") && level == 6)
				|| (s.equals("9") && level == 8)
				|| (s.equals("9") && level == 9)
				|| (s.equals("9") && level == 11)) {
			return "dokuz";
		}

		if ((s.equals("9") && level == 1) || (s.equals("9") && level == 4)
				|| (s.equals("9") && level == 7)
				|| (s.equals("9") && level == 10)) {
			return "doksan";
		}

		return "";
	}

	private static String correspondsEN(String s, int level) {
		if ((s.equals("0") && level == 0) || (s.equals("0") && level == 1))
			return "";
		if (s.equals("1") && level == 0)
			return "one";
		if (s.equals("1") && level == 3)
			return "thousand";
		if (s.equals("1") && level == 6)
			return "million";
		if (s.equals("1") && level == 9)
			return "billion";

		if ((s.equals("1") && level == 1) || (s.equals("1") && level == 4)
				|| (s.equals("1") && level == 7)
				|| (s.equals("1") && level == 10)) {
			return "ten";
		}

		if ((s.equals("1") && level == 2) || (s.equals("1") && level == 5)
				|| (s.equals("1") && level == 8)
				|| (s.equals("1") && level == 11)) {
			return "hundred";
		}

		if ((s.equals("2") && level == 0) || (s.equals("2") && level == 2)
				|| (s.equals("2") && level == 3)
				|| (s.equals("2") && level == 5)
				|| (s.equals("2") && level == 6)
				|| (s.equals("2") && level == 8)
				|| (s.equals("2") && level == 9)
				|| (s.equals("2") && level == 11)) {
			return "two";
		}

		if ((s.equals("2") && level == 1) || (s.equals("2") && level == 4)
				|| (s.equals("2") && level == 7)
				|| (s.equals("2") && level == 10)) {
			return "twenty";
		}

		if ((s.equals("3") && level == 0) || (s.equals("3") && level == 2)
				|| (s.equals("3") && level == 3)
				|| (s.equals("3") && level == 5)
				|| (s.equals("3") && level == 6)
				|| (s.equals("3") && level == 8)
				|| (s.equals("3") && level == 9)
				|| (s.equals("3") && level == 11)) {
			return "three";
		}

		if ((s.equals("3") && level == 1) || (s.equals("3") && level == 4)
				|| (s.equals("3") && level == 7)
				|| (s.equals("3") && level == 10)) {
			return "thirty";
		}

		if ((s.equals("4") && level == 0) || (s.equals("4") && level == 2)
				|| (s.equals("4") && level == 3)
				|| (s.equals("4") && level == 5)
				|| (s.equals("4") && level == 6)
				|| (s.equals("4") && level == 8)
				|| (s.equals("4") && level == 9)
				|| (s.equals("4") && level == 11)) {
			return "four";
		}

		if ((s.equals("4") && level == 1) || (s.equals("4") && level == 4)
				|| (s.equals("4") && level == 7)
				|| (s.equals("4") && level == 10)) {
			return "forty";
		}

		if ((s.equals("5") && level == 0) || (s.equals("5") && level == 2)
				|| (s.equals("5") && level == 3)
				|| (s.equals("5") && level == 5)
				|| (s.equals("5") && level == 6)
				|| (s.equals("5") && level == 8)
				|| (s.equals("5") && level == 9)
				|| (s.equals("5") && level == 11)) {
			return "five";
		}

		if ((s.equals("5") && level == 1) || (s.equals("5") && level == 4)
				|| (s.equals("5") && level == 7)
				|| (s.equals("5") && level == 10)) {
			return "fifty";
		}

		if ((s.equals("6") && level == 0) || (s.equals("6") && level == 2)
				|| (s.equals("6") && level == 3)
				|| (s.equals("6") && level == 5)
				|| (s.equals("6") && level == 6)
				|| (s.equals("6") && level == 8)
				|| (s.equals("6") && level == 9)
				|| (s.equals("6") && level == 11)) {
			return "six";
		}

		if ((s.equals("6") && level == 1) || (s.equals("6") && level == 4)
				|| (s.equals("6") && level == 7)
				|| (s.equals("6") && level == 10)) {
			return "sixty";
		}

		if ((s.equals("7") && level == 0) || (s.equals("7") && level == 2)
				|| (s.equals("7") && level == 3)
				|| (s.equals("7") && level == 5)
				|| (s.equals("7") && level == 6)
				|| (s.equals("7") && level == 8)
				|| (s.equals("7") && level == 9)
				|| (s.equals("7") && level == 11)) {
			return "seven";
		}

		if ((s.equals("7") && level == 1) || (s.equals("7") && level == 4)
				|| (s.equals("7") && level == 7)
				|| (s.equals("7") && level == 10)) {
			return "seventy";
		}

		if ((s.equals("8") && level == 0) || (s.equals("8") && level == 2)
				|| (s.equals("8") && level == 3)
				|| (s.equals("8") && level == 5)
				|| (s.equals("8") && level == 6)
				|| (s.equals("8") && level == 8)
				|| (s.equals("8") && level == 9)
				|| (s.equals("8") && level == 11)) {
			return "eight";
		}

		if ((s.equals("8") && level == 1) || (s.equals("8") && level == 4)
				|| (s.equals("8") && level == 7)
				|| (s.equals("8") && level == 10)) {
			return "eighty";
		}

		if ((s.equals("9") && level == 0) || (s.equals("9") && level == 2)
				|| (s.equals("9") && level == 3)
				|| (s.equals("9") && level == 5)
				|| (s.equals("9") && level == 6)
				|| (s.equals("9") && level == 8)
				|| (s.equals("9") && level == 9)
				|| (s.equals("9") && level == 11)) {
			return "nine";
		}

		if ((s.equals("9") && level == 1) || (s.equals("9") && level == 4)
				|| (s.equals("9") && level == 7)
				|| (s.equals("9") && level == 10)) {
			return "ninety";
		}

		return "";
	}

	// roundUp fonksiyonlari , tamamalanMAdi!
	public static double roundUp(double number, long factor) {
		long result = factor;
		while (number > result) {
			result = result + factor;
		}
		return (double) result;
	}

	public static double roundUp(double number, String curr) {
		return roundUp(1, 1);
	}

	public static Timestamp addDays(Timestamp pDate, long numDays) {
		int currDay = pDate.getDate();
		int currMon = pDate.getMonth();
		int currYear = pDate.getYear();
		int monDays = getMonthDays(currMon);
		if (numDays >= 0) {
			for (int i = 0; i < numDays; i++) {
				if ((currDay + 1) > monDays) {
					currDay = 1;
					if ((currMon + 1) > 11) {
						currMon = 1;
						currYear += 1;
					} else {
						currMon += 1;
						monDays = getMonthDays(currMon);
					}
				} else {
					currDay += 1;
				}
			}
		} else {
			for (int i = 0; i < Math.abs(numDays); i++) {
				if ((currDay == 1) && (currMon == 1)) {
					currDay = 31;
					currMon = 12;
					currYear -= 1;
				} else {
					if (currDay == 1) {
						currDay = getMonthDays(currMon - 1);
						currMon -= 1;
					} else {
						currDay -= 1;
					}
				}
			}
		}

		pDate.setDate(currDay);
		pDate.setMonth(currMon);
		pDate.setYear(currYear);
		return pDate;
	}

	public static int getMonthDays(int mon) {
		// Month sayilari ocak=0, subat=1 gibi gidiyor. 12 bir sonraki yilin
		// ocagi
		// Bu nedenle if kosullari garip gorunebilir, ama dogrudur.
		if ((mon == 0) || (mon == 2) || (mon == 4) || (mon == 6) || (mon == 7)
				|| (mon == 9) || (mon == 11) || (mon == 12)) {
			return 31;
		} else if ((mon == 3) || (mon == 5) || (mon == 8) || (mon == 10)) {
			return 30;
		} else if (mon == 1) {
			return 28;
		}
		return 0;
	}

	public static String getMonthMMM(int mon) {
		if (mon == 1)
			return "JAN";
		if (mon == 2)
			return "FEB";
		if (mon == 3)
			return "MAR";
		if (mon == 4)
			return "APR";
		if (mon == 5)
			return "MAY";
		if (mon == 6)
			return "JUN";
		if (mon == 7)
			return "JUL";
		if (mon == 8)
			return "AUG";
		if (mon == 9)
			return "SEP";
		if (mon == 10)
			return "OCT";
		if (mon == 11)
			return "NOV";
		if (mon == 12)
			return "DEC";
		return "";
	}

	public static String getMonths_TR(int mon) {
		if (mon == 1)
			return "Ocak";
		if (mon == 2)
			return "Þubat";
		if (mon == 3)
			return "Mart";
		if (mon == 4)
			return "Nisan";
		if (mon == 5)
			return "Mayýs";
		if (mon == 6)
			return "Haziran";
		if (mon == 7)
			return "Temmuz";
		if (mon == 8)
			return "Aðustos";
		if (mon == 9)
			return "Eylül";
		if (mon == 10)
			return "Ekim";
		if (mon == 11)
			return "Kasým";
		if (mon == 12)
			return "Aralýk";
		return "";
	}

	public static double roundUp(double number) {
		String str = String.valueOf((long) number);
		int n = str.length();
		double x1 = Math.ceil((Math.ceil(((double) n) / 2)) / 2);
		double x2 = 0;
		if (Math.sqrt(Math.sqrt(number)) > (Math.pow(10, x1)) / 2)
			x2 = (Math.pow(10, x1)) / 2;
		else
			x2 = Math.pow(10, x1 - 1);
		double x3 = getModulus(number, x2);
		return (number + x2 - x3);
	}

	public static double getModulus(double number, double mod) {
		while (number >= mod) {
			number = number - mod;
		}
		return number;
	}

	public static long getModulus(long number, long mod) {
		BigInteger num = new BigInteger(String.valueOf(number));
		BigInteger mdl = new BigInteger(String.valueOf(mod));
		num = num.mod(mdl);
		number = num.longValue();
		return number;
	}

	public static String replaceString(String srcStr, String oldStr,
			String newStr) {
		int i = 0;
		int newi = 0;
		if (srcStr == null)
			return "";
		while ((i <= srcStr.length()) && (srcStr.indexOf(oldStr, i) >= 0)) {
			newi = srcStr.substring(0, srcStr.indexOf(oldStr, i)).length()
					+ newStr.length();
			String temp1 = srcStr.substring(0, srcStr.indexOf(oldStr, i));
			String temp2 = "";
			int int1 = srcStr.length() - srcStr.indexOf(oldStr, i)
					- oldStr.length();
			if (int1 != 0)
				temp2 = srcStr.substring(
						srcStr.indexOf(oldStr, i) + oldStr.length(),
						srcStr.length());
			srcStr = temp1 + newStr + temp2;
			i = newi;
		}
		return srcStr;
	}

	public static Timestamp convertStringToDateTime(String str) {
		// The string format that this function accepts:
		// YYYYMMDD:hhmm
		java.sql.Date D = new java.sql.Date(1990, 0, 1);
		java.sql.Time T = new java.sql.Time(0, 0, 0);
		str.trim();
		if (str.length() == 0) {
			return null;
		} else {
			String tempStr = getSubString(str, 0, str.indexOf(":"));
			tempStr = getSubString(tempStr, 0, 4) + "-"
					+ getSubString(tempStr, 4, 6) + "-"
					+ getSubString(tempStr, 6, 8);
			D = D.valueOf(tempStr);

			tempStr = getSubString(str, str.indexOf(":") + 1, str.length());
			tempStr = getSubString(tempStr, 0, 2) + ":"
					+ getSubString(tempStr, 2, 4) + ":00";
			T = T.valueOf(tempStr);

			return new Timestamp(D.getYear(), D.getMonth(), D.getDate(),
					T.getHours(), T.getMinutes(), 0, 0);
		}
	}

	public static String replace(String s, char x, char y) {
		int ind1, ind2, indCur = 0;
		String ret = "", tmp = "";
		while ((ind1 = s.indexOf("'", indCur)) > -1) {
			ind2 = s.indexOf("'", ind1 + 1);
			tmp = s.substring(indCur, ind1);
			tmp = tmp.replace(x, y);
			ret += tmp;
			ret += s.substring(ind1, ind2 + 1);
			indCur = ind2 + 1;
		}
		tmp = s.substring(indCur, s.length());
		tmp = tmp.replace(x, y);
		ret += tmp;
		return ret;
	}

	public static int countSubstringOccurences(String str, String sub) {
		int len = sub.length(), ret = 0, curIndx = 0;
		while ((curIndx = str.indexOf(sub, curIndx)) > -1) {
			ret++;
			curIndx += len;
		}
		return ret;
	}

	public static Timestamp getLastMonday(Timestamp t) {
		// nearly finds the last monday. It may deviate 1 minutes at most
		long x, dist = 0;
		int hr = 0, min = 0, day;
		day = t.getDay();
		if (day != 0)
			dist = (day - 1) * 24 * 60 * 60 * 1000;
		else
			dist = 6 * 24 * 60 * 60 * 1000;

		x = t.getTime();
		x -= dist;
		Timestamp resDate = new Timestamp(x);
		resDate.setHours(0);
		resDate.setMinutes(0);
		resDate.setSeconds(0);
		resDate.setNanos(1);
		return resDate;
	}

	public static Timestamp getBeginningOfMonth(Timestamp t) {
		Timestamp rDate = new Timestamp(t.getTime());
		rDate.setDate(1);
		rDate.setHours(0);
		rDate.setMinutes(0);
		rDate.setSeconds(0);
		rDate.setNanos(1);
		return rDate;
	}

	public static Timestamp getBeginningOfLastMonth(Timestamp t) {
		int x;
		int year;
		year = t.getYear();
		Timestamp rLMDate = new Timestamp(t.getTime());
		x = t.getMonth();

		if (x == 0) {
			rLMDate.setMonth(11);
			rLMDate.setYear(year - 1);
		} else
			rLMDate.setMonth(t.getMonth() - 1);
		rLMDate.setDate(1);
		rLMDate.setHours(0);
		rLMDate.setMinutes(0);
		rLMDate.setSeconds(0);
		rLMDate.setNanos(1);
		return rLMDate;

	}

	public static Timestamp getBeginningOf3Months(Timestamp t) {
		int x, year;
		Timestamp r3MDate = new Timestamp(t.getTime());
		x = t.getMonth();
		year = t.getYear();
		if (x <= 1) {
			if (x == 1) {
				r3MDate.setMonth(11);
				r3MDate.setYear(year - 1);
			} else if (x == 0) {
				r3MDate.setMonth(10);
				r3MDate.setYear(year - 1);
			}
		} else
			r3MDate.setMonth(t.getMonth() - 2);
		r3MDate.setDate(1);
		r3MDate.setHours(0);
		r3MDate.setMinutes(0);
		r3MDate.setSeconds(0);
		r3MDate.setNanos(1);
		return r3MDate;
	}

	public static Timestamp getThisYear(Timestamp t) {
		Timestamp rDate = new Timestamp(t.getTime());
		rDate.setMonth(0);// /////////////
		rDate.setDate(1);
		rDate.setHours(0);
		rDate.setMinutes(0);
		rDate.setSeconds(0);
		rDate.setNanos(1);
		return rDate;
	}

	public static String formSQLString(String arg) {
		String ret = replaceString(arg, "'", "''");
		return ret;
	}

	public static int findElementIndex(String[] str, String fn) {
		for (int i = 0; i < str.length; i++)
			if ((str[i] != null) && (str[i].equals(fn)))
				return i;
		return -1;
	}

	public static int findElementIndex(int[] iArr, int fn) {
		for (int i = 0; i < iArr.length; i++)
			if (iArr[i] == fn)
				return i;
		return -1;
	}

	/*************** StringBuffer Utility Functions *****************************/
	/*************************** BEGIN *****************************/
	public static int StringBufferIndexOf(StringBuffer buf, String str) {
		int lenBuf = buf.length();
		int lenStr = str.length();
		for (int i = 0; i < lenBuf; i++) {
			if (buf.charAt(i) == str.charAt(0)) {
				try {
					boolean stillMatches = true;
					for (int j = 1; stillMatches && j < lenStr; j++) {
						if (str.charAt(j) != buf.charAt(i + j))
							stillMatches = false;
					}
					if (stillMatches)
						return i;
				} catch (StringIndexOutOfBoundsException e) {
				}
			}
		}
		return -1;
	}

	public static boolean StringBufferStartsWith(StringBuffer buf, String str) {
		int len = str.length();
		if (len > buf.length())
			return false;
		for (int j = 0; j < len; j++)
			if (str.charAt(j) != buf.charAt(j))
				return false;
		return true;
	}

	public static boolean StringBufferEndsWith(StringBuffer buf, String str) {
		int lenBuf = buf.length();
		int lenStr = str.length();
		if (lenStr > lenBuf)
			return false;
		for (int j = 1; j < lenStr + 1; j++)
			if (str.charAt(lenStr - j) != buf.charAt(lenBuf - j))
				return false;
		return true;
	}

	public static boolean StringBufferEquals(StringBuffer buf, String str) {
		int lenBuf = buf.length();
		int lenStr = str.length();
		if (lenStr != lenBuf)
			return false;
		for (int j = 0; j < lenStr; j++)
			if (str.charAt(j) != buf.charAt(j))
				return false;
		return true;
	}

	public static String encodeString(String str) {
		String ret = "";
		for (int i = 0; i < str.length(); i++) {
			String tmp = str.substring(i, i + 1);
			int num = encoder * (int) (Math.random() * 26);
			num += ((int) tmp.charAt(0));
			tmp = "0000" + num;
			tmp = tmp.substring(tmp.length() - 4);
			ret += tmp;
		}
		return ret;
	}

	public static String decodeString(String str) {
		String resStr, unify, tempc1, tempc2, tempc3, tempc4;
		int len;
		int num;
		resStr = "";
		len = str.length();
		len = len / 4;
		for (int i = 0; i <= len - 1; i++) {
			tempc1 = str.substring(4 * i + 0, 4 * i + 1);
			tempc2 = str.substring(4 * i + 1, 4 * i + 2);
			tempc3 = str.substring(4 * i + 2, 4 * i + 3);
			tempc4 = str.substring(4 * i + 3, 4 * i + 4);
			unify = tempc1 + tempc2 + tempc3 + tempc4;
			num = Integer.parseInt(unify) % encoder;
			resStr = resStr + (char) num;
		}
		return resStr;
	}

	public static String enter2br(String text) throws Exception {
		String tempStr = (text != null ? text : "");
		tempStr = replaceString(tempStr, "" + (char) 13, "");
		tempStr = replaceString(tempStr, "" + (char) 10, "<br>");
		return tempStr;
	}

	public static Vector getActiveUsers() {
		Vector sorted = new Vector();
		try {
			long longest = 0;
			int ind = 0;
			for (int i = 0; i < vecUserTime.size() - 1; i++) {
				for (int j = i; j < vecUserTime.size(); j++) {
					String usri = "" + vecUsers.elementAt(i);
					String usrj = "" + vecUsers.elementAt(j);
					String timei = "" + vecUserTime.elementAt(i);
					String timej = "" + vecUserTime.elementAt(j);
					String logintimei = "" + vecUserLoginTime.elementAt(i);
					String logintimej = "" + vecUserLoginTime.elementAt(j);
					if (timej.compareTo(timei) > 0) {
						vecUserTime.setElementAt(timei, j);
						vecUserTime.setElementAt(timej, i);
						vecUsers.setElementAt(usri, j);
						vecUsers.setElementAt(usrj, i);
						vecUserLoginTime.setElementAt(logintimei, j);
						vecUserLoginTime.setElementAt(logintimej, i);
					}
				}
			}
		} catch (Exception e) {
		}
		return sorted;
	}

	public static double MakeNumber(String str) { // ÖR: input=1.000.000 ->
													// output=1000000

		String avans = "";
		int i = 0;
		String kar = "";
		if (str.length() > 3) {
			while (i < str.length()) {
				kar = str.substring(i, i + 1);
				if (!kar.equals(".")) {
					avans += kar;
				}
				i++;
			}
		}
		return Double.parseDouble(avans);
	}

	public static String nNokta(double number) { // ÖR: input=1000000
													// output=1.000.000
		String tempstr = "";
		String newstr = "";
		tempstr = Double.toString(number);
		tempstr = tempstr.trim();
		while (tempstr.length() > 3) {
			newstr = "." + tempstr.substring(tempstr.length() - 3) + newstr;
			tempstr = tempstr.substring(0, tempstr.length() - 3);
		}
		return tempstr + newstr;
	}

	public static String printDouble(double dbl) {
		return (nNokta(CommonJava.n15_0(dbl)));
	}

	public static String random(int len) {
		String str = "" + Math.random();
		str = str.substring(2);
		while (len > str.length())
			str = str + str;
		str = str.substring(0, len);
		return str;
	}

	public static String nNokta(String number) { // ÖR: input=1000000
													// output=1.000.000
		String tempstr = "";
		String newstr = "";
		tempstr = number;
		tempstr = tempstr.trim();
		while (tempstr.length() > 3) {
			newstr = "." + tempstr.substring(tempstr.length() - 3) + newstr;
			tempstr = tempstr.substring(0, tempstr.length() - 3);
		}
		return tempstr + newstr;
	}

	public static void sendEmail(String userName, String passWord,
			String emailAddy) {
		/*
		 * String host = "smtpout.netonehosting.com"; String to = emailAddy;
		 * String from = "fromMail"; String subject = "subjectMessage";
		 * 
		 * String messageText = "Some yadda, yadda"; boolean sessionDebug =
		 * false;
		 * 
		 * Properties props = System.getProperties();
		 * props.put("mail.smtp.host", host);
		 * props.put("mail.transport.protocol", "smtp"); Session session =
		 * Session.getDefaultInstance(props, null);
		 * session.setDebug(sessionDebug);
		 * 
		 * try { Message msg = new MimeMessage(session); msg.setFrom(new
		 * InternetAddress(from)); InternetAddress[] address = {new
		 * InternetAddress(to)}; msg.setRecipients(Message.RecipientType.TO,
		 * address); msg.setSubject(subject); msg.setSentDate(new
		 * java.util.Date()); msg.setText(messageText); Transport.send(msg); }
		 * catch (MessagingException mex) {  }
		 */
	}

	public static String hexaToString(String input) {
		String address = input;
		if (input.substring(0, 2).equals("0x")) {
			int len = input.length();
			String[] arrEmailAdd = new String[(len - 2) / 2];
			for (int i = 1; i < ((len - 2) / 2) + 1; i++) {
				arrEmailAdd[i - 1] = input.substring(2 * i, 2 * i + 2);
			}
			char[] addressChars = new char[arrEmailAdd.length];
			for (int i = 0; i < arrEmailAdd.length; i++) {
				addressChars[i] = (char) Integer.parseInt(arrEmailAdd[i], 16);
			}
			address = new String(addressChars);
		} // end of if
		return address;
	}

	public static String generateImage(String imagePath) {
		return "<img src=\" images/" + imagePath + "\"";
	}

	public static String generateImage(String imagePath, String css) {
		return "<img src=\" images/" + imagePath + "\" class=\"" + css + "\"";
	}

	public static String generateImage(String imagePath, int height, int width) {
		return "<img src=\" images/" + imagePath + "\" height=\"" + height
				+ "\" width=\"" + width + "\">";
	}

	public static String generateImageWithPopup(String imagePath,
			String popupLink) {
		return "<img src=\" images/" + imagePath + "\" onClick=\"openW('"
				+ popupLink + "')\">";
	}

	public static String generateImageWithPopup(String imagePath,
			String popupLink, String css) {
		return "<img src=\" images/" + imagePath + "\" class=\"" + css
				+ "\" onClick=\"openW('" + popupLink + "')\">";
	}

	public static String generateImageWithPopup(String imagePath,
			String popupLink, int height, int width) {
		return "<img src=\" images/" + imagePath + "\" height=\"" + height
				+ "\" width=\"" + width + "\" onClick=\"openW('" + popupLink
				+ "')\">";
	}

	/*
	 * Bu metod string icinde virgullerle ayrilmis degerleri vector olarak geri
	 * dondurur
	 */
	public static Vector getStringAsVector(String s) {
		Vector VItems = new Vector();
		if (s != null) {
			String str = s.endsWith(",") ? s : s + ",";
			while (str.indexOf(",") > 0) {
				VItems.add(str.substring(0, str.indexOf((","))).trim());
				str = str.substring(str.indexOf(",") + 1, str.length());
			}
		}
		return VItems;
	}

	public static String[] getStringAsStringArray(String s) {
		Vector items = getStringAsVector(s);
		String[] ret = new String[items.size()];
		for (int i = 0; i < items.size(); i++) {
			ret[i] = (String) items.get(i);
		}
		return ret;
	}

	public static long[] getStringAsLongArray(String s) {
		Vector items = getStringAsVector(s);
		long[] ret = new long[items.size()];
		for (int i = 0; i < items.size(); i++) {
			ret[i] = Long.parseLong(items.get(i).toString());
		}
		return ret;
	}

	public static String getYear(Date today) {
		return dateFormatterYYYY.format(today);
	}

	public static int[] getNextTenYear() {
		int[] years = new int[10];
		int today = Integer.parseInt(getYear(Calendar.getInstance().getTime()));

		for (int i = 0; i < years.length; i++) {
			years[i] = today + i;
		}
		return years;
	}

	public static int strToInt(String s){
		if(strEqualNullOrEmpty(s))
			return 0;
		else
			try{
				return Integer.parseInt(s);
			}catch (Exception e) {
			return 0;
			}
	}


	public static String dateToStr(Date flightdate) {
		if(flightdate == null)
			return "";
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		 
		return df.format(flightdate);
	}
	
	// TK-P012130 - Web 3
	public static String getRequestExtraKeyValue(List<ParamType> extraParams ,String keyValue){
		
		try {
			int i = 0;
			while (i < extraParams.size()) {
				if (extraParams.get(i).getKey().equalsIgnoreCase(keyValue))
					return extraParams.get(i).getValue();
				i++;
			}
		} catch (Exception e) {
			logger.error(StringUtils.stack2string(e));
			
			return "";
		}
		
		return "";
	}
	//
	
	// Web3.0 > E_AKYILDIZ (BEGIN)
	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden CLIENT_IP
	 * bilgisini getirir.
	 */
	public static String getIpAddressFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"CLIENT_IP");
	}

	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden SESSION_ID
	 * bilgisini getirir.
	 */
	public static String getSessionIdFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"SESSION_ID");
	}

	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden
	 * CONVERSATION_ID bilgisini getirir.
	 */
	public static String getConversationIdFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"CONVERSATION_ID");
	}

	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden
	 * CLIENT_REQUEST_ID bilgisini getirir.
	 */
	public static String getClientRequestIdFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"CLIENT_REQUEST_ID");
	}

	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden INSERTED_BY
	 * bilgisini getirir.
	 */
	public static String getInsertedByFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"INSERTED_BY");
	}
	
	public static boolean nullOrEmpty(String input){
		if(input == null || "".equals(input)){
			return true;
		}
		return false;
	}
	// Web3.0 > E_AKYILDIZ (END)
	
	/**
	 * RequestHeader icerisindeki ekstra parametreler listesinden USER_DEPT
	 * bilgisini getirir.
	 */
	public static String getUserDeptFromRequestHeader(
			RequestHeader requestHeader) {
		
		return getRequestExtraKeyValue(requestHeader.getExtraParameters(),
				"USER_DEPT");
	}
	
}
