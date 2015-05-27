package com.zdnf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.zdnf.dao.INoticeDAO;
import com.zdnf.model.Notice;
import com.zdnf.servlet.base.BaseServlet;

public class NoticeListServlet extends BaseServlet {

	public void service(HttpServletRequest request ,
			HttpServletResponse response)
			throws IOException , ServletException
	{
		INoticeDAO noticeDAO = (INoticeDAO)getCtx().getBean("noticeDAO");
		List<Notice> noticeList = noticeDAO.findAllNotice();
		JSONArray jsonArray = new JSONArray(noticeList);
		response.setContentType("text/html; charset=UTF-8");	
		response.getWriter().println(jsonArray.toString());
	}
}
