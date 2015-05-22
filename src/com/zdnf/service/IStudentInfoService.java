package com.zdnf.service;

import com.zdnf.model.Student;


public interface IStudentInfoService {
	
    public Student getStudentInfo(int id);
	
	public void updateInfo(int id,String username,String password,String sex,String info,String name);



}
