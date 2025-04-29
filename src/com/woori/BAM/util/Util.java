package com.woori.BAM.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	public static String  getDateStr() {
		
	

	LocalDateTime now = LocalDateTime.now();
	String formatter = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
	String regDate = formatter;  // 재활용 용도 
	
	return formatter;
	}
}
