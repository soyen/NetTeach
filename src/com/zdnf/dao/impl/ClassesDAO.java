package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IClassesDAO;
import com.zdnf.model.Classes;
import com.zdnf.util.PageModel;


public class ClassesDAO extends HibernateDaoSupport implements IClassesDAO {

	public void saveClasses(Classes classes) {
		
		this.getHibernateTemplate().save(classes);
			
		
	}

	public void deleteClasses(Classes classes) {
		
	   this.getHibernateTemplate().delete(classes);
		


	}

	public List findAllClasses() {
		
		return (List)this.getHibernateTemplate().loadAll(Classes.class);
			
	}

	public Classes getClassesById(int id) {
		
		return (Classes)this.getHibernateTemplate().load(Classes.class, id);
		
	}

	public void updateClasses(Classes classes) {
		
		this.getHibernateTemplate().update(classes);
		

	}

	public PageModel findDepartmentByPage(final int pageNo,final int pageSize,final String queryStr) {
		PageModel pageModel = null;
		
		List list = new ArrayList();
		try{
			if(queryStr!=null && queryStr.trim().length() != 0){
		
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("from Classes c where c.className like ? order by c.id")
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
						return session.createQuery("select c from Classes c order by c.id")
						
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
			
			totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Classes c where c.className like ?", 
                    "%"+queryStr+"%").get(0);
		}else {
			//采用session取得总记录数
			
			totalRecords = (Long)this.getSession().createQuery("select count(*) from Classes c ").uniqueResult();
		}
		return totalRecords.intValue();
	}

}
