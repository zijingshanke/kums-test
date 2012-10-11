package com.kurui.test.base.util;


public class TestJingZheng{
String para1;
StringBuffer para2;

public void method1(String param){
	para1 = param.replace('j','l');
}

public void method2(StringBuffer param){
	para2 = param.append('c');
}

public static void main(String[] args){
	TestJingZheng obj = new TestJingZheng();
	obj.method1(new String("java"));
	obj.method2(new StringBuffer("java"));
	System.out.println(obj.para1);
	System.out.println(obj.para2.toString());
}

}
