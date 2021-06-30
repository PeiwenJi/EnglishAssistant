package admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
* ����������ʱ�乤���࣬��Ҫ�������Ŀ���е�һЩ��������ʱ�䴦�������з�װ�������ڿ�����ʹ��.
*/
public class DateTimeTool {

/**
* ��������ʽ���ַ������ڣ��Ƿ����ָ����ʽ���Ƿ�Ϊ�գ��������ڵĺϷ��Ķ����м���
*
* @param dateString
* Ҫ���м��������ַ���
*
* @return boolean: ����ָ����ʽ���� true������Ϊ false
* @throws ParseException
*/
public static boolean checkDateString(String dateString) {

// ��������
if (dateString == null) {
return false;
}

String[] strs = dateString.split("-");
if (strs == null || strs.length != 3) {
return false;
}
dateString = "";
dateString += strs[0];
dateString += "-";
if (strs[1].length() < 2) {
dateString += "0" + strs[1];
} else {
dateString += strs[1];
}
dateString += "-";
if (strs[2].length() < 2) {
dateString += "0" + strs[2];
} else {
dateString += strs[2];
}

SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd");

try {
Date date = simpleDF.parse(dateString);
String newDateString = simpleDF.format(date);
if (newDateString.equals(dateString))
return true;
else
return false;
} catch (ParseException e) {
throw new RuntimeException("����[" + dateString + "]��ʽ��Ч.");
}
}

/**
* �жϵ�ǰ�����Ƿ����,���ڸ�ʽ���� yyyy-MM-dd(ע��)
*
* @param nowDate
* ��ǰ����
* @param expireDate
* ��������
* @return true:�ѹ��� false:δ���� �����Ƿ�:����true
*/
public static boolean isDateExpire(Date nowDate, Date expireDate) {
if (expireDate == null || nowDate == null) {
return false;
}
Calendar cal = Calendar.getInstance();
cal.setTime(expireDate);
Calendar cal2 = Calendar.getInstance();
cal2.setTime(nowDate);
return cal.after(cal2);
}

private static boolean isDateExpire(String nowDate, String expireDate) throws ParseException {
if (!checkDateString(nowDate))
return true;
if (!checkDateString(expireDate))
return true;

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date myExpireDate = null;
Date myNowDate = null;
try {
myExpireDate = dateFormat.parse(expireDate);
myNowDate = dateFormat.parse(nowDate);
} catch (ParseException e) {
e.printStackTrace();
return false;
}
return isDateExpire(myExpireDate, myNowDate);
}

/**
* ��������ʽ���ַ���ʱ�䣬�Ƿ����ָ����ʽ���Ƿ�Ϊ�գ�����ʱ��ĺϷ��Ķ����м���
*
* @param timeString
* Ҫ���м��������ַ���
*
* @return boolean: ����ָ����ʽ���� true������Ϊ false
*/
public static boolean checkTimeString(String timeString) {

// ��������
if (timeString == null) {
return false;
}

SimpleDateFormat simpleDF = new SimpleDateFormat("HH:mm:SS");

try {
Date date = simpleDF.parse(timeString);
String newDateString = simpleDF.format(date);
if (newDateString.equals(timeString))
return true;
else
return false;
} catch (ParseException e) {
return false;
}
}

/**
* ��Date���͵�ʱ��ת��Ϊ java.sql.Date ���͵�ʱ��
*
* @param date
* Date ���͵�ʱ��
*
* @return java.sql.Date �ɹ�����ת���õ�Date���Ͷ��� null�������쳣
*/
public static java.sql.Date getSqlDateFromDate(Date date) {

// ��������
if (date == null) {
return null;
}
java.sql.Date dateSql = new java.sql.Date(date.getTime());

return dateSql;
}

/**
* ��java.sql.Date ���͵�ʱ��ת��Ϊ Date���͵�ʱ��
*
* @param sqlDate
* java.sql.Date���͵�ʱ��
*
* @return Date �ɹ�����ת���õ�java.sql.Date���Ͷ��� null�������쳣
*/
public static Date getDateFromSqlDate(java.sql.Date sqlDate) {

// ��������
if (sqlDate == null) {
return null;
}
Date date = new java.sql.Date(sqlDate.getTime());

return date;
}

/**
* ��ָ����ʽΪ��yyyy-MM-dd���������ַ�����ת��ΪDate�Ͷ���
*
* @param dateString
* Ҫת���������ַ�������ʽΪ��yyyy-MM-dd��
*
* @return Date: ����ת���ɹ���Date�Ͷ���, null: �����쳣
* @throws ParseException
*/
public static Date getDateFromString(String dateString) {

// ��������
try {
if (!checkDateString(dateString)) {
return null;
}
} catch (Exception e) {
e.printStackTrace();
}

return getDateFromString(dateString, "yyyy-MM-dd");
}

/**
* ��ָ�������ڸ�ʽ�ַ�����ʽ�������ַ���ΪDate�Ͷ���,���Ը�ʽ�� ��ȷ�Խ��м��飬���ԣ���ʽ����Ļ������ش�������ڶ���
*
* ���ڸ�ʽ�ַ�����д������SimpleDateFormat���е�������
*
* @param dateString
* Ҫת���������ַ���
* @param pattern
* ָ�������ڸ�ʽ�ַ���
*
* @return Date: ����ת���ɹ���Date�Ͷ���, null: �����쳣
*/
public static Date getDateFromString(String dateString, String pattern) {
if (dateString == null || pattern == null) {
return null;
}

SimpleDateFormat simpleDF = new SimpleDateFormat(pattern);
Date date = null;
try {
date = simpleDF.parse(dateString);
} catch (ParseException e) {
throw new RuntimeException("����[" + dateString + "]��ʽ��Ч.");
}

return date;
}

/**
* ��ָ����ʽΪ��HH:mm:SS����ʱ���ַ�����ת��ΪDate�Ͷ���
*
* @param timeString
* Ҫת���������ַ�������ʽΪ"HH:mm:SS"
*
* @return Date: ����ת���ɹ���Date�Ͷ���, null: �����쳣
*/
public static Date getDateFromTimeString(String timeString) {
// ��������
if (!checkTimeString(timeString)) {
return null;
}

return getDateFromString(timeString, "HH:mm:SS");
}

/**
* ��ָ����Date�������Ӹ�����<b>����</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param days
* Ҫ���ӵ�<b>����</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>����</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addDay(Date date, int days) {
if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.DAY_OF_YEAR, days);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* �������ָ�������յ�����
*
* @param dateBegin
* ָ��������
* @param days
* ����:���Ĺ�����;����:��ǰ�Ĺ�����
* @return Date
*/
public static Date addWorkDay(Date dateBegin, int days) {
if (dateBegin == null) {
return null;
}
Calendar calBegin = Calendar.getInstance();

// ��������
calBegin.setTime(dateBegin);
if (days >= 0) {
for (; days > 0;) {
calBegin.add(Calendar.DAY_OF_MONTH, 1);
if ((calBegin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) && (calBegin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
days--;
}
}
} else {
for (; 0 > days;) {
calBegin.add(Calendar.DAY_OF_MONTH, -1);
if ((calBegin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) && (calBegin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
days++;
}
}
}

return calBegin.getTime();
}

/**
* ��ָ����Date�������Ӹ�����<b>����</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param months
* Ҫ���ӵ�<b>����</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>����</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addMonth(Date date, int months) {

if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.MONTH, months);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* ��ָ����Date�������Ӹ�����<b>����</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param years
* Ҫ���ӵ�<b>����</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>����</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addYear(Date date, int years) {

if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.YEAR, years);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* ��ָ����Date�������Ӹ�����<b>ʱ����</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param hours
* Ҫ���ӵ�<b>ʱ����</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>ʱ����</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addHour(Date date, int hours) {

if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.HOUR, hours);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* ��ָ����Date�������Ӹ�����<b>������</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param minutes
* Ҫ���ӵ�<b>������</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>������</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addMinute(Date date, int minutes) {
if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.MINUTE, minutes);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* ��ָ����String���Ӹ�����<b>������</b>��õ��µ�String��time�ĸ�ʽΪ Сʱ:���ӣ����ӷ���
*
* @param date
* Ҫ�����ӵ�String
* @param minutes
* Ҫ���ӵ�<b>������</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>������</b>���String, �����쳣���� null
*/
public static String addMinute(String time, int minutes) {
if (time == null || time.trim().length() == 0) {
return null;
}

String result = null;
try {
Date date = new SimpleDateFormat("HH:mm").parse(time);

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.MINUTE, minutes);
Date resultDate = ca.getTime();

result = new SimpleDateFormat("HH:mm").format(resultDate);
} catch (Exception e) {
result = null;
}

return result;
}

/**
* ��ָ����Date�������Ӹ�����<b>������</b>��õ��µ�Date����
*
* @param date
* Ҫ�����ӵ�Date����
* @param seconds
* Ҫ���ӵ�<b>������</b>(����Ϊ��������Ϊ����ʱ��ʾ����)
*
* @return Date: ��������<b>������</b>���Date�Ͷ���, �����쳣���� null
*/
public static Date addSecond(Date date, int seconds) {
if (date == null) {
return null;
}

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.add(Calendar.SECOND, seconds);
Date resultDate = ca.getTime();

return resultDate;
}

/**
* ���������Date�����Ƿ�Ϊ����
*
* @param date
* ���ڼ����Date����
*
* @return true Date����Ϊ���꣬����Ϊ false
*/
public static boolean isLeapYear(Date date) {
if (date == null) {
return false;
}
boolean result = false;

Calendar ca = Calendar.getInstance();
ca.setTime(date);
ca.get(Calendar.YEAR);
int year = ca.get(Calendar.YEAR);

if (((year % 4) == 0 && (year % 100 != 0)) || ((year % 400) == 0)) {
result = true;
}

return result;
}

// ��ȡ���µ�һ��
public static String getMonthFirstDate() {
Calendar cal = Calendar.getInstance();

SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");

// ��ǰ�µĵ�һ��
cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
Date beginTime = cal.getTime();

return datef.format(beginTime);
}

// ��ȡ���µ�һ������һ��
public String getMonthFirstAndEndDate() {
Calendar cal = Calendar.getInstance();

SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
// ��ǰ�µ����һ��
cal.set(Calendar.DATE, 1);
cal.roll(Calendar.DATE, -1);
Date endTime = cal.getTime();
String endTime1 = datef.format(endTime) + " 23:59:59";
// ��ǰ�µĵ�һ��
cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
Date beginTime = cal.getTime();
String beginTime1 = datef.format(beginTime) + " 00:00:00";

return beginTime1 + "," + endTime1;
}

public long getNumBetweenTwoDate(String startDate, String endDate) {
try {
Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(startDate);
Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse(endDate);

// ��������õ���������
long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) > 0 ? (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) : (date2.getTime() - date1.getTime())
/ (24 * 60 * 60 * 1000);

return day + 1;
} catch (Exception e) {
e.printStackTrace();
return 0;
}
}

/**
* ��yyyy-MM-dd������ʽת��Ϊ yyyy��MM��dd�� ����X
* @param date ����
* @param htmlFlag �Ƿ���html��ʽ��ʾ
* @return
* @throws ParseException
*/
public static String parseDateShow(String date,boolean htmlFlag) throws ParseException{
String showDate = "";
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
Date sd = sf.parse(date);

Calendar c = Calendar.getInstance();
c.setTime(sd);
int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

if(htmlFlag){
switch (dayOfWeek) {
case 1:
showDate = "&nbsp;&nbsp;<font color='orange'>������</font>";
break;
case 2:
showDate = "&nbsp;&nbsp;����һ";
break;
case 3:
showDate = "&nbsp;&nbsp;���ڶ�";
break;
case 4:
showDate = "&nbsp;&nbsp;������";
break;
case 5:
showDate = "&nbsp;&nbsp;������";
break;
case 6:
showDate = "&nbsp;&nbsp;������";
break;
case 7:
showDate = "&nbsp;&nbsp;<font color='orange'>������</font>";
break;
}
}else{
switch (dayOfWeek) {
case 1:
showDate = " ������";
break;
case 2:
showDate = " ����һ";
break;
case 3:
showDate = " ���ڶ�";
break;
case 4:
showDate = " ������";
break;
case 5:
showDate = " ������";
break;
case 6:
showDate = " ������";
break;
case 7:
showDate = " ������";
break;
}
}

sf = new SimpleDateFormat("yyyy��MM��dd��");

return sf.format(sd) + showDate;
}

public static void main(String[] args){
try {
// String sdate="2010-08-01";
// String edate="2010-08-25";
//
// System.out.println(DateTimeTool.parseDateShow(sdate, true));
// System.out.println(DateTimeTool.parseDateShow(edate, true));
// System.out.println(DateTimeTool.parseDateShow(sdate, false));
// System.out.println(DateTimeTool.parseDateShow(edate, false));

// String h1 = "15:20";
// String h2 = "19:50";

// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
// Date newDate = DateTimeTool.addMinute(sdf.parse(h1), 10);
// System.out.println(sdf.format(newDate));

// Date newDate2 = DateTimeTool.addMinute(sdf.parse(h1), 0-30);
// System.out.println(sdf.format(newDate2));

// Date newDate3 = DateTimeTool.addMinute(sdf.parse(h2), 20);
// System.out.println(sdf.format(newDate3));

// Date newDate4 = DateTimeTool.addMinute(sdf.parse(h2), 0-30);
// System.out.println(sdf.format(newDate4));

// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
// SimpleDateFormat csf = new SimpleDateFormat("MM-dd");
// long oneday = 24*60*60*1000;
// Date sd = sf.parse(sdate);
// Date ed = sf.parse(edate);
// //�������������������
// long l = (ed.getTime() - sd.getTime())/oneday>0?(ed.getTime() - sd.getTime())/oneday+1:1;
// String[] cells = new String[(int)l];
//
// for (int i = 0; i <cells.length; i++) {
// cells[i] = csf.format(DateTimeTool.addDay(sd, i));
// }
//
// for (String string : cells) {
// System.out.println(string);
// }
} catch (Exception e) {
e.printStackTrace();
}
}

//��ȡһ���µĵ�һ������һ��
public static String getFirstDataAndLastDate(String year,String month) {
Calendar cal = Calendar.getInstance();
SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
// ��ǰ�µĵ�һ��
cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, 1);
String beginTime = datef.format(cal.getTime());

// ��ǰ�µ����һ��
cal.roll(Calendar.DATE, -1);
String endTime = datef.format(cal.getTime());
return beginTime+","+endTime;
}

//��Date��������ת��Ϊ�ַ�������
public static String getStringFromDate(Date date, String pattern) {
if (date == null || pattern == null) {
return null;
}

SimpleDateFormat simpleDF = new SimpleDateFormat(pattern);
return simpleDF.format(date);
}

public static String periodToString(Long millisecond){
String str = "";
long day = millisecond / 86400000;
long hour = (millisecond % 86400000) / 3600000 ;
long minute = (millisecond % 86400000 % 3600000) / 60000;
if(day > 0){
str = String.valueOf(day) + "��";
}
if(hour > 0){
str += String.valueOf(hour) + "Сʱ";
}
if(minute > 0){
str += String.valueOf(minute) + "����";
}
return str;
}
}




