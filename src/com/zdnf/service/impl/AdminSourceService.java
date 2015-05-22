package com.zdnf.service.impl;

import java.io.IOException;
import java.io.OutputStream;

import com.zdnf.dao.ISourceDAO;

import com.zdnf.model.Source;
import com.zdnf.service.IAdminSourceService;
import com.zdnf.util.PageModel;

public class AdminSourceService implements IAdminSourceService {

	private ISourceDAO sourceDAO;
	
	public void setSourceDAO(ISourceDAO sourceDAO) {
		this.sourceDAO = sourceDAO;
	}

	@Override
	public void deleteSource(int id) {
		sourceDAO.deleteSource(getSource(id));
		
	}

	@Override
	public String getFileName(int id) {
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
	public void write(OutputStream os, int id) {
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

		

}
