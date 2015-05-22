package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Admin;
import com.zdnf.model.Teacher;
import com.zdnf.util.PageModel;


public class TeacherDAO extends HibernateDaoSupport implements ITeacherDAO {
	
	@Override
	public Teacher validate(String username, String password) {
		String param[]={username,password};	
		List list =getHibernateTemplate().find("from Teacher where username=? and password=?",param);
		if(list.isEmpty())return null;
		Teacher teacher =(Teacher)list.get(0);
		return teacher;
	}

	public void saveTeacher(Teacher teacher) {
		
			this.getHibernateTemplate().save(teacher);
			
		

	}

	public void deleteTeacher(Teacher teacher) {
		
			   this.getHibernateTemplate().delete(teacher);
		
	}

	public List findAllTeacher() {
		
			return (List)this.getHibernateTemplate().loadAll(Teacher.class);
			
	}

	public Teacher getTeacherById(int id) {
		
			return (Teacher)this.getHibernateTemplate().load(Teacher.class, id);
		
	}

	public void updateTeacher(Teacher teacher) {
		
			this.getHibernateTemplate().update(teacher);
		

	}

	@Override
	public PageModel findTeacherByPage(final int pageNo,final int pageSize,final String queryStr) {
		PageModel pageModel = null;
		List list = new ArrayList();
		try{
			if(queryStr!=null && queryStr.trim().length() != 0){
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("from Teacher t where t.name like ? order by t.id")
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
						return session.createQuery("select t from Teacher t order by t.id")
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
			totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Teacher t where t.name like ? ", 
					                                              "%"+queryStr + "%").get(0);
		}else {
			//采用session取得总记录数
			totalRecords = (Long)this.getSession().createQuery("select count(*) from Teacher t").uniqueResult();
		}
		return totalRecords.intValue();
	}
	

}
