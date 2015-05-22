package com.zdnf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.json.*;

import com.zdnf.dao.IAdminDAO;
import com.zdnf.model.Admin;
import com.zdnf.servlet.base.BaseServlet;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
//@WebServlet(urlPatterns="/android/login.jsp")
public class LoginServlet extends BaseServlet
{
    public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		// ��ȡadminDAO
		IAdminDAO adminDAO = (IAdminDAO)getCtx().getBean("adminDAO");
		// ��֤�û���¼
		int id = 0;
		Admin admin = adminDAO.validate(username, password);
		response.setContentType("text/html; charset=GBK");
		// ��¼�ɹ�
		if (admin != null)
		{
			id = admin.getId();
			request.getSession(true).setAttribute("id" , id);
		}
		try
		{
			// ����֤��userId��װ��JSONObject
			JSONObject jsonObj = new JSONObject().put("id" , id);
			// �����Ӧ
			response.getWriter().println(jsonObj.toString());
		}
		catch (JSONException ex)
		{
			ex.printStackTrace();
		}
	}
}