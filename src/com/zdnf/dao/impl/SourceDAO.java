package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.ISourceDAO;
import com.zdnf.model.Source;
import com.zdnf.util.PageModel;

public class SourceDAO extends HibernateDaoSupport implements ISourceDAO {

	@Override
	public void deleteSource(Source source) {
		
		this.getHibernateTemplate().delete(source);
		
	}

	@Override
	public Source getSourceById(int id) {
		
		return (Source)this.getHibernateTemplate().load(Source.class, id);
		
	}

	@Override
	public void saveSource(Source source) {
		
		this.getHibernateTemplate().save(source);
		this.getHibernateTemplate().flush();
		
	}

	
	@Override
	public PageModel findSourceByPage(final int pageNo,final int pageSize, final String queryStr) {
		PageModel pageModel = null;
	List list = new ArrayList();
	try{
		if(queryStr!=null && queryStr.trim().length() != 0){
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Source s where s.fileName like ? order by s.id")
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
					return session.createQuery("select s from Source s order by s.id")
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
		totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Source s where s.fileName like ? ", 
				                                                 "%"+queryStr + "%").get(0);
	}else {
		//采用session取得总记录数
		totalRecords = (Long)this.getSession().createQuery("select count(*) from Source s").uniqueResult();
	}
	return totalRecords.intValue();
}

}
