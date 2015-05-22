package com.zdnf.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IAdminDAO;
import com.zdnf.model.Admin;


public class AdminDAO extends HibernateDaoSupport implements IAdminDAO {

	public Admin validate(String username, String password) {
		String param[]={username,password};	
		List list =getHibernateTemplate().find("from Admin where username=? and password=?",param);
		if(list.isEmpty())return null;
		Admin admin =(Admin)list.get(0);
		return admin;
	}


}
