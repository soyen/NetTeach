package com.zdnf.dao;


import com.zdnf.model.Source;
import com.zdnf.util.PageModel;

public interface ISourceDAO {
	
	    public void saveSource(Source source);
		
		public void deleteSource(Source source);
		
		public Source getSourceById(int id);
			
		public PageModel findSourceByPage(final int pageNo,final int pageSize,final String queryStr);

}
