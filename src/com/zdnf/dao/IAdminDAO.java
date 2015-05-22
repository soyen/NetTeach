package com.zdnf.dao;

import com.zdnf.model.Admin;


public interface IAdminDAO {
	
	public Admin validate(String username,String password);

}
