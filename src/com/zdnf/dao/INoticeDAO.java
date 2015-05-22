package com.zdnf.dao;

import java.util.List;

import com.zdnf.model.Notice;
import com.zdnf.util.PageModel;

public interface INoticeDAO {
	
	    public void saveNotice(Notice notice);
		
		public void deleteNotice(Notice notice);
		
		public Notice getNoticeById(int id);
		
		public void updateNotice(Notice notice);
		
		public List<Notice> findAllNotice();
		
		public PageModel findNoticeByPage(final int pageNo,final int pageSize,final String queryStr);
		
		public List<Notice> getLatestNotices();


}
