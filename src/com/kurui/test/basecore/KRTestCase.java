package com.kurui.test.basecore;

import junit.framework.TestCase;

public class KRTestCase extends TestCase {
	/**
	 * 规划：
	 * 1.脱离容器测试方法
	 * 2.
	 */

	static {
		// 初始化JDBC连接池
		initDataSource();
	}

	/**
	 * 业务方法
	 */
	public static void testBase() {
		// =================
		// =================

		destory();
	}

	/**
	 * 初始化JDBC连接池
	 */
	private static void initDataSource() {
	}

	/**
	 * 释放资源
	 */
	private static void destory() {
	}

}
