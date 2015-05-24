package com.zdnf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import org.json.*;

import com.zdnf.dao.IAdminDAO;
import com.zdnf.dao.IStudentDAO;
import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Admin;
import com.zdnf.model.Student;
import com.zdnf.model.Teacher;
import com.zdnf.servlet.base.BaseServlet;
import com.zdnf.util.Constant;

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
		int id = 0;
		
		switch (Integer.parseInt(userType)) {
		case 1:
			// ��ȡstudentDAO
			IStudentDAO studentDAO = (IStudentDAO)getCtx().getBean("studentDAO");
			// ��֤�û���¼			
			Student student = studentDAO.validate(username, password);
			// ��¼�ɹ�
			if (student != null)
			{
				id = student.getId();
				request.getSession(true).setAttribute("id" , id);
			}
			break;
		case 2:
			// ��ȡstudentDAO
			ITeacherDAO teacherDAO = (ITeacherDAO)getCtx().getBean("teacherDAO");
			// ��֤�û���¼			
			Teacher teacher = teacherDAO.validate(username, password);
			// ��¼�ɹ�
			if (teacher != null)
			{
				id = teacher.getId();
				request.getSession(true).setAttribute("id" , id);
			}		
			break;
		case 3:
			// ��ȡadminDAO
			IAdminDAO adminDAO = (IAdminDAO)getCtx().getBean("adminDAO");
			// ��֤�û���¼			
			Admin admin = adminDAO.validate(username, password);
			// ��¼�ɹ�
			if (admin != null)
			{
				id = admin.getId();
				request.getSession(true).setAttribute("id" , id);
			}
	        break;

		}		
		response.setContentType("text/html; charset=GBK");		
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