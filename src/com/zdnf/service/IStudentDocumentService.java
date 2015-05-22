package com.zdnf.service;

import java.io.OutputStream;
import java.util.Set;

import com.zdnf.model.Course;
import com.zdnf.model.Notice;
import com.zdnf.model.Source;
import com.zdnf.util.PageModel;

public interface IStudentDocumentService {
	
	 public Notice getNotice(int id);
	 public PageModel queryNotice(int pageNo,int pageSize,String queryStr);
	 
	 
	 public Source getSource(int id);
	 public PageModel querySourse(int pageNo,int pageSize,String queryStr);
	 public String getSourceFileName(int id);
	 void writeSource(OutputStream os,int id);
	 
	 public Course getCourse(int courseId);	 
	 public Set getOwnCourse(int studentId);	 
	 public String deleteCourse(int studentId,int courseId);
	 public String getCourseFileName(int id);
	 void writeCourse(OutputStream os,int id);

}
