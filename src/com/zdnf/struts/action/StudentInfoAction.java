package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Student;
import com.zdnf.service.IStudentInfoService;
import com.zdnf.struts.form.StudentForm;
import com.zdnf.struts.form.TeacherForm;

public class StudentInfoAction extends StudentBaseDispatchAction {
	
       private IStudentInfoService studentInfoService;
       

	
	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public ActionForward find(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 HttpSession session = request.getSession(false);
		 int id = (Integer)session.getAttribute("studentId");
		 Student student = studentInfoService.getStudentInfo(id);
		 request.setAttribute("student", student);
		return new ActionForward("/WEB-INF/jsp/student/info/modifyStudent.jsp");
	}
	
	public ActionForward modify(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse respone)throws Exception{
		 HttpSession session = request.getSession(false);
		 StudentForm StudentForm = (StudentForm)form;
		 int id = (Integer)session.getAttribute("studentId");	
		 String username = StudentForm.getUsername();
		 String password = StudentForm.getPassword();
		 String name = StudentForm.getName();
		 String sex = StudentForm.getSex();
		 String info = StudentForm.getInfo();
		 studentInfoService.updateInfo(id, username, password, sex, info, name);
		return mapping.findForward("success");
	}

}
