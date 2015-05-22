package com.zdnf.service;

import java.io.OutputStream;
import java.util.List;

import com.zdnf.model.Course;
import com.zdnf.model.Notice;
import com.zdnf.util.PageModel;

public interface IAdminDocumentService {
	
	public void saveNotice(String title, String content);
	public void deleteNotice(int id);
	public Notice getNotice(int id);
	public void updateNotice(int id,String title,String content);
    public PageModel queryNotice(int pageNo,int pageSize,String queryStr);
	
	public void saveCourse(String courseName, String info,String fileName,byte[] fileData);
	public void deleteCourse(int id);
	public Course getCourse(int id);
	public void updateCourse(int id, String courseName, String info,String fileName,byte[] fileData);
	public PageModel queryCourse(int pageNo,int pageSize,String queryStr);
	public String getFileName(int id);
	void write(OutputStream os,int id);

}
