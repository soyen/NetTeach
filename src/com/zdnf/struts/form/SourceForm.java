package com.zdnf.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class SourceForm extends ActionForm {
	
	private int id;
	
	private String remark;
	
	private FormFile fileContent;
	
	private String queryStr ;

	private int pageNo;
	
	private int pageSize;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public FormFile getFileContent() {
		return fileContent;
	}

	public void setFileContent(FormFile fileContent) {
		this.fileContent = fileContent;
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

}
