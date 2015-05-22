package com.zdnf.dao;

import java.util.List;

import com.zdnf.model.Classes;
import com.zdnf.util.PageModel;

public interface IClassesDAO {
	
	    public void saveClasses(Classes classes);
		
		public void deleteClasses(Classes classes);
		
		public Classes getClassesById(int id);
		
		public void updateClasses(Classes classes);
		
		public List<Classes> findAllClasses();
		
		public PageModel findDepartmentByPage(final int pageNo,final int pageSize,final String queryStr);

}
