package com.kurui.test.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AccountIBatisDaoImpl extends SqlMapClientDaoSupport {
	public long save(Account obj) {
		return (Long) getSqlMapClientTemplate().insert("insertAccount", obj);
	}

	public void update(Account obj) {
		getSqlMapClientTemplate().update("updateAccount", obj);
	}

	public void delete(Account obj) {
		getSqlMapClientTemplate().delete("deleteAccountById", obj.getId());
	}

	public Account get(Long primaryKey) {
		return (Account) getSqlMapClientTemplate().queryForObject(
				"selectAccountById", primaryKey);
	}
}