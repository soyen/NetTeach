package com.zdnf.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.zdnf.model.Student;

public class CourseForm extends ActionForm {
	
	private int id;
	
	private String courseName;
	
	private String info;
	
	private Set<Student> students;
	
	private String fileName;
	
	private FormFile fileContent;
	
	private String remark;

	
	//查询条件
	private String queryStr ;

	//第几页
	private int pageNo;
	
	//每页多少条
	private int pageSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FormFile getFileContent() {
		return fileContent;
	}

	public void setFileContent(FormFile fileContent) {
		this.fileContent = fileContent;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
