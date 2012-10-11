package com.bgIntlgn.server.system.util.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bgIntlgn.client.component.Field.hint.HintData;
import com.bgIntlgn.client.entity.statement.SerialDefine;

public class MyTestApp {

	@BeforeClass
	public static void setUpClass() throws Exception {}

	@AfterClass
	public static void tearDownClass() throws Exception {}

	@Before
	public void setUp() {}

	@After
	public void tearDown() {}

	public void testDBCP() throws SQLException {
		// PoolUtils util = new PoolUtils();
		// util.adapt(factory)
		// KeyedObjectPoolFactory keyPoolFactory = new
		// GenericKeyedObjectPoolFactory(new BaseKeyedPoolableObjectFactory());
		GenericObjectPool connectionPool = new GenericObjectPool(null);
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
				"jdbc:postgresql://localhost:5432/bgIntelligence", "bi", "123");
		@SuppressWarnings("unused")
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
				connectionFactory, connectionPool, null, "select * from dictionarys", false, false);
		DataSource ds = (DataSource) new PoolingDataSource(connectionPool);
		for (int i = 0; i < 3; i++) {
			Connection con = ds.getConnection();
			ResultSet rs = con.createStatement().executeQuery("Select * from dictionarys");
			while (rs.next()) {
				System.out.print(rs.getObject(1) + ", ");
				System.out.print("\n");
			}

			PreparedStatement ps = con.prepareStatement("Select * from dictionarys");
			ResultSet prs = ps.executeQuery();
			while (prs.next()) {
				System.out.print(prs.getObject(1) + "[p], ");
				System.out.print("\n");
			}
		}
	}

	// public void testLocalThread() throws Exception {
	// Thread th1 = new TestTh();
	// Thread th2 = new TestTh();
	// Thread th3 = new TestTh();
	// th1.start();
	// th2.start();
	// th3.start();
	// }

	public void testDate() {
		Date d = new Date();
		System.out.println(d.getTime());
	}

	public void testLoader() throws Exception {
	// Configure conf = new Configure();
	// conf.loaderPackage = "com.bgIntlgn.server.action";
	// Manager mg = LogicManager.getInstance();
	// mg.init(conf);
	}

	public void formatTest() {
		System.out.println(String.format("--------%3d---------", 12));
	}

	public void testSerial() {
		SerialDefine sf = new SerialDefine();
		sf.setBlankCharacter("_");
		sf.setDateBlankCharacter("-");
		sf.setPrefix("Pre");
		sf.setDateLength(4);
		sf.setInfix("inFx");
		sf.setName("test");
		sf.setLength(5);
		sf.setSuffix("sufx");

		System.out.println(String.format("%s : [%s]", sf.getName(), sf.nextSerial(90)));
	}

	/**
	 * 
	 */
	@SuppressWarnings("static-access")
	public void HierarchTest() {
		Base b = new Base();
		System.out.println(b.ser);
		Sub1 s1 = new Sub1();
		System.out.println(s1.ser);
		Sub2 s2 = new Sub2();
		System.out.println(s2.ser);
		Sub2 s21 = new Sub2();
		System.out.println(s21.ser);

		Base ss1 = new Base() {

			{
				ser = "ssssss111111111";
			}
		};
		System.out.println(ss1.ser);
		Base ss2 = new Base() {

			{
				ser = "ssssss22222222222";
			}
		};
		System.out.println(ss2.getClass() + ":" + ss2);
		System.out.println(ss1.getClass() + ":" + ss1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testHintData() {
		HintData[] hd = new HintData[] {
				new HintData("没有我什么事毛线"),
				new HintData("中国四川的榨菜"),
				new HintData("四川成都"),
				new HintData("没有我什么事毛线"),
				new HintData("不好吃的中国四川的榨菜"),
				new HintData("毛线"),
				new HintData("毛线啥子都不是的哈哈嘟嘟地发狂的附件"),
				new HintData("就是线"),
				new HintData("四川") };
		List<HintData> lst = Arrays.asList(hd);
		String org = lst.toString();
		System.out.println(lst.toString());
		for (HintData h : lst) {
			h.compare("四川");
		}
		Collections.sort(lst);
		System.out.println(lst.toString());
		String rslt = lst.toString();
		assertEquals(org, rslt);
	}
}

class Base {

	public int cnt;

	public String c = this.getClass().toString();

	public static String ser = "base";

	public Base(int c) {
		cnt = c;
	}

	public Base() {

	}

	public String toString() {
		return c + ":" + ser + ", cnt=" + cnt;
	}
}

class Sub1 extends Base {

	public Sub1() {
		super(0);
		ser = "1111111111";
	}
}

class Sub2 extends Base {

	public Sub2() {
		super(0);
		ser = "222222222222";
	}
}

class TestTh extends Thread {

	private ThreadLocal<Integer> cnt = new ThreadLocal<Integer>() {

		public Integer initialValue() {
			return -2;
		}
	};

	private ThreadLocal<List<Base>> lst = new ThreadLocal<List<Base>>() {

		public List<Base> initialValue() {
			List<Base> lst = new LinkedList<Base>();

			lst.add(new Base(111));
			lst.add(new Base(222));
			lst.add(new Base(333));
			return lst;
		}
	};
	{}

	public void run() {
		Integer c = cnt.get();
		System.out.println("c = " + cnt.get());
		System.out.println("c2 = " + (cnt.get() + 2));
		System.out.println("c3 = " + cnt.get());
		Random rand = new Random();
		List<Base> tlst = lst.get();
		System.out.println("c = " + lst.get().get(0).cnt);
		lst.get().get(0).cnt = 222222;
		System.out.println("c = " + lst.get().get(0).cnt);
		while (c < 20) {
			c++;
			Base str = tlst.get(rand.nextInt(3));
			str.cnt = c;
			System.out.println("c = " + c + ", local = " + cnt.get() + "\n tlst :"
					+ tlst.toString());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("last: c = " + c + ", local = " + cnt.get());
		System.out.println("tlst :" + tlst + ", \n" + lst.get());
	}
};
