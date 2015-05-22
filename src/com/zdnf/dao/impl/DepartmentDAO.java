package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IDepartmentDAO;
import com.zdnf.model.Department;
import com.zdnf.util.PageModel;

public class DepartmentDAO extends HibernateDaoSupport implements
		IDepartmentDAO {

	@Override
	public void deleteDepartment(Department departmen) {
		this.getHibernateTemplate().delete(departmen);

	}

	@Override
	public List findAllDepartment() {
		return this.getHibernateTemplate().loadAll(Department.class);
	}

	@Override
	public Department getDepartmentById(int id) {
		return (Department)this.getHibernateTemplate().load(Department.class,id);
	}

	@Override
	public void saveDepartment(Department department) {
		this.getHibernateTemplate().save(department);

	}

	@Override
	public void updateDepartment(Department department) {
	    this.getHibernateTemplate().update(department);

	}
	
	public PageModel findDepartmentByPage(final int pageNo,final int pageSize,final String queryStr) {
		PageModel pageModel = null;
		List list = new ArrayList();
		try{
			if(queryStr!=null && queryStr.trim().length() != 0){
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("from Department d where d.departmentName like ? order by d.id")
										.setParameter(0, "%"+queryStr + "%")
										.setFirstResult((pageNo - 1) * pageSize)
										.setMaxResults(pageSize)
										.list();
					}
				});
				
			}else{
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("select d from Department d order by d.id")
						.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
					}
				});
				
			}
			pageModel = new PageModel();
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setList(list);
			pageModel.setTotalRecords(getTotalRecords(queryStr));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageModel;
		
	}
	
	private int getTotalRecords(String queryStr) {
		Long totalRecords = 0L;
		if (queryStr != null && queryStr.trim().length() != 0) {
			//采用模板取得总记录数据
			totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Department d where d.departmentName like ? ", 
					                                              "%"+queryStr + "%").get(0);
		}else {
			//采用session取得总记录数
			totalRecords = (Long)this.getSession().createQuery("select count(*) from Department d").uniqueResult();
		}
		return totalRecords.intValue();
	}

}
