package com.kurui.test.ibatis;

import java.io.Reader;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestIBatis extends TestCase {

	static Logger logger = Logger.getLogger(TestIBatis.class.getName());

	public static void main(String[] args) {
		String resource = "SqlMapClient.xml";
		resource = "com/ibatis/test/" + resource;

		// sqlMap系统初始化完毕，开始执行update操作
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			sqlMap.startTransaction();

			IBatis ibatis = new IBatis();
			// ibatis.setId(new Integer(1));
			// ibatis.setName("Erica");
			// ibatis.setAge(new Integer(1));
			// sqlMap.insert("insertIBatis", ibatis);
			// System.out.println("insert success ");

			ibatis = (IBatis) sqlMap.queryForObject("getIBatis", "Erica");
			if (ibatis != null) {
				System.out.println("result:" + ibatis.getId() + "--Name:"
						+ ibatis.getName());
			} else {
				System.out.println("ibatis is null ");
			}

			//
			sqlMap.commitTransaction();
		} catch (Exception e) {
			logger.debug(e.toString());
			e.printStackTrace();
		}
	}
}
