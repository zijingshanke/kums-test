package com.kurui.test.base.util;

import com.kurui.kums.base.util.DateUtil;

import junit.framework.TestCase;

public class TestDateUtil extends TestCase {
	
	
	
	public static void main(String[] args) {
		
		String strDate="2011-12-01";
		String result=DateUtil.getDateString(strDate,
				"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
		System.out.println(result);
	
	
		System.out.println(DateUtil.getLastDays(3)[0]);
	}
}
