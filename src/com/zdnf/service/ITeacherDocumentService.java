package com.zdnf.service;

import java.io.OutputStream;
import java.util.Set;

import com.zdnf.model.Course;
import com.zdnf.model.Notice;
import com.zdnf.model.Source;
import com.zdnf.util.PageModel;

public interface ITeacherDocumentService {
	
	
	 public Notice getNotice(int id);
	 public PageModel queryNotice(int pageNo,int pageSize,String queryStr);
	 
	 public void saveSource(String fileName,byte[] fileData);
	 public void deleteSource(int id);
	 public Source getSource(int id);
	 public PageModel querySourse(int pageNo,int pageSize,String queryStr);
	 public String getSourceFileName(int id);
	 void writeSource(OutputStream os,int id);
	 
	 
	 public void saveCourse(String courseName, String info,String fileName,byte[] fileData,int teacherId);
	 public void deleteCourse(int id);
	 public Course getCourse(int id);
	 public void updateCourse(int id, String courseName, String info,String fileName,byte[] fileData,String remark);
	 public Set getTeacherCourse(int teacherId);
	 public Set getCourseStudent(int courseId);
	 public String getCourseFileName(int id);
	 void writeCourse(OutputStream os,int id);
}
	
