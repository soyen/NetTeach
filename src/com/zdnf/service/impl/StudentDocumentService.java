package com.zdnf.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.Iterator;

import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.INoticeDAO;
import com.zdnf.dao.ISourceDAO;
import com.zdnf.dao.IStudentDAO;
import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Course;
import com.zdnf.model.Notice;
import com.zdnf.model.Source;
import com.zdnf.model.Student;
import com.zdnf.service.IStudentDocumentService;
import com.zdnf.util.PageModel;

public class StudentDocumentService implements IStudentDocumentService {
	
	private INoticeDAO noticeDAO;
	private ICourseDAO courseDAO;
	private ITeacherDAO teacherDAO;
	private ISourceDAO sourceDAO;
	private IStudentDAO studentDAO;

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public void setSourceDAO(ISourceDAO sourceDAO) {
		this.sourceDAO = sourceDAO;
	}

	@Override
	public Notice getNotice(int id) {
		return noticeDAO.getNoticeById(id);
	}

	@Override
	public PageModel queryNotice(int pageNo, int pageSize, String queryStr) {
		return noticeDAO.findNoticeByPage(pageNo, pageSize, queryStr);
	}

	@Override
	public String getSourceFileName(int id) {
		return sourceDAO.getSourceById(id).getFileName();
	}

	@Override
	public Source getSource(int id) {
		return sourceDAO.getSourceById(id);
	}

	@Override
	public PageModel querySourse(int pageNo, int pageSize, String queryStr) {
		return sourceDAO.findSourceByPage(pageNo, pageSize, queryStr);
	}

	@Override
	public void writeSource(OutputStream os, int id) {
		Source source = sourceDAO.getSourceById(id);
		try
		{
		 os.write(source.getFileContent());
		 os.flush();
	       }
		 catch (IOException ex)
		{
		throw new RuntimeException(ex);
		 }
		
	}

	@Override
	public Course getCourse(int courseId) {
		
		return courseDAO.getCourseById(courseId);
	}

	@Override
	public Set getOwnCourse(int studentId) {
		Student student = studentDAO.getStudentById(studentId);
		Set courseSet = student.getCourses();
		return courseSet;
	}

	@Override
	public String deleteCourse(int studentId, int courseId) {
		String result = new String();
		Student student = studentDAO.getStudentById(studentId);
		Course course = courseDAO.getCourseById(courseId);
		Set courseSet = student.getCourses();
		boolean flag = courseSet.remove(course);
		if(flag==true){
			result = "É¾³ý³É¹¦";
		}else result = "É¾³ýÊ§°Ü";
		return result;
	}
	@Override
	public void writeCourse(OutputStream os, int id) {
		Course course = courseDAO.getCourseById(id);
		try
		{
		 os.write(course.getFileContent());
		 os.flush();
	       }
		 catch (IOException ex)
		{
		throw new RuntimeException(ex);
		 }
		
	}
	@Override
	public String getCourseFileName(int id) {
		return courseDAO.getCourseById(id).getFileName();
	}

}
