package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.dao.ITeacherDAO;

import com.zdnf.model.Teacher;
import com.zdnf.struts.form.TeacherForm;

public class TeacherLoginAction extends Action {
	
	private ITeacherDAO teacherDAO;

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		TeacherForm teacherForm = (TeacherForm) form;
		String username = teacherForm.getName();
		String password = teacherForm.getPassword();
		Teacher teacher = teacherDAO.validate(username, password);
        if(teacher!=null){
        	session.setAttribute("user", teacher);
			session.setAttribute("userName",username);
			session.setAttribute("teacherId", teacher.getId());
        	return mapping.findForward("success");
        }else{
        	String error = "µÇÂ¼Ê§°Ü";
             request.setAttribute("msg", error);
        	return mapping.findForward("error");
        }
	}
	
	
	

}
