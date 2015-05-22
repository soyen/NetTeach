package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IStudentDAO;
import com.zdnf.model.Student;
import com.zdnf.model.Teacher;
import com.zdnf.util.PageModel;

public class StudentDAO extends HibernateDaoSupport implements IStudentDAO {

	public void saveStudent(Student student) {
		
			this.getHibernateTemplate().save(student);
			
		

	}

	public void deleteStudent(Student student) {
		
			   this.getHibernateTemplate().delete(student);
		

	}

	public List findAllStudent() {
		
			return (List)this.getHibernateTemplate().loadAll(Student.class);
			
	}

	public Student getStudentById(int id) {
		
			return (Student)this.getHibernateTemplate().load(Student.class, id);
		
	}

	public void updateStudent(Student student) {
		
			this.getHibernateTemplate().update(student);
		
	}

	@Override
	public PageModel findStudentByPage(final int pageNo,final int pageSize,final String queryStr) {
		PageModel pageModel = null;
		List list = new ArrayList();
		try{
			if(queryStr!=null && queryStr.trim().length() != 0){
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("from Student s where s.name like ? order by s.id")
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
						return session.createQuery("select s from Student s order by s.id")
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
			totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Student s where s.name like ? ", 
					                                              "%"+queryStr + "%").get(0);
		}else {
			//采用session取得总记录数
			totalRecords = (Long)this.getSession().createQuery("select count(*) from Student s").uniqueResult();
		}
		return totalRecords.intValue();
	}

	@Override
	public Student validate(String username, String password) {
		String param[]={username,password};	
		List list =getHibernateTemplate().find("from Student where username=? and password=?",param);
		if(list.isEmpty())return null;
		Student student =(Student)list.get(0);
		return student;
	}

}
