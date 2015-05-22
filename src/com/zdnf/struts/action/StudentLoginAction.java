package com.zdnf.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.dao.INoticeDAO;
import com.zdnf.dao.IStudentDAO;


import com.zdnf.model.Student;

import com.zdnf.struts.form.TeacherForm;

public class StudentLoginAction extends Action {
	
	private IStudentDAO studentDAO;
	
	private INoticeDAO noticeDAO;
	
	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}


	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		TeacherForm teacherForm = (TeacherForm) form;
		String username = teacherForm.getName();
		String password = teacherForm.getPassword();
		Student student = studentDAO.validate(username, password);
        if(student!=null){
        	session.setAttribute("user", student);
			session.setAttribute("userName",username);
			session.setAttribute("studentId", student.getId());
			List noticeList = noticeDAO.getLatestNotices();
			request.setAttribute("noticeList", noticeList);
        	return mapping.findForward("success");
        }else{
        	String error = "µÇÂ¼Ê§°Ü";
             request.setAttribute("msg", error);
        	return mapping.findForward("error");
        }
	}
	
	
	

}
