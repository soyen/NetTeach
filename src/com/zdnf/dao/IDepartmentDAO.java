package com.zdnf.dao;

import java.util.List;
import com.zdnf.model.Department;
import com.zdnf.util.PageModel;

public interface IDepartmentDAO {
	
	public void saveDepartment(Department department);
	
	public void deleteDepartment(Department departmen);
	
	public Department getDepartmentById(int id);
	
	public void updateDepartment(Department department);
	
	public List<Department> findAllDepartment();
	
	public PageModel findDepartmentByPage(final int pageNo,final int pageSize,final String queryStr);

}
