package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.ICourseDAO;
import com.zdnf.model.Course;
import com.zdnf.util.PageModel;

public class CourseDAO extends HibernateDaoSupport implements ICourseDAO {

	@Override
	public void deleteCourse(Course course) {
		
		this.getHibernateTemplate().delete(course);
		
	}

	@Override
	public List findAllCourse() {
	
		return this.getHibernateTemplate().find("from Course");
		
	}

	@Override
	public Course getCourseById(int id) {
		
		return (Course)this.getHibernateTemplate().load(Course.class, id);
		
	}

	@Override
	public void saveCourse(Course course) {
		
		this.getHibernateTemplate().save(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		
		this.getHibernateTemplate().update(course);
		
	}

	@Override
	public PageModel findCourseByPage(final int pageNo,final int pageSize, final String queryStr) {
		PageModel pageModel = null;
	List list = new ArrayList();
	try{
		if(queryStr!=null && queryStr.trim().length() != 0){
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Course c where c.courseName like ? or c.info like ? order by c.id")
									.setParameter(0, "%"+queryStr + "%")
									.setParameter(1, "%"+queryStr + "%")
									.setFirstResult((pageNo - 1) * pageSize)
									.setMaxResults(pageSize)
									.list();
				}
			});
			
		}else{
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("select c from Course c order by c.id")
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
		totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Course c where c.courseName like ? ", 
										                      "%"+queryStr + "%").get(0);
	}else {
		//采用session取得总记录数
		totalRecords = (Long)this.getSession().createQuery("select count(*) from Course c").uniqueResult();
	}
	return totalRecords.intValue();
}

}
