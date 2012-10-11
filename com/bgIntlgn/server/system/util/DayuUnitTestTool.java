/*package com.bgIntlgn.server.system.util;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.catalina.deploy.Test;

import com.bgIntlgn.server.system.util.test.MyTestApp;

*//**
 * 
 * @author yuhuibear
 *//*
public class DayuUnitTestTool {

	public static void main(String[] args) {
		try {
			MyTestApp instance = new MyTestApp();
			for (Method cmd : Test.class.getDeclaredMethods()) {
				System.out.println("___________" + cmd.getName() + "___________");
				cmd.invoke(instance);
			}
		} catch (Exception ex) {
			Logger.getLogger(DayuUnitTestTool.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
*/