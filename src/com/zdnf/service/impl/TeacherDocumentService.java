package com.zdnf.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.INoticeDAO;
import com.zdnf.dao.ISourceDAO;
import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Course;
import com.zdnf.model.Notice;
import com.zdnf.model.Source;
import com.zdnf.model.Teacher;
import com.zdnf.service.ITeacherDocumentService;
import com.zdnf.util.PageModel;

public class TeacherDocumentService implements ITeacherDocumentService {
	
	private INoticeDAO noticeDAO;
	private ICourseDAO courseDAO;
	private ITeacherDAO teacherDAO;
	private ISourceDAO sourceDAO;
	
	
	

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
	public void deleteSource(int id) {
		sourceDAO.deleteSource(getSource(id));
		
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
	public void saveSource(String fileName,byte[] fileData) {
		Source source = new Source();
		source.setFileName(fileName);
		
		source.setFileContent(fileData);
		sourceDAO.saveSource(source);
		
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
	public void saveCourse(String courseName, String info, String fileName,
			byte[] fileData, int teacherId) {
		Course course = new Course();
		Teacher teacher = teacherDAO.getTeacherById(teacherId);
		course.setCourseName(courseName);
		course.setInfo(info);
		course.setFileName(fileName);

		course.setTeacher(teacher);
		course.setFileContent(fileData);
		courseDAO.saveCourse(course);
		
	}
	@Override
	public void deleteCourse(int id) {
		courseDAO.deleteCourse(getCourse(id));
		
	}
	@Override
	public String getCourseFileName(int id) {
		return courseDAO.getCourseById(id).getFileName();
	}
	@Override
	public Course getCourse(int id) {
		return courseDAO.getCourseById(id);
	}
	
	@Override
	public void updateCourse(int id, String courseName, String info,
			String fileName, byte[] fileData, String remark) {
		Course course = getCourse(id);
		course.setCourseName(courseName);
		course.setInfo(info);
		if(fileData.equals("")){
		courseDAO.updateCourse(course);
		}else{
		course.setFileName(fileName);
		course.setFileContent(fileData);
		courseDAO.updateCourse(course);
		}
		
	}
	public void writeCourse(OutputStream os, int id) {
		Course cource = courseDAO.getCourseById(id);
		try
		{
		 os.write(cource.getFileContent());
		 os.flush();
	       }
		 catch (IOException ex)
		{
		throw new RuntimeException(ex);
		 }
		 
	}
	@Override
	public Set getTeacherCourse(int teacherId) {
		Teacher teacher = teacherDAO.getTeacherById(teacherId);
		Set courseSet = teacher.getCourses();
		return courseSet;
	}

	@Override
	public Set getCourseStudent(int courseId) {
		Course course = getCourse(courseId);
		return course.getStudents();
	}

	

	
	

}
