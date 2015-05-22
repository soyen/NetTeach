package com.zdnf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.INoticeDAO;
import com.zdnf.model.Notice;
import com.zdnf.util.PageModel;

public class NoticeDAO extends HibernateDaoSupport implements INoticeDAO {

	public void saveNotice(Notice notice) {
		
			this.getHibernateTemplate().save(notice);
		
	}

	public void deleteNotice(Notice notice) {
		
			this.getHibernateTemplate().delete(notice);
		
	}

	public List<Notice> findAllNotice() {
		
			return this.getHibernateTemplate().loadAll(Notice.class);
			
	}

	public Notice getNoticeById(int id) {
		
			return (Notice)this.getHibernateTemplate().load(Notice.class, id);
		
	}

	public void updateNotice(Notice notice) {
		
			this.getHibernateTemplate().update(notice);
		
	}

	@Override
	public PageModel findNoticeByPage(final int pageNo,final int pageSize,final String queryStr) {
		PageModel pageModel = null;
		List list = new ArrayList();
		try{
			if(queryStr!=null && queryStr.trim().length() != 0){
				list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery("from Notice n where n.title like ? or n.content like ? order by n.id")
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
						return session.createQuery("select n from Notice n order by n.id")
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
			totalRecords = (Long)this.getHibernateTemplate().find("select count(*) from Notice n where n.title like ? ", 
					                                              "%"+queryStr + "%").get(0);
		}else {
			//采用session取得总记录数
			totalRecords = (Long)this.getSession().createQuery("select count(*) from Notice n").uniqueResult();
		}
		return totalRecords.intValue();
	}
	
	private int getTotals(){
		Long totalRecords = 0L;
		totalRecords = (Long)this.getSession().createQuery("select count(*) from Notice n").uniqueResult();
		return totalRecords.intValue();
	}
	
	@Override
	public List<Notice> getLatestNotices() {
		List list = new ArrayList();
		int total = this.getTotals();		
        final int latest = 0;
        if(total<10){
        	total = total+10;
        }
 //       latest = total;
		try{
			list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("select n from Notice n order by n.id")
					.setFirstResult(latest)
					.setMaxResults(10)
					.list();
				}
			});
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
