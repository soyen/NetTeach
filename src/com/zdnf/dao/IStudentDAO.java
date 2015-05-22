package com.zdnf.dao;

import java.util.List;

import com.zdnf.model.Student;
import com.zdnf.util.PageModel;

public interface IStudentDAO {
	
	    public Student validate(String username,String password);

	    public void saveStudent(Student student);
		
		public void deleteStudent(Student student);
		
		public Student getStudentById(int id);
		
		public void updateStudent(Student student);
		
		public List<Student> findAllStudent();
		
		public PageModel findStudentByPage(final int pageNo,final int pageSize,final String queryStr);
}
