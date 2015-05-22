package com.zdnf.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.INoticeDAO;
import com.zdnf.model.Course;
import com.zdnf.model.Notice;

import com.zdnf.service.IAdminDocumentService;
import com.zdnf.util.PageModel;

public class AdminDocumentService implements IAdminDocumentService {
	
	private INoticeDAO noticeDAO;
	
	private ICourseDAO courseDAO;
	
	
	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	
	
	
	public void saveNotice(String title, String content) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setCreateTime(new Date());
		noticeDAO.saveNotice(notice);
		
	}

	public void deleteNotice(int id) {
		noticeDAO.deleteNotice(getNotice(id));
		}

	public Notice getNotice(int id) {
		return noticeDAO.getNoticeById(id);
	}


	public void updateNotice(int id,String title,String content) {
		Notice notice = getNotice(id);
		notice.setTitle(title);
		notice.setContent(content);
		noticeDAO.updateNotice(notice);
		
	}
    public PageModel queryNotice(int pageNo,int pageSize,String queryStr){
		return noticeDAO.findNoticeByPage(pageNo, pageSize, queryStr);
    	
    }
	
	
	

	@Override
	public void deleteCourse(int id) {
		courseDAO.deleteCourse(getCourse(id));

	}

	@Override
	public Course getCourse(int id) {
		return courseDAO.getCourseById(id);
	}

	@Override
	public void saveCourse(String courseName, String info,String fileName,byte[] fileData) {
		Course course = new Course();
		course.setCourseName(courseName);
		course.setInfo(info);
		course.setFileName(fileName);
		course.setFileContent(fileData);
		courseDAO.saveCourse(course);

	}

	@Override
	public void updateCourse(int id, String courseName, String info,String fileName,byte[] fileData) {
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

	@Override
	public PageModel queryCourse(int pageNo, int pageSize, String queryStr) {
		return courseDAO.findCourseByPage(pageNo, pageSize, queryStr);
	}
	
	public String getFileName(int id){
		return courseDAO.getCourseById(id).getFileName();
		
	}

	@Override
	public void write(OutputStream os, int id) {
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
		
	

}
