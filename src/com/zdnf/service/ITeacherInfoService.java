package com.zdnf.service;

import com.zdnf.model.Teacher;

public interface ITeacherInfoService {
	
	public Teacher getTeacherInfo(int id);
	
	public void updateInfo(int id,String username,String password,String sex,String info,String name);

}
