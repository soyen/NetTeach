package com.zdnf.service;

import java.io.OutputStream;
import com.zdnf.model.Source;
import com.zdnf.util.PageModel;

public interface IAdminSourceService {
	public void saveSource(String fileName,byte[] fileData);
	public void deleteSource(int id);
	public Source getSource(int id);
    public PageModel querySourse(int pageNo,int pageSize,String queryStr);
	public String getFileName(int id);
	void write(OutputStream os,int id);
}
