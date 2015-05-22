package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Teacher;
import com.zdnf.service.ITeacherInfoService;
import com.zdnf.struts.form.TeacherForm;

public class TeacherInfoAction extends TeacherBaseDispatchAction {

	private ITeacherInfoService teacherInfoService;

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}
	
	public ActionForward find(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 HttpSession session = request.getSession(false);
		 int id = (Integer)session.getAttribute("teacherId");
		 Teacher teacher = teacherInfoService.getTeacherInfo(id);
		 request.setAttribute("teacher", teacher);
		return new ActionForward("/WEB-INF/jsp/teacher/info/modifyTeacher.jsp");
	}
	
	public ActionForward modify(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 HttpSession session = request.getSession(false);
		 TeacherForm teacherForm = (TeacherForm)form;
		 int id = (Integer)session.getAttribute("teacherId");	
		 String username = teacherForm.getUsername();
		 String password = teacherForm.getPassword();
		 String name = teacherForm.getName();
		 String sex = teacherForm.getSex();
		 String info = teacherForm.getInfo();
		 teacherInfoService.updateInfo(id, username, password, sex, info, name);
		return mapping.findForward("success");
	}
	
}
