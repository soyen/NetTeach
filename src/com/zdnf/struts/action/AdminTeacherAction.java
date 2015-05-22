package com.zdnf.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zdnf.model.Teacher;
import com.zdnf.service.IAdminDeptService;
import com.zdnf.service.IAdminUserService;
import com.zdnf.struts.form.TeacherForm;
import com.zdnf.util.PageModel;

public class AdminTeacherAction extends AdminBaseDispatchAction {
	
	private IAdminUserService adminUserService;
	
	private IAdminDeptService adminDeptService;
	
	

	public void setAdminDeptService(IAdminDeptService adminDeptService) {
		this.adminDeptService = adminDeptService;
	}

	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
   
	public ActionForward beforeAddTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("deptList", adminDeptService.findAllDepartment());
		
		return new ActionForward("/WEB-INF/jsp/admin/teacher/addTeacher.jsp");
	
	}
	public ActionForward addTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		  
		   TeacherForm teacherForm = (TeacherForm)form;
		   String username = teacherForm.getUsername();
		   String password = teacherForm.getPassword();
		   String name = teacherForm.getName();
		   String sex = teacherForm.getSex();
		   String info = teacherForm.getInfo();
		   String title = teacherForm.getTitle();
		   String teacherNo = teacherForm.getTeacherNo();
		   int departmentId = Integer.parseInt(teacherForm.getDeptList());
		   
		   adminUserService.saveTeacher(username, password, name, sex, info, teacherNo, title, departmentId);
		   
		   return new ActionForward("/admin/teacher/listTeacher.do");
	}
	
	public ActionForward deleteTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    TeacherForm teacherForm = (TeacherForm)form;
		    int id = teacherForm.getId();
		    adminUserService.deleteTeacher(id);
		    return new ActionForward("/admin/teacher/listTeacher.do");
		
	}
	public ActionForward modifyTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    TeacherForm teacherForm = (TeacherForm)form;
		    int id = teacherForm.getId();
		    String username = teacherForm.getUsername();
			String password = teacherForm.getPassword();
			String name = teacherForm.getName();
			String sex = teacherForm.getSex();
		    String info = teacherForm.getInfo();
			String title = teacherForm.getTitle();
			String teacherNo = teacherForm.getTeacherNo();			
		    adminUserService.updateTeacher(id, username, password, sex, info, teacherNo, title, name);
		    return new ActionForward("/admin/teacher/listTeacher.do");
	}
	public ActionForward findTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   TeacherForm teacherForm = (TeacherForm)form;
		   int id = teacherForm.getId();
		   Teacher teacher = adminUserService.getTeacher(id);
		   request.setAttribute("teacher", teacher);
		   return new ActionForward("/WEB-INF/jsp/admin/teacher/modifyTeacher.jsp");
		   
	}
	public ActionForward listTeacher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 TeacherForm teacherForm = (TeacherForm)form;
		 PageModel pageModel = adminUserService.queryTeacher(teacherForm.getPageNo(),teacherForm.getPageSize(),teacherForm.getQueryStr());
		 request.setAttribute("pagemodel", pageModel);
		 return new ActionForward("/WEB-INF/jsp/admin/teacher/listTeachers.jsp");
	
	}
	
	

}
