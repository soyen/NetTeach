package com.zdnf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zdnf.dao.IClassesDAO;
import com.zdnf.dao.IDepartmentDAO;
import com.zdnf.model.Classes;
import com.zdnf.model.Department;
import com.zdnf.service.IAdminDeptService;
import com.zdnf.util.PageModel;

public class AdminDeptService implements IAdminDeptService {
	
	private IDepartmentDAO departmentDAO;
	
	private IClassesDAO classesDAO;

	public void setClassesDAO(IClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}



	public void setDepartmentDAO(IDepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	

	@Override
	public void deleteClasses(int id) {
		classesDAO.deleteClasses(getClasses(id));

	}
	
	@Override
	public List findAllClasses() {
		return classesDAO.findAllClasses();
	}
	
	@Override
	public Classes getClasses(int id) {
		return classesDAO.getClassesById(id);
	}
	
	@Override
	public void saveClasses(String className,int departmentId) {
	  Department department = departmentDAO.getDepartmentById(departmentId);
	  Classes classes = new Classes();
	  classes.setClassName(className);
	  classes.setDepartment(department);
     classesDAO.saveClasses(classes);
		

	}
	
	@Override
	public void updateClasses(int id, String className, String maxCapacity) {
		Classes classes = getClasses(id);
		classes.setClassName(className);
		classesDAO.updateClasses(classes);

	}
	@Override
	public PageModel queryClasses(int pageNo, int pageSize, String queryStr) {
	     return classesDAO.findDepartmentByPage(pageNo, pageSize, queryStr);
	}


	
	
	
	@Override
	public void saveDepartment(String departmentName, String introduce) {
		Department department = new Department();
		department.setDepartmentName(departmentName);
		department.setIntroduce(introduce);
		departmentDAO.saveDepartment(department);

	}

	
	@Override
	public void deleteDepartment(int id) {
		departmentDAO.deleteDepartment(getDepartment(id));

	}

	@Override
	public void updateDepartment(int id, String departmentName,
			String introduce) {
		Department department = getDepartment(id);
		department.setDepartmentName(departmentName);
		department.setIntroduce(introduce);
		departmentDAO.updateDepartment(department);

	}
	
	@Override
	public Department getDepartment(int id) {
		return departmentDAO.getDepartmentById(id);
	}


	@Override
	public List findAllDepartment() {
		return departmentDAO.findAllDepartment();
		
	}


	
	@Override
	public PageModel queryDepartment(int pageNo, int pageSize, String queryStr) {
		return departmentDAO.findDepartmentByPage(pageNo, pageSize, queryStr);
	}
	

}
