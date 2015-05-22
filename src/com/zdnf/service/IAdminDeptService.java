package com.zdnf.service;

import java.util.List;
import java.util.Map;

import com.zdnf.model.Classes;
import com.zdnf.model.Department;
import com.zdnf.util.PageModel;


public interface IAdminDeptService {
	
	public void saveClasses(String className,int departmentId);
	public void deleteClasses(int id);
	public Classes getClasses(int id);
	public void updateClasses(int id,String className,String maxCapacity);
	public List findAllClasses();
	public PageModel queryClasses(int pageNo, int pageSize, String queryStr);
	
	public void saveDepartment(String departmentName,String introduce);
	public void deleteDepartment(int id);
	public Department getDepartment(int id);
	public void updateDepartment(int id,String departmentName,String introduce);
	public List findAllDepartment();
	public PageModel queryDepartment(int pageNo,int pageSize,String queryStr);

}
