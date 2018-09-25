package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hello {

	public static void main(String[] args) {
		//这是没意思dsd
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:SSS");
		String formatStr =formatter.format(new Date());
		System.out.println(formatStr);//2017-����-15 13:17:08:355
	    for (int i = 0; i <1000; i++) {
			System.out.println(i);
		}
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String formatStr2 =formatter2.format(new Date());
		System.out.println(formatStr2);//2017-09-15 13:18:44:672
//dsds
	}
}
